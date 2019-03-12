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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author thoma
 */
@Entity
public class Client extends Utilisateur implements Serializable {

    @OneToMany(mappedBy = "leClient")
    private List<Devis> lesDevis = new ArrayList<Devis>();
    @ManyToOne
    private Entreprise lEntreprise;

    

    public List<Devis> getLesDevis() {
        return lesDevis;
    }

    public void setLesDevis(List<Devis> lesDevis) {
        this.lesDevis = lesDevis;
    }

    public Entreprise getlEntreprise() {
        return lEntreprise;
    }

    public void setlEntreprise(Entreprise lEntreprise) {
        this.lEntreprise = lEntreprise;
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
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Client[ id=" + id + " ]";
    }
    
}
