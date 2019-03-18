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
public class Service implements Serializable {

    public List<Prestation> getPrestations() {
        return prestations;
    }

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }

    public Offre getlOffre() {
        return lOffre;
    }

    public void setlOffre(Offre lOffre) {
        this.lOffre = lOffre;
    }

    @OneToMany(mappedBy = "leService")
    private List<Prestation> prestations = new ArrayList<Prestation>();

    private String description_Service;
    private String nom_Service;
    private double cout_Service;
    @ManyToOne
    private Offre lOffre;

    public String getNom_Service() {
        return nom_Service;
    }

    public void setNom_Service(String nom_Service) {
        this.nom_Service = nom_Service;
    }
    

    public String getDescription_Service() {
        return description_Service;
    }

    public void setDescription_Service(String description_Service) {
        this.description_Service = description_Service;
    }

    public double getCout_Service() {
        return cout_Service;
    }

    public void setCout_Service(double cout_Service) {
        this.cout_Service = cout_Service;
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
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Service[ id=" + id + " ]";
    }
    
}
