
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
        <h1>Add Bottom or Topping</h1>
        
        
        <form action="AddServlet" method="post">
        <select name="addSetting">
            <option value="toppings"> Top</option>
            <option value="bottoms"> Bottom</option>
             </select>
            <br>Name for topping:<input type="text" name="name"/>
            <br>Price: <input type="number" name="price"/>
            
            <br><input type="submit" value="Add this topping or bottom!"/>
        </form>
    </div>
    </body>
</html>
