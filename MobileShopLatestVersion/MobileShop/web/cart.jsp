
<%@page import="entity.Stavka"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Item"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%  List<Stavka> items = new ArrayList();
    int broj = 0;
    int suma = 0;
    if(session.getAttribute("cart") != null) {
     items = (List<Stavka>)session.getAttribute("cart");
}
    %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Korpa</title>
        <link rel="stylesheet" href="css/cart.css" />
    </head>
    <body>
        <jsp:include page="include/top.jsp" />
        <div class="content">
                <table border="2">
                    <caption><div> <img src='slike/logo/Cart.jpg' alt="korpa" />Korpa</div></caption>
                    <tr>
                        <th>Slika</th>
                        <th>Proizvođač</th>
                        <th>Model</th>
                        <th>Cena </th>
                        <th>Količina</th>
                        <th>Sum</th>
                        <th>Option</th>
                    </tr>
                    <% if(items.isEmpty()) {  %>
                    <tr><td colspan="7" align="center">Korpa je trenutno prazna</td></tr>
                    <% } else { %>
                    <% for(Stavka it:items) {

                        suma += it.getModel().getCena() *  it.getKolicina();

                        %>
                    <tr>
                        <td><img src='slike/slikeTelefona/<%= it.getModel().getReferencaSlike() %>.jpg' alt='slika' /></td>
                        <td><%= it.getModel().getProizvodjac().getNazivBrenda() %></td>
                        <td><%= it.getModel().getNazivModela() %></td>
                        <td><%= it.getModel().getCena() %>.00</td>
                        <td><%= it.getKolicina() %></td>
                        <td><%= it.getModel().getCena() * it.getKolicina() %>.00</td>
                        <td><a href='orderServlet?action=remove&&id=<%= it.getModel().getModelId() %>' onclick=" return confirm('Da li želite da izbacite proizvod iz korpe?')" > delete</a></td>
                    </tr>
                    <% }} %>
                    <tr><td colspan="6" align="right">ukupno</td><td align="center"><%= suma %>.00</td></tr>
                </table>
                <div id="actions">
                    <a href="Home.jsp">Nazad na kupovinu</a>
                    <a href='orderServlet?action=buy&&suma=<%=suma %>' onclick=" return confirm('Posalji porudzbinu?')">Pošalji porudžbinu</a>
                </div>
             
            <div id='deo2'>
                <div id='cart-img'>
                    
                </div>
                <div id='total'>
                    <table>
                        <tr>
                            <td>Vrednost porudžbine: </td>
                            <td><%= suma %>.00 RSD</td>
                        </tr>
                        <tr>
                            <td>Za plaćanje:  </td>
                            <td><%= suma %>.00 RSD</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
