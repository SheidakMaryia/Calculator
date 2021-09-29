package by.sheidak.servlets;

import by.sheidak.entity.Operation;
import by.sheidak.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import by.sheidak.services.SessionFacade;


@WebServlet(name = "CalcServlet", urlPatterns = "/calculation")
public class CalcServlet extends HttpServlet {
    //HistoryOfOperationsDao history = new HistoryOperationsDaoImp();

    private final SessionFacade sessionFacade = new SessionFacade();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/calculation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");


        Operation calculation = sessionFacade.calculate(num1, num2, operation);
        Operation mathOperation = new Operation(num1, num2, operation, calculation.getResult(), user);
        sessionFacade.saveOperations(mathOperation);
        req.setAttribute("result", calculation.getResult());

        getServletContext().getRequestDispatcher("/calculation.jsp").forward(req,resp);


//        Operation result = Calculation.getResult(num1, num2, operation);//method getResult must be static
//
//        history.saveOperations(result.getNum1(), result.getNum2(), result.getTypeOfOperation(), result.getResult(), user);
//        req.setAttribute("result", result.getResult());
//
//        getServletContext().getRequestDispatcher("/calculation.jsp").forward(req,resp);

    }
}
