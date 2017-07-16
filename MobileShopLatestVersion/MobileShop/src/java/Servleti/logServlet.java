package Servleti;

import entity.Korisnik;
import entity.Prava;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    Ovaj servlet sluzi za logovanje i registrovanje korisnika. Na osnovu popunjavanja polja na stranici prijava.jsp
    i u zavisnosti od action-a, vrsi se pretraga korisnika u bazi.
    Statusa "1" sluzi za logovanje postojecih korisnika. Prvo se username uzima iz polja user, i proverava da li postoji korisnik u bazi sa takvim korisnickim imenom.
    Ukoliko postoji vrsi se provera njegove lozinke i nivoa prava, a ukoliko ne postoji odmah se vraca odgovor korisniku na stranici.
    Status "2" sluzi za registraciju, gde se uzimaju podaci iz polja na stranici, i nakon provere korisnickog imena i emaila(postojanje korisnickog imena i emaila), korisnik se ubacuje u bazu podataka i moze da se uloguje.
    Klase koje se koriste DAO i Korisnik.
 */

@WebServlet(name = "logServlet", urlPatterns = {"/logServlet"})
public class logServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try 
        {
            String status = request.getParameter("status");
            HttpSession sesija = request.getSession(true);
            String poruka = "";
            if(status.equals("1")) // action za logovanje
            {
                String pass = request.getParameter("lozinka").trim();
                if(dao.DAO.proveraKorIme(request.getParameter("korIme").trim())) // metoda za proveru korisnika u bazi na osnovu korisnickog imena, tip boolean
                {
                    Korisnik korisnik = dao.DAO.logovanKorisnik(request.getParameter("korIme").trim()); // medota za vracanje korisnika na osnovu korisnickog imena
                    dao.DAO.closeSession();
                    if(korisnik.getPassword().equals(pass)) // provera sifre korisnike sa sifrom iz polja
                    {
                        if(korisnik.getPrava().getPravaId() == 1) 
                            poruka = "dobrodosliAdmin";
                        else
                            poruka = "dobrodosli";
                            
                        sesija.setAttribute("korisnik", korisnik);
                        sesija.setAttribute("statusKorisnika", "log");
                        
                    }
                    else {
                        poruka = "Uneta lozinka nije ispravna";
                    }
                }
                else {
                    poruka = "Uneto korisnicko ime ne postoji";
                }
            }
            else if(status.equals("2")) // action za registraciju
            {
                String ime = request.getParameter("ime").trim();
                String prezime = request.getParameter("prezime").trim();
                String korIme = request.getParameter("korIme").trim();
                String lozinka = request.getParameter("lozinka").trim();
                String grad = request.getParameter("grad").trim();
                String adresa = request.getParameter("adresa").trim();
                String postanskiBroj = request.getParameter("postanskiBroj").trim();
                String telBroj = request.getParameter("brojTel").trim();
                String eMail = request.getParameter("email").trim();
                int pb = Integer.parseInt(postanskiBroj);

                if(dao.DAO.proveraKorIme(korIme) && dao.DAO.proveraEmail(eMail)) // provera da li su zauzeti kor ime i email
                {
                    poruka = "Korisnicko ime je zauzeto. Email je zauzet.";
                }
                else if(dao.DAO.proveraKorIme(korIme))  // dostupnost kor imena. Metoda za proveru dostupnosti kor imena, tip boolean
                {
                    dao.DAO.closeSession();
                    poruka = "Korisnicko ime je zauzeto.";
                }
                else if(dao.DAO.proveraEmail(eMail)) // dostupnost emaila. Metoda za proveru dostupnosti email, tip boolean
                {
                    dao.DAO.closeSession();
                    poruka = "Izabrani e-mail je vec upotrebljen.";
                }
                else
                {

                    Prava pravo = dao.DAO.vratiPravoKor(2); // metoda za vracanje prava korisnika
                    Korisnik korisnik = new Korisnik(ime,prezime,korIme,lozinka,telBroj,adresa,grad,postanskiBroj,eMail,pravo); // objekat korisnik
                    dao.DAO.ubaciKorisnika(korisnik); // perzistencija korisnika u bazu
                    dao.DAO.closeSession();
                    poruka = "Poštovani "+korisnik.getIme()+", registracija je uspela, možete da se ulogujete.";
                }
            }
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
                {
                    out.print(poruka);
                }
        }
        catch(Exception e)
        {
            System.out.println("LoginServlet");
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
