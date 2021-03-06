package entity;
// Generated Jun 27, 2017 12:32:05 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Baterija generated by hbm2java
 */
@Entity
@Table(name="baterija"
    ,catalog="mobile_shop"
)
public class Baterija  implements java.io.Serializable {


     private Integer baterijaId;
     private String vrstaBaterije;
     private Set<Model> models = new HashSet<Model>(0);

    public Baterija() {
    }

	
    public Baterija(String vrstaBaterije) {
        this.vrstaBaterije = vrstaBaterije;
    }
    public Baterija(String vrstaBaterije, Set<Model> models) {
       this.vrstaBaterije = vrstaBaterije;
       this.models = models;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="baterija_id", unique=true, nullable=false)
    public Integer getBaterijaId() {
        return this.baterijaId;
    }
    
    public void setBaterijaId(Integer baterijaId) {
        this.baterijaId = baterijaId;
    }

    
    @Column(name="vrstaBaterije", nullable=false, length=45)
    public String getVrstaBaterije() {
        return this.vrstaBaterije;
    }
    
    public void setVrstaBaterije(String vrstaBaterije) {
        this.vrstaBaterije = vrstaBaterije;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="baterija")
    public Set<Model> getModels() {
        return this.models;
    }
    
    public void setModels(Set<Model> models) {
        this.models = models;
    }




}


