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

/**
 *
 * @author thoma
 */
@Entity
public class Devis_Non_Standard extends Devis implements Serializable {

    private String path_Powerpoint;


    public String getPath_Powerpoint() {
        return path_Powerpoint;
    }

    public void setPath_Powerpoint(String path_Powerpoint) {
        this.path_Powerpoint = path_Powerpoint;
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
        if (!(object instanceof Devis_Non_Standard)) {
            return false;
        }
        Devis_Non_Standard other = (Devis_Non_Standard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Devis_Non_Standard[ id=" + id + " ]";
    }
    
    
}
