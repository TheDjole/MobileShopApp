package Servleti;

import entity.Korisnik;
import entity.Model;
import entity.Poruzbina;
import entity.Stavka;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.mapping.Set;

/*
    Ovaj servlet sluzi za popunjavanje potrosacke korpe i slanje porudzbine korisnika.
    Ima tri action order, remove i buy.
    Action odred se nalazi kod svakog modela i aktivira se pritiskom na dugme poruce model gde se potom uzima id modela, vadi se taj model iz baze i ubacuje u listu(potrosacku korpu).
    Action remove sluzi za brisanje odredjenog modela i korpe.
    Action buy sluzi za slanje porudzbine i upisivanje Poruzbina i stavki u bazu.
    Klase koje se koriste su DAO, Poruzbina, Korisnik, Stavke, Model.
    

*/

@WebServlet(name = "orderServlet", urlPatterns = {"/orderServlet"})
public class orderServlet extends HttpServlet {

 
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
            
            String action = request.getParameter("action");
            HttpSession session = request.getSession(true);
            List<Stavka> stavkas = new ArrayList();
            if(action.equals("order")) // Ubacivanje modela u potrosacku korpu
            {
                if(session.getAttribute("cart")==null) // proverava se postojanje liste u sesiji
                {
                     int id = Integer.parseInt(request.getParameter("id"));
                     Model model = dao.DAO.vratiModelpoID(id); // Metoda za vracanje modela na osnovu id-a
                     Stavka stavka = new Stavka(model,new Poruzbina(),1); // pravi se objekat klase stavka, i taj objekat se dodaje u listu
                     stavkas = new ArrayList<Stavka>();
                     stavkas.add(stavka);
                     session.setAttribute("cart", stavkas); // lista se stavlja u sesiju
                }
                else 
                {
                    stavkas = (List<Stavka>)session.getAttribute("cart");
                    int id = Integer.parseInt(request.getParameter("id"));
                    int index = isExisting(id, stavkas); // metoda koja proverava da li stavka sa takvim modelom vec postoji u korpi
                    
                    if(index != -1) // ukoliko postoji, povecava samo kolicinu stavke za jedan
                    {
                        stavkas.get(index).setKolicina(stavkas.get(index).getKolicina()+1);
                    }
                    else // ukoliko vec ne postoji u korpi, ubacuje stavku u korpu
                    {
                        Model model = dao.DAO.vratiModelpoID(id);
                        dao.DAO.closeSession();
                        Stavka stavka = new Stavka(model,new Poruzbina(),1);
                        stavkas.add(stavka);
                    }
                     session.setAttribute("cart", stavkas);       

                }
                RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
                rd.forward(request, response);

            }
            if(action.equalsIgnoreCase("remove")) // action remove, sluzi sa brisanje stavke iz korpe
            {
                 if(session.getAttribute("cart") != null)
                     stavkas = (List<Stavka>)session.getAttribute("cart");

                 int index = isExisting(Integer.parseInt(request.getParameter("id")), stavkas);
                 if(index != -1) stavkas.remove(index); // ukoliko postoji takva stavka u listi, brise je iz iste

                 session.setAttribute("cart", stavkas);
                 RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
                 rd.forward(request, response);
            }
            if(action.equalsIgnoreCase("buy")) // action sluzi za slanje porudzbine
            {
                if(session.getAttribute("korisnik") != null) // provera da li je korisnik ulogovan
                {
                    
                    Korisnik kor = (Korisnik) session.getAttribute("korisnik");
                    
                    stavkas = (List<Stavka>)session.getAttribute("cart");
                    
                    if(session.getAttribute("cart")== null || stavkas.size() == 0 ) // provera da li postoje stavke u korpi
                    {
                       RequestDispatcher rd = request.getRequestDispatcher("cart.jsp");
                       rd.forward(request, response); 
                    }
                    else //ukoliko korpa nije prazna, porudzbina se upisuje u bazu
                    {
                        Poruzbina poruzbina = dao.DAO.insertPorudzbina(new Poruzbina(kor,"placena",Integer.parseInt(request.getParameter("suma")),""));
                        for(Stavka s:stavkas){
                            dao.DAO.insertStavke(new Stavka(s.getModel(),poruzbina,s.getKolicina()));
                        }

                        Korisnik kor2 = dao.DAO.logovanKorisnik(kor.getUsername());
                        session.setAttribute("korisnik",kor2);
                        dao.DAO.closeSession();
                        stavkas.clear();
                        RequestDispatcher rd = request.getRequestDispatcher("info.jsp");
                        rd.forward(request, response);
                    }

                    
                }
                else 
                {
                    RequestDispatcher rd = request.getRequestDispatcher("prijava.jsp");
                    rd.forward(request, response);
                }
            }
        } 
        catch (Exception e)
        {
            System.out.println("Order Servlet");
            System.out.println(e);
        }
         
       
    }
    
    private static int isExisting(int id,List<Stavka> stavke) // privatna metoda koja proverava da li izabrani model postoji u korpi
    {   // ukoliko postoji, vraca id stavke u kojoj se nalazi taj model, ukoliko ne, vraca -1
        
        for(int i = 0;i<stavke.size();i++) {
            if(stavke.get(i).getModel().getModelId() == id) {
                return i;
            }
        }
        return -1;
        
    }
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
      
    }

  
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
