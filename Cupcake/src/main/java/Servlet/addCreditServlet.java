/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DataAccessObject.DAOCupcake;
import Entity.User;
import MyDataSource.CupcakeDataSource;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jesper
 */
@WebServlet(name = "addCreditServlet", urlPatterns = {"/addCreditServlet"})
public class addCreditServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    
        User f = (User) request.getSession().getAttribute("user");
        
int credit = 0;  
try{
String creditx = request.getParameter("credit");
        
        if(creditx.equals("")){
    
            request.setAttribute("message", "You must enter a number that is above 0 to add credits to your account.");
            request.getRequestDispatcher("MyPage.jsp").forward(request, response);

        }else{
           credit = Integer.parseInt(request.getParameter("credit"));
        }
        if(credit <= 0 || credit > 10000){
            request.setAttribute("message", "You must enter a number that is above 0 to add credits to your account. AND MAX 10.000");
            request.getRequestDispatcher("MyPage.jsp").forward(request, response);
        }else{

           
            f.setCredit(f.getCredit() + credit);
            request.getSession().setAttribute("user", f);
            
            DAOCupcake x =  new DAOCupcake(new CupcakeDataSource().getDataSource());
            x.setCreditToUser(f, f.getCredit());
            request.getRequestDispatcher("MyPage.jsp").forward(request, response);
        
        }
}catch(Exception e){
    request.setAttribute("message", "You must enter a number that is above 0 to add credits to your account. AND MAX 10.000");
    request.getRequestDispatcher("MyPage.jsp").forward(request, response);
}

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
