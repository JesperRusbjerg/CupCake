package Servlet;

import DataAccessObject.Handler;
import Entity.CupCake;
import Entity.User;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PlaceOrderServlet", urlPatterns = {"/PlaceOrderServlet"})
public class PlaceOrderServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Handler handler = new Handler();
        User u = (User) request.getSession().getAttribute("user");
        List<CupCake> cakesInCart = (List<CupCake>) request.getSession().getAttribute("cartlist");
        int price = 0;
        for (CupCake c : cakesInCart) {
            price += c.getPrice();
        }

        handler.addOrder(price, u.getUserID());
        int orderID = handler.getOrderID(u.getUserID());

        for (CupCake c : cakesInCart) {
            handler.addOrderItem(orderID, c.getTopping().getToppingsID(), c.getBottom().getBottomsID(), c.getPrice(), c.getQuantity());
        }
        u.setCredit(u.getCredit() - price);
        request.getSession().setAttribute("user", u);
        handler.setCreditToUser(u, u.getCredit());
        request.getSession().removeAttribute("cartlist");
        request.setAttribute("ordersucces", "Order Succesful! Your Cupcakes are ready for Pick-Up! \n You can view your orders in your 'Show Orders' tab!");
        request.getRequestDispatcher("MyPage.jsp").forward(request, response);
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
