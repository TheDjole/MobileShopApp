<%@page import="java.util.Collections"%>
<%@page import="com.sun.java.swing.plaf.windows.WindowsTreeUI.CollapsedIcon"%>
<%@page import="dao.DAO"%>
<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% 
     
    List<Model>   sviModeli = DAO.sviAktivniModeli(); 
    DAO.closeSession();
   
    Collections.sort(sviModeli);
    session.setAttribute("sviModeli", sviModeli);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pretraga</title>
        <link rel="stylesheet" href="css/pretraga.css" />
        <script src="JavaScript/pretraga.js"></script>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
            <h3 style="text-align: center;">Uporedi telefone:</h3>
            <hr>
            <div id="left">
                <select onchange="prikaziTelefon1(this.value)">
                        <option value="none">[--izaberi model--]</option>
                               <%for(Model m:sviModeli) { %>
                               <option value=<%=m.getModelId() %>><%= m.getProizvodjac().getNazivBrenda() +" "+ m.getNazivModela() %></option>
                               <% } %>   
                </select>
                <hr>
                <div id="prikazTelefona1" >
                    
                </div>
            </div>
            <div id="right">
                <select onchange="prikaziTelefon2(this.value)">
                    <option value="none">[--izaberi model--]</option>
                    <%for(Model m:sviModeli) { %>
                    <option value=<%=m.getModelId() %>><%= m.getProizvodjac().getNazivBrenda() +" "+ m.getNazivModela() %></option>
                    <% } %>  
                </select>
                <hr>
                <div id="prikazTelefona2"></div>   
            </div>
        </div>
    </body>
</html>
