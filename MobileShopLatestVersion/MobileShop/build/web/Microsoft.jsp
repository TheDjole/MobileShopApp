<%-- 
    Document   : Microsoft
    Created on : Jun 14, 2017, 6:48:18 PM
    Author     : Nenad
--%>
<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<% List<Model> microsoft = (List<Model>)session.getAttribute("microsoft");  %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Microsoft</title>
        <link rel="stylesheet" href="css/samsung.css" />
        <script src="JavaScript/Home.js"></script>
    </head>
    <body>
            <jsp:include page="include/top.jsp" />
            <div class="content">
            <div class="div-head">
                <h1><img src="slike/logo/ms-logo.jpg" alt="Microsoft Logo" /> Microsoft</h1>
            </div>
            <select onchange="prikazi('microsoft',this.value)">
            <option value="none">[--izaberi model--]</option>        
            <% for(Model m:microsoft) { %>
            <option value=<%=m.getModelId() %>><%= m.getNazivModela() %></option>
            <% } %>
            </select>
            <div class="profil-phone" id="phone-ispis">
                
            </div>
        </div>
    </body>
</html>
