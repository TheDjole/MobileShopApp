package Servleti;

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
    Ovaj servelt sluzi za prikazivanje specifikacija izbranog modela. Pritiskom na dugme specifikacije koje se nalazi na vise stranice,
    salje se id izabranog modela, i potom se na servletu taj model vadi iz baze, stavlja u sesiju i vrsi se preusmeravanje na stranicu specifikacije.jsp
    gde se prikazuje profil izabranog telefona.
    Klase koje se koriste su DAO, Model.



*/

@WebServlet(name = "specifikacijaServlet", urlPatterns = {"/specifikacijaServlet"})
public class specifikacijaServlet extends HttpServlet {

   
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
            String vrednost = request.getParameter("btn1");
            HttpSession sesija = request.getSession(true);
            List<Model> modeli = null;

            if(sesija.getAttribute("sviModeli") != null)
                modeli = (List<Model>)sesija.getAttribute("sviModeli");
            else {
                modeli = dao.DAO.sviAktivniModeli();
                dao.DAO.closeSession();
                sesija.setAttribute("sviModeli", modeli);
            }


            for(Model m:modeli)
            {
                if(m.getModelId() == Integer.parseInt(vrednost))
                {
                    sesija.setAttribute("model", m);
                    RequestDispatcher rd = request.getRequestDispatcher("Specifikacija.jsp");
                    rd.forward(request, response);
                    break;
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Specifikacija Servlet");
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
