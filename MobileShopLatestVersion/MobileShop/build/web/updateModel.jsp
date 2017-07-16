<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.DAO"%>
<%@page import="entity.Model"%>
<!DOCTYPE html>

<% 
   List<Model> sviModeli = DAO.sviModeli();
   DAO.closeSession();
   Collections.sort(sviModeli);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ažuriraj model</title>
        <link rel="stylesheet" href="css/update.css" />
        <script src="JavaScript/update.js"></script>
    </head>
    <body>
        <jsp:include page="include/topAdmin.jsp" />
        <div class="content">
            <p id="messageBar"></p>
            <div id="selectdiv">
                <table>
                    <tr>
                        <Td>
                            <select id="SelectPhone" onchange="izaberi()" >
                                <option value="none">[---izaberi model---]</option>
                                <% for(Model m:sviModeli) { %>
                                <option value=<%=m.getModelId() %>><%= m.getProizvodjac().getNazivBrenda() +" "+m.getNazivModela() %></option>
                                <% } %>
                            </select>
                        </Td>
                    </tr> 
                    <tr>
                        <td>
                            <input type="radio" name="updatePhone" value="cena" onclick="showValue(this.value)" >Cena</input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="updatePhone" value="dimenzije" onclick="showValue(this.value)" >Dimenzije</input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="updatePhone" value="naziv" onclick="showValue(this.value)" >Naziv</input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="radio" name="updatePhone" value="stanje" onclick="showValue(this.value)" >Status</input>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="showPhone">
                 
            </div>
            
             
        </div>
</body>
</html>
