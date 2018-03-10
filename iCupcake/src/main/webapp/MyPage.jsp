
<%@page import="Entity.User"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%@include file="Include/MyNavbar.jsp" %>

        <%
            User v = (User) request.getSession().getAttribute("user");
        %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="display-4">Your page:</h1>
                    <p class="lead"> In the top of you can use the Menu to navigate through the site! </p>
                    <p class="lead"> CupCakes is for ordering CupCakes! </p>
                    <p class="lead"> Here "My Page" you can add additional credits! And also see your previous orders! </p>
                    ${message}
                    <p class="lead"> Credits: <% out.print(v.getCredit()); %>   </p>
                    <form action="addCreditServlet" method="post">
                        <div class="form-group">
                            <label for="credit">Credit:</label>
                            <input type="number" class="form-control" id="credit" name="credit" placeholder="Enter credits amount:">
                            <br>
                            <input type="submit" class="btn btn-primary" value="Add Credits"/><br>
                        </div>
                    </form>
                    <br>
                    <form action="ShowOrdersServlet" method="post">
                        <input type="submit" class="btn btn-primary" value="Show Orders"/><br>
                    </form>
                    <br>
                    <p class="lead"> Logged in as : <% out.print(v.getName());  %>
                        <%  if (v.isAdmin()) { %>
                    <p class="lead"> Admin Page:
                        <a href="AdminServlet">Admin page:</a><br>
                        <%}%>
                </div>
            </div>
        </div>
    </body>
</html>
