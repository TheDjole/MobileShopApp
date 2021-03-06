package entity;
// Generated Jun 27, 2017 12:32:05 PM by Hibernate Tools 4.3.1


import java.math.BigDecimal;
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
 * VelicinaEkrana generated by hbm2java
 */
@Entity
@Table(name="velicina_ekrana"
    ,catalog="mobile_shop"
)
public class VelicinaEkrana  implements java.io.Serializable {


     private Integer velicinaId;
     private BigDecimal dijagonala;
     private Set<Model> models = new HashSet<Model>(0);

    public VelicinaEkrana() {
    }

	
    public VelicinaEkrana(BigDecimal dijagonala) {
        this.dijagonala = dijagonala;
    }
    public VelicinaEkrana(BigDecimal dijagonala, Set<Model> models) {
       this.dijagonala = dijagonala;
       this.models = models;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="velicina_id", unique=true, nullable=false)
    public Integer getVelicinaId() {
        return this.velicinaId;
    }
    
    public void setVelicinaId(Integer velicinaId) {
        this.velicinaId = velicinaId;
    }

    
    @Column(name="dijagonala", nullable=false, precision=6, scale=1)
    public BigDecimal getDijagonala() {
        return this.dijagonala;
    }
    
    public void setDijagonala(BigDecimal dijagonala) {
        this.dijagonala = dijagonala;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="velicinaEkrana")
    public Set<Model> getModels() {
        return this.models;
    }
    
    public void setModels(Set<Model> models) {
        this.models = models;
    }




}


