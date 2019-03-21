/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
public class Historique_Question implements Serializable {

    private String Contenu_Question;
    private Date Date_Question;
    private String mot_Cle;
    @ManyToOne
    private Devis leDevis;
    @Column(name="REPONSE")
    private String Reponse;

    public Devis getLeDevis() {
        return leDevis;
    }

    public void setLeDevis(Devis leDevis) {
        this.leDevis = leDevis;
    }

    public String getReponse() {
        return Reponse;
    }

    public void setReponse(String reponse) {
        this.Reponse = reponse;
    }
    
    
    

    public String getContenu_Question() {
        return Contenu_Question;
    }

    public void setContenu_Question(String Contenu_Question) {
        this.Contenu_Question = Contenu_Question;
    }

    public Date getDate_Question() {
        return Date_Question;
    }

    public void setDate_Question(Date Date_Question) {
        this.Date_Question = Date_Question;
    }

    public String getMot_Cle() {
        return mot_Cle;
    }

    public void setMot_Cle(String mot_Cle) {
        this.mot_Cle = mot_Cle;
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
        if (!(object instanceof Historique_Question)) {
            return false;
        }
        Historique_Question other = (Historique_Question) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Historique_Question[ id=" + id + " ]";
    }
    
}
