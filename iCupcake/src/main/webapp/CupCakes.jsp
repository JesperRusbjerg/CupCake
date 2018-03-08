

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
        <title>JSP Page</title>
    </head>
    <body>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="index.html"><img id="regdiv3" src="logo2.png" alt="logo"></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="CupCakeServlet">Shop <span class="sr-only">(current)</span></a>
                    </li>
                    <% if (request.getSession().getAttribute("user") != null) {%>
                    <li class="nav-item active">
                        <a class="nav-link" href="MyPage.jsp">My Page <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href ="LogoutServlet">Log Out <span class="sr-only">(current)</span></a>
                    </li> <%}
                    else { %>  <li class="nav-item active">
                        <a class="nav-link" href="Login.jsp">Log in <span class="sr-only">(current)</span></a>
                    </li> <%} %>
                </ul>
            </div>
        </nav>


                <div class="main">
                    <div class="col-sm-6">
                        <h1>CupCake page!</h1>
                        ${message} <br>
                        <p>Each topping is added together and a final price will be shown in your shopping cart.</p>
                    </div>
                    <br>
                    <form action="CartServlet" method="post">
                        <div class="form-group col-sm-2">
                            <label for="selectbottom">Bottoms:</label><br>
                            <select class="custom-select" id="selectbottom" name="selectbottom">
                                <optgroup label = "Bottoms">
                                    <c:forEach var="bottom" items="${bottoms}">
                                        <option value="${bottom.name}">${bottom.name} - ${bottom.price} kr </option>
                                    </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-sm-2">
                            <label for="selecttopping">Toppings:</label><br>
                            <select class="custom-select" id="selecttopping" name="selecttopping">
                                <optgroup label = "Toppings">
                                    <c:forEach var="topping" items="${toppings}">
                                        <option value="${topping.name}">${topping.name} - ${topping.price} kr </option>

                                    </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-sm-2">
                            <label for="Amount">Amount:</label>
                            <input type="number" class="form-control" id="Amount" name="amount" placeholder="Enter amount">
                            <br>
                            <input type="submit" class="btn btn-primary" value="Add CupCake to Cart"/>
                        </div>

                    </form>
                </div>

                <%
                    if (request.getSession().getAttribute("user") != null) {
                        User v = (User) request.getSession().getAttribute("user");
                %>
                <p> Logged in as : <% out.print(v.getName());  %>
                <p> Credits: <% out.print(v.getCredit()); %>      
                    <%}%>



                    <%if (request.getSession().getAttribute("cartlist") == null) { %>

                <div class="main">
                    <p>  Shopping Cart: </p>
                    <p> There are no items added yet! </p>


                    <% }
                    else {%>



                    <div class="main">
                        <h1>This is your current shoppingcart</h1>

                        <c:forEach var="cupcake" items="${cartlist}">
                            Amount: ${cupcake.amount} - Bottom: ${cupcake.bottom} + Top: ${cupcake.top} Price: - ${cupcake.price} kr 
                            <br>
                        </c:forEach>


                        <%     int totalprice = 0;
                            for (CupCake elem : (List<CupCake>) request.getSession().getAttribute("cartlist")) {
                                totalprice = totalprice + elem.getPrice();
                            }
                        %>
                        <p> TotalPrice: <% out.print(totalprice);   %> </p>




                        <%
                            if (request.getSession().getAttribute("user") != null) {
                                User v = (User) request.getSession().getAttribute("user");
                        %>

                        <% if (v.getCredit() >= totalprice) { %>  
                        <p>Placing the order will minus your accouts credits by: <% out.print(totalprice); %> </p>
                        <p> As soon as you press the button, your CupCakes will be ready for pickup</p>
                        <p> You will be able to see your order History under "My Page" </p>
                        <form action="PlaceOrderServlet">
                            <br>  <input type="submit" value="Place order!"/> 
                        </form>

                        <form action="ClearBasketServlet">
                            <input type="submit" value="Clear Basket!"/>
                        </form>


                        <%}
                        else {%>
                        <p> Your order costs: <% out.print(totalprice); %> . Your account only has <% out.print(v.getCredit()); %> amount of credit.<br> You can add more credit under "My Page"<%}%>
                        <p> Logged in as : <% out.print(v.getName());  %>
                        <p> Credits: <% out.print(v.getCredit()); %>      
                            <%}
                            else {%>
                        <p> You are currently not logged in. You must log in to place an order. </p>
                        <%}
                            }%>


                    </div>

                    </body>
                    </html>
