
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
        <title>JSP Page</title>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="Include/Menu.jsp" %>
  
    <div class="main">
        <h1> Your order history: </h1>
        <% List<Order> o = (List<Order>) request.getAttribute("orders");
        
        
        for (Order elem : o) {%>
        
        <p> Order ID: <% out.print(elem.getOrderID()); %>  </p>
      <p> Total Price: <%  out.print(elem.getTotalprice()); %>  </p> 
     
      <form action="OrderUserDetailServlet" method="post">
        
          <input type="hidden" name="orderID" value="<%out.print(elem.getOrderID());%>" />
          <input type="hidden" name="totalprice" value="<%out.print(elem.getTotalprice());%>" />
          <input type="submit" value="Order Details"/>
               
        </form>
      
      
          <%  }%>
        
        
        <h1>   </h1>
        
    </div>
    </body>
</html>
