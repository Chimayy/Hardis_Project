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
 * @author Utilisateur
 */
@Entity
public class Historique_QuestionPublique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String pseudo;
    private String question;
    private String reponse;
    @ManyToOne
    private Offre lOffre;
    @ManyToOne
    private Utilisateur_Hardis gestionnaire;

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Offre getlOffre() {
        return lOffre;
    }

    public void setlOffre(Offre lOffre) {
        this.lOffre = lOffre;
    }

    public Utilisateur_Hardis getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Utilisateur_Hardis gestionnaire) {
        this.gestionnaire = gestionnaire;
    }
    
    

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
        if (!(object instanceof Historique_QuestionPublique)) {
            return false;
        }
        Historique_QuestionPublique other = (Historique_QuestionPublique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Historique_QuestionPublique[ id=" + id + " ]";
    }
    
}