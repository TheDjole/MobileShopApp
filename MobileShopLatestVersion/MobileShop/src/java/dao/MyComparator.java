package dao;

import entity.Model;
import java.util.Comparator;

public class MyComparator implements Comparator<Model>
{

    @Override
    public int compare(Model o1, Model o2)
    {
        if(o1.getCena() > o2.getCena()) 
            return -1;
        else if(o1.getCena() < o2.getCena())
            return 1;
        return 0;
        
    }
    
}
