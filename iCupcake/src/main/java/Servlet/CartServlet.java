package Servlet;

import DataAccessObject.DAOCupcake;
import DataAccessObject.Handler;
import Entity.CupCake;
import MyDataSource.CupcakeDataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CartServlet", urlPatterns = {"/CartServlet"})
public class CartServlet extends HttpServlet {

    private List<CupCake> cartlist;
    DAOCupcake dao = new DAOCupcake(new CupcakeDataSource().getDataSource());

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Handler handler = new Handler();
        if (request.getSession().getAttribute("cartlist") == null) {
            cartlist = new ArrayList();

        } else {
            cartlist = (List<CupCake>) request.getSession().getAttribute("cartlist");
        }

        String bottomName = request.getParameter("selectbottom");
        String toppingName = request.getParameter("selecttopping");

        int amount = 0;
        if (request.getParameter("amount").equals("")) {
            request.setAttribute("message", "You must order at least 1 or max 50 cupcake to add to cart.");
            request.getRequestDispatcher("CupCakeServlet").forward(request, response);
        } else {
            amount = Integer.parseInt(request.getParameter("amount"));
        }
        if (amount <= 0 || amount >= 100) {
            request.setAttribute("message", "You must order at least 1, and max 100 cupcake to add to cart.");
            request.getRequestDispatcher("CupCakeServlet").forward(request, response);
        } else {

            request.setAttribute("message", "CupCake has been succesfully added to your ShoppingCart!");

            int bottomprice = handler.bottomPrice(bottomName);
            int toppingprice = dao.toppingPrice(toppingName);

            CupCake c = new CupCake(bottomName, toppingName, (bottomprice + toppingprice) * amount, amount);

            cartlist.add(c);

            request.getSession().setAttribute("cartlist", cartlist);

            request.getRequestDispatcher("CupCakeServlet").forward(request, response);
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
