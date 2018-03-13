<%@page import="Entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataAccessObject.DAOCupcake"%>
<%@page import="MyDataSource.CupcakeDataSource"%>
<%@page import="java.util.List"%>
<%@page import="Entity.CupCake"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Shop</title>
    </head>
    <body>

        <%@include file="Include/MyNavbar.jsp" %>

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6">
                    <h1 class="display-4">Cupcake page!</h1>
                    <p class="lead">${message}</p>
                    <p class="lead">Each topping is added together and a final price will be shown in your shopping cart.</p>
                    <br>
                    <form action="CartServlet" method="post">
                        <div class="form-group">
                            <label for="selectbottom">Bottoms:</label><br>
                            <select class="custom-select" id="selectbottom" name="selectbottom">
                                <optgroup label = "Bottoms">
                                    <c:forEach var="bottom" items="${bottoms}">
                                        <option value="${bottom.name}">${bottom.name} - ${bottom.price} kr </option>
                                    </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="selecttopping">Toppings:</label><br>
                            <select class="custom-select" id="selecttopping" name="selecttopping">
                                <optgroup label = "Toppings">
                                    <c:forEach var="topping" items="${toppings}">
                                        <option value="${topping.name}">${topping.name} - ${topping.price} kr </option>

                                    </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="Quantity">Quantity</label>
                            <input type="number" class="form-control" id="Quantity" name="quantity" placeholder="Enter quantity">
                            <br>
                            <input type="submit" class="btn btn-primary" value="Add Cupcake to Cart"/><br><br>
                        </div>

                    </form>
                    <%
                        if (request.getSession().getAttribute("user") != null) {
                            User v = (User) request.getSession().getAttribute("user");
                    %>
                    <p class="lead"> Logged in as : <% out.print(v.getEmail());  %>
                    <p class="lead"> Credits: <% out.print(v.getCredit()); %>      
                        <%}%>
                </div>

                <div class="col-md-6">
                    <%if (request.getSession().getAttribute("cartlist") == null) { %>
                    <h1 class="display-4">Shopping Cart:</h1>
                    <p class="lead">There are no items added yet!</p>

                    <% } else {%>
                    <h1 class="display-4">This is your current shoppingcart</h1>
                    <hr class="my-4">

                    <c:forEach var="cupcake" items="${cartlist}">
                        <p class="lead">Quantity ${cupcake.quantity} - Bottom: ${cupcake.bottom} + Top: ${cupcake.top} Price: - ${cupcake.price} kr</p> 
                    </c:forEach>

                    <%     int totalprice = 0;
                        for (CupCake elem : (List<CupCake>) request.getSession().getAttribute("cartlist")) {
                            totalprice = totalprice + elem.getPrice();
                        }
                    %>
                    <hr class="my-4">
                    <p class="lead font-weight-bold"> Total Price: <% out.print(totalprice); %> </p>

                    <%
                        if (request.getSession().getAttribute("user") != null) {
                            User v = (User) request.getSession().getAttribute("user");
                    %>

                    <% if (v.getCredit() >= totalprice) { %>  
                    <p class="lead">Placing the order will minus your accouts credits by: <% out.print(totalprice); %> </p>
                    <p class="lead">As soon as you press the button, your CupCakes will be ready for pickup.</p>
                    <p class="lead">You will be able to see your order History under "My Page" </p>
                    <form action="PlaceOrderServlet">
                        <br><input type="submit" class="btn btn-primary" value="Place order!"/> 
                    </form>

                    <form action="ClearBasketServlet">
                        <br><input type="submit" class="btn btn-primary" value="Clear Basket!"/>
                    </form>

                    <%} else {%>
                    <p> Your order costs: <% out.print(totalprice); %> . Your account only has <% out.print(v.getCredit()); %> amount of credit.<br> You can add more credit under "My Page"<%}%>
                        <%} else {%>
                    <p class="alert alert-danger">You are currently not logged in. You must log in to place an order. </p>
                    <%}
                        }%>
                </div>
            </div>
        </div>
    </body>
</html>
