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
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String emailAddress;
        String password;
        
        try{
        emailAddress = request.getParameter("emailAddress");
        password = request.getParameter("password");
        
         
        DAOCupcake x = new DAOCupcake(new CupcakeDataSource().getDataSource());
        
        boolean check = x.checkIfRegisterable(emailAddress, password);
        
        if(check){
            x.createUser(emailAddress, password, 50);
            User f = x.getUser(emailAddress);
            request.getSession().setAttribute("user", f);
      request.getRequestDispatcher("MyPage.jsp").forward(request, response);
        }
        else{
            request.setAttribute("message", "Registration Failed, Please fill out all the data-fields! Or try a diffrent user name.");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
            
        }
        
        } catch(Exception e){
          request.setAttribute("message", "Registration Failed, Please fill out all the data-fields! Enter a valid email adress and a fresh password!");
            request.getRequestDispatcher("Register.jsp").forward(request, response);
              
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
