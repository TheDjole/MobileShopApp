package Servleti;

import entity.Poruzbina;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
    Ovaj servlet sluzi administratoru da moze da proveri porudzbine korisnika.
    Podatke uzima sa stranice adminpage.jsp i potom vraca porudzbinu na osnovu izbora id-a porudzbine i
    potom preumerava podatke na stranicu porudzbina.jsp.
    Klase koje se koriste Poruzbina i DAO.

*/

@WebServlet(name = "prikazPorudzbine", urlPatterns = {"/prikazPorudzbine"})
public class prikazPorudzbine extends HttpServlet {

    
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
            Poruzbina por = dao.DAO.selectPoruzbina(Integer.parseInt(request.getParameter("idporudzine"))); // metoda za vracanje porudzbine na osnovu id-a
            dao.DAO.closeSession();
            HttpSession session = request.getSession(true);
            session.setAttribute("porudzbina", por);
            RequestDispatcher rd = request.getRequestDispatcher("porudzbina.jsp");
            rd.forward(request, response);  
        }
        catch(Exception e)
        {
            System.out.println("Prikaz porudzbine servlet");
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
