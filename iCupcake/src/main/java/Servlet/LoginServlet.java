package Servlet;

import DataAccessObject.Handler;
import Entity.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailAddress = request.getParameter("emailAddress");
        String password = request.getParameter("password");

        Handler handler = new Handler();
        User user = handler.loginAuthentication(emailAddress, password);

        if (user != null && !user.isAdmin()) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("MyPage.jsp").forward(request, response);
        } else if (user != null && user.isAdmin()) {
            request.getSession().setAttribute("user", user);
            request.getRequestDispatcher("MyPage.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Account invalid");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
