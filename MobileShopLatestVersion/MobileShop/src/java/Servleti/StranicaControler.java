package Servleti;

import dao.DAO;
import entity.Model;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    Servlet StranicaControler sluzi za preusmeravanje na stranice odredjenih proizvodjaca. 
    Do njega se dolazi putem linkova u navigacionom meniju ili klikom na naziv proizvodjaca na home.jsp.
    Nakon klika on prikuplja sve modele za tog proizvodjaca i preusmerava na stranicu istog, nakon cega korisnik moze da vidi karakteristike svakog telefona tog proizvodjaca.
    Koristi se klasa DAO kako bi se pokupili adekvatni modeli iz baze na osnovu izbora proizvodjaca.

*/


@WebServlet(name = "StranicaControler", urlPatterns = {"/StranicaControler"})
public class StranicaControler extends HttpServlet {

   
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
            String proizvodjac = request.getParameter("proizvodjac");
            List<Model> models = null;
            HttpSession sesija = request.getSession(true);  // otvara se sesija
            switch(proizvodjac)
            {
                case "Samsung": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac); // metoda koja vraca sve modele na osnovu imena proizvodjaca
                    sesija.setAttribute("samsung", models);
                break;
                case "Microsoft": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac);
                    sesija.setAttribute("microsoft", models);
                break;
                case "Nokia": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac);
                    sesija.setAttribute("nokia", models);
                break;
                case "Huawei": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac);
                    sesija.setAttribute("huawei", models);
                break;
                case "Sony": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac);
                    sesija.setAttribute("sony", models);
                break;
                case "Apple": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac);
                    sesija.setAttribute("apple", models);
                break;
                case "Alcatel": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac);
                    sesija.setAttribute("alcatel", models);
                break;
                case "HTC": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac);
                    sesija.setAttribute("htc", models);
                break;
                case "LG": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac);
                    sesija.setAttribute("lg", models);
                break;
                case "BlackBerry": 
                    models = DAO.sviModeliJednoProizvodjaca(proizvodjac);
                    sesija.setAttribute("blackberry", models);
                break;
            }
            DAO.closeSession();
            sesija.setAttribute("statusKorisnika", "no-log");
            RequestDispatcher rd = request.getRequestDispatcher(proizvodjac+".jsp");
            rd.forward(request, response);
        }
        catch(Exception e) {
            System.out.println("StranicaControler");
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
