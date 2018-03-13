<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Register</title>
    </head>
    <body>
        <%@include file="Include/MyNavbar.jsp" %>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="display-4">Register Page!</h1>
                    <form action="RegisterServlet" method="post">
                        <br> ${message}
                        <p class="lead">Register form:</p>
                        <form action="LoginServlet" method="post">
                            <div class="form-group">
                                <label for="emailAddress">Email Address:</label>
                                <input type="text" class="form-control" id="Email" name="emailAddress" placeholder="Enter email address:">
                            </div>
                            <div class="form-group">
                                <label for="password">Password:</label>
                                <input type="password" class="form-control" id="Password" name="password" placeholder="Enter password:">
                            </div>
                            <br>
                            <p class="lead">Credits: As a free-signup bonus, you get 50 credits to spend on Cupcakes.</p>
                            <p class="lead">However, you can easily add more under "My page" once logged in!</p>
                            <input type="hidden" name="credit" value="50"/>
                            <br><input class="btn btn-primary" type="submit" value="Register"/>
                        </form>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
