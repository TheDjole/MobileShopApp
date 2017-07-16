
<%@page import="java.util.List"%>
<%@page import="dao.DAO"%>
<%@page import="entity.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
    List <Korisnik> korisnici = DAO.sviKorisnici();
    DAO.closeSession();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link rel="stylesheet" href="css/adminPageCss.css" />
        <script src="JavaScript/adminpage.js"></script>
    </head>
    <body>
        <jsp:include page="include/topAdmin.jsp" />
        <div class="content">
            <div id="korisnici">
                <div id="choiceone">
                    <select id="userSelect" onchange="showUser(this.value)">
                        <option value="none">[---Izaberi korisnika---]</option>
                        <% for(Korisnik K:korisnici) { %>
                        <option value=<%=K.getKorisnikId() %>> <%= K.getUsername() %> </option>
                        <% } %>
                    </select>
                </div>
                <div id="choicetwo">
                        <p>Pretraga po korisničkom imenu</p>
                        <input type="text" id="txt1" width="100" onkeyup="searchByUsername(this.value)" />
                </div>
                <div id="displayUsers">
                        
                </div>
            </div>
            <div id="showProfil">
                        
            </div>
        </div>
    </body>
</html>
