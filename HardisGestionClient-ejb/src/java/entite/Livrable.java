/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author thoma
 */
@Entity
public class Livrable implements Serializable {

    public Prestation getLaPrestation() {
        return laPrestation;
    }

    public void setLaPrestation(Prestation laPrestation) {
        this.laPrestation = laPrestation;
    }

    private String type_Livrable;
    private String path_Livrable;
    @ManyToOne
    private Prestation laPrestation;

    public String getType_Livrable() {
        return type_Livrable;
    }

    public void setType_Livrable(String type_Livrable) {
        this.type_Livrable = type_Livrable;
    }

    public String getPath_Livrable() {
        return path_Livrable;
    }

    public void setPath_Livrable(String path_Livrable) {
        this.path_Livrable = path_Livrable;
    }
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livrable)) {
            return false;
        }
        Livrable other = (Livrable) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Livrable[ id=" + id + " ]";
    }
    
}
