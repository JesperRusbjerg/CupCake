
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
        <title>Add cupcake page</title>
    </head>
    <body>

        <%@include file="Include/MyNavbar.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="display-4">Add Bottom or Topping</h1>
                    <br>
                    <form action="AddServlet" method="post">
                        <div class="form-group">
                            <label for="selectbottom">Select whether to add bottom or top:</label><br>
                            <select class="custom-select" name="addSetting">
                                <option value="toppings"> Top</option>
                                <option value="bottoms"> Bottom</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="credit">Enter name of new flavour:</label>
                            <input type="text" class="form-control" name="name" placeholder="Flavour...">
                            <label for="credit">Enter new price:</label>
                            <input type="number" class="form-control" name="price" placeholder="Price...">
                            <br>
                            <input type="submit" class="btn btn-primary" value="Add new item"/><br>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
