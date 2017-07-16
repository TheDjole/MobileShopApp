package Servleti;


import dao.DAO;
import entity.Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    Ovaj servelt sluzi za uporedjivane telefona. On prikuplja zahteve korisnika sa stranice pretraga.jsp i u zavisnosti
    od selecta koji je izabran, refresuje deo stranice prikazujuci izabrani model.
    Na ovaj nacin korisnik moze da postavi dva telefona jedan uz drugi i da uporedi njihove specifikacije.
    Klase koje se koriste su DAO, Model.
    
*/

@WebServlet(name = "uporedjivanjeServlet", urlPatterns = {"/uporedjivanjeServlet"})
public class uporedjivanjeServlet extends HttpServlet 
{

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
            String izabranTelefon = request.getParameter("prikaz");
            HttpSession sesija = request.getSession(true);
            List<Model> modeli = null;
            
            if(sesija.getAttribute("sviModeli") != null)
            {
                modeli = (List<Model>)sesija.getAttribute("sviModeli");
            }
            else
            {
                modeli = DAO.sviAktivniModeli();
                DAO.closeSession();
            }
            Model modelTelefona = null;

            if(izabranTelefon.equals("telefon1"))
            {
                for(Model m:modeli)
                {
                    if(m.getModelId()== Integer.parseInt(request.getParameter("izabranTelefon")))
                        modelTelefona = m;
                }
            }
            else if(izabranTelefon.equals("telefon2"))
            {
                for(Model m:modeli)
                {
                    if(m.getModelId()== Integer.parseInt(request.getParameter("izabranTelefon2")))
                        modelTelefona = m;
                }
            }
            
            
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
            {
                out.print("<div id='image-div'>");
                out.print("<img style='width:180px; height:180px;'src='slike/slikeTelefona/"+modelTelefona.getReferencaSlike()+".jpg'>");
                out.print("<p>"+modelTelefona.getNazivModela()+"</p>");
                out.print("<p> Cena: "+modelTelefona.getCena()+".00 RSD</p>");
                out.print("</div>");
                out.print("<div>");
                out.print("<table>");
                out.print("<tr><td>Model:</td><td>"+modelTelefona.getNazivModela()+"</td></tr>");
                out.print("<tr><td>Mreže:</td><td>"+modelTelefona.getMreze().getMreze()+"</td></tr>");
                out.print("<tr><td>Dimenzije telefona:</td><td>"+modelTelefona.getDimenzijeTelefona()+"</td></tr>");
                out.print("<tr><td>Težina telefona/gram:</td><td>"+modelTelefona.getTezinaTelefona()+"</td></tr>");
                out.print("<tr><td>Tastatura:</td><td>"+modelTelefona.getTastatura().getVrstaTastature()+"</td></tr>");
                out.print("<tr><td>Baterija:</td><td>"+modelTelefona.getBaterija().getVrstaBaterije()+"</td></tr>");
                out.print("<tr><td colspan=\"2\" align='center' >Kamera</td></tr>");
                out.print("<tr><td>Kamera:</td><td>"+modelTelefona.getKamera().getKvalitetKamere()+"</td></tr>");
                out.print("<tr><td>Rezolucija kamere:</td><td>"+modelTelefona.getRezolucijaKamere().getRezolucijaKamere()+"</td></tr>");
                out.print("<tr><td colspan=\"2\" align='center' >Ekran</td></tr>");
                out.print("<tr><td>Tip ekrana:</td><td>"+modelTelefona.getEkran().getTipEkrana()+"</td></tr>");
                out.print("<tr><td>Veličina ekrana:</td><td>"+modelTelefona.getVelicinaEkrana().getDijagonala()+"</td></tr>");
                out.print("<tr><td>Rezolucija ekrana:</td><td>"+modelTelefona.getRezolucijaEkrana().getRezolucija()+"</td></tr>");
                out.print("<tr><td colspan=\"2\" align='center' >Memorija</td></tr>");
                out.print("<tr><td>RAM memorija:</td><td>"+modelTelefona.getRammemorija().getVrednost()+"</td></tr>");
                out.print("<tr><td>Interna memorija:</td><td>"+modelTelefona.getInternaMemorija().getVrednost()+"</td></tr>");
                out.print("<tr><td>Eksterna memorija:</td><td>"+modelTelefona.getEksternamemorija().getMogucnost()+"</td></tr>");
                out.print("<tr><td colspan=\"2\" align='center' >Operativni sistem</td></tr>");
                out.print("<tr><td>Operativni sistem: </td><td>"+modelTelefona.getOperativnisistem().getVrstaOperativnogSistema()+"</td></tr>");
                out.print("<tr><td>Verzija: </td><td>"+modelTelefona.getVerzijaOs().getVerzija()+"</td></tr>");
                out.print("<tr><td>Dual SIM: </td><td>"+modelTelefona.getDualsim().getStatus()+"</td></tr>");
                out.print("</table></div>");
            }
        }
        catch (Exception e)
        {
            System.out.println("Uporedjivanje Servlet");
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
