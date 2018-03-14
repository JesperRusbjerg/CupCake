
<%@page import="Entity.Order"%>
<%@page import="Entity.CupCake"%>
<%@page import="java.util.List"%>
<%@page import="Entity.User"%>
<%@page import="MyDataSource.CupcakeDataSource"%>
<%@page import="DataAccessObject.DAOCupcake"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Admin Show Orders</title>
    </head>
    <body>

        <%@include file="Include/MyNavbar.jsp" %>
        <div class="container-fluid">
            <div class="row"> 
                <div class="col-md-6">
                    <h1 class="display-4">ALL ORDERS:</h1>
                    <% if (request.getAttribute("editComplete") != null) {
                            String editComplete = (String) request.getAttribute("editComplete"); %>
                    <p class="bg-success text-center"> <% out.print(editComplete); %> </p>
                    <%}%>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>OrderID </th>
                                <th> UserID </th>
                                <th> Order Price </th>
                            </tr>
                        </thead>
                        <tbody>
                            <% List<Order> o = (List<Order>) request.getAttribute("orders");
                                for (Order elem : o) {%>
                            <tr>
                                <th> <% out.print(elem.getOrderID());  %> </th>        
                                <th> <% out.print(elem.getUserID());  %> </th>  
                                <th> <% out.print(elem.getTotalprice());  %> </th> 
                                <th> 
                                    <form action="AdminShowOrderServlet" method="post">
                                        <input type="hidden" name="orderID" value="<%out.print(elem.getOrderID());%>" >
                                        <input type="hidden" name="totalprice" value="<%out.print(elem.getTotalprice());%>" >
                                        <input type="hidden" name="userID" value="<% out.print(elem.getUserID()); %>" >
                                        <input type="submit" class="btn btn-primary" value="Order Details">
                                    </form>
                                </th>

                                <th> 
                                    <form action="AdminShowOrderServlet" method="post">
                                        <input type="hidden" name="orderIDforEditPrice" value="<%out.print(elem.getOrderID());%>" >
                                        <input type="hidden" name="price" value="<%out.print(elem.getTotalprice());%>" >
                                        <input type="hidden" name="userID" value="<% out.print(elem.getUserID()); %>" >
                                        <input type="submit" class="btn btn-success" value="EDIT ORDER">
                                    </form>
                                </th>
                                <%}%>
                            </tr>    
                        </tbody>
                    </table>
                </div>

                <% if (request.getAttribute("orderIDforEditPrice") != null && request.getAttribute("priceForEdit") != null) {
                %>
                <div class="col-md-6">
                    <%  int orderID = (int) request.getAttribute("orderIDforEditPrice");
                        int price = (int) request.getAttribute("priceForEdit");
                        User u = (User) request.getAttribute("user");
                    %>

                    <h1 class="display-4">Order to edit for User: <% out.print(u.getUsername()); %>, ID: <% out.print(u.getUserID()); %></h1>

                    <p class="lead"> Order ID: <% out.print(orderID); %>  </p>
                    <p class="lead"> Total Price: <% out.print(price); %>  </p>
                    <div class="form-group">
                        <form action="AdminShowOrderServlet" method="post">
                            <input type="hidden" name="finalOrderID" value="<%out.print(orderID);%>" />
                            <input class="form-control" type="number" name="finalPrice" value="<%out.print(price);%>" />

                            <br> <input class="btn btn-primary" type="submit" value="EDIT ORDER"/>
                        </form>    
                    </div>
                </div>  



                <%} %>


                <% if (request.getAttribute("details") != null) {
                     User u = (User) request.getAttribute("user");
                
                %>
                <div class="col-md-6">
                    <h1>Order Details: for User: <% out.print(u.getUsername()); %>, ID: <% out.print(u.getUserID()); %> </h1>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Bottom</th>
                                <th>Topping </th>
                                <th>Quantity of cakes</th>
                                <th> Price for cakes</th>
                            </tr>
                        </thead> 
                        <tbody>

                            <%                                List<CupCake> details = (List<CupCake>) request.getAttribute("details");
                                for (CupCake elem : details) {
                            %>

                            <tr>
                                <th> <% out.print(elem.getBottom().getName()); %> </th>
                                <th>  <% out.print(elem.getTopping().getName()); %> </th>
                                <th>  <% out.print(elem.getQuantity()); %> </th>
                                <th> <% out.print(elem.getPrice()); %>  </th>
                                    <%}%>
                            </tr> 
                        </tbody>
                    </table>    
                    <p class="lead"> Total price: <% out.print(Integer.parseInt(request.getParameter("totalprice"))); %>  </p>      
                </div>
                <%}%>
            </div>
            <form action="AdminServlet" method="post">
                <br>
                <input type="submit" class="btn btn-success" value="BACK TO ADMIN PAGE">
            </form>
        </div> 
    </body>
</html>
