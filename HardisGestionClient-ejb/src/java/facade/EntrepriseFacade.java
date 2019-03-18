/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import entite.Agence;
import entite.Entreprise;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thoma
 */
@Stateless
public class EntrepriseFacade extends AbstractFacade<Entreprise> implements EntrepriseFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntrepriseFacade() {
        super(Entreprise.class);
    }

    @Override
    public List<Entreprise> listeEntreprise() {
        String txt = "SELECT e FROM Entreprise AS e";
        Query req = getEntityManager().createQuery(txt);
        List<Entreprise> liste = req.getResultList();
        return liste;
    }

    @Override
    public Entreprise rechercherEntrepriseParId(long id) {
        Entreprise result;
        String txt = "SELECT e FROM Entreprise AS e WHERE e.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Entreprise)req.getSingleResult();
        return result;
    }
    
    @Override
    public Entreprise rechercherEntrepriseParSiret(String siret){
        Entreprise result;
        String txt = "SELECT e FROM Entreprise AS e WHERE e.numero_SIRET=:siret";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("siret", siret);
        List<Entreprise> liste = req.getResultList();
        if(!liste.isEmpty()){
            return liste.get(0);
        }
        else {return null;} 
    }
    
    @Override
     public List<Entreprise> rechercherEntrepriseParNom(String nom){
        Entreprise result;
        String txt = "SELECT e FROM Entreprise AS e WHERE e.nom_Entreprise=:nom";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("nom", nom);
        List<Entreprise> liste = req.getResultList();
        return liste;      
    }
        

    @Override
    public void creerEntreprise(String cp, String nom, String siret, String rue, String ville, Agence agence) {
        Entreprise entrepriseACreer = new Entreprise();
        entrepriseACreer.setCP_Entreprise(cp);
        entrepriseACreer.setNom_Entreprise(nom);
        entrepriseACreer.setNumero_SIRET(siret);
        entrepriseACreer.setRue_Entreprise(rue);
        entrepriseACreer.setVille_Entreprise(ville);
        entrepriseACreer.setlAgence(agence);
        em.persist(entrepriseACreer);
    }
    
    @Override
    public void supprimerEntreprise(Entreprise ent){
        em.remove(ent);
    }
}
