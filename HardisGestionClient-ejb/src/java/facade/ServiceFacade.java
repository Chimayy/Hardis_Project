/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Offre;
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
    public List<Service> rechercheService(long id) {
        String txt = "SELECT s FROM Service AS s WHERE s.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        List<Service> liste = req.getResultList();
        return liste;
    }

    @Override
    public void creerService(String description_Service, String nom, double cout_Service, Offre offre) {
        Service ServiceACreer = new Service();
        ServiceACreer.setDescription_Service(description_Service);
        ServiceACreer.setNom_Service(nom);
        ServiceACreer.setCout_Service(cout_Service);
        ServiceACreer.setlOffre(offre);
        em.persist(ServiceACreer);
    }
    
    @Override
    public void modifierService(Service service, String description, String nom, double cout, Offre offre){
        service.setDescription_Service(description);
        service.setNom_Service(nom);
        service.setCout_Service(cout);
        service.setlOffre(offre);
        em.merge(service);
    }
    
    @Override
    public void supprimerService(Service service){
        em.remove(service);
    }
}
