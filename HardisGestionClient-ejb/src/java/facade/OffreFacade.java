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
        String txt = "SELECT  FROM AS f";
        Query req = getEntityManager().createQuery(txt);
        List<Offre> liste = req.getResultList();
        return liste;
    }

    @Override
    public Offre rechercheOffre(long id) {
        Offre result;
        String txt = "SELECT  FROM  AS  WHERE .id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Offre)req.getSingleResult();
        return result;
    }

    @Override
    public void creerOffre(String description, String nom) {
        Offre offreACreer = new Offre();
        offreACreer.setDescription_Offre(description);
        offreACreer.setNom_Offre(nom);
        em.persist(offreACreer);
    }
    
    
    
}
