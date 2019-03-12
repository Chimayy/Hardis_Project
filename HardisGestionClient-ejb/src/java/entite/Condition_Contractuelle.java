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

/**
 *
 * @author thoma
 */
@Entity
public class Condition_Contractuelle implements Serializable {

    public List<Prestation> getLesPrestations() {
        return lesPrestations;
    }

    public void setLesPrestations(List<Prestation> lesPrestations) {
        this.lesPrestations = lesPrestations;
    }

    private String contenu_Condition;
    
    @ManyToMany(mappedBy = "condition_Contractuelles")
    private List<Prestation> lesPrestations = new ArrayList<Prestation>();
    

    public String getContenu_Condition() {
        return contenu_Condition;
    }

    public void setContenu_Condition(String contenu_Condition) {
        this.contenu_Condition = contenu_Condition;
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
        if (!(object instanceof Condition_Contractuelle)) {
            return false;
        }
        Condition_Contractuelle other = (Condition_Contractuelle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Condition_Contractuelle[ id=" + id + " ]";
    }
    
}
