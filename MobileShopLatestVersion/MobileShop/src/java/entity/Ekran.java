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
 * Ekran generated by hbm2java
 */
@Entity
@Table(name="ekran"
    ,catalog="mobile_shop"
)
public class Ekran  implements java.io.Serializable {


     private Integer ekranId;
     private String tipEkrana;
     private Set<Model> models = new HashSet<Model>(0);

    public Ekran() {
    }

	
    public Ekran(String tipEkrana) {
        this.tipEkrana = tipEkrana;
    }
    public Ekran(String tipEkrana, Set<Model> models) {
       this.tipEkrana = tipEkrana;
       this.models = models;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ekran_id", unique=true, nullable=false)
    public Integer getEkranId() {
        return this.ekranId;
    }
    
    public void setEkranId(Integer ekranId) {
        this.ekranId = ekranId;
    }

    
    @Column(name="tipEkrana", nullable=false, length=45)
    public String getTipEkrana() {
        return this.tipEkrana;
    }
    
    public void setTipEkrana(String tipEkrana) {
        this.tipEkrana = tipEkrana;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ekran")
    public Set<Model> getModels() {
        return this.models;
    }
    
    public void setModels(Set<Model> models) {
        this.models = models;
    }




}

