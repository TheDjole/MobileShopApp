<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Model> samsung = (List<Model>)session.getAttribute("samsung");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Samsung</title>
        <link rel="stylesheet" href="css/samsung.css" />
        <script src="JavaScript/Home.js"></script>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
             <div class="div-head">
                <h1><img src="slike/logo/samsung-logo.jpg" alt="samsung Logo" /> Samsung</h1>
            </div>
            <select onchange="prikazi('samsung',this.value)">
            <option value="none">[--izaberi model--]</option>    
            <% for(Model m:samsung) { %>
            <option value=<%=m.getModelId() %>><%= m.getNazivModela() %></option>
            <% } %>
            </select>
            <div class="profil-phone" id="phone-ispis">
                
            </div>
        </div>
    </body>
</html>
