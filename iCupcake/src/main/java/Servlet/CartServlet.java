package Servlet;

import DataAccessObject.Handler;
import Entity.Bottoms;
import Entity.CupCake;
import Entity.Toppings;
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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Handler handler = new Handler();
        if (request.getSession().getAttribute("cartlist") == null) {
            cartlist = new ArrayList();
        }
        else {
            cartlist = (List<CupCake>) request.getSession().getAttribute("cartlist");
        }

        int bottomsID = Integer.parseInt(request.getParameter("selectbottom"));
        int toppingsID = Integer.parseInt(request.getParameter("selecttopping"));

        int quantity = 0;
        if (request.getParameter("quantity").equals("")) {
            request.setAttribute("message", "You must order at least 1 or max 50 cupcake to add to cart.");
            request.getRequestDispatcher("CupCakeServlet").forward(request, response);
        }
        else {
            quantity = Integer.parseInt(request.getParameter("quantity"));
        }
        if (quantity <= 0 || quantity > 100) {
            request.setAttribute("message", "You must order at least 1, and max 100 cupcake to add to cart.");
            request.getRequestDispatcher("CupCakeServlet").forward(request, response);
        }
        else {
            request.setAttribute("message", "CupCake has been succesfully added to your ShoppingCart!");
            boolean updated = false;
            for (CupCake cupCake : cartlist) {
                int b_ID = cupCake.getBottom().getBottomsID();
                int t_ID = cupCake.getTopping().getToppingsID();
                if (b_ID == bottomsID && t_ID == toppingsID) {
                    int totalPrice = cupCake.getPrice();
                    int b_price = cupCake.getBottom().getPrice();
                    int t_price = cupCake.getTopping().getPrice();
                    cupCake.setPrice(totalPrice + ((b_price + t_price) * quantity));
                    cupCake.setQuantity(cupCake.getQuantity() + quantity);
                    updated = true;
                }
            }
            if (!updated) {
                Bottoms bottom = handler.findBottom(bottomsID);
                Toppings topping = handler.findTopping(toppingsID);
                CupCake cake = new CupCake(bottom, topping, (bottom.getPrice() + topping.getPrice()) * quantity, quantity);
                cartlist.add(cake);
            }
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
