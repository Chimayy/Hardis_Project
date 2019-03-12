/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
public class Facture implements Serializable {

    public List<Bon_De_Commande> getBon_De_Commandes() {
        return bon_De_Commandes;
    }

    public void setBon_De_Commandes(List<Bon_De_Commande> bon_De_Commandes) {
        this.bon_De_Commandes = bon_De_Commandes;
    }

    public int getPourcentage_paiement_Facture() {
        return pourcentage_paiement_Facture;
    }

    public void setPourcentage_paiement_Facture(int pourcentage_paiement_Facture) {
        this.pourcentage_paiement_Facture = pourcentage_paiement_Facture;
    }

    @OneToMany(mappedBy = "laFacture")
    private List<Bon_De_Commande> bon_De_Commandes = new ArrayList<Bon_De_Commande>();

    private double montant_Facture;
    private int pourcentage_paiement_Facture;
    private Date date_Facture;
    private etat_Facture etat_Facture;

    public etat_Facture getEtat_Facture() {
        return etat_Facture;
    }

    public void setEtat_Facture(etat_Facture etat_Facture) {
        this.etat_Facture = etat_Facture;
    }
    
    

    public double getMontant_Facture() {
        return montant_Facture;
    }

    public void setMontant_Facture(double montant_Facture) {
        this.montant_Facture = montant_Facture;
    }

    public int getPourcentage_avancement_Facture() {
        return pourcentage_paiement_Facture;
    }

    public void setPourcentage_avancement_Facture(int pourcentage_avancement_Facture) {
        this.pourcentage_paiement_Facture = pourcentage_avancement_Facture;
    }

    public Date getDate_Facture() {
        return date_Facture;
    }

    public void setDate_Facture(Date date_Facture) {
        this.date_Facture = date_Facture;
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
        if (!(object instanceof Facture)) {
            return false;
        }
        Facture other = (Facture) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Facture[ id=" + id + " ]";
    }
    
}
