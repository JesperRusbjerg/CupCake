<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="index.jsp"><img id="regdiv3" src="logo2.png" alt="logo"></a>
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
        </li> <%}%>
    </ul>
</nav>