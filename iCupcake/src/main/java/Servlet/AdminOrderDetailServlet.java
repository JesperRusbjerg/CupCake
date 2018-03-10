package Servlet;

import DataAccessObject.DAOCupcake;
import Entity.CupCake;
import MyDataSource.CupcakeDataSource;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AdminOrderDetailServlet", urlPatterns = {"/AdminOrderDetailServlet"})
public class AdminOrderDetailServlet extends HttpServlet {

    DAOCupcake dao = new DAOCupcake(new CupcakeDataSource().getDataSource());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int userID = Integer.parseInt(request.getParameter("orderID"));
        int totalPrice = Integer.parseInt(request.getParameter("totalprice"));
        int userIDD = Integer.parseInt(request.getParameter("userID"));

        List<CupCake> b = dao.OrderDetailsUser(userID);

        request.setAttribute("userid", userIDD);
        request.setAttribute("orderid", userID);
        request.setAttribute("order", b);
        request.setAttribute("price", totalPrice);
        request.getRequestDispatcher("AdminOrderDetail.jsp").forward(request, response);

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
