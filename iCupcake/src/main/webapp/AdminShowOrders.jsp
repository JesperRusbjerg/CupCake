
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
        <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <%@include file="Include/MyNavbar.jsp" %>
        <%--<ul class="nav nav-tabs">
            <li class="nav-item">
                <a class="nav-link active" href="index.html"><img id="regdiv3" src="logo2.png" alt="logo"></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="CupCakeServlet">Cupcakes</a>
            </li>
            <% if (request.getSession().getAttribute("user") != null) {%>
            <li class="nav-item">
                <a class="nav-link" href="MyPage.jsp">My Page</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href ="LogoutServlet"> Log Out </a></a>
            </li> <%} else { %>  <li class="nav-item">
                <a class="nav-link" href="Login.jsp">Log in</a>
            </li> <%} %>
        </ul>--%>




        <h1>ALL ORDERS:</h1>

        <div class="container-fluid">
            <div class="row"> 
                <div class="col-md-6">
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
                                    <form action="AdminEditTotalPrice.jsp" method="post">
                                        <input type="hidden" name="orderID" value="<%out.print(elem.getOrderID());%>" >
                                        <input type="hidden" name="price" value="<%out.print(elem.getTotalprice());%>" >
                                        <input type="submit" class="btn btn-success" value="EDIT ORDER">
                                    </form>
                                </th>
                                <%}%>
                            </tr>    
                        </tbody>
                    </table>
                </div>



                <% if (request.getParameter("orderID") != null) {

                        int orderID = Integer.parseInt(request.getParameter("orderID"));
                        DAOCupcake x = new DAOCupcake(new CupcakeDataSource().getDataSource());
                %>
                <div class="col-md-6">

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
                            <tr>
                                <%
                                    List<CupCake> b = (List<CupCake>) x.OrderDetailsUser(orderID);
                                    for (CupCake elem : b) {
                                %>


                                <th> <% out.print(elem.getBottom()); %> </th>
                                <th>  <% out.print(elem.getTop()); %> </th>
                                <th>  <% out.print(elem.getAmount()); %> </th>
                                <th> <% out.print(elem.getPrice()); %>  </th>
                            </tr>
                            <% }%>

                        </tbody>
                    </table>    



                    <p> Price for cakes: <% out.print(Integer.parseInt(request.getParameter("totalprice"))); %>  </p>      
                </div>
                <%}%>








            </div>
            <form action="Admin.jsp" method="post">
                <br><input type="submit" value="Back to admin page"/>
            </form>
        </div> 


    </body>
</html>
