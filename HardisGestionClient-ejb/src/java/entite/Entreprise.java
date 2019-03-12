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
public class Entreprise implements Serializable {

    public List<Interlocuteur> getInterlocuteurs() {
        return interlocuteurs;
    }

    public void setInterlocuteurs(List<Interlocuteur> interlocuteurs) {
        this.interlocuteurs = interlocuteurs;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public Agence getlAgence() {
        return lAgence;
    }

    public void setlAgence(Agence lAgence) {
        this.lAgence = lAgence;
    }

    @OneToMany(mappedBy = "lEntreprise")
    private List<Interlocuteur> interlocuteurs = new ArrayList<Interlocuteur>();

    @OneToMany(mappedBy = "lEntreprise")
    private List<Client> clients = new ArrayList<Client>();

    private String nom_Entreprise;
    private String numero_SIRET;
    private String rue_Entreprise;
    private String ville_Entreprise;
    private String CP_Entreprise;
    @ManyToOne
    private Agence lAgence;

    public String getNom_Entreprise() {
        return nom_Entreprise;
    }

    public void setNom_Entreprise(String nom_Entreprise) {
        this.nom_Entreprise = nom_Entreprise;
    }

    public String getNumero_SIRET() {
        return numero_SIRET;
    }

    public void setNumero_SIRET(String numero_SIRET) {
        this.numero_SIRET = numero_SIRET;
    }

    public String getRue_Entreprise() {
        return rue_Entreprise;
    }

    public void setRue_Entreprise(String rue_Entreprise) {
        this.rue_Entreprise = rue_Entreprise;
    }

    public String getVille_Entreprise() {
        return ville_Entreprise;
    }

    public void setVille_Entreprise(String ville_Entreprise) {
        this.ville_Entreprise = ville_Entreprise;
    }

    public String getCP_Entreprise() {
        return CP_Entreprise;
    }

    public void setCP_Entreprise(String CP_Entreprise) {
        this.CP_Entreprise = CP_Entreprise;
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
        if (!(object instanceof Entreprise)) {
            return false;
        }
        Entreprise other = (Entreprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Entreprise[ id=" + id + " ]";
    }
    
}
