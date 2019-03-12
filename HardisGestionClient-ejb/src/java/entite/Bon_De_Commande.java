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
public class Bon_De_Commande implements Serializable {

    private double montant_BonDeCommande;
    private String descriptif_BonDeCommande;
    @ManyToOne
    private Facture laFacture;
    @ManyToOne
    private Prestation laPrestation;

    public Facture getLaFacture() {
        return laFacture;
    }

    public void setLaFacture(Facture laFacture) {
        this.laFacture = laFacture;
    }

    public Prestation getLaPrestation() {
        return laPrestation;
    }

    public void setLaPrestation(Prestation laPrestation) {
        this.laPrestation = laPrestation;
    }
    

    public double getMontant_BonDeCommande() {
        return montant_BonDeCommande;
    }

    public void setMontant_BonDeCommande(double montant_BonDeCommande) {
        this.montant_BonDeCommande = montant_BonDeCommande;
    }

    public String getDescriptif_BonDeCommande() {
        return descriptif_BonDeCommande;
    }

    public void setDescriptif_BonDeCommande(String descriptif_BonDeCommande) {
        this.descriptif_BonDeCommande = descriptif_BonDeCommande;
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
        if (!(object instanceof Bon_De_Commande)) {
            return false;
        }
        Bon_De_Commande other = (Bon_De_Commande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Bon_De_Commane[ id=" + id + " ]";
    }
    
}
