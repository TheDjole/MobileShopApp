package dao;

import entity.Baterija;
import entity.BojeEkrana;
import entity.Dualsim;
import entity.Ekran;
import entity.Eksternamemorija;
import entity.InternaMemorija;
import entity.Kamera;
import entity.Korisnik;
import entity.Model;
import entity.Mreze;
import entity.Operativnisistem;
import entity.Poruzbina;
import entity.Prava;
import entity.Proizvodjac;
import entity.Rammemorija;
import entity.RezolucijaEkrana;
import entity.RezolucijaKamere;
import entity.Status;
import entity.Stavka;
import entity.Tastatura;
import entity.VelicinaEkrana;
import entity.VerzijaOs;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DAO 
{
    private static Session session = null;
  
    
    public static List<Proizvodjac> sviProizvodjaci()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Proizvodjac> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Proizvodjac");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Model> sviModeli()
    { 
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Model> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Model");
            pomocna = query.list();
            for(Model m:pomocna)
               Hibernate.initialize(m);
            trans.commit();
        } 
        catch (HibernateException e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
        
    }
    
    public static List<Korisnik> sviKorisnici()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Korisnik> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Korisnik k join fetch k.prava p where p.pravaId = :id ");
            query.setParameter("id", 2);
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Model> sviModeliJednoProizvodjaca(String proizvodjac)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Model> pomocna = new ArrayList();
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Proizvodjac where nazivBrenda = :podatak");
            query.setParameter("podatak", proizvodjac);
            Proizvodjac pom = (Proizvodjac)query.list().get(0);
            for(Model m:pom.getModels())
                if(m.getStatus().getStatusId()!=3) pomocna.add(m);
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static boolean proveraProizvodjaca(String proizvodjac){
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Proizvodjac where nazivBrenda = :podatak");
            query.setParameter("podatak", proizvodjac);
            Proizvodjac pom = (Proizvodjac)query.list().get(0);
            if(!pom.equals(null)) return true;
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
        }
        return false;
    }
    
    public static boolean proveraKorIme(String username)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Korisnik where username = :podatak");
            query.setParameter("podatak", username);
            if(query.list().isEmpty()) return false;
            //Korisnik pom = (Korisnik)query.list().get(0);
            //if(pom != null) return true;
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return true;
    }
    
    public static boolean proveraEmail(String eMail)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Korisnik where email = :podatak");
            query.setParameter("podatak", eMail);
            if(query.list().isEmpty()) return false;
            //Korisnik pom = (Korisnik)query.list().get(0);
            //if(pom!=null) return true;
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return true;
    }
    
    public static Korisnik ubaciKorisnika(Korisnik korisnik)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(korisnik);
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return korisnik;
    }
    
    public static Korisnik logovanKorisnik(String username)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Korisnik pom = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Korisnik where username = :podatak");
            query.setParameter("podatak", username);
            pom = (Korisnik)query.list().get(0);
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static void azurirajPassword(Korisnik kor,String pass)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try
        {
            trans = session.beginTransaction();
            kor.setPassword(pass);
            session.merge(kor);
            trans.commit();
        }
        catch(Exception e){
           if(trans != null) {
                trans.rollback();  
            }
           System.out.println(e);
        }
    }
    
    public static void azurirajPodatke(String user, String ime, String prezime, String email, String adresa, String grad)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Query q = session.createQuery("from Korisnik where username = :podatak");
            q.setParameter("podatak", user);
            Korisnik pom = (Korisnik)q.list().get(0);
            pom.setIme(ime);
            pom.setPrezime(prezime);
            pom.setEmail(email);
            pom.setAdresa(adresa);
            pom.setGrad(grad);
            session.merge(pom);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static Model vratiModelpoID(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Model pom = (Model)session.get(Model.class, id);
            trans.commit();
            if(!pom.equals(null)) 
                return pom;
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        
        return null;
    }
    
    public static void closeSession()
    {
        session.close();
    }
    
    public static Prava vratiPravoKor(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Prava pravo = null;
        try 
        {
            trans = session.beginTransaction();
            pravo = (Prava)session.get(Prava.class, id);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        
        return pravo;
    }
    
    public static Poruzbina insertPorudzbina(Poruzbina poruzbina)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(poruzbina);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return poruzbina;
    }
    
    public static void insertStavke(Stavka stavka)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(stavka);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static Poruzbina selectPoruzbina(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Poruzbina poruzbina = null;
        try 
        {
            trans = session.beginTransaction();
            poruzbina = (Poruzbina)session.get(Poruzbina.class, id);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        
        return poruzbina;
    }
    
    public static Korisnik vratiKorisnikaPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Korisnik pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Korisnik)session.get(Korisnik.class, id);
            trans.commit();
        }
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static List<Mreze> sveMreze()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Mreze> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Mreze");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Tastatura> sveTastature()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Tastatura> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Tastatura");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Baterija> sveBaterije()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Baterija> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Baterija");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Kamera> sveKamere()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Kamera> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Kamera");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<RezolucijaKamere> sveRezolucijaKamere()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<RezolucijaKamere> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from RezolucijaKamere");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Ekran> sveTipoveEkrana()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Ekran> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Ekran");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
           if(trans != null) {
                trans.rollback();  
            }
           System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<VelicinaEkrana> sveVelicinaEkrana()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<VelicinaEkrana> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from VelicinaEkrana");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<RezolucijaEkrana> sveRezolucijaEkrana()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<RezolucijaEkrana> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from RezolucijaEkrana");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<BojeEkrana> sveBojeEkrana()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<BojeEkrana> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from BojeEkrana");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Rammemorija> sveRAMMem()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Rammemorija> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Rammemorija");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<InternaMemorija> sveInternaMemorija()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<InternaMemorija> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from InternaMemorija");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Eksternamemorija> svaEksternamemorija()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Eksternamemorija> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Eksternamemorija");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Operativnisistem> sviOS()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Operativnisistem> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Operativnisistem");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<VerzijaOs> sveVerzijeOs()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<VerzijaOs> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from VerzijaOs");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Dualsim> sviDualsim()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Dualsim> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Dualsim");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
    
    public static List<Status> sviStatuses()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Status> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Status");
            pomocna = query.list();
            trans.commit();
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
   
    public static void insertModel(Model model)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(model);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static Baterija vratiBaterijuPoId(int id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Baterija pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Baterija)session.get(Baterija.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static BojeEkrana vratiBojuPoId(int id) 
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        BojeEkrana pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (BojeEkrana)session.get(BojeEkrana.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static Dualsim vratiDualsimPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Dualsim pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Dualsim)session.get(Dualsim.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static Ekran vratiEkranPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Ekran pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Ekran)session.get(Ekran.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
     public static Eksternamemorija vratiEksternamemorijaPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Eksternamemorija pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Eksternamemorija)session.get(Eksternamemorija.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
     
    public static InternaMemorija vratiInternaMemorijaPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        InternaMemorija pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (InternaMemorija)session.get(InternaMemorija.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static Kamera vratiKameraPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Kamera pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Kamera)session.get(Kamera.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static Mreze vratiMrezePoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Mreze pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Mreze)session.get(Mreze.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static Operativnisistem vratiOperativnisistemPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Operativnisistem pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Operativnisistem)session.get(Operativnisistem.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static Proizvodjac vratiProizvodjacPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Proizvodjac pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Proizvodjac)session.get(Proizvodjac.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static Rammemorija vratiRammemorijaPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Rammemorija pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Rammemorija)session.get(Rammemorija.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static RezolucijaEkrana vratiRezolucijaEkranaPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        RezolucijaEkrana pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (RezolucijaEkrana)session.get(RezolucijaEkrana.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static RezolucijaKamere vratiRezolucijaKamerePoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        RezolucijaKamere pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (RezolucijaKamere)session.get(RezolucijaKamere.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static Status vratiStatusPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Status pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Status)session.get(Status.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static Tastatura vratiTastaturaPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        Tastatura pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (Tastatura)session.get(Tastatura.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pom;
    }
    
    public static VelicinaEkrana vratiVelicinaEkranaPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        VelicinaEkrana pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (VelicinaEkrana)session.get(VelicinaEkrana.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
           if(trans != null) {
                trans.rollback();  
            }
           System.out.println(e);
        }
        return pom;
    }
    
    public static VerzijaOs vratiVerzijaOsPoId(int id)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        VerzijaOs pom = null;
        try 
        {
            trans = session.beginTransaction();
            pom = (VerzijaOs)session.get(VerzijaOs.class, id);
            trans.commit();
        } 
        catch (Exception e)
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
            
        }
        return pom;
    }
    
    public static void insertBateriju(Baterija baterija)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(baterija);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertMreze(Mreze mreze)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(mreze);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertTastaturu(Tastatura tastatura)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(tastatura);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertEkran(Ekran ekran)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(ekran);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertVelicinuEkrana(VelicinaEkrana velicinaEkrana)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(velicinaEkrana);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertStatus(Status status)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(status);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertRezolucijaEkrana(RezolucijaEkrana rezolucijaEkrana)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(rezolucijaEkrana);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertKamera(Kamera kamera)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(kamera);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertRezolucijaKamere(RezolucijaKamere rezolucijaKamere)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(rezolucijaKamere);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertBojuEkrana(BojeEkrana bojeEkrana)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(bojeEkrana);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertOperativniSistem(Operativnisistem operativnisistem)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(operativnisistem);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertVerzijaOS(VerzijaOs verzijaOs)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(verzijaOs);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertRAM(Rammemorija rammemorija)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(rammemorija);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void insertInternaMemorija(InternaMemorija internaMemorija)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            session.persist(internaMemorija);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void updateCenuModela(int id,int cena)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Model pom = (Model)session.get(Model.class, id);
            pom.setCena(cena);
            session.merge(pom);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void updateDimezijeModela(int id,String dimenzije)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Model pom = (Model)session.get(Model.class, id);
            pom.setDimenzijeTelefona(dimenzije.trim());
            session.merge(pom);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void updateNazivModela(int id,String Naziv)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Model pom = (Model)session.get(Model.class, id);
            pom.setNazivModela(Naziv.trim());
            session.merge(pom);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static void updateStatusModela(int id,int statusid)
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        try 
        {
            trans = session.beginTransaction();
            Model pom = (Model)session.get(Model.class, id);
            pom.setStatus(vratiStatusPoId(statusid));
            session.merge(pom);
            trans.commit();
            
        } 
        catch (Exception e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
    }
    
    public static List<Model> sviAktivniModeli()
    {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = null;
        List<Model> pomocna = null;
        try 
        {
            trans = session.beginTransaction();
            Query query = session.createQuery("from Model m join fetch m.status ms where ms.statusId != 3");
            pomocna = query.list();
            for(Model m:pomocna)
               Hibernate.initialize(m);
            trans.commit();
        } 
        catch (HibernateException e) 
        {
            if(trans != null) {
                trans.rollback();  
            }
            System.out.println(e);
        }
        return pomocna;
    }
}
