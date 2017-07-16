package Servleti;

import entity.*;
import dao.*;
import entity.Proizvodjac;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Nenad
 */
/* 
   Ovaj servlet se koristi u radu sa dve stranice, NoviModel.jsp i noveMogucnosti.jsp.
   Metoda doGet se koristi kod rada sa noveMogucnosti.jsp i sluza za ubacivanje novih vrednosti za pojedine performanse telefona.
   Kao primer, ukoliko u prodavnicu stigne telefon sa novom vrstom baterije, koju do sada nismo imali, iskoristicemo mogucnost da ubacimo tu novu vrstu baterije u bazu, preko noveMogucnosti.jsp.
   Na ovaj nacin cemo je imati na raspolaganju za svaki naredni telefon koji bude imao ovu vrstu baterije. Pored baterije postoje mogucnosti za ubacivanje jos performansi poput Ekrana, Mreza, Memorije, Statusa itd.
   Metoda doPost se koristi za ubacivanje novih modela telefona u bazi. Ona kupi modatke iz forme na stranici noviModel.jsp i potom sa tim podatica pravi objekat Model, koji posle ubacuje u bazu podataka i stavlja na raspolaganje korisnicima.
   Clasa dao.DAO se koristi za sve radnje koje se odnose na bazu podataka.
   Takodje servelet ima anotaciju @MultipartConfig jer je potrebno uploadovati sliku svakog novog modela koji se ubacuje u bazu podataka.
*/
@WebServlet(name = "NoviModelServlet", urlPatterns = {"/NoviModelServlet"})
@MultipartConfig(maxFileSize = 16177215) public class NoviModelServlet extends HttpServlet {

   private final static Logger LOGGER = Logger.getLogger(NoviModelServlet.class.getCanonicalName());
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {  }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
        
