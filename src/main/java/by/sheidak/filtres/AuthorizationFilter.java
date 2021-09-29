package by.sheidak.filtres;

import by.sheidak.entity.User;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

import org.slf4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(servletNames = { "HistoryOfOperations"})
public class AuthorizationFilter extends HttpFilter {
    private final Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class.getName());

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) req;
        HttpServletResponse httpResponse = (HttpServletResponse) res;
        User user = (User) httpRequest.getSession().getAttribute("user");
        if (user == null) {
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/main");
            logger.warn("Attempted unauthorized access to the application!");
        } else {
            chain.doFilter(httpRequest, httpResponse);
        }
    }
}

