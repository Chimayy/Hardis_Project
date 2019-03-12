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

/**
 *
 * @author thoma
 */
@Entity
public class Prestation_Standard extends Prestation implements Serializable {

    public String getExpertise_Minimum() {
        return expertise_Minimum;
    }

    public void setExpertise_Minimum(String expertise_Minimum) {
        this.expertise_Minimum = expertise_Minimum;
    }

    public double getMontant_Jour() {
        return montant_Jour;
    }

    public void setMontant_Jour(double montant_Jour) {
        this.montant_Jour = montant_Jour;
    }

    public double getNb_Jours() {
        return nb_Jours;
    }

    public void setNb_Jours(double nb_Jours) {
        this.nb_Jours = nb_Jours;
    }

    private String expertise_Minimum;
    private double montant_Jour;
    private double nb_Jours;
    
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
        if (!(object instanceof Prestation_Standard)) {
            return false;
        }
        Prestation_Standard other = (Prestation_Standard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Prestation_Standard[ id=" + id + " ]";
    }
    
}
