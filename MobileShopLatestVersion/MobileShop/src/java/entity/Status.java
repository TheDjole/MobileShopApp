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
 * Status generated by hbm2java
 */
@Entity
@Table(name="status"
    ,catalog="mobile_shop"
)
public class Status  implements java.io.Serializable {


     private Integer statusId;
     private String status;
     private Set<Model> models = new HashSet<Model>(0);

    public Status() {
    }

	
    public Status(String status) {
        this.status = status;
    }
    public Status(String status, Set<Model> models) {
       this.status = status;
       this.models = models;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="status_id", unique=true, nullable=false)
    public Integer getStatusId() {
        return this.statusId;
    }
    
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    
    @Column(name="status", nullable=false, length=45)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="status")
    public Set<Model> getModels() {
        return this.models;
    }
    
    public void setModels(Set<Model> models) {
        this.models = models;
    }




}


