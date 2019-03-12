/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Date;
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
public class Historique_Echange implements Serializable {

    private String contenu_Echange;
    private Date date_Echange;
    private String path_Compte_Rendu;
    @ManyToOne
    private Devis leDevis;

    public String getContenu_Echange() {
        return contenu_Echange;
    }

    public void setContenu_Echange(String contenu_Echange) {
        this.contenu_Echange = contenu_Echange;
    }

    public Date getDate_Echange() {
        return date_Echange;
    }

    public void setDate_Echange(Date date_Echange) {
        this.date_Echange = date_Echange;
    }

    public String getPath_Compte_Rendu() {
        return path_Compte_Rendu;
    }

    public void setPath_Compte_Rendu(String path_Compte_Rendu) {
        this.path_Compte_Rendu = path_Compte_Rendu;
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
        if (!(object instanceof Historique_Echange)) {
            return false;
        }
        Historique_Echange other = (Historique_Echange) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Historique_Echange[ id=" + id + " ]";
    }
    
}
