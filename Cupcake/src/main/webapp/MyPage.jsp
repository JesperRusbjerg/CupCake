
<%@page import="Entity.User"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
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
            <%
            User v = (User) request.getSession().getAttribute("user");
           %>


            <h1>Your page:</h1>
            

        <p> In the top of you can use the Menu to navigate through the site! </p>
        <p> CupCakes is for ordering CupCakes! </p>
        <p> Here "My Page" you can add additional credits! And also see your previous orders! </p>
             

                ${message}
             <p> Credits: <% out.print(v.getCredit()); %>   </p>
            <form action="addCreditServlet" method="post">
                <br>Credit: <input type="number" name="credit" value="0"/>
                <input type="submit" value="Add credits!"/>
            </form>
            <br>
            
            <form action="ShowOrdersServlet" method="post">
            <br><input type="submit" value="Show orders!"/>
        </form>
            
            <br>
           
       
             <p> Logged in as : <% out.print(v.getName());  %>
        
            
            
            <%  if(v.isAdmin()){ %>
            <p> Admin Page:
                <a href="Admin.jsp">Admin page:</a><br>
                <%} %>
            
         
        </div>

            </body>
            </html>
