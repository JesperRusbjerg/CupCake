<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="Stylesheet.css" rel="stylesheet" type="text/css"/>
</head>
<body>

    <%@include file="Include/Menu.jsp" %>
    <div id="registermain">
        
            <div id="regidiv1">
        <h1>Welcome to the register page!</h1>
        <form action="RegisterServlet" method="post">
            <br> ${message}
            <br> Register form:
            <br>Email adress: <input type="text" name="emailAddress"/>
            <br>Password: <input type="password" name="password"/>
            <br>Credits: As a free-signup bonus, you get 50 credits, to spend on Cupcakes<br> However, you can easily add more under "My page" once logged in! <input type="hidden" name="credit" value="50"/>
            <br><input type="submit" value="Register"/>
        </form>
            </div>
            <img id="regidiv2" src="cupcakes.jpg" alt="Cake">
    </div>
    </body>
</html>
