
<%@page import="Entity.User"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>My Page</title>
    </head>
    <body>
        <%@include file="Include/MyNavbar.jsp" %>

        <%
            User user = (User) request.getSession().getAttribute("user");
            
        %>
        
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="display-4">Your page:</h1>
                    <% if (request.getAttribute("ordersucces") != null) {
                            String order = (String) request.getAttribute("ordersucces");
                    %>
                    <br>
                    <p class="bg-success text-center"> <% out.print(order); %> </p> 
                    <% }%>
                    <br>
                    <p class="lead"> Use the Top Menu to navigate through the site.</p>
                    <p class="lead"> Click on 'Shop' to order cupcakes.</p>
                    <br>
                    <p class="lead"> Here at 'My Page' you can add additional credits, and also see your previous orders.</p>
                    <p class="lead"> Your current credits: <% out.print(user.getCredit()); %>   </p>

                    <form action="AddCreditServlet" method="post">
                        ${message}
                        <div class="form-group">
                            <label for="credit">Enter amount of credits to add:</label>
                            <input type="number" class="form-control" id="credit" name="credit" placeholder="Amount:">
                            <br>
                            <input type="submit" class="btn btn-primary" value="Add Credits"/><br>
                        </div>
                    </form>
                        
                    <br>
                    <form action="ShowOrdersServlet" method="post">
                        <input type="submit" class="btn btn-primary" value="Show Orders"/><br>
                    </form>
                    <br>
                    <p class="lead"> Logged in as : <% out.print(user.getUsername());  %></p>
                    <p class="lead"> Email : <% out.print(user.getEmail());  %></p>
                        <%  if (user.isAdmin()) { %>
                        <p class="lead"> Admin Page:</p>
                    <form action="AdminServlet" method="post">
                        <input type="submit" class="btn btn-primary" value="Admin Page"/><br>
                    </form>
                    <%}%>
                </div>
            </div>
        </div>
    </body>
</html>
