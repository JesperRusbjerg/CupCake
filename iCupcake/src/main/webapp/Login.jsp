<html>
   <head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {margin:0;}

.navbar {
  overflow: hidden;
  background-color: #333;
  position: fixed;
  top: 0;
  width: 100%;
}

.navbar a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.navbar a:hover {
  background: #ddd;
  color: black;
}

.main {
  padding: 16px;
  margin-top: 30px;
  height: 1500px; /* Used in this example to enable scrolling */
}
</style>
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
        <h1>Login</h1>
    
        
        <form action="LoginServlet" method="post">
        ${message}
            <br>Email adress: <input type="text" name="emailAddress"/>
            <br>Password: <input type="password" name="password"/>
                        <input type="submit" value="Login"/>
                        
                        <p> new User? </p> 
                <a href="Register.jsp">Register</a><br>
        </form>
        
    </div>
    </body>
</html>
