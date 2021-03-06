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
 * Proizvodjac generated by hbm2java
 */
@Entity
@Table(name="proizvodjac"
    ,catalog="mobile_shop"
)
public class Proizvodjac  implements java.io.Serializable {


     private Integer proizvodjacId;
     private String nazivBrenda;
     private Set<Model> models = new HashSet<Model>(0);

    public Proizvodjac() {
    }

	
    public Proizvodjac(String nazivBrenda) {
        this.nazivBrenda = nazivBrenda;
    }
    public Proizvodjac(String nazivBrenda, Set<Model> models) {
       this.nazivBrenda = nazivBrenda;
       this.models = models;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="proizvodjac_id", unique=true, nullable=false)
    public Integer getProizvodjacId() {
        return this.proizvodjacId;
    }
    
    public void setProizvodjacId(Integer proizvodjacId) {
        this.proizvodjacId = proizvodjacId;
    }

    
    @Column(name="nazivBrenda", nullable=false, length=45)
    public String getNazivBrenda() {
        return this.nazivBrenda;
    }
    
    public void setNazivBrenda(String nazivBrenda) {
        this.nazivBrenda = nazivBrenda;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proizvodjac")
    public Set<Model> getModels() {
        return this.models;
    }
    
    public void setModels(Set<Model> models) {
        this.models = models;
    }




}


