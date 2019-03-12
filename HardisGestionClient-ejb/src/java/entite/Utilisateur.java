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
import javax.persistence.OneToOne;

/**
 *
 * @author thoma
 */
@Entity
public class Utilisateur implements Serializable {

    @OneToOne(mappedBy = "user")
    private Consentement_RGPD leConsentement;

    private String mot_De_Passe;
    private String mail_Connexion;
    private String nom_Utilisateur;
    private String prenom_Utilisateur;

    public Consentement_RGPD getLeConsentement() {
        return leConsentement;
    }

    public void setLeConsentement(Consentement_RGPD leConsentement) {
        this.leConsentement = leConsentement;
    }

    public String getMot_De_Passe() {
        return mot_De_Passe;
    }

    public void setMot_De_Passe(String mot_De_Passe) {
        this.mot_De_Passe = mot_De_Passe;
    }

    public String getMail_Connexion() {
        return mail_Connexion;
    }

    public void setMail_Connexion(String mail_Connexion) {
        this.mail_Connexion = mail_Connexion;
    }

    public String getNom_Utilisateur() {
        return nom_Utilisateur;
    }

    public void setNom_Utilisateur(String nom_Utilisateur) {
        this.nom_Utilisateur = nom_Utilisateur;
    }

    public String getPrenom_Utilisateur() {
        return prenom_Utilisateur;
    }

    public void setPrenom_Utilisateur(String prenom_Utilisateur) {
        this.prenom_Utilisateur = prenom_Utilisateur;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Utilisateur[ id=" + id + " ]";
    }
    
}
