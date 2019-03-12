/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Client;
import entite.Devis;
import entite.Devis_Non_Standard;
import entite.Devis_Standard;
import entite.Offre;
import entite.Prestation_Non_Standard;
import entite.statut_Devis;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thoma
 */
@Stateless
public class Devis_StandardFacade extends AbstractFacade<Devis_Standard> implements Devis_StandardFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Devis_StandardFacade() {
        super(Devis_Standard.class);
    }

    @Override
    public void creerDevisStandard(double montant, boolean facturation_Auto,Date date_Devis, Date date_Intervention, Date dateDebut, Date dateFin, Offre offre, Prestation_Non_Standard presta, Client client) {
        Devis_Non_Standard devisACreer = new Devis_Non_Standard();
        devisACreer.setDate_Debut(dateDebut);
        devisACreer.setDate_Devis(date_Devis);
        devisACreer.setDate_Fin(dateFin);
        devisACreer.setDate_Intervention(date_Intervention);
        devisACreer.setFacturation_Auto(facturation_Auto);
        devisACreer.setMontant_Devis(montant);
        devisACreer.setlOffre(offre);
        devisACreer.setLeClient(client);
        devisACreer.setLaPrestation(presta);
        devisACreer.setStatut(statut_Devis.en_cours);
        em.persist(devisACreer);     
    }
    
    
    
}
