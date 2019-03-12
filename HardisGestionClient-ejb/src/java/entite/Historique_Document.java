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
public class Historique_Document implements Serializable {

    private String path_Document;
    @ManyToOne
    private Devis leDevis;

    public String getPath_Document() {
        return path_Document;
    }

    public void setPath_Document(String path_Document) {
        this.path_Document = path_Document;
    }

    public Devis getLeDevis() {
        return leDevis;
    }

    public void setLeDevis(Devis leDevis) {
        this.leDevis = leDevis;
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
        if (!(object instanceof Historique_Document)) {
            return false;
        }
        Historique_Document other = (Historique_Document) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Historique_Document[ id=" + id + " ]";
    }
    
}
