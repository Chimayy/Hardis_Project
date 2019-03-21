/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Offre;
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
public class OffreFacade extends AbstractFacade<Offre> implements OffreFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OffreFacade() {
        super(Offre.class);
    }

    @Override
    public List<Offre> listeOffre() {
        String txt = "SELECT o FROM Offre AS o";
        Query req = getEntityManager().createQuery(txt);
        List<Offre> liste = req.getResultList();
        return liste;
    }

    @Override
    public List<Offre> rechercheOffre(long id) {
        String txt = "SELECT o FROM Offre AS o WHERE o.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        List<Offre> liste = req.getResultList();
        return liste;
    }
    
    @Override
    public List<Offre> rechercherListeOffreNom(String nom){
        String txt = "SELECT o FROM Offre AS o WHERE o.nom_Ofre =:nom";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", nom);
        List<Offre> liste = req.getResultList();
        if(liste!=null){
            return liste;
        }
        else{return null;}
    }
    
    @Override
    public Offre rechercheOffreNom(String nom){
        String txt = "SELECT o FROM Offre AS o WHERE o.nom_Offre=:nom";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("nom", nom);
        List<Offre> liste = req.getResultList();
        if(!liste.isEmpty()){
            return liste.get(0);
        }
        else {return null;} 
    }

    @Override
    public void creerOffre(String description, String nom) {
        Offre offreACreer = new Offre();
        offreACreer.setDescription_Offre(description);
        offreACreer.setNom_Offre(nom);
        em.persist(offreACreer);
    }
       
}
