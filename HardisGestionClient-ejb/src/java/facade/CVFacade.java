/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.CV;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thoma
 */
@Stateless
public class CVFacade extends AbstractFacade<CV> implements CVFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CVFacade() {
        super(CV.class);
    }

    @Override
    public void creerCV(String type_CV, String path_CV) {
        CV CVACreer = new CV();
        CVACreer.setPath_CV(path_CV);
        CVACreer.setType_CV(type_CV);
        em.persist(CVACreer);
    }
    
    
}
