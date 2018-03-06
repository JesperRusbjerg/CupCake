/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataAccessObject.DAOCupcake;
import Entity.CupCake;
import Entity.User;
import MyDataSource.CupcakeDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesper
 */
@WebServlet(name = "PlaceOrderServlet", urlPatterns = {"/PlaceOrderServlet"})
public class PlaceOrderServlet extends HttpServlet {

    DAOCupcake x =  new DAOCupcake(new CupcakeDataSource().getDataSource());
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        User u = (User) request.getSession().getAttribute("user");
        List<CupCake> c =(List<CupCake>) request.getSession().getAttribute("cartlist");
        int price = 0;
        for (CupCake cupCake : c) {
            price += cupCake.getPrice();
        }
        
        x.addOrder(price, u.getUserID());
        
        int orderID = x.getOrderID(u.getUserID());
        
        for (CupCake cupCake : c) {
            x.addOrderItem(orderID, u.getUserID(), cupCake.getBottom(), cupCake.getTop(), cupCake.getPrice(), cupCake.getAmount());
        }
        
        u.setCredit(u.getCredit() - price);
        request.getSession().setAttribute("user", u);
        
        x.setCreditToUser(u, u.getCredit());
        
        request.getSession().removeAttribute("cartlist");
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
