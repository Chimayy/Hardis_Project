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
import javax.persistence.OneToMany;

/**
 *
 * @author thoma
 */
@Entity
public class Agence implements Serializable {

    @OneToMany(mappedBy = "lAgence")
    private List<Entreprise> entreprises = new ArrayList<Entreprise>();

    private String rue_Agence;
    private String ville_Agence;
    private String CP_Agence;
    private String pays_Agence;

    public List<Entreprise> getEntreprises() {
        return entreprises;
    }

    public void setEntreprises(List<Entreprise> entreprises) {
        this.entreprises = entreprises;
    }

    public String getRue_Agence() {
        return rue_Agence;
    }

    public void setRue_Agence(String rue_Agence) {
        this.rue_Agence = rue_Agence;
    }

    public String getVille_Agence() {
        return ville_Agence;
    }

    public void setVille_Agence(String ville_Agence) {
        this.ville_Agence = ville_Agence;
    }

    public String getCP_Agence() {
        return CP_Agence;
    }

    public void setCP_Agence(String CP_Agence) {
        this.CP_Agence = CP_Agence;
    }

    public String getPays_Agence() {
        return pays_Agence;
    }

    public void setPays_Agence(String pays_Agence) {
        this.pays_Agence = pays_Agence;
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
        if (!(object instanceof Agence)) {
            return false;
        }
        Agence other = (Agence) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Agence[ id=" + id + " ]";
    }
    
}
