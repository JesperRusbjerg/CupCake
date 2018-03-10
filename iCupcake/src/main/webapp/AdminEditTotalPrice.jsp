
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
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Edit price</title>
   
    </head>
    <body>
        <%@include file="Include/Menu.jsp" %>
   
    <div class="main">
        <h1>Edit total price for order!</h1>
        
        <% int orderID =  Integer.parseInt(request.getParameter("orderID"));
           int price = Integer.parseInt(request.getParameter("price"));
        %>
        
        <p> Order ID: <% out.print(orderID); %>  </p>
        <p> Price: <% out.print(price); %>  </p>
        
        <form action="AdminEditTotalPrice" method="post">
           <input type="hidden" name="orderID" value="<%out.print(orderID);%>" />
           <input type="number" name="price" value="<%out.print(price);%>" />

                <br> <input type="submit" value="EDIT ORDER"/>
          </form>
        
           <form action="Admin.jsp" method="post">
                <br><input type="submit" value="Back to admin page"/>
            </form>
           
    </div>
    </body>
</html>
