package by.sheidak.servlets;

import by.sheidak.entity.User;
import by.sheidak.filtres.AuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {
    private final Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User)req.getSession().getAttribute("user");
        logger.info("End session user - {}.", user.getName());

        HttpSession session = req.getSession();
        session.invalidate();
        //resp.sendRedirect(req.getContextPath() + "/main");
        resp.sendRedirect("/main");

    }


}
