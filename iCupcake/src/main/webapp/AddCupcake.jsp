
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
