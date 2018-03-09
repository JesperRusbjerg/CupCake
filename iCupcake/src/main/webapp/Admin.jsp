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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>

    </head>
    <body>
        <%@include file="Include/MyNavbar.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">

                    <h1 class="display-4">Admin page!</h1><br>

                    <%
                        List<User> c = new DAOCupcake(new CupcakeDataSource().getDataSource()).getUsers();

                        request.getSession().setAttribute("usersadmin", c);
                    %>

                    <form action="AdminServlet" method="post">
                        <div class="form-group">
                            <select class="custom-select" id="selectUsersAdmin" name="userid">
                                <option selected disabled>Users</option>
                                <c:forEach var="user" items="${usersadmin}">
                                    <option value="${user.userID}"> ${user.name}  </option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Delete this user!"/>
                        </div>
                    </form>

                    <form action="AdminShowOrderServlet" method="post">
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Show all orders as admin!"/>
                        </div>
                    </form>

                    <form action="AddCupcake.jsp" method="post">
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary" value="Add Cupcake"/>
                        </div>
                    </form>

                    <%
                        if (request.getSession().getAttribute("user") != null) {
                            User v = (User) request.getSession().getAttribute("user");
                    %>
                    <p class="lead"> Logged in as : <% out.print(v.getName());  %>
                    <p class="lead"> Credits: <% out.print(v.getCredit()); %>      
                        <%}%>
                </div>
            </div>
        </div>
    </body>
</html>
