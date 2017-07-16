<%-- 
    Document   : Alcatel
    Created on : Jun 16, 2017, 12:45:37 PM
    Author     : Nenad
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Model> alcatel = (List<Model>)session.getAttribute("alcatel");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcatel</title>
        <link rel="stylesheet" href="css/samsung.css" />
        <script src="JavaScript/Home.js"></script>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
             <div class="div-head">
                <h1><img src="slike/logo/alcatel-logo.jpg" alt="Alcatel Logo" /> Alcatel</h1>
            </div>
            <select onchange="prikazi('alcatel',this.value)">
                <option value="none">[--izaberi model--]</option>
            <% for(Model m:alcatel) { %>
            <option value=<%=m.getModelId() %> ><%= m.getNazivModela() %></option>
            <% } %>
            </select>
            <div class="profil-phone" id="phone-ispis">
                
            </div>
        </div>
    </body>
</html>
