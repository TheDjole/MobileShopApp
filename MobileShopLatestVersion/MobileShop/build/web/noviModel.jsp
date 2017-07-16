
<%@page import="entity.*"%>
<%@page import="java.util.List"%>
<%@page import="dao.DAO"%>
<%@page import="entity.Model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% 
    List<Proizvodjac> sviProizvodjaciList = DAO.sviProizvodjaci();
    List<Mreze> sveMreze = DAO.sveMreze();
    List<Tastatura> sveTastature = DAO.sveTastature();
    List<Baterija> sveBaterije = DAO.sveBaterije();
    List<Kamera> sveKamere = DAO.sveKamere();
    List<RezolucijaKamere> sveRezolucijaKamere = DAO.sveRezolucijaKamere();
    List<Ekran> sviEkrani = DAO.sveTipoveEkrana();
    List<VelicinaEkrana> sveVelicine = DAO.sveVelicinaEkrana();
    List<RezolucijaEkrana> sveRezolucijaEkrana = DAO.sveRezolucijaEkrana();
    List<BojeEkrana> sveBojeEkrana = DAO.sveBojeEkrana();
    List<Rammemorija> sveRammemorije = DAO.sveRAMMem();
    List<InternaMemorija> sveInternaMemorije = DAO.sveInternaMemorija();
    List<Eksternamemorija> sveEksternamemorijas = DAO.svaEksternamemorija();
    List<Operativnisistem> sviOS = DAO.sviOS();
    List<VerzijaOs> sveVerzijaOses = DAO.sveVerzijeOs();
    List<Dualsim> sviDualsims = DAO.sviDualsim();
    List<Status> sviStatuses = DAO.sviStatuses();
    List<Model> sviModeli = DAO.sviAktivniModeli();
    DAO.closeSession();
    
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novi Model</title>
        <link rel="stylesheet" href="css/noviModel.css" />
        <script src="JavaScript/NoviModel.js"></script>
    </head>
    <body>
         <jsp:include page="include/topAdmin.jsp" />
         <div class="content">
            <div id="actionInfo">
                
            </div>
             <form method="POST" action="NoviModelServlet" enctype="multipart/form-data" onsubmit="return insertNewModel();"  >
             <table>
                 <caption>Ubaci novi model</caption>
                 <tr>
                    <td>
                         Proizvođač:
                    </td>
                    <td>
                    <select id="ModelProiz" name="ModelProiz" >
                        <option value="none">[---izaberi proizvođača---]</option>
                        <% for(Proizvodjac pr:sviProizvodjaciList) { %>
                        <option value=<%=pr.getProizvodjacId() %>><%= pr.getNazivBrenda() %></option>
                        <% } %>
                    </select>
                    </td>
                    <td>
                         Unesi ime modela: 
                    </td>
                    <td>
                         <input type="text" id="ModelField" name="ModelField" width="100" required />
                    </td>
                </tr>
                <tr>
                    <td>
                        Mreže:
                    </td>
                    <td>
                    <select id="ModelMreza" name="ModelMreza" >
                        <option value="none" >[---izaberi mreže---]</option>
                        <% for(Mreze mreze:sveMreze) { %>
                        <option value=<%= mreze.getMrezaId() %>><%= mreze.getMreze() %></option>
                        <% } %>
                    </select>
                    </td>
                    <td>
                        Dimenzije telefona: 
                    </td>
                    <td>
                        <input type="text" name="ModelDimenzije" id="ModelDimenzije" width="100" required placeholder="154.4 x 75.8 x 6.9 mm" />
                    </td>
                </tr>
                <tr>
                    <td>
                        Težina telefona: 
                    </td>
                    <td>
                        <input type="text" name="ModelTezina" id="ModelTezina" width="100" required placeholder="primer: 153" />
                    </td>
               
                    <td>
                        Tastatura:
                    </td>
                    <td>
                    <select id="ModelTastatura" name="ModelTastatura" >
                        <option value="none" >[---izaberi tastaturu---]</option>
                        <% for(Tastatura tast:sveTastature) { %>
                        <option value=<%= tast.getTastaturaId() %>><%= tast.getVrstaTastature() %></option>
                        <% } %>
                    </select>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Vrsta Baterije: 
                    </td>
                    <td>
                    <select id="ModelBaterija" name="ModelBaterija" >
                        <option value="none" >[---izaberi bateriju---]</option>
                        <% for(Baterija baterija:sveBaterije) { %>
                        <option value=<%= baterija.getBaterijaId() %>><%= baterija.getVrstaBaterije() %></option>
                        <% } %>
                    </select>
                    </td>
                    <td>
                        Vrsta Kamere: 
                    </td>
                    <td>
                    <select id="ModelKamera" name="ModelKamera" >
                        <option value="none" >[---izaberi kameru---]</option>
                        <% for(Kamera kamera:sveKamere) { %>
                        <option value=<%= kamera.getKameraId() %>><%= kamera.getKvalitetKamere() %> Mpx </option>
                        <% } %>
                    </select>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Rezolucija kamere: 
                    </td>
                    <td>
                    <select id="ModelKameraRez" name="ModelKameraRez" >
                        <option value="none" >[---izaberi rezoluciju---]</option>
                        <% for(RezolucijaKamere kameraRez: sveRezolucijaKamere) { %>
                        <option value=<%= kameraRez.getKameraRezId() %>><%= kameraRez.getRezolucijaKamere() %></option>
                        <% } %>
                    </select>
                    </td> 
                    <td>
                        Vrsta Ekrana: 
                    </td>
                    <td>
                    <select id="ModelEkran" name="ModelEkran" >
                        <option value="none" >[---izaberi ekran---]</option>
                        <% for(Ekran ekran :sviEkrani) { %>
                        <option value=<%= ekran.getEkranId() %>><%= ekran.getTipEkrana() %></option>
                        <% } %>
                    </select>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Velicina ekrana: 
                    </td>
                    <td>
                    <select id="ModelEkranVel" name="ModelEkranVel" >
                        <option value="none" >[---izaberi velicinu ekrana---]</option>
                        <% for(VelicinaEkrana VelEkran: sveVelicine) { %>
                        <option value=<%= VelEkran.getVelicinaId() %>><%= VelEkran.getDijagonala() %> inča </option>
                        <% } %>
                    </select>
                    </td> 
                    <td>
                        Rezolucija ekrana: 
                    </td>
                    <td>
                    <select id="ModelEkranRez" name="ModelEkranRez" >
                        <option value="none" >[---izaberi rezoluciju ekrana---]</option>
                        <% for(RezolucijaEkrana ekranRez: sveRezolucijaEkrana) { %>
                        <option value=<%= ekranRez.getRezolucijaEkranaId() %>><%= ekranRez.getRezolucija() %></option>
                        <% } %>
                    </select>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Boje ekrana: 
                    </td>
                    <td>
                    <select id="BojeEkrana" name="BojeEkrana" >
                        <option value="none" >[---Boje ekrana---]</option>
                        <% for(BojeEkrana boje :sveBojeEkrana) { %>
                        <option value=<%= boje.getBojeId() %>><%= boje.getVrednost() %></option>
                        <% } %>
                    </select>
                    </td> 
                    <td>
                        RAM memorija: 
                    </td>
                    <td>
                    <select id="ModelRAM" name="ModelRAM" >
                        <option value="none" >[---RAM memorija---]</option>
                        <% for(Rammemorija RAM: sveRammemorije) { %>
                        <option value=<%= RAM.getRamId() %>><%= RAM.getVrednost() %></option>
                        <% } %>
                    </select>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Veličina interne memorije: 
                    </td>
                    <td>
                    <select id="ModelIntMem" name="ModelIntMem" >
                        <option value="none" >[---Interna memorija---]</option>
                        <% for(InternaMemorija intMem: sveInternaMemorije) { %>
                        <option value=<%= intMem.getInternamemorijaId() %>><%= intMem.getVrednost() %></option>
                        <% } %>
                    </select>
                    </td> 
                    <td>
                        Eksterna memorija: 
                    </td>
                    <td>
                    <select id="ModelExtMem" name="ModelExtMem" >
                        <option value="none" >[---Eksterna memorija---]</option>
                        <% for(Eksternamemorija Ext: sveEksternamemorijas) { %>
                        <option value=<%= Ext.getEksternamemorijaId() %>><%= Ext.getMogucnost() %></option>
                        <% } %>
                    </select>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Operativni sistem: 
                    </td>
                    <td>
                    <select id="ModelOS" name="ModelOS"  >
                        <option value="none" >[---Operativni sistem---]</option>
                        <% for(Operativnisistem OS: sviOS) { %>
                        <option value=<%= OS.getOsId() %>><%= OS.getVrstaOperativnogSistema() %></option>
                        <% } %>
                    </select>
                    </td> 
                    <td>
                        Verzija OS-a: 
                    </td>
                    <td>
                    <select id="ModelOSver" name="ModelOSver" >
                        <option value="none" >[---Verzija OS---]</option>
                        <% for(VerzijaOs VOS: sveVerzijaOses) { %>
                        <option value=<%= VOS.getVerzijaId() %>><%= VOS.getVerzija() %></option>
                        <% } %>
                    </select>
                    </td> 
                 </tr>
                 <tr>
                    <td>
                        Dual SIM: 
                    </td>
                    <td>
                    <select id="ModelDualSim" name="ModelDualSim" >
                        <option value="none" >[---Dual SIM---]</option>
                        <% for(Dualsim DS: sviDualsims) { %>
                        <option value=<%= DS.getSimId() %>><%= DS.getStatus() %></option>
                        <% } %>
                    </select>
                    </td> 
                    <td>
                        Status: 
                    </td>
                    <td>
                    <select id="ModelStatus" name="ModelStatus" >
                        <option value="none" >[---Status---]</option>
                        <% for(Status status: sviStatuses) { %>
                        <option value=<%= status.getStatusId() %>><%= status.getStatus() %></option>
                        <% } %>
                    </select>
                    </td> 
                </tr>
                <tr>
                    <td>
                        Slika telefona: 
                    </td>
                    <td>
                        <input type="file" name="ModelUpload" id="ModelUpload" size="100" required />
                    </td> 
                     <td>Cena modela: </td>
                     <td><input type="text" name="ModelCena" id="ModelCena" required /> </td>
                 </tr>
                 <tr>
                     <td colspan="4" align="center" ><input type="submit" value="Ubaci model" /> </td>
                 </tr>
            </table>
            </form> 
            
         </div>
    </body>
</html>
