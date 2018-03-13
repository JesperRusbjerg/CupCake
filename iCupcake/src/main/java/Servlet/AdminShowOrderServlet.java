package Servlet;

import DataAccessObject.Handler;
import Entity.CupCake;
import Entity.Order;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminShowOrderServlet", urlPatterns = {"/AdminShowOrderServlet"})
public class AdminShowOrderServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Handler handler = new Handler();

        String checkforOrderDetails = request.getParameter("orderID");
        if (checkforOrderDetails != null) {
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            List<CupCake> details = (List<CupCake>) handler.OrderDetailsUser(orderID);
            request.setAttribute("details", details);
        }

        String checkForEditPrice = request.getParameter("orderIDforEditPrice");
        if (checkForEditPrice != null) {
            int orderIDforEditPrice = Integer.parseInt(request.getParameter("orderIDforEditPrice"));
            int priceForEdit = Integer.parseInt(request.getParameter("price"));
            request.setAttribute("orderIDforEditPrice", orderIDforEditPrice);
            request.setAttribute("priceForEdit", priceForEdit);
        }

        String checkForFinalPrice = request.getParameter("finalPrice");
        if (checkForFinalPrice != null) {
            int orderID = Integer.parseInt(request.getParameter("finalOrderID"));
            int price = Integer.parseInt(request.getParameter("finalPrice"));
            handler.updateTotalPrice(price, orderID);
            request.setAttribute("editComplete", "Order " + orderID + " has been succesfully updated, total price now is: " + price);
        }

        List<Order> allOrders = handler.AllOrders();
        request.setAttribute("orders", allOrders);
        request.getRequestDispatcher("AdminShowOrders.jsp").forward(request, response);
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
