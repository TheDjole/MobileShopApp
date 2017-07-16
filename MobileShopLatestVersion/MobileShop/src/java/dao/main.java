package dao;

import entity.Korisnik;
import entity.Model;
import java.util.List;

public class main
{
    public static void main(String[] args)
    {
       List<Model> modeli = DAO.sviAktivniModeli();
       for(Model m:modeli)
            System.out.println(m.getStatus().getStatus());
        System.out.println(modeli.size());
    }
}
