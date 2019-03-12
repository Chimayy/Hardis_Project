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
public class Interlocuteur implements Serializable {

    public Entreprise getlEntreprise() {
        return lEntreprise;
    }

    public void setlEntreprise(Entreprise lEntreprise) {
        this.lEntreprise = lEntreprise;
    }
    
    private String nom_Interlocuteur;
    private String prenom_Interlocuteur;
    private String mail_Interlocuteur;
    private String num_Tel_Interlocuteur;
    @ManyToOne
    private Entreprise lEntreprise;
    

    public String getNom_Interlocuteur() {
        return nom_Interlocuteur;
    }

    public void setNom_Interlocuteur(String nom_Interlocuteur) {
        this.nom_Interlocuteur = nom_Interlocuteur;
    }

    public String getPrenom_Interlocuteur() {
        return prenom_Interlocuteur;
    }

    public void setPrenom_Interlocuteur(String prenom_Interlocuteur) {
        this.prenom_Interlocuteur = prenom_Interlocuteur;
    }

    public String getMail_Interlocuteur() {
        return mail_Interlocuteur;
    }

    public void setMail_Interlocuteur(String mail_Interlocuteur) {
        this.mail_Interlocuteur = mail_Interlocuteur;
    }

    public String getNum_Tel_Interlocuteur() {
        return num_Tel_Interlocuteur;
    }

    public void setNum_Tel_Interlocuteur(String num_Tel_Interlocuteur) {
        this.num_Tel_Interlocuteur = num_Tel_Interlocuteur;
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
        if (!(object instanceof Interlocuteur)) {
            return false;
        }
        Interlocuteur other = (Interlocuteur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Interlocuteur[ id=" + id + " ]";
    }
    
}
