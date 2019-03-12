/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Prestation;
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
public class PrestationFacade extends AbstractFacade<Prestation> implements PrestationFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestationFacade() {
        super(Prestation.class);
    }

    @Override
    public List<Prestation> listePrestation() {
        String txt = "SELECT p FROM Prestation AS p";
        Query req = getEntityManager().createQuery(txt);
        List<Prestation> liste = req.getResultList();
        return liste;
    }

    @Override
    public Prestation recherchePrestation(long id) {
        Prestation result;
        String txt = "SELECT p FROM Prestation AS p WHERE p.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Prestation)req.getSingleResult();
        return result;
    }
    
}
