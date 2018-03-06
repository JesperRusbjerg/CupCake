
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
            <h1>Order details: </h1>

            <% int counter = 1;
               int orderID = (int) request.getAttribute("orderid");
               int userID = (int) request.getAttribute("userid");
            List<CupCake> x = (List<CupCake>) request.getAttribute("order");
            for (CupCake elem : x) { %>
            <p>  Cake Number: <% out.print(counter); %> </p>
            <p> Order id: <% out.print(orderID); %>  </p>
                       <p>Bottom:  <% out.print(elem.getBottom()); %> </p>
                <p>Topping: <% out.print(elem.getTop()); %> </p>
                <p>Amount of cakes: <% out.print(elem.getAmount()); %></p>
               <p> Totalprice for this cake:  <% out.print(elem.getPrice()); %> </p>
                
               

            </form> <br>
            <%++counter;
            } %>

            <p> Totalprice for given order: <% out.print(request.getAttribute("price"));%> </p>

            <form action="Admin.jsp" method="post">
                <br><input type="submit" value="Back to admin page"/>
            </form>
        </div>
    </body>
</html>
