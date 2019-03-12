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
import javax.persistence.OneToOne;

/**
 *
 * @author thoma
 */
@Entity
public class Consentement_RGPD implements Serializable {

    private boolean boolConsentement;
    private Date dateConsentement;
    @OneToOne
    private Utilisateur user;

    public boolean isBoolConsentement() {
        return boolConsentement;
    }

    public void setBoolConsentement(boolean boolConsentement) {
        this.boolConsentement = boolConsentement;
    }

    public Date getDateConsentement() {
        return dateConsentement;
    }

    public void setDateConsentement(Date dateConsentement) {
        this.dateConsentement = dateConsentement;
    }

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
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
        if (!(object instanceof Consentement_RGPD)) {
            return false;
        }
        Consentement_RGPD other = (Consentement_RGPD) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Consentement_RGPD[ id=" + id + " ]";
    }
    
}
