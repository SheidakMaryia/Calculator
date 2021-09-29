package by.sheidak.servlets.telephone;

import by.sheidak.entity.Telephone;
import by.sheidak.entity.User;
import by.sheidak.services.SessionFacade;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddTelephoneServlet", urlPatterns = "/addTelephone")
public class AddTelephoneServlet extends HttpServlet {

    private final SessionFacade sessionFacade = new SessionFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getServletContext().getRequestDispatcher("/addTelephone.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String phoneNumber = req.getParameter("phoneNumber");

        Telephone telephone = new Telephone(phoneNumber, user);
        boolean saveNum = sessionFacade.saveNewTelephone(telephone);
        if (saveNum){
            req.setAttribute("message", "Successfully save new phone number");
            getServletContext().getRequestDispatcher("/addTelephone.jsp").forward(req,resp);
        }


    }
}
