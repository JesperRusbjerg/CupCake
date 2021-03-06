package Servlet;

import DataAccessObject.Handler;
import Entity.CupCake;
import Entity.Order;
import Entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ShowOrdersServlet", urlPatterns = {"/ShowOrdersServlet"})
public class ShowOrdersServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Handler handler = new Handler();
        
        //dette checker om der er trykket på 'order details'
        String check = request.getParameter("orderID");
        if (check != null) {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            List<CupCake> details = (List<CupCake>) handler.OrderDetailsUser(orderID);
            request.setAttribute("details", details);
        }
        
        //dette viser en generel liste over brugerens tidligere ordrer
        User u = (User) request.getSession().getAttribute("user");
        List<Order> orders = handler.showOrdersForUser(u.getUserID());
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("UserOrders.jsp").forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
