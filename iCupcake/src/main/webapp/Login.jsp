<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <%@include file="Include/Menu.jsp" %>


        <div class="main">
            <h1>Login</h1>


            <form action="LoginServlet" method="post">
                ${message}
                <br>Email adress: <input type="text" name="emailAddress"/>
                <br>Password: <input type="password" name="password"/>
                <br><input type="submit" value="Login"/>

                <p> new User? </p> 
                <a href="Register.jsp">Register</a><br>
            </form>

        </div>
    </body>
</html>
