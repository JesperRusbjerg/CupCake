

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
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        
        <title>JSP Page</title>
       
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
        <h1>CupCake page!</h1>
        ${message} <br>
        Each topping is added together and a final price will be shown in your shopping cart.
        <br>
        <p> &emsp; Bottoms &emsp; &emsp; &emsp; &emsp; &emsp;  Toppings </p>
         <form action="CartServlet" method="post">
        <select name="selectbottom">
          <optgroup label = "Bottoms">
            <c:forEach var="bottom" items="${bottoms}">
            <option value="${bottom.name}">${bottom.name} - ${bottom.price} kr </option>
        </c:forEach>
    </select>
        
         
        
       <select name="selecttopping">
          <optgroup label = "Toppings">
            <c:forEach var="topping" items="${toppings}">
            <option value="${topping.name}">${topping.name} - ${topping.price} kr </option>
            
        </c:forEach>
    </select>

             Amount: <input type="number" name="amount"/>
             
        <input type="submit" value="Add CupCake to Cart"/>
         </form>    
        
        
        <% 
                if(request.getSession().getAttribute("user") != null){
            User v = (User) request.getSession().getAttribute("user");
                %>
                <p> Logged in as : <% out.print(v.getName());  %>
                <p> Credits: <% out.print(v.getCredit()); %>      
                <%}%>

               
  
   <%if( request.getSession().getAttribute("cartlist") == null){ %>
        
        <div class="main">
        <p>  Shopping Cart: </p>
        <p> There are no items added yet! </p>
        
        
        <% }else{%>
                
                
        
    <div class="main">
        <h1>This is your current shoppingcart</h1>
        
            <c:forEach var="cupcake" items="${cartlist}">
            Amount: ${cupcake.amount} - Bottom: ${cupcake.bottom} + Top: ${cupcake.top} Price: - ${cupcake.price} kr 
             <br>
        </c:forEach>
             
             
             <%     int totalprice = 0;
                 for (CupCake elem : (List<CupCake>)request.getSession().getAttribute("cartlist")) {
                     totalprice = totalprice + elem.getPrice();
                 }
             %>
             <p> TotalPrice: <% out.print(totalprice);   %> </p>
             
              
               
             
     <% 
                if(request.getSession().getAttribute("user") != null){
            User v = (User) request.getSession().getAttribute("user");
                %>
               
                <% if(v.getCredit() >= totalprice){ %>  
                <p>Placing the order will minus your accouts credits by: <% out.print(totalprice); %> </p>
                <p> As soon as you press the button, your CupCakes will be ready for pickup</p>
                <p> You will be able to see your order History under "My Page" </p>
                   <form action="PlaceOrderServlet">
                <br>  <input type="submit" value="Place order!"/> 
                   </form>
                
                <form action="ClearBasketServlet">
            <input type="submit" value="Clear Basket!"/>
        </form>
                
                
                <%}else{%>
 <p> Your order costs: <% out.print(totalprice); %> . Your account only has <% out.print(v.getCredit()); %> amount of credit.<br> You can add more credit under "My Page"<%}%>
                <p> Logged in as : <% out.print(v.getName());  %>
                <p> Credits: <% out.print(v.getCredit()); %>      
                <%}else{%>
                <p> You are currently not logged in. You must log in to place an order. </p>
<%}}%>


    </div>
  
</body>
</html>
