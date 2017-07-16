package Servleti;

import entity.Korisnik;
import entity.Poruzbina;
import entity.Stavka;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    Ovaj servlet sluzi za prikazivanje podataka o logovanom korisniku na stranici profil.jsp.
    Na osnovu zahteva klijenta na profil.jsp , refresuju se deo stranice  sa odgovarajucim podacima.
    Postoje 4 razlicita desavanja.
    Value profil gde se prikazuju svi osnovni podaci o korisniku.
    Value porudzbine gde se pokazuju sve porudzbine ulogovanog korisnika.
    Value podaci koji korisniku omogucava promenenu podataka.
    Value lozinka koji korisniku omogucava proveru lozinke.
    Metoda doPost sluzi sa slanje novih podataka u slujacu promene podatka ili promene sifre.


*/

@WebServlet(name = "profilServlet", urlPatterns = {"/profilServlet"})
public class profilServlet extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) { }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try
        {
            HttpSession sesija = request.getSession(true);
            if(sesija.getAttribute("korisnik")!=null) // proverava da li je istakla sesija
            {
                Korisnik kor = (Korisnik)sesija.getAttribute("korisnik"); // uzima logovanog korisnika iz sesije
                String value = request.getParameter("value").trim(); // value
                if(value.equalsIgnoreCase("profil")) // prikazivanje osnovnih podataka korisnika
                {
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.print("<table>");
                        out.print("<tr><td>Ime: "+kor.getIme()+"</td></tr>");
                        out.print("<tr><td>Prezime: "+kor.getPrezime()+"</td></tr>");
                        out.print("<tr><td>Korisničko ime: "+kor.getUsername()+"</td></tr>");
                        out.print("<tr><td>e-mail: "+kor.getEmail()+"</td></tr>");
                        out.print("<tr><td>Adresa: "+kor.getAdresa()+", Grad: "+kor.getGrad()+"</td></tr>");
                        out.print("</table>");

                    }
                }
                if(value.equalsIgnoreCase("porudzbina")) // prikazivanje svih porudzbina korisnika
                {
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) 
                    {
                        if(kor.getPoruzbinas().isEmpty())
                        {
                            out.print("Trenutno nemate porudžbina.");
                        }
                        else 
                        {
                           out.print("<table>");
                           for(Poruzbina por:kor.getPoruzbinas())
                           {
                              out.print("<tr><td>Porudžbina: "+por.getPorudzbinaId()+"</td><td>Iznos: "+por.getIznos()+".00 RSD</td><td><a href='prikazPorudzbine?idporudzine="+por.getPorudzbinaId()+"'>Detalji>>></a></td></tr>"); 
                           }
                           out.print("<table>");

                        }
                    }
                }
                if(value.equalsIgnoreCase("podaci"))  // omoucavanje promene podataka korisnika
                {
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter())
                    {
                            out.print("<table>");
                            out.print("<tr><td>Ime: </td><td><input type='text' id='azur-ime' value='"+kor.getIme()+"' required /></tr></td>");
                            out.print("<tr><td>Prezime:</td><td> <input type='text' id='azur-prezime' value='"+kor.getPrezime()+"' required /></tr></td>");
                            out.print("<tr><td>e-Mail: </td><td><input type='text' id='azur-email' value='"+kor.getEmail()+"' required /></tr></td>");
                            out.print("<tr><td>Adresa: </td><td> <input type='text' id='azur-adr' value='"+kor.getAdresa()+"' required /></tr></td>");
                            out.print("<tr><td>Grad: </td><td> <input type='text' id='azur-grd' value='"+kor.getGrad()+"' required /></tr></td>");
                            out.print("<tr><td><input type='submit' value='Ažuriraj podatke' onclick='refresh()'/></tr></td>");
                            out.print("</table>");

                    }
                  }
                if(value.equalsIgnoreCase("lozinka")) // omogucava promenu sifre korisniku
                {
                    response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter())
                    {
                        out.print("<table>");
                        out.print("<tr><td>Ukucaj novu šifru:</td><td> <input type='password' id='azur-pass1' required /></tr></td>");
                        out.print("<tr><td></td></tr>");
                        out.print("<tr><td>Ponovi novu šifru:</td><td> <input type='password' id='azur-pass2' required /></tr></td>");
                        out.print("<tr><td></td></tr>");
                        out.print("<tr><td><input type='submit' value='Ažuriraj šifru' onclick='refreshPassword()'/></tr></td>");
                        out.print("</table>");
                    }
                } 
            }
            else // ukoliko je sesija istekla, umerava vas na prijavu 
            {
                response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter()) {
                        out.print("Istekla vam se sesija. Ulogujte se ponovo. <a href='prijava.jsp'>Log here</a>");
                    }
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Profil Servlet");
            System.out.println(e);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {   
            HttpSession sesija = request.getSession(true);
            if(sesija.getAttribute("korisnik")!=null)
            {
                Korisnik k = (Korisnik) sesija.getAttribute("korisnik");
                String poruka = "";

                String value = request.getParameter("value").trim();
                if(value.equalsIgnoreCase("promenaSifre")) // Dogadjaj promene sifre, gde se uzima nova vrednost i azurira za logovanog korisnika
                {

                    dao.DAO.azurirajPassword(k, request.getParameter("novaLozinka")); // azuriranje nove sifre korisnika
                    poruka = "Šifra je uspešno promenjena.";
                }
                if(value.equalsIgnoreCase("promenaPodataka")) // dogadjaj promene podataka, gde se uzimaju nove vrednosti i direktno azuriraju za logovanog korisnika u bazi
                {

                    dao.DAO.azurirajPodatke(k.getUsername(), request.getParameter("ime").trim(),  // azuiranje novih podataka korisnika
                            request.getParameter("prezime").trim(), request.getParameter("email").trim(), 
                            request.getParameter("adresa").trim(), request.getParameter("grad").trim());
                    sesija.setAttribute("korisnik", dao.DAO.logovanKorisnik(k.getUsername()));
                    poruka = "Podaci su uspešno ažurirani.";
                }

                response.setContentType("text/html;charset=UTF-8");
                    try (PrintWriter out = response.getWriter())
                    {
                        out.print(poruka);
                    }
            }
            else {
                 response.setContentType("text/html;charset=UTF-8");
                 try (PrintWriter out = response.getWriter()) {
                        out.print("Istekla vam se sesija. Ulogujte se ponovo. <a href='prijava.jsp'>Log here</a>");
                    }
            }
        } 
        catch (Exception e)
        {
            System.out.println("Profil Servet/promena sifre");
            System.out.println(e);
        }
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
