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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author thoma
 */
@Entity
public class Prestation implements Serializable {

    public List<Devis> getLesDevis() {
        return lesDevis;
    }

    public void setLesDevis(List<Devis> lesDevis) {
        this.lesDevis = lesDevis;
    }

    public List<Livrable> getLivrables() {
        return livrables;
    }

    public void setLivrables(List<Livrable> livrables) {
        this.livrables = livrables;
    }

    public List<Condition_Contractuelle> getCondition_Contractuelles() {
        return condition_Contractuelles;
    }

    public void setCondition_Contractuelles(List<Condition_Contractuelle> condition_Contractuelles) {
        this.condition_Contractuelles = condition_Contractuelles;
    }

    public List<Bon_De_Commande> getBon_De_Commandes() {
        return bon_De_Commandes;
    }

    public void setBon_De_Commandes(List<Bon_De_Commande> bon_De_Commandes) {
        this.bon_De_Commandes = bon_De_Commandes;
    }

    public String getNom_Prestation() {
        return nom_Prestation;
    }

    public void setNom_Prestation(String nom_Prestation) {
        this.nom_Prestation = nom_Prestation;
    }

    public String getDescription_Prestation() {
        return description_Prestation;
    }

    public void setDescription_Prestation(String description_Prestation) {
        this.description_Prestation = description_Prestation;
    }

    public double getCout_Prestation() {
        return cout_Prestation;
    }

    public void setCout_Prestation(double cout_Prestation) {
        this.cout_Prestation = cout_Prestation;
    }

    public boolean isFacturation_Frais_Inclus() {
        return facturation_Frais_Inclus;
    }

    public void setFacturation_Frais_Inclus(boolean facturation_Frais_Inclus) {
        this.facturation_Frais_Inclus = facturation_Frais_Inclus;
    }

    public Service getLeService() {
        return leService;
    }

    public void setLeService(Service leService) {
        this.leService = leService;
    }

    @OneToMany(mappedBy = "laPrestation")
    private List<Devis> lesDevis = new ArrayList<Devis>();

    @OneToMany(mappedBy = "laPrestation")
    private List<Livrable> livrables = new ArrayList<Livrable>();

    @ManyToMany
    private List<Condition_Contractuelle> condition_Contractuelles = new ArrayList<Condition_Contractuelle>();

    @OneToMany(mappedBy = "laPrestation")
    private List<Bon_De_Commande> bon_De_Commandes = new ArrayList<Bon_De_Commande>();

    private String nom_Prestation;
    private String description_Prestation;
    private String nom_Responsable;
    private String tel_Responsable;
    private String mail_Responsable;
    private double cout_Prestation;
    private boolean facturation_Frais_Inclus;
    private int delai_Relance;
    private lieu_Intervention lieu_Intervention;
    @ManyToOne
    private Service leService;

    public lieu_Intervention getLieu_Intervention() {
        return lieu_Intervention;
    }

    public void setLieu_Intervention(lieu_Intervention lieu_Intervention) {
        this.lieu_Intervention = lieu_Intervention;
    }

    public String getnom_Prestation() {
        return nom_Prestation;
    }

    public void setnom_Prestation(String nom_Prestation) {
        this.nom_Prestation = nom_Prestation;
    }

    public String getdescription_Prestation() {
        return description_Prestation;
    }

    public void setdescription_Prestation(String description_Prestation) {
        this.description_Prestation = description_Prestation;
    }

    public String getNom_Responsable() {
        return nom_Responsable;
    }

    public void setNom_Responsable(String nom_Responsable) {
        this.nom_Responsable = nom_Responsable;
    }

    public String getTel_Responsable() {
        return tel_Responsable;
    }

    public void setTel_Responsable(String tel_Responsable) {
        this.tel_Responsable = tel_Responsable;
    }

    public String getMail_Responsable() {
        return mail_Responsable;
    }

    public void setMail_Responsable(String mail_Responsable) {
        this.mail_Responsable = mail_Responsable;
    }

    public double getcout_Prestation() {
        return cout_Prestation;
    }

    public void setcout_Prestation(double cout_Service) {
        this.cout_Prestation = cout_Prestation;
    }

    public boolean isfacturation_Frais_Inclus() {
        return facturation_Frais_Inclus;
    }

    public void setfacturation_Frais_Inclus(boolean facturation_Frais_Inclus) {
        this.facturation_Frais_Inclus = facturation_Frais_Inclus;
    }

    public int getDelai_Relance() {
        return delai_Relance;
    }

    public void setDelai_Relance(int delai_Relance) {
        this.delai_Relance = delai_Relance;
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
        if (!(object instanceof Prestation)) {
            return false;
        }
        Prestation other = (Prestation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Prestationt[ id=" + id + " ]";
    }
    
}
