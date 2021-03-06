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

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    //UsersDao usersDao = new UsersDaoImpl();
    private final SessionFacade sessionFacade = new SessionFacade();
    private final Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User(name, login, password);

        boolean registration = sessionFacade.registration(user);
        if (registration){
            User userByLogin = sessionFacade.getUserByLogin(user);
            req.getSession().setAttribute("user", userByLogin);

            resp.sendRedirect(req.getContextPath() + "/calculation");
            logger.info("Register new user - {}.", user.getName());
        }else {
            req.setAttribute("message", "This user already exist");
            resp.sendRedirect(req.getContextPath() + "/main");
            logger.info("Failed registration attempt.");
        }



//        if (!usersDao.getUsers().contains(user)){
//            usersDao.addUser(user);
//            req.getSession().setAttribute("user", user);
//            resp.sendRedirect(req.getContextPath() + "/calculation");
//        }else {
//            req.setAttribute("message", "This user already exist");
//            resp.sendRedirect(req.getContextPath() + "/main");
//        }
    }
}
