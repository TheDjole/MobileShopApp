<%@page import="entity.Korisnik"%>
<%@page import="entity.Stavka"%>
<%@page import="entity.Poruzbina"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% Poruzbina por = (Poruzbina)session.getAttribute("porudzbina"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Porudžbina</title>
        <link rel="stylesheet" href="css/porudzbina.css" />
    </head>
    <body>
        <% if(session.getAttribute("korisnik") != null) { %>
        <% Korisnik kor = (Korisnik)(session.getAttribute("korisnik"));
           if(kor.getPrava().getPravaId() == 2) {       %>
        <jsp:include page="include/top.jsp" />
        <% } else {%>
        <jsp:include page="include/topAdmin.jsp" />
        <% }} %>
        <div class="content">
            <table>
                <caption>Sastav porudžbine</caption>
                <tr>
                    <th>Slika</th>
                    <th>Proizvođač</th>
                    <th>Model</th>
                    <th>Količina</th>
                    <th>Cena</th>
                    <th>Suma</th>
                </tr>
                <% for(Stavka stavka: por.getStavkas()) { %>
                <tr>
                    <td><img src='slike/slikeTelefona/<%= stavka.getModel().getReferencaSlike() %>.jpg' alt='slika' /> </td>
                    <td><%= stavka.getModel().getProizvodjac().getNazivBrenda() %></td>
                    <td><a href='specifikacijaServlet?btn1=<%= stavka.getModel().getModelId() %>' ><span><%= stavka.getModel().getNazivModela() %></span></a></td>
                    <td><%= stavka.getKolicina() %></td>
                    <td><%= stavka.getModel().getCena() %>.00 RSD</td>
                    <td><%= stavka.getModel().getCena() * stavka.getKolicina() %>.00 RSD</td>
                </tr>
                <% } %>
                <tr>
                    <td colspan='5'>Vrednost porudžbine:</td>
                    <td><%=por.getIznos() %>.00 RSD</td>
                </tr>
            </table>
            
        </div>
    </body>
</html>
