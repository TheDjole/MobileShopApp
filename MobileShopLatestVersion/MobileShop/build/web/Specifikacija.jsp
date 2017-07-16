<%-- 
    Document   : Samsung
    Created on : Jun 14, 2017, 11:33:39 AM
    Author     : Nenad
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="entity.Model"%>
<% Model model = (Model)session.getAttribute("model"); %>
<% String link = "slike/slikeTelefona/"+model.getReferencaSlike()+".jpg"; %>
<% double cenaEvri = model.getCena()/122.3902; 
DecimalFormat df = new DecimalFormat("#.##");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><%=model.getProizvodjac().getNazivBrenda()+" "+model.getNazivModela() %></title>
        <link rel="stylesheet" href="css/profil.css"/>
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
        <div class="sadrzaj">
        
        <div class="Osnovni-info">
            <h3><%=model.getProizvodjac().getNazivBrenda()+" "+model.getNazivModela() %></h3>
            <img src=<%=link %> alt="samsung" />
            <h3>Cena: <%= model.getCena() %>.00 RSD (<%= df.format(cenaEvri) %> EURA)</h3>
            <a href='orderServlet?action=order&&id=<%=model.getModelId() %>'><input type="button" value="Ubaci u korpu" /></a>
        </div>
        <table>
            <caption>Specifikacije</caption>
            <tr><td>Model telefona: </td><td class="podnaslov"><%= model.getProizvodjac().getNazivBrenda() +" "+ model.getNazivModela() %></td></tr>
            <tr><td>Mreže: </td><td class="podnaslov"><%= model.getMreze().getMreze() %></td></tr>
            <tr><td>Dimenzije telefona: </td><td class="podnaslov"><%= model.getDimenzijeTelefona() %></td></tr>
            <tr><td>Težina telefona/gram: </td><td class="podnaslov"><%= model.getTezinaTelefona() %></td></tr>
            <tr><td>Tastatura: </td><td class="podnaslov"><%= model.getTastatura().getVrstaTastature() %></td></tr>
            <tr><td>Baterija: </td><td class="podnaslov"><%= model.getBaterija().getVrstaBaterije() %></td></tr>
            <tr><td colspan="2"  id="naslov" >Kamera</td></tr>
            <tr><td>Kamera: </td><td class="podnaslov"><%= model.getKamera().getKvalitetKamere() %></td></tr>
            <tr><td>Rezolucija kamere: </td><td class="podnaslov"><%= model.getRezolucijaKamere().getRezolucijaKamere() %></td></tr>
            <tr><td colspan="2"  id="naslov" >Ekran</td></tr>
            <tr><td>Tip ekrana: </td><td class="podnaslov"><%= model.getEkran().getTipEkrana() %></td></tr>
            <tr><td>Veličina ekrana: </td><td class="podnaslov"><%= model.getVelicinaEkrana().getDijagonala() %></td></tr>
            <tr><td>Rezolucija ekrana: </td><td class="podnaslov"><%= model.getRezolucijaEkrana().getRezolucija() %></td></tr>
            <tr><td>Broj boja: </td><td class="podnaslov"><%= model.getBojeEkrana().getVrednost() %></td></tr>
            <tr><td colspan="2"  id="naslov" >Memorija</td></tr>
            <tr><td>RAM memorija: </td><td class="podnaslov"><%= model.getRammemorija().getVrednost() %></td></tr>
            <tr><td>Interna memorija: </td><td class="podnaslov"><%= model.getInternaMemorija().getVrednost() %></td></tr>
            <tr><td>Eksterna memorija: </td><td class="podnaslov"><%= model.getEksternamemorija().getMogucnost() %></td></tr>
            <tr><td colspan="2"  id="naslov" >Operativni sistem</td></tr>
            <tr><td>Operativni sistem: </td><td class="podnaslov"><%= model.getOperativnisistem().getVrstaOperativnogSistema() %></td></tr>
            <tr><td>Verzija: </td><td class="podnaslov"><%= model.getVerzijaOs().getVerzija() %></td></tr>
            <tr><td>Dual SIM: </td><td class="podnaslov"><%= model.getDualsim().getStatus() %></td></tr>
        </table>
        </div>
        </div>
    </body>
</html>
