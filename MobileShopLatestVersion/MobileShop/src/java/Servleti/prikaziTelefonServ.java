package Servleti;

import entity.Model;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    Ovaj servlet sluzi za prikazivanje telefona na osnovu izbora u selectu.
    Podaci u selectu se nalaze na svim stranicama koje se odnose na proizvodjace, i izborom modela u selectu
    se refresuje deo stranice gde se prikazuje model telefona sa njegovim specifikacijama.
    Stranice koje koriste ovaj servlet (Samsung.jsp, Huawei.jsp, LG.jsp itd)
    Klase koje se koriste DAO i Model.
*/

@WebServlet(name = "prikaziTelefonServ", urlPatterns = {"/prikaziTelefonServ"})
public class prikaziTelefonServ extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {  }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try 
        {
            HttpSession sesija = request.getSession(true);
            Model modelTelefona = dao.DAO.vratiModelpoID(Integer.parseInt(request.getParameter("idModela"))); // metoda za vracanje modela na osnovu id-a
            dao.DAO.closeSession();
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) 
                {
                    
                    out.print("<div id='image-div'>");
                    out.print("<img style='width:180px; height:180px;'src='slike/slikeTelefona/"+modelTelefona.getReferencaSlike()+".jpg'>");
                    out.print("<p>"+modelTelefona.getProizvodjac().getNazivBrenda()+" "+modelTelefona.getNazivModela()+"</p>");
                    out.print("<p> Cena: "+modelTelefona.getCena()+".00 RSD</p>");
                    out.print("<a href='orderServlet?action=order&&id="+modelTelefona.getModelId()+"'><input type='button' value='Ubaci u korpu' /></a>");
                    out.print("</div>");
                    out.print("<div>");
                    out.print("<table>");
                    out.print("<tr><td>Model:</td><td>"+modelTelefona.getNazivModela()+"</td></tr>");
                    out.print("<tr><td>Mreže:</td><td>"+modelTelefona.getMreze().getMreze()+"</td></tr>");
                    out.print("<tr><td>Dimenzije telefona:</td><td>"+modelTelefona.getDimenzijeTelefona()+"</td></tr>");
                    out.print("<tr><td>Težina telefona/gram:</td><td>"+modelTelefona.getTezinaTelefona()+"</td></tr>");
                    out.print("<tr><td>Tastatura:</td><td>"+modelTelefona.getTastatura().getVrstaTastature()+"</td></tr>");
                    out.print("<tr><td>Baterija:</td><td>"+modelTelefona.getBaterija().getVrstaBaterije()+"</td></tr>");
                    out.print("<tr><td colspan=\"2\"  >Kamera</td></tr>");
                    out.print("<tr><td>Kamera:</td><td>"+modelTelefona.getKamera().getKvalitetKamere()+"</td></tr>");
                    out.print("<tr><td>Rezolucija kamere:</td><td>"+modelTelefona.getRezolucijaKamere().getRezolucijaKamere()+"</td></tr>");
                    out.print("<tr><td colspan=\"2\">Ekran</td></tr>");
                    out.print("<tr><td>Tip ekrana:</td><td>"+modelTelefona.getEkran().getTipEkrana()+"</td></tr>");
                    out.print("<tr><td>Veličina ekrana:</td><td>"+modelTelefona.getVelicinaEkrana().getDijagonala()+"</td></tr>");
                    out.print("<tr><td>Rezolucija ekrana:</td><td>"+modelTelefona.getRezolucijaEkrana().getRezolucija()+"</td></tr>");
                    out.print("<tr><td>Boje:</td><td>"+modelTelefona.getBojeEkrana().getVrednost()+"</td></tr>");
                    out.print("<tr><td colspan=\"2\" >Memorija</td></tr>");
                    out.print("<tr><td>RAM memorija:</td><td>"+modelTelefona.getRammemorija().getVrednost()+"</td></tr>");
                    out.print("<tr><td>Interna memorija:</td><td>"+modelTelefona.getInternaMemorija().getVrednost()+"</td></tr>");
                    out.print("<tr><td>Eksterna memorija:</td><td>"+modelTelefona.getEksternamemorija().getMogucnost()+"</td></tr>");
                    out.print("<tr><td colspan=\"2\" >Operativni sistem</td></tr>");
                    out.print("<tr><td>Operativni sistem: </td><td>"+modelTelefona.getOperativnisistem().getVrstaOperativnogSistema()+"</td></tr>");
                    out.print("<tr><td>Verzija: </td><td>"+modelTelefona.getVerzijaOs().getVerzija()+"</td></tr>");
                    out.print("<tr><td>Dual SIM: </td><td>"+modelTelefona.getDualsim().getStatus()+"</td></tr>");
                    out.print("</table></div>");
                    
                }
            
        } 
        catch (Exception e) 
        {
            System.out.println("Prikaz telefona servlet");
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
