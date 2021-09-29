package by.sheidak.servlets;

import by.sheidak.entity.User;
import by.sheidak.filtres.AuthorizationFilter;
import by.sheidak.services.SessionFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorization")
public class AuthorizationServlet extends HttpServlet {

    //UsersDao userDao = new UsersDaoImpl();
    private final SessionFacade sessionFacade = new SessionFacade();
    private final Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User userLog = new User(login,password);
        boolean authorization = sessionFacade.authorization(userLog);

        if (authorization){
            User user = sessionFacade.getUserByLogin(userLog);
            req.getSession().setAttribute("user", user);
            resp.sendRedirect(req.getContextPath() + "/calculation");
            logger.info("Successful logIn for user - {}.", user.getName());
        }else{
            resp.sendRedirect(req.getContextPath() + "/main");
            logger.info("Login attempt failed.");
        }



//        if(userDao.getUsers().contains(userLog)) {
//            User user = userDao.getUserByLogin(login);
//            req.getSession().setAttribute("user", user);
//            resp.sendRedirect(req.getContextPath() + "/calculation");
//        }else{
//            resp.sendRedirect(req.getContextPath() + "/main");
//        }

    }
}
