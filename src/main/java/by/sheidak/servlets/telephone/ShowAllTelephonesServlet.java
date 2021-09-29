package by.sheidak.servlets.telephone;

import by.sheidak.entity.Operation;
import by.sheidak.entity.Telephone;
import by.sheidak.entity.User;
import by.sheidak.services.SessionFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowAllTelephonesServlet", urlPatterns = "/showAllTelephones")
public class ShowAllTelephonesServlet extends HttpServlet {

    private final SessionFacade sessionFacade = new SessionFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        List<Telephone> allTelephones = sessionFacade.getAllTelephonesByUser(user);
        req.setAttribute("allTelephones", allTelephones);
        getServletContext().getRequestDispatcher("/showAllTelephones.jsp").forward(req, resp);
    }


}
