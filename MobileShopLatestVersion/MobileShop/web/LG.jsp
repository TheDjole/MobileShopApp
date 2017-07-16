<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Model> lg = (List<Model>)session.getAttribute("lg");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LG</title>
        <link rel="stylesheet" href="css/samsung.css" />
        <script src="JavaScript/Home.js"></script>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
             <div class="div-head">
                <h1><img src="slike/logo/lg-logo.jpg" alt="LG Logo" /> LG</h1>
            </div>
            <select onchange="prikazi('lg',this.value)">
            <option value="none">[--izaberi model--]</option>
            <% for(Model m:lg) { %>
            <option value=<%=m.getModelId() %>>LG- <%= m.getNazivModela() %></option>
            <% } %>
            </select>
            <div class="profil-phone" id="phone-ispis">
                
            </div>
        </div>
    </body>
</html>
