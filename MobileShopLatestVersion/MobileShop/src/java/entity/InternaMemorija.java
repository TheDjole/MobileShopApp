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
 * InternaMemorija generated by hbm2java
 */
@Entity
@Table(name="interna_memorija"
    ,catalog="mobile_shop"
)
public class InternaMemorija  implements java.io.Serializable {


     private Integer internamemorijaId;
     private String vrednost;
     private Set<Model> models = new HashSet<Model>(0);

    public InternaMemorija() {
    }

	
    public InternaMemorija(String vrednost) {
        this.vrednost = vrednost;
    }
    public InternaMemorija(String vrednost, Set<Model> models) {
       this.vrednost = vrednost;
       this.models = models;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="internamemorija_Id", unique=true, nullable=false)
    public Integer getInternamemorijaId() {
        return this.internamemorijaId;
    }
    
    public void setInternamemorijaId(Integer internamemorijaId) {
        this.internamemorijaId = internamemorijaId;
    }

    
    @Column(name="vrednost", nullable=false, length=45)
    public String getVrednost() {
        return this.vrednost;
    }
    
    public void setVrednost(String vrednost) {
        this.vrednost = vrednost;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="internaMemorija")
    public Set<Model> getModels() {
        return this.models;
    }
    
    public void setModels(Set<Model> models) {
        this.models = models;
    }




}


