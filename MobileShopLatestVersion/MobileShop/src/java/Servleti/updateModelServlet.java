
package Servleti;

import entity.Model;
import entity.Status;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nenad
 */
/* 
    Ovaj servlet radi sa stranicom UpdateModel.jsp i služi za ažuriranje podataka izabranog modela.
    Na osnovu ID-a modela iz selecta sa stranice se iz baze uzima taj model, koristeći metodu selectModelPoId(), nakon čega 
    će administrator moći da ažurira podatke izabranog modela i da ga ažurira u bazi.
*/
@WebServlet(name = "updateModelServlet", urlPatterns = {"/updateModelServlet"})
public class updateModelServlet extends HttpServlet {

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
            String action = request.getParameter("action");
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
            {
                Model model = dao.DAO.vratiModelpoID(Integer.parseInt(request.getParameter("modelId"))); // metoda za uzimanje modela na osnovu id-a
                switch(action)
                {
                    case "cena":
                    {
                        out.print("<table>");
                        out.print("<tr><td><p>Trenutna cena ovog modela je "+model.getCena()+".00 RSD</p></td></tr>");
                        out.print("<tr><td><h3>Ako želite da promenite cenu, unesite novu cenu u polje.</h3></td></tr>");
                        out.print("<tr><td><input type='text' id='novaCenaPolje' placeholder='nova cena' /></td></tr>");
                        out.print("<tr><td><button value='updateCenu' onclick='actionCena(this.value)'  >Promeni cenu modela</button></td></tr>");
                        out.print("</table>");
                        break;
                    }
                    case "dimenzije":
                    {
                        out.print("<table>");
                        out.print("<tr><td><p>Trenutne dimenzije ovog modela su "+model.getDimenzijeTelefona()+"</p></td></tr>");
                        out.print("<tr><td><h3>Ako želite da promenite podatke, unesite novu dimenziju u polje.</h3></td></tr>");
                        out.print("<tr><td><input type='text' id='novaDimenzijaPolje' placeholder='nova dimenzija' /></td></tr>");
                        out.print("<tr><td><button value='updateDimenzije' onclick='actionDimenzija(this.value)' >Promeni dimenzije telefona </button></td></tr>");
                        out.print("</table>");
                        break;
                    }
                    case "naziv":
                    {
                        out.print("<table>");
                        out.print("<tr><td><p>Trenutna naziv ovog modela je "+model.getNazivModela()+"</p></td></tr>");
                        out.print("<tr><td><h3>Ako želite da promenite naziv, unesite novi naziv u polje.</h3></td></tr>");
                        out.print("<tr><td><input type='text' id='noviNazivPolje' placeholder='nova naziv' /></td></tr>");
                        out.print("<tr><td><button value='updateNaziv' onclick='actionNaziv(this.value)' >Promeni naziv modela</button></td></tr>");
                        out.print("</table>");
                        break;
                    }
                    case "stanje":
                    {
                        out.print("<table>");
                        out.print("<tr><td><p>Trenutna status ovog modela je: "+model.getStatus().getStatus()+".</p></td></tr>");
                        out.print("<tr><td><h3>Ako želite da promenite podatke, odaberite novi status.</h3></td></tr>");
                        out.print("<tr><td><select id='noviStatusPolje'>");
                        List<Status> statusi = dao.DAO.sviStatuses();
                        dao.DAO.closeSession();
                        for(Status s:statusi)   
                            out.print("<option value="+s.getStatusId()+">"+s.getStatus()+"</option>");
                        out.print("</select></td></tr>");
                        out.print("<tr><td><button value='updateStatus' onclick='actionStatus(this.value)' >Promeni status telefona</button></td></tr>");
                        out.print("</table>");
                        break;
                    }
                    case "updateCenu": 
                    {
                        dao.DAO.updateCenuModela(Integer.parseInt(request.getParameter("modelId")), Integer.parseInt(request.getParameter("novaCena")));
                        dao.DAO.closeSession();
                        out.print("<p> Ažurirana je cena "+model.getNazivModela()+" modela. Nova cena iznosi "+Integer.parseInt(request.getParameter("novaCena"))+".00 RSD  <button onclick='reloadBar()'>Ok</button></p>");
                        break;
                    }
                    case "updateDimenzije":
                    {
                        dao.DAO.updateDimezijeModela(Integer.parseInt(request.getParameter("modelId")), request.getParameter("novaDimenzija"));
                        dao.DAO.closeSession();
                        out.print("<p> Ažurirana je dimenzija "+model.getNazivModela()+" modela. Nova dimenzije modela su "+request.getParameter("novaDimenzija")+".  <button onclick='reloadBar()'>Ok</button></p>");
                        break;
                    }
                    case "updateNaziv":
                    {
                        dao.DAO.updateNazivModela(Integer.parseInt(request.getParameter("modelId")), request.getParameter("noviNaziv"));
                        dao.DAO.closeSession();
                        out.print("<p> Ažurirana je naziv "+model.getNazivModela()+" modela. Nova naziv modela je "+request.getParameter("noviNaziv")+".  <button onclick='reloadBar()'>Ok</button></p>");
                        break;
                    }
                    case "updateStatus":
                    {
                        dao.DAO.updateStatusModela(Integer.parseInt(request.getParameter("modelId")), Integer.parseInt(request.getParameter("statusId")));
                        dao.DAO.closeSession();
                        out.print("<p> Ažurirana je status "+model.getNazivModela()+" modela.<button onclick='reloadBar()'>Ok</button></p>");
                        break;
                    }
                }
            }
        } 
        catch (Exception e)
        {
            System.out.println("UpdateModelServlet");
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
    }

}
