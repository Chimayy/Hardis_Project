/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Client;
import entite.Devis;
import entite.Devis_Non_Standard;
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
public class Devis_Non_StandardFacade extends AbstractFacade<Devis_Non_Standard> implements Devis_Non_StandardFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Devis_Non_StandardFacade() {
        super(Devis_Non_Standard.class);
    }

    @Override
    public void creerDevisNonStandard(double montant, boolean facturation_Auto, Date dateDevis, Date date_Intervention, Date dateDebut, String dateFin, String path, Offre offre, Prestation_Non_Standard presta, Client client) {
        Devis_Non_Standard devisACreer = new Devis_Non_Standard();
        devisACreer.setDate_Debut(dateDebut);
        devisACreer.setDate_Devis(dateDevis);
        devisACreer.setDate_Fin(dateDebut);
        devisACreer.setDate_Intervention(date_Intervention);
        devisACreer.setFacturation_Auto(facturation_Auto);
        devisACreer.setMontant_Devis(montant);
        devisACreer.setStatut(statut_Devis.en_cours);
        devisACreer.setPath_Powerpoint(path);
        devisACreer.setLaPrestation(presta);
        devisACreer.setLeClient(client);
        devisACreer.setlOffre(offre);
        em.persist(devisACreer);
    }
    
    
}
