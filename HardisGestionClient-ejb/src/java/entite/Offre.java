/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author thoma
 */
@Entity
public class Offre implements Serializable {

    @OneToMany(mappedBy = "lOffre")
    private List<Historique_QuestionPublique> historique_QuestionPubliques;

    public List<Profil_Metier> getProfil_Metiers() {
        return profil_Metiers;
    }

    public void setProfil_Metiers(List<Profil_Metier> profil_Metiers) {
        this.profil_Metiers = profil_Metiers;
    }

    public List<Devis> getLesDevis() {
        return lesDevis;
    }

    public void setLesDevis(List<Devis> lesDevis) {
        this.lesDevis = lesDevis;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    @OneToMany(mappedBy = "lOffre")
    private List<Profil_Metier> profil_Metiers = new ArrayList<Profil_Metier>();

    @OneToMany(mappedBy = "lOffre")
    private List<Devis> lesDevis = new ArrayList<Devis>();

    @OneToMany(mappedBy = "lOffre")
    private List<Service> services = new ArrayList<Service>();

    private String nom_Offre;
    private String description_Offre;

    public String getNom_Offre() {
        return nom_Offre;
    }

    public void setNom_Offre(String nom_Offre) {
        this.nom_Offre = nom_Offre;
    }

    public String getDescription_Offre() {
        return description_Offre;
    }

    public void setDescription_Offre(String description_Offre) {
        this.description_Offre = description_Offre;
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
        if (!(object instanceof Offre)) {
            return false;
        }
        Offre other = (Offre) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Offre[ id=" + id + " ]";
    }
    
}
