<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Model> huawei = (List<Model>)session.getAttribute("huawei");  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Huawei</title>
        <link rel="stylesheet" href="css/samsung.css" />
        <script src="JavaScript/Home.js"></script>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
             <div class="div-head">
                <h1><img src="slike/logo/huawei-logo.jpg" alt="Huawei Logo" /> Huawei</h1>
            </div>
            <select onchange="prikazi('huawei',this.value)">
            <option value="none">[--izaberi model--]</option>
            <% for(Model m:huawei) { %>
            <option value=<%=m.getModelId() %>><%= m.getNazivModela() %></option>
            <% } %>
            </select>
            <div class="profil-phone" id="phone-ispis">
                
            </div>
        </div>
    </body>
</html>
