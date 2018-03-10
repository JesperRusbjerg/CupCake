<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="Include/MyNavbar.jsp" %>

        
        
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">

                    <h1 class="display-4">Register Page!</h1><br>
                <form action="RegisterServlet" method="post">
                    <br> ${message}
                    <br> Register form:
                    <br>Email adress: <input type="text" name="emailAddress"/>
                    <br>Password: <input type="password" name="password"/>
                    <br>Credits: As a free-signup bonus, you get 50 credits, to spend on Cupcakes<br> However, you can easily add more under "My page" once logged in! <input type="hidden" name="credit" value="50"/>
                    <br><input class="btn btn-primary" type="submit" value="Register"/>
                </form>
            </div>
        </div>
        </div>
    </body>
</html>
