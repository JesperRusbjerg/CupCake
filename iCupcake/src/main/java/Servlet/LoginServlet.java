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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jesper
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
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


    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailAddress = request.getParameter("emailAddress");
        String password = request.getParameter("password");
        
       
         User f = new DAOCupcake(new CupcakeDataSource().getDataSource()).loginAuthentication(emailAddress, password);
    
         
         
         
        if(f != null && !f.isAdmin()){
            
//            if(request.getSession().getAttribute("cartlist") != null){
//                request.getSession().removeAttribute("cartlist");
//            }
            
//                HttpSession session = request.getSession();
//                session.setAttribute("name", emailAddress);
//                session.setAttribute("credit", f.getCredit());
                request.getSession().setAttribute("user", f);
                  request.getRequestDispatcher("MyPage.jsp").forward(request, response);
                
        }
        else if(f != null && f.isAdmin()){
            
//            if(request.getSession().getAttribute("cartlist") != null){
//                request.getSession().removeAttribute("cartlist");
//            }
                
//                request.getSession().setAttribute("name", emailAddress);
//                request.getSession().setAttribute("credit", f.getCredit());
                  request.getSession().setAttribute("user", f);
                  request.getRequestDispatcher("MyPage.jsp").forward(request, response);
            
            
        }
        else{
               request.setAttribute("message", "Account invalid");
               request.getRequestDispatcher("Login.jsp").forward(request, response);
               
        }
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
