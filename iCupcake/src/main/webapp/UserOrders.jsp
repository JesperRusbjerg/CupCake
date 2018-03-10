
<%@page import="Entity.CupCake"%>
<%@page import="Entity.Order"%>
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
        <title>JSP Page</title>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="Include/MyNavbar.jsp" %>

        <div class="container-fluid">
            <div class="row"> 
                <div class="col-md-6">
                    <h1> Your order history: </h1>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>OrderID </th>
                                <th> Order Price </th>
                            </tr>
                        </thead>

                        <tbody>
                            <% List<Order> o = (List<Order>) request.getAttribute("orders");

            for (Order elem : o) {%>
                            <tr>
                                <th> Order ID: <% out.print(elem.getOrderID()); %>  </th>
                                <th> Total Price: <%  out.print(elem.getTotalprice()); %>  </th> 

                                <th>
                                    <form action="ShowOrdersServlet" method="post">

                                        <input type="hidden" name="orderID" value="<%out.print(elem.getOrderID());%>" />
                                        <input type="hidden" name="totalprice" value="<%out.print(elem.getTotalprice());%>" />
                                        <input type="submit" class="btn btn-primary" value="Order Details"/><br>

                                    </form>
                                </th>
                                 <%  }%>
                            </tr>
                        </tbody>
                    </table>
                </div>
               


                <% if (request.getParameter("orderID") != null) {
                        int orderID = Integer.parseInt(request.getParameter("orderID"));
                        DAOCupcake x = new DAOCupcake(new CupcakeDataSource().getDataSource());
                %>
                <div class="col-md-6">
            <h1> Order Details: </h1>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Bottom</th>
                                <th>Topping </th>
                                <th>Amount of cakes</th>
                                <th> Price for Cakes</th>
                            </tr>
                        </thead> 
                        <tbody>

                            <%
                                List<CupCake> b = (List<CupCake>) x.OrderDetailsUser(orderID);
                                for (CupCake elem : b) {
                            %>

                            <tr>
                                <th> <% out.print(elem.getBottom()); %> </th>
                                <th>  <% out.print(elem.getTop()); %> </th>
                                <th>  <% out.print(elem.getAmount()); %> </th>
                                <th> <% out.print(elem.getPrice()); %>  </th>

                                <%}%>
                            </tr> 
                        </tbody>
                    </table>    

                    <p> Price for cakes: <% out.print(Integer.parseInt(request.getParameter("totalprice"))); %>  </p>      
                </div>




                <%}%>
            </div>
        </div>

    </body>
</html>
