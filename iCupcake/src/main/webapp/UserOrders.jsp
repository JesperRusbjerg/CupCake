
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
   <style>
body {margin:0;}

.navbar {
  overflow: hidden;
  background-color: #333;
  position: fixed;
  top: 0;
  width: 100%;
}

.navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.navbar a:hover {
  background: #ddd;
  color: black;
}
    
.main {
  padding: 16px;
  margin-top: 30px;
  height: 1500px; /* Used in this example to enable scrolling */
}
</style>
    </head>
    <body>
        <div class="navbar">
   <a href="CupCakeServlet">Cup Cakes</a>
  <% if (request.getSession().getAttribute("user") != null){
 %> <a href="MyPage.jsp">My Page</a>
 <a href ="LogoutServlet"> Log Out </a> <%} else{ %>
    <a href="Login.jsp">Log in</a> <%} %>
  
</div>
   
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
