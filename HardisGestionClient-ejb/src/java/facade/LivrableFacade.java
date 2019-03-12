/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Livrable;
import entite.Prestation;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thoma
 */
@Stateless
public class LivrableFacade extends AbstractFacade<Livrable> implements LivrableFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LivrableFacade() {
        super(Livrable.class);
    }

    @Override
    public void creerLivrable(String path, String type, Prestation prestation) {
        Livrable livrableACreer = new Livrable();
        livrableACreer.setPath_Livrable(path);
        livrableACreer.setType_Livrable(type);
        livrableACreer.setLaPrestation(prestation);
        em.persist(livrableACreer);
    }
    
    
    
}
