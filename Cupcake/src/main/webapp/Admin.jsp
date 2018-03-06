<%-- 
    Document   : Admin
    Created on : 28-02-2018, 10:54:03
    Author     : Jesper
--%>


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
        <h1>Welcome to admin page!</h1>
        
        <%
              List<User> c = new DAOCupcake(new CupcakeDataSource().getDataSource()).getUsers(); 
        
                request.getSession().setAttribute("usersadmin", c);
            %>
        
                <form action="AdminServlet" method="post">
               <select name="userid">
            <option selected disabled>Users</option>
            <c:forEach var="user" items="${usersadmin}">
                <option value="${user.userID}"> ${user.name}  </option>
                </c:forEach>
                </select>
             <input type="submit" value="Delete this user!"/>
                </form>
    
         <form action="AdminShowOrderServlet" method="post">
            <br><input type="submit" value="Show all orders as admin!"/>
        </form>
           
     <form action="AddCupcake.jsp" method="post">
            <br><input type="submit" value="Add Cupcake"/>
        </form>
            
         
            
            
            
    
    </div>
            
             <% 
                if(request.getSession().getAttribute("user") != null){
            User v = (User) request.getSession().getAttribute("user");
                %>
                <p> Logged in as : <% out.print(v.getName());  %>
                <p> Credits: <% out.print(v.getCredit()); %>      
                <%}%>
    </body>
</html>
