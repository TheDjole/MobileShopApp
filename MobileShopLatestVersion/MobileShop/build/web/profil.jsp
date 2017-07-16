<%@page import="entity.Korisnik"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<% Korisnik korisnik = (Korisnik)session.getAttribute("korisnik"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profil korisnika</title>
        <link rel="stylesheet" href="css/kNalog.css" />
        <script src="JavaScript/Profil.js"></script>
    </head>
    <body>
         <jsp:include page="include/top.jsp" />
         <div class="content">
            <div id="navigation-profil">
                <table>
                    <tr>
                        <td><button value="profil" onclick="loadContent(this.value)">Moj profil</button></td>
                    </tr>
                    <tr>
                        <td><button value="porudzbina" onclick="loadContent(this.value)">Moje porudžbine</button></td>
                    </tr>
                    <tr>
                        <td><button value="podaci" onclick="loadContent(this.value)" >Promeni podatke</button></td>
                    </tr>
                    <tr>
                        <td><button value="lozinka" onclick="loadContent(this.value)" >Promeni šifru</button></td>
                    </tr>
                </table>
            </div>
             <p id="info-bar"></p>
             <div id="profil-load" onload="brisanje()">
                
                 
             </div>
               
            </div>
         </div>
         
    </body>
</html>
