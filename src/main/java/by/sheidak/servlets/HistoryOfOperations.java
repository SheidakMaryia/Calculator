package by.sheidak.servlets;

import by.sheidak.dao.HistoryOfOperationsDao;
import by.sheidak.dao.inMemory.HistoryOperationsDaoImp;
import by.sheidak.entity.Operation;
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
import java.util.List;

@WebServlet(name = "HistoryOfOperations", urlPatterns = "/history")
public class HistoryOfOperations extends HttpServlet {
    HistoryOfOperationsDao historyOfOperationsDao = new HistoryOperationsDaoImp();
    private final SessionFacade sessionFacade = new SessionFacade();

    private final Logger logger = LoggerFactory.getLogger(AuthorizationFilter.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession().getAttribute("user");
        List<Operation> history1 = sessionFacade.getHistory(user);
        req.setAttribute("history", history1);
        getServletContext().getRequestDispatcher("/historyOfOperations.jsp").forward(req, resp);
        logger.info("Request history");



//        String login = user.getLogin();
//        List<Operation> history = historyOfOperationsDao.showHistoryByLogin(login);
//        req.setAttribute("history", history);
//        getServletContext().getRequestDispatcher("/historyOfOperations.jsp").forward(req, resp);

    }
}
