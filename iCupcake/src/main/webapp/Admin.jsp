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
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
  
    </head>
    <body>
        <%@include file="Include/Menu.jsp" %>
   
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
