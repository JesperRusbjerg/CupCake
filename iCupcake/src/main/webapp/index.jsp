
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>HOME</title>
    </head>
    <body>
        <%@include file="Include/MyNavbar.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-6">
                    <h1 class="display-4">Welcome!</h1>
                    <br>
                    <p class="lead"> This is the most delicious CupCake Shop of all times.</p>
                    <p class="lead"> You can see our delicious selection of Bottoms and Toppings under the 'Shop' tab.</p>
                    <p class="lead"> As soon as you place an order, it will be ready for pick up in our Cupcake Shop!</p>
                    <br>
                    <p class="lead"> Please log in under the 'Log in' tab in the top.</p>
                    <p class="lead"> If you are still not registered, you can also register under the 'Log in' tab.</p>
                    <br>
                    <p class="lead">Remember: A cake a day keeps the doctor away (if you can hit him)!</p>
                </div>
                <div class="col-md-6">
                    <img class="regdiv2" src="cupcakes.jpg" alt="Cupcake picture">
                    <p class="lead"> Pick between a varity of delicious cupcakes.. Just head to "Shop" to see the different flavors</p>
                </div>
            </div>
        </div>
    </body>
</html>
