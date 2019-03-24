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
public class Profil_Metier implements Serializable {

    private int niveau_Habilitation;
    @ManyToOne
    private Offre lOffre;
    @ManyToOne
    private Utilisateur_Hardis lUtilisateur;
    private String pathCV;

    public String getPathCV() {
        return pathCV;
    }

    public void setPathCV(String pathCV) {
        this.pathCV = pathCV;
    }
    
    

    public Offre getlOffre() {
        return lOffre;
    }

    public void setlOffre(Offre lOffre) {
        this.lOffre = lOffre;
    }

    public Utilisateur_Hardis getlUtilisateur() {
        return lUtilisateur;
    }

    public void setlUtilisateur(Utilisateur_Hardis lUtilisateur) {
        this.lUtilisateur = lUtilisateur;
    }
    

    public int getNiveau_Habilitation() {
        return niveau_Habilitation;
    }

    public void setNiveau_Habilitation(int niveau_Habilitation) {
        this.niveau_Habilitation = niveau_Habilitation;
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
        if (!(object instanceof Profil_Metier)) {
            return false;
        }
        Profil_Metier other = (Profil_Metier) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Profil_Metier[ id=" + id + " ]";
    }
    
}