            String action = request.getParameter("action");
            String poruka = "";
            switch(action)
            {
                case "Baterija":
                {
                    DAO.insertBateriju(new Baterija(request.getParameter("value").trim()));
                    poruka = "<p>Ubacena je nova baterija. Vrednost: "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
                case "Mreze": 
                {
                    DAO.insertMreze(new Mreze(request.getParameter("value").trim()));
                    poruka = "<p>Ubačena je nova vrednost za mreže. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
               
                case "Tastatura": 
                {
                    DAO.insertTastaturu(new Tastatura(request.getParameter("value").trim()));
                    poruka = "<p>Ubačena je nova vrednost za tastaturu. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>)";
                    break;
                }
                
                case "Ekran": 
                {
                    DAO.insertEkran(new Ekran(request.getParameter("value").trim()));
                    poruka = "<p>Ubačena je nova vrednost za ekran. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
                case "Dimenzije ekrana": 
                {
                    DAO.insertVelicinuEkrana(new VelicinaEkrana(new BigDecimal(request.getParameter("value").trim())));
                    poruka = "<p>Ubačena je nova vrednost za dimenizije ekrana. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
                case "Status": 
                {
                    DAO.insertStatus(new Status(request.getParameter("value").trim()));
                    poruka = "<p>Ubačena je nova vrednost za status. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
                case "Rezolucija ekrana": 
                {
                    DAO.insertRezolucijaEkrana(new RezolucijaEkrana(request.getParameter("value").trim()));
                    poruka = "<p>Ubačena je nova vrednost za rezoluciju ekrana. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
                case "Kamera": 
                {
                    DAO.insertKamera(new Kamera(new BigDecimal(request.getParameter("value").trim()), action));
                    poruka = "<p>Ubačena je nova vrednost za kameru. Vrednost : "+request.getParameter("value").trim()+"     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
                case "Rezolucija kamere":
                {
                    DAO.insertRezolucijaKamere(new RezolucijaKamere(request.getParameter("value").trim(),"Mpx"));
                    poruka ="<p>Ubačena je nova vrednost za rezoluciju kamere. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
                case "Boja ekrana": 
                {
                    DAO.insertBojuEkrana(new BojeEkrana(request.getParameter("value").trim()));
                    poruka = "<p>Ubačena je nova vrednost za boje ekrana. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
                
                case "Operativni sistem": 
                {
                    DAO.insertOperativniSistem(new Operativnisistem(request.getParameter("value").trim()));
                    poruka = "<p>Ubačena je nova vrednost za operativni sistem. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
                case "Verzija operativnog sistema": 
                {
                    DAO.insertVerzijaOS(new VerzijaOs(request.getParameter("value").trim()));
                    poruka = "<p>Ubačena je nova vrednost za verziju operativnog sistema. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                case "RAM memorija": 
                {
                    DAO.insertRAM(new Rammemorija(request.getParameter("value").trim().concat(" MB")));
                    poruka = "<p>Ubačena je nova vrednost za RAM memoriju. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                case "Interna memorija": 
                {
                    DAO.insertInternaMemorija(new InternaMemorija(request.getParameter("value").trim().concat(" MB")));
                    poruka = "<p>Ubačena je nova vrednost za internu memoriju. Vrednost : "+request.getParameter("value").trim()+".     <button onclick='refresh()'>OK</button></p>";
                    break;
                }
                
            }
                DAO.closeSession();
                out.print(poruka);
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        String nazivModela = request.getParameter("ModelField").trim();
        String dimenzije = request.getParameter("ModelDimenzije").trim();
        int tezina = Integer.parseInt(request.getParameter("ModelTezina").trim());
        int cena = Integer.parseInt(request.getParameter("ModelCena").trim());
        HttpSession session = request.getSession(true);
        
        
        Proizvodjac proizvodjac = DAO.vratiProizvodjacPoId(Integer.parseInt(request.getParameter("ModelProiz")));
        Mreze mreze = DAO.vratiMrezePoId(Integer.parseInt(request.getParameter("ModelMreza")));
        Tastatura tastatura = DAO.vratiTastaturaPoId(Integer.parseInt(request.getParameter("ModelTastatura")));
        Baterija baterija = DAO.vratiBaterijuPoId(Integer.parseInt(request.getParameter("ModelBaterija")));
        Kamera kamera = DAO.vratiKameraPoId(Integer.parseInt(request.getParameter("ModelKamera")));
        RezolucijaKamere rezolucijaKamere = DAO.vratiRezolucijaKamerePoId(Integer.parseInt(request.getParameter("ModelKameraRez")));
        Ekran ekran = DAO.vratiEkranPoId(Integer.parseInt(request.getParameter("ModelEkran")));
        VelicinaEkrana velicinaEkrana = DAO.vratiVelicinaEkranaPoId(Integer.parseInt(request.getParameter("ModelEkranVel")));
        RezolucijaEkrana rezolucijaEkrana = DAO.vratiRezolucijaEkranaPoId(Integer.parseInt(request.getParameter("ModelEkranRez")));
        BojeEkrana bojeEkrana = DAO.vratiBojuPoId(Integer.parseInt(request.getParameter("BojeEkrana")));
        Rammemorija RAM = DAO.vratiRammemorijaPoId(Integer.parseInt(request.getParameter("ModelRAM")));
        InternaMemorija internaMemorija = DAO.vratiInternaMemorijaPoId(Integer.parseInt(request.getParameter("ModelIntMem")));
        Eksternamemorija eksternamemorija = DAO.vratiEksternamemorijaPoId(Integer.parseInt(request.getParameter("ModelExtMem")));
        Operativnisistem OS = DAO.vratiOperativnisistemPoId(Integer.parseInt(request.getParameter("ModelOS")));
        VerzijaOs verzijaOS = DAO.vratiVerzijaOsPoId(Integer.parseInt(request.getParameter("ModelOSver")));
        Dualsim dualsim = DAO.vratiDualsimPoId(Integer.parseInt(request.getParameter("ModelDualSim")));
        Status status = DAO.vratiStatusPoId(Integer.parseInt(request.getParameter("ModelStatus")));
        
        String path = "C:\\Users\\Nenad\\Documents\\NetBeansProjects\\MobileShop\\web\\slike\\slikeTelefona/";
        Part filePart = request.getPart("ModelUpload");
        String fileName = getFileName(filePart);
        String referencaslike = fileName.substring(0, fileName.indexOf("."));
        
        OutputStream outS = new FileOutputStream(new File(path + File.separator + fileName));
        InputStream filecontent = filePart.getInputStream();

        int read = 0;
        final byte[] bytes = new byte[1024];

        while ((read = filecontent.read(bytes)) != -1) {
                outS.write(bytes, 0, read);
        }

        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}",
                    new Object[]{fileName, path});
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            Model model = new Model(baterija,bojeEkrana,dualsim,ekran,eksternamemorija,internaMemorija,kamera,mreze,OS,
            proizvodjac,RAM,rezolucijaEkrana,rezolucijaKamere,status,tastatura,velicinaEkrana,verzijaOS,nazivModela,dimenzije,tezina,referencaslike,cena);
            DAO.insertModel(model);
            //session.setAttribute("model", model);
            session.setAttribute("sviModeli", DAO.sviModeli());
            DAO.closeSession();
            RequestDispatcher rd = request.getRequestDispatcher("TelefonInfo.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    private String getFileName(final Part part) {
        final String partHeader = part.getHeader("content-disposition");
        LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                        content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }

}
