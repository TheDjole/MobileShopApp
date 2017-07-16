package Servleti;

import entity.Korisnik;
import entity.Poruzbina;
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
    PretragaKorisnikaServlet sluzi administratoru da moze da vrsi pretragu svih korisnika na osnovu korisnickog imena.
    Pretraga se moze vrsiti na osnovu izbora u selectu ili na popunjavanja text input-a.
    On na osnovu podataka sa adminpage.jsp vraca sve informacije za izabranog korisnika, kao i sve njegove porudzbine i takodje mu omogucava da pregleda svaku porudzbinu izabranog korinsika.
    

*/


@WebServlet(name = "PretragaKorisnikaServlet", urlPatterns = {"/PretragaKorisnikaServlet"})
public class PretragaKorisnikaServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())  {}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try 
        {
            String action = request.getParameter("action");
            HttpSession session = request.getSession(true);
            if(action.equalsIgnoreCase("search"))   // ovaj action vraca podatke na osnovu pretrage po korisnickom imenu.
            {                                       // kucanjem u text polje se vrsi pretraga korisnika na osnovu korisnickog imena, i potom se vracaju svi oni koji sadrze ukucan text
                String value = request.getParameter("value").trim();
                List<Korisnik> korisnici = dao.DAO.sviKorisnici(); // metoda vraca sve registrovane korisnike
                dao.DAO.closeSession();
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter())  
                {
                    if(value.length()>0)
                    {
                         out.print("<table>");
                         for(Korisnik kor:korisnici)
                         {
                             if(kor.getUsername().toUpperCase().contains(value.toUpperCase()))
                                 out.print("<tr><td>"+kor.getUsername()+"</td><td><button value="+kor.getKorisnikId()+" onclick='showUser(this.value)'>Više</button></td></tr>");
                         }
                         out.print("</table>");
                    }
                    else {
                        out.print("Unesite neki karakter.");
                    }  
                }
            }
            if(action.equalsIgnoreCase("show"))  // ovaj action funkcionise na osnovu izbora u selectu, gde za izabranog korisnika vraca sve njegove informacije
            {
                int id = Integer.parseInt(request.getParameter("value"));
                Korisnik pom = dao.DAO.vratiKorisnikaPoId(id);  // uzima id korisnika iz select-a na stranici i vraca podatke za izabranog korisnika
                dao.DAO.closeSession();
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter())  
                {
                    out.print("<table>");
                    out.print("<caption>Profil korisnika</caption>");
                    out.print("<tr>");
                    out.print("<td>Ime: "+pom.getIme()+"</td>");
                    out.print("<td>Prezime: "+pom.getPrezime()+"</td>");
                    out.print("</tr>");
                    out.print("<tr>");
                    out.print("<td>Korisničko ime: "+pom.getUsername()+"</td>");
                    out.print("<td>Lozinka: xxxxxxxxx </td>");
                    out.print("</tr>");
                    out.print("<tr>");
                    out.print("<td>Email: "+pom.getEmail()+"</td>");
                    out.print("<td>Adresa: "+pom.getAdresa()+", "+pom.getGrad()+"</td>");
                    out.print("</tr>");
                    out.print("<tr>");
                    out.print("<td colspan='2'>Telefon: "+pom.getTelefon()+"</td></tr>");
                    out.print("<td colspan='2' align='center' font-size='20px' font-style='italic' >Porudžbine korisnika</td></tr>");
                    for(Poruzbina por:pom.getPoruzbinas())
                        out.print("<tr><td>Iznos porudžbine: "+por.getIznos()+".00 RSD , "+por.getStatusPorudzbine()+"</td><td><a href='prikazPorudzbine?idporudzine="+por.getPorudzbinaId()+"'>Detalji>>></a></td></tr>");
                    out.print("</table>");
                    
                }
                
            }
        } 
        catch (Exception e)
        {
            System.out.println("PretragaKorisnikaServlet");
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
