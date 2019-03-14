/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;
import entite.Agence;
import entite.Client;
import entite.Devis;
import entite.Historique_Consultant;
import entite.Prestation;
import entite.Prestation_Non_Standard;
import entite.Prestation_Standard;
import entite.Service;
import entite.Utilisateur_Hardis;
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
public class DevisFacade extends AbstractFacade<Devis> implements DevisFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DevisFacade() {
        super(Devis.class);
    }

    @Override
    public List<Devis> listeDevis() {
        String txt = "SELECT a FROM Agence AS a";
        Query req = getEntityManager().createQuery(txt);
        List<Devis> liste = req.getResultList();
        return liste;
    }

    @Override
    public void demandeDevisClient(String zoneLibre, Client Client, Service service, String standardOuPas) {
       
        if (standardOuPas.equals("standard"))
        {
            Prestation_Standard standardACreer = new Prestation_Standard();
            standardACreer.setLeService(service);
            Devis devisPreRempli = new Devis();
            devisPreRempli.setlOffre(service.getlOffre());
            devisPreRempli.setFormulaire_Client(zoneLibre);
            devisPreRempli.setLeClient(Client);
            devisPreRempli.setLaPrestation(standardACreer);
            em.persist(standardACreer);
            em.persist(devisPreRempli);
        }
        else
        {
            Prestation_Non_Standard nonstandardACreer = new Prestation_Non_Standard();           
            nonstandardACreer.setLeService(service);
            Devis devisPreRempli = new Devis();
            devisPreRempli.setlOffre(service.getlOffre());
            devisPreRempli.setFormulaire_Client(zoneLibre);
            devisPreRempli.setLeClient(Client);
            devisPreRempli.setLaPrestation(nonstandardACreer);
            em.persist(nonstandardACreer);
            em.persist(devisPreRempli);
        }
            
    }

    @Override
    public void affecterDevisAuReferentLocal(Devis devis) {
        Agence agenceDuClient = devis.getLeClient().getlEntreprise().getlAgence();
        double delegationMax = 0;
        double temp = 0;
        List<Utilisateur_Hardis> consultantDeLAgence = agenceDuClient.getLesUtilisateur_Hardis();
        Utilisateur_Hardis consultantEnCours = null;
        Utilisateur_Hardis referentLocal = null;
        for (int i=0; i<consultantDeLAgence.size(); i++)
        {
            consultantEnCours = consultantDeLAgence.get(i);
            temp = consultantEnCours.getPlafond_Delegation();
            if( temp>delegationMax)
            {
                referentLocal = consultantEnCours;
                delegationMax = temp;
            }
        }
        Historique_Consultant referent = new Historique_Consultant();
        referent.setLeDevis(devis);
        referent.setLeConsultant(referentLocal);
        referent.setFonctionConsultant("chef de projet");
        em.persist(referent);       
    }
    
    
    
    
    
}
