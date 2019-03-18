/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Prestation;
import entite.Prestation_Non_Standard;
import entite.Service;
import entite.lieu_Intervention;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thoma
 */
@Stateless
public class Prestation_Non_StandardFacade extends AbstractFacade<Prestation_Non_Standard> implements Prestation_Non_StandardFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Prestation_Non_StandardFacade() {
        super(Prestation_Non_Standard.class);
    }

    @Override
    public void creerPrestationNonStandard(String description, String nomresp, String telresp, String mailresp, double cout, boolean facturation, int delai, Service service, lieu_Intervention lieu ) {
        Prestation_Non_Standard PrestaACreer = new Prestation_Non_Standard();
        PrestaACreer.setDelai_Relance(delai);
        PrestaACreer.setLieu_Intervention(lieu);
        PrestaACreer.setMail_Responsable(mailresp);
        PrestaACreer.setNom_Responsable(nomresp);
        PrestaACreer.setTel_Responsable(telresp);
        PrestaACreer.setcout_Prestation(cout);
        PrestaACreer.setdescription_Prestation(description);
        PrestaACreer.setfacturation_Frais_Inclus(facturation);
        PrestaACreer.setLeService(service);
        em.persist(PrestaACreer);
    }

    //méthode à appeler lors de la demande de devis client
    @Override
    public void creerPrestaNS(Service service) {
        Prestation_Non_Standard presta = new Prestation_Non_Standard();
        presta.setLeService(service);
        em.persist(presta);
    }
    
    
}
