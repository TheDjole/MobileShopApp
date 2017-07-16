<%@page import="dao.DAO"%>
<%@page import="java.util.List"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%  
    List<Model> sviModeli = DAO.sviAktivniModeli(); 
    DAO.closeSession();
    session.setAttribute("sviModeli", sviModeli);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detaljna pretraga</title>
        <link rel="stylesheet" href="css/pretraga2.css" />
         <script src="JavaScript/DetaljnaPretraga.js"></script>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
            <div id="searchway">
                <table>
                    <tr id="naslov" ><td>Pretraga po modelu/proizvođaču</td></tr>
                    <tr><td><input type="text" id="searchfield" onkeyup="searchfield(this.value)" /></td></tr>
                    <tr id="naslov"><td>Sortiraj po ceni</td></tr>
                    <tr><td><select id="mySelect" onchange="select(this.value)"><option value="none"></option><option value="rast">Rastući</option><option value="opadanje">Opadajući</option></select></td></tr>
                    <tr id="naslov"><td> Kvalitet kamere </td></tr>
                    <tr><td><input type="radio" name="camera" value="<5" onclick="check1(this.value)" /> < 5 Mpx</td></tr>
                    <tr><td><input type="radio" name="camera" value="5-10" onclick="check1(this.value)" /> 5 - 10 Mpx</td></tr>
                    <tr><td><input type="radio" name="camera" value="11>" onclick="check1(this.value)" /> 11 > Mpx</td></tr>
                    <tr id="naslov"><td> Filtriranje po ceni </td></tr>
                    <tr><td><input type="radio" name="ScreenRez" value="<15" onclick="check2(this.value)" /> < 15000 RSD </td></tr>
                    <tr><td><input type="radio" name="ScreenRez" value="15-30" onclick="check2(this.value)" /> 15000 - 30000 RSD </td></tr>
                    <tr><td><input type="radio" name="ScreenRez" value="30-50" onclick="check2(this.value)" /> 30000 - 50000 RSD> </td></tr>
                    <tr><td><input type="radio" name="ScreenRez" value="50>" onclick="check2(this.value)" /> 50000 RSD > </td></tr>
                    <tr id="naslov"><td>Dual SIM</td></tr>
                    <tr><td><input type="radio" name="DualSIM" value="Da" onclick="check3(this.value)" /> Da</td></tr>
                    <tr><td><input type="radio" name="DualSIM" value="Ne" onclick="check3(this.value)" /> Ne</td></tr>
                    <tr id="naslov"><td>Dimenzije ekrana</td></tr>
                    <tr><td><input type="radio" name="Screen" value="<4" onclick="check4(this.value)" /> < 4.0</td></tr>
                    <tr><td><input type="radio" name="Screen" value="4-5" onclick="check4(this.value)" /> 4.0-5.0</td></tr>
                    <tr><td><input type="radio" name="Screen" value="5>" onclick="check4(this.value)" /> 5.0></td></tr>
                </table>
            </div>
            <div id="prikaz">
                
            </div>
        </div>
</body>
</html>
