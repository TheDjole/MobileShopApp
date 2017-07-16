<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Model> htc = (List<Model>)session.getAttribute("htc");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>HTC</title>
        <link rel="stylesheet" href="css/samsung.css" />
        <script src="JavaScript/Home.js"></script>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
             <div class="div-head">
                <h1><img src="slike/logo/HTC-Logo.jpg" alt="HTC Logo" /> HTC</h1>
            </div>
            <select onchange="prikazi('htc',this.value)">
            <option value="none">[--izaberi model--]</option>
            <% for(Model m:htc) { %>
            <option value=<%=m.getModelId() %>><%= m.getNazivModela() %></option>
            <% } %>
            </select>
            <div class="profil-phone" id="phone-ispis">
                
            </div>
        </div>
    </body>
</html>
