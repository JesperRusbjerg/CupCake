
<%@page import="Entity.User"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="Include/Menu.jsp" %>

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
