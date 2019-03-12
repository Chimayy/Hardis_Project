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
public class CV implements Serializable {

    private String type_CV;
    private String path_CV;

    public String getType_CV() {
        return type_CV;
    }

    public void setType_CV(String type_CV) {
        this.type_CV = type_CV;
    }

    public String getPath_CV() {
        return path_CV;
    }

    public void setPath_CV(String path_CV) {
        this.path_CV = path_CV;
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
        if (!(object instanceof CV)) {
            return false;
        }
        CV other = (CV) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.CV[ id=" + id + " ]";
    }
    
}
