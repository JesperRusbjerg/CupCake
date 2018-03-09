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
                    <h1>Login</h1>
                    <form action="LoginServlet" method="post">
                        ${message}
                        <div class="form-group">
                            <label for="emailAddress">Email Address:</label>
                            <input type="text" class="form-control" id="Email" name="emailAddress" placeholder="Enter email address:">
                            <br>
                        </div>
                        <div class="form-group">
                            <label for="password">Password:</label>
                            <input type="password" class="form-control" id="Password" name="password" placeholder="Enter password:">
                            <br>
                        </div>
                        <br>
                        <input type="submit" class="btn btn-primary" value="Login"/><br><br>
                        <br>
                    </form>
                    <form action="Register.jsp" method="post">
                        <p class="lead">New User? </p> 
                        <input type="submit" class="btn btn-primary" value="Register"/><br><br>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
