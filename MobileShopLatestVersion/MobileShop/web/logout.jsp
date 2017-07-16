<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LogOut page</title>
    </head>
    <body>
        <% session.setAttribute("korisnik", null);  %>
        <form action="logoutServlet">
            <input type="submit" value="LOGOUT" />
        </form>
    </body>
</html>
