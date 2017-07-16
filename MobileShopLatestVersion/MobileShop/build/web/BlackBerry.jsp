<%-- 
    Document   : BlackBerry
    Created on : Jun 16, 2017, 12:45:18 PM
    Author     : Nenad
--%>
<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Model> blackberry = (List<Model>)session.getAttribute("blackberry");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blackberry</title>
        <link rel="stylesheet" href="css/samsung.css" />
        <script src="JavaScript/Home.js"></script>
    </head>
    <body>
       <jsp:include page="include/top.jsp" />
        <div class="content">
             <div class="div-head">
                <h1><img src="slike/logo/blackberry-logo.jpg" alt="Blackberry Logo" /> Blackberry</h1>
            </div>
            <select onchange="prikazi('blackberry',this.value)">
            <option value="none">[--izaberi model--]</option>
            <% for(Model m:blackberry) { %>
            <option value=<%=m.getModelId() %>>Blackberry <%= m.getNazivModela() %></option>
            <% } %>
            </select>
            <div class="profil-phone" id="phone-ispis">
                
            </div>
        </div>
        
    </body>
</html>
