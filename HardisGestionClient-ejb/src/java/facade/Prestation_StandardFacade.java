/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import entite.Prestation_Standard;
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
public class Prestation_StandardFacade extends AbstractFacade<Prestation_Standard> implements Prestation_StandardFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Prestation_StandardFacade() {
        super(Prestation_Standard.class);
    }

    @Override
    public void creerPrestationStandard( String description, String nomresp, String telresp, String mailresp, double cout, boolean facturation, int delai, Service service, lieu_Intervention lieu, String Expertise, double montantJour, double nbJour ) {
        Prestation_Standard PrestaACreer = new Prestation_Standard();
        PrestaACreer.setDelai_Relance(delai);
        PrestaACreer.setLieu_Intervention(lieu);
        PrestaACreer.setMail_Responsable(mailresp);
        PrestaACreer.setNom_Responsable(nomresp);
        PrestaACreer.setTel_Responsable(telresp);
        PrestaACreer.setcout_Prestation(cout);
        PrestaACreer.setdescription_Prestation(description);
        PrestaACreer.setfacturation_Frais_Inclus(facturation);
        PrestaACreer.setLeService(service);
        PrestaACreer.setExpertise_Minimum(Expertise);
        PrestaACreer.setMontant_Jour(montantJour);
        PrestaACreer.setNb_Jours(nbJour);
        em.persist(PrestaACreer);
    }

    @Override
    public Prestation_Standard creerPrestaS(Service service) {
        Prestation_Standard presta = new Prestation_Standard();
        presta.setLeService(service);
        em.persist(presta);
        return presta;
    }
        
    
    }
    

