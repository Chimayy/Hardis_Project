/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Service;
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
public class ServiceFacade extends AbstractFacade<Service> implements ServiceFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiceFacade() {
        super(Service.class);
    }

    @Override
    public List<Service> listeService() {
        String txt = "SELECT s FROM Service AS s";
        Query req = getEntityManager().createQuery(txt);
        List<Service> liste = req.getResultList();
        return liste;
    }

    @Override
    public Service rechercheService(long id) {
        Service result;
        String txt = "SELECT s FROM Service AS s WHERE s.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Service)req.getSingleResult();
        return result;
    }

    @Override
    public void creerService(String description_Service, double cout_Service) {
        Service ServiceACreer = new Service();
        ServiceACreer.setDescription_Service(description_Service);
        ServiceACreer.setCout_Service(cout_Service);
        em.persist(ServiceACreer);
    }
    
    
}
