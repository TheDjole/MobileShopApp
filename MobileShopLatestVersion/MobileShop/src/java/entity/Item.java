package entity;
public class Item 
{
    private Model model;
    private int kolicina;
    
    public Item(Model m,int kolicina)
    {
        this.kolicina = kolicina;
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
    
    
    
    
    
}
