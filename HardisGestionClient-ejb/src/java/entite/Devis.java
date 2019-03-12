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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author thoma
 */
@Entity
public class Devis implements Serializable {

    @OneToMany(mappedBy = "leDevis")
    private List<Historique_Consultant> historique_Consultants = new ArrayList<Historique_Consultant>();

    @OneToMany(mappedBy = "leDevis")
    private List<Historique_Question> historique_Questions = new ArrayList<Historique_Question>();

    @OneToMany(mappedBy = "leDevis")
    private List<Historique_Echange> historique_Echanges = new ArrayList<Historique_Echange>();

    @OneToMany(mappedBy = "leDevis")
    private List<Historique_Document> historique_Documents = new ArrayList<Historique_Document>();

    private String motif_Refus;
    private Date date_Devis;
    private double montant_Devis;
    private String formulaire_Client;
    private boolean facturation_Auto;
    private Date date_Intervention;
    private statut_Devis statut;
    private Date date_Debut;
    private Date date_Fin;
    @ManyToOne
    private Offre lOffre;
    @ManyToOne
    private Prestation laPrestation;
    @ManyToOne
    private Client leClient;

    public List<Historique_Echange> getHistorique_Echanges() {
        return historique_Echanges;
    }

    public void setHistorique_Echanges(List<Historique_Echange> historique_Echanges) {
        this.historique_Echanges = historique_Echanges;
    }

    public List<Historique_Document> getHistorique_Documents() {
        return historique_Documents;
    }

    public void setHistorique_Documents(List<Historique_Document> historique_Documents) {
        this.historique_Documents = historique_Documents;
    }

    public Offre getlOffre() {
        return lOffre;
    }

    public void setlOffre(Offre lOffre) {
        this.lOffre = lOffre;
    }

    public Prestation getLaPrestation() {
        return laPrestation;
    }

    public void setLaPrestation(Prestation laPrestation) {
        this.laPrestation = laPrestation;
    }

    public Client getLeClient() {
        return leClient;
    }

    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }
    
    

    public Date getDate_Debut() {
        return date_Debut;
    }

    public void setDate_Debut(Date date_Debut) {
        this.date_Debut = date_Debut;
    }

    public Date getDate_Fin() {
        return date_Fin;
    }

    public void setDate_Fin(Date date_Fin) {
        this.date_Fin = date_Fin;
    }
    

    public statut_Devis getStatut() {
        return statut;
    }

    public void setStatut(statut_Devis statut) {
        this.statut = statut;
    }
    
    

    public String getMotif_Refus() {
        return motif_Refus;
    }

    public void setMotif_Refus(String motif_Refus) {
        this.motif_Refus = motif_Refus;
    }

    public Date getDate_Devis() {
        return date_Devis;
    }

    public void setDate_Devis(Date date_Devis) {
        this.date_Devis = date_Devis;
    }

    public double getMontant_Devis() {
        return montant_Devis;
    }

    public void setMontant_Devis(double montant_Devis) {
        this.montant_Devis = montant_Devis;
    }

    public String getFormulaire_Client() {
        return formulaire_Client;
    }

    public void setFormulaire_Client(String formulaire_Client) {
        this.formulaire_Client = formulaire_Client;
    }

    public boolean isFacturation_Auto() {
        return facturation_Auto;
    }

    public void setFacturation_Auto(boolean facturation_Auto) {
        this.facturation_Auto = facturation_Auto;
    }

    public Date getDate_Intervention() {
        return date_Intervention;
    }

    public void setDate_Intervention(Date date_Intervention) {
        this.date_Intervention = date_Intervention;
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
        if (!(object instanceof Devis)) {
            return false;
        }
        Devis other = (Devis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Devis[ id=" + id + " ]";
    }
    
}
