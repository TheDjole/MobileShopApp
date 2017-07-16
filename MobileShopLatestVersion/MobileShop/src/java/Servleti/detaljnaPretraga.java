package Servleti;

import dao.DAO;
import dao.MyComparator;
import entity.Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    Ovaj servlet sluzi za pretragu telefona po razlicitim kriterijumima.
    Na osnovu odabira kriterijuma pretrage od strane korisnika na stranici pretraga2.jsp, servlet vraca sve modele koji odgovaraju izabranom kriterijumu.
    Postoje vise vrsta pretrage, pretraga po ceni, dualsim, velicini ekrana, kvalitetu kamere, potom ima pretraga po nazivu modela ili proizvodjaca kao i sortiranje od najskupljeg ka najjeftinijeg i obrnuto.
    Od klasa se koristi Model i DAO.

*/



@WebServlet(name = "detaljnaPretraga", urlPatterns = {"/detaljnaPretraga"})
public class detaljnaPretraga extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {   
        try 
        {
            
            String checkbox = request.getParameter("checkbox"); // uzima vrednost sa stranice 
            List<Model> sviModeli = null;
            HttpSession sesija = request.getSession(true);
            if(sesija.getAttribute("sviModeli") != null)
            {
                sviModeli = (List<Model>)sesija.getAttribute("sviModeli");
            } 
            else
            {
                sviModeli = DAO.sviAktivniModeli();  // vraca sve modele
                dao.DAO.closeSession();
                sesija.setAttribute("sviModeli", sviModeli);
            }
            String check = request.getParameter("checkedValue");
            BigDecimal bd = null;
            BigDecimal bd2 = null;


            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) 
            {

                out.print("<form action = 'specifikacijaServlet'>");
                out.print("<table>");

                    if(checkbox.equals("check1"))
                    {    
                        for(Model m:sviModeli) // pretraga na osnovu kvaliteta kamere
                        {
                            if(check.equals("5-10"))
                            {
                                    bd = new BigDecimal(5);
                                    bd2 = new BigDecimal(10);
                                    if(m.getKamera().getKvalitetKamere().compareTo(bd) == 1 && (m.getKamera().getKvalitetKamere().compareTo(bd2) == 0 
                                            || m.getKamera().getKvalitetKamere().compareTo(bd2) == -1))
                                        ispis(m,out);
                            }
                            if(check.equals("<5"))
                            {
                                    bd = new BigDecimal(5);
                                    if(m.getKamera().getKvalitetKamere().compareTo(bd) == -1 || m.getKamera().getKvalitetKamere().compareTo(bd) == 0 )
                                        ispis(m,out);

                            }
                            if(check.equals("11>"))
                            {
                                    bd = new BigDecimal(11);
                                    if(m.getKamera().getKvalitetKamere().compareTo(bd) == 1)
                                        ispis(m,out);
                            }
                        }
                    }           
                    if(checkbox.equals("check2")) // pretraga na osnovu izbora raspona cene
                    {
                        for(Model m:sviModeli)
                        {   
                            switch(check)
                            {
                                case "<15": 
                                    if(m.getCena()<=15000)
                                        ispis(m,out); 
                                break;
                                case "15-30": 
                                    if(m.getCena()>15000 && m.getCena()<=30000)
                                        ispis(m,out); 
                                break;
                                case "30-50": 
                                    if(m.getCena()>30000 && m.getCena()<=50000) 
                                        ispis(m,out); 
                                break;
                                case "50>": 
                                    if(m.getCena()>50000) 
                                        ispis(m,out);
                                break;
                            }
                        }
                    }
                    if(checkbox.equals("check3")) // pretraga na osnovu izbora da li je telefon sa dve kartice ili ne
                    {
                        for(Model m:sviModeli)
                        {
                            if(m.getDualsim().getStatus().equalsIgnoreCase(check)) 
                            {
                                ispis(m,out); 
                            }
                        }
                    }
                    if(checkbox.equals("check4")) // pretraga na osnovu dijagonale ekrana
                    {    
                        for(Model m:sviModeli)
                        {
                            if(check.equals("4-5"))
                            {
                                    bd = new BigDecimal(4);
                                    bd2 = new BigDecimal(5);
                                    if(m.getVelicinaEkrana().getDijagonala().compareTo(bd) == 1 && (m.getVelicinaEkrana().getDijagonala().compareTo(bd2) == 0 || m.getVelicinaEkrana().getDijagonala().compareTo(bd2) == -1))
                                        ispis(m,out);   

                            }
                            if(check.equals("<4"))
                            {
                                    bd = new BigDecimal(4);
                                    if(m.getVelicinaEkrana().getDijagonala().compareTo(bd) == -1 || m.getVelicinaEkrana().getDijagonala().compareTo(bd) == 0 )
                                      ispis(m,out);  
                            }
                            if(check.equals("5>"))
                            {
                                    bd = new BigDecimal(5);
                                    if(m.getVelicinaEkrana().getDijagonala().compareTo(bd) == 1)
                                      ispis(m,out);  
                            }
                        }
                    }   
                    if(checkbox.equalsIgnoreCase("check5")) // sortiranje telefona po ceni
                    {

                        List<Model> models = (List<Model>) sesija.getAttribute("sviModeli");

                        if(check.equals("rast")) {
                            Collections.sort(models, new MyComparator());
                            Collections.reverse(models);
                        }

                        if(check.equals("opadanje")) {
                           Collections.sort(models, new MyComparator());

                        }

                        for(Model m:models)
                        {
                           ispis(m,out); 
                        }
                    }
                    if(checkbox.equalsIgnoreCase("check6"))  // live pretraga modela po proizvodjacu ili modelu na osnovu popunjavanja polja
                    {
                        List<Model> models = new ArrayList();
                        for(Model m:sviModeli) {
                            if(m.getNazivModela().toUpperCase().contains(check.toUpperCase()) || m.getProizvodjac().getNazivBrenda().toUpperCase().contains(check.toUpperCase())) {
                                models.add(m);
                            }
                        }
                        if(models.isEmpty()) {
                            out.print("Nema rezultata pretrage.");
                        }
                        else {
                            for(Model m:models) {
                              ispis(m,out);  
                            }
                        }

                    }

                    out.print("</table>");
                    out.print("</form>");
                }
        }
        catch (Exception e) 
        {
            System.out.println("Detaljna pretraga Servlet");
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

     private static void ispis(Model m, PrintWriter out) // metoda za ispis svakog telefona koji zadovolji uslov
     {
        
        out.print("<tr><td><img src='slike/slikeTelefona/"+m.getReferencaSlike()+".jpg' alt='slika' style='width='70' height='30' margin-right:15px; >  "+m.getProizvodjac().getNazivBrenda()+" "+m.getNazivModela()+" ,cena: "+m.getCena()+".00 RSD</td><td style='width:80px;'><button value='"+m.getModelId()+"' name='btn1' style=' cursor:pointer;' >Specifikacije</button></td><td style='width:80px;' id='poruci' ><a href='orderServlet?action=order&&id="+m.getModelId()+"' >Poruči</a></td></tr>");
    }
    
    
}
