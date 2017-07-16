<%-- 
    Document   : Apple
    Created on : Jun 14, 2017, 6:47:38 PM
    Author     : Nenad
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Model> apple = (List<Model>)session.getAttribute("apple");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Apple</title>
        <link rel="stylesheet" href="css/samsung.css" />
        <script src="JavaScript/Home.js"></script>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
        <div class="div-head">
            <h1><img src="slike/logo/apple-logo.jpg" alt="Apple Logo" /> Apple</h1>
        </div>
        <select onchange="prikazi('apple',this.value)">
            <option value="none">[--izaberi model--]</option>
            <% for(Model m:apple) { %>
            <option value=<%=m.getModelId() %>><%= m.getNazivModela() %></option>
            <% } %>
        </select>
        <div class="profil-phone" id="phone-ispis">
                
        </div>
        </div>
            
    </body>
</html>
