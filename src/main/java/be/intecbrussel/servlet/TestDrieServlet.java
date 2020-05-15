package be.intecbrussel.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/testdrie")
public class TestDrieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.isNew()){
            session.setAttribute("warningMessage", "");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,resp);
        }
        req.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if(action.equals("logout")){
            logout(req,resp);
        }else if (action.equals("login")){
            login(req,resp);
        }

    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = req.getParameter("nametoadd");

        if(user.equals("")){
            session.setAttribute("warningMessage", ", u moet een naam ingeven!");
            req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);

        } else {
            session.setAttribute("nametoadd", user);
            req.getRequestDispatcher("/WEB-INF/pages/welcome.jsp").forward(req, resp);
        }
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req, resp);
    }


}


