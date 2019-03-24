/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author thoma
 */
@Entity
public class Utilisateur_Hardis extends Utilisateur implements Serializable {


    @OneToMany(mappedBy = "leConsultant")
    private List<Historique_Consultant> historique_Consultants = new ArrayList<Historique_Consultant>();

    public List<Profil_Metier> getProfil_Metiers() {
        return profil_Metiers;
    }

    public void setProfil_Metiers(List<Profil_Metier> profil_Metiers) {
        this.profil_Metiers = profil_Metiers;
    }

    public List<Periode_Disponible> getPeriode_Disponibles() {
        return periode_Disponibles;
    }

    public void setPeriode_Disponibles(List<Periode_Disponible> periode_Disponibles) {
        this.periode_Disponibles = periode_Disponibles;
    }

    @OneToMany(mappedBy = "lUtilisateur")
    private List<Profil_Metier> profil_Metiers = new ArrayList<Profil_Metier>();

    @OneToMany(mappedBy = "user")
    private List<Periode_Disponible> periode_Disponibles = new ArrayList<Periode_Disponible>();

    private double plafond_Delegation;
    private boolean statut_Actif;
    private profil_Technique profil_Technique;
    @ManyToOne
    @JoinColumn(name="LAGENCE_ID")
    private Agence lAgence;

    public List<Historique_Consultant> getHistorique_Consultants() {
        return historique_Consultants;
    }

    public void setHistorique_Consultants(List<Historique_Consultant> historique_Consultants) {
        this.historique_Consultants = historique_Consultants;
    }

    public Agence getlAgence() {
        return lAgence;
    }

    public void setlAgence(Agence lAgence) {
        this.lAgence = lAgence;
    }
    
    public double getPlafond_Delegation() {
        return plafond_Delegation;
    }

    public void setPlafond_Delegation(double plafond_Delegation) {
        this.plafond_Delegation = plafond_Delegation;
    }

    public boolean isStatut_Actif() {
        return statut_Actif;
    }

    public void setStatut_Actif(boolean statut_Actif) {
        this.statut_Actif = statut_Actif;
    }

    public profil_Technique getProfil_Technique() {
        return profil_Technique;
    }

    public void setProfil_Technique(profil_Technique profil_Technique) {
        this.profil_Technique = profil_Technique;
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
        if (!(object instanceof Utilisateur_Hardis)) {
            return false;
        }
        Utilisateur_Hardis other = (Utilisateur_Hardis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.utilisateur_Hardis[ id=" + id + " ]";
    }
    
}
