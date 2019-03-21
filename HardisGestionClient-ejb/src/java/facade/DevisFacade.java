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
<<<<<<< HEAD
=======
import entite.Historique_Question;
>>>>>>> exilessmath
import entite.Prestation;
import entite.Prestation_Non_Standard;
import entite.Prestation_Standard;
import entite.Service;
import entite.Utilisateur_Hardis;
import entite.statut_Devis;
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> exilessmath
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
        String txt = "SELECT d FROM Devis AS d";
        Query req = getEntityManager().createQuery(txt);
        List<Devis> liste = req.getResultList();
        return liste;
    }
    
    

    @Override
    public void demandeDevisClient(String zoneLibre, Client Client, Service service) {
        Devis brouillonDevisClient = new Devis();
        brouillonDevisClient.setLeClient(Client);
        brouillonDevisClient.setFormulaire_Client(zoneLibre);
<<<<<<< HEAD
        brouillonDevisClient.setStatut(statut_Devis.en_cours);
=======
        brouillonDevisClient.setStatut(statut_Devis.a_affecter);
>>>>>>> exilessmath
        em.persist(brouillonDevisClient);
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
        devis.getLaPrestation().setNom_Responsable(referentLocal.getNom_Utilisateur());
        devis.getLaPrestation().setMail_Responsable(referentLocal.getMail_Connexion());
        em.persist(referent);
        em.persist(devis);
    }

    @Override
    public Devis rechercheDevis(long id) {
        Devis result;
        String txt = "SELECT d FROM Devis AS d WHERE d.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Devis)req.getSingleResult();
        return result;
    }
<<<<<<< HEAD
    
=======

    @Override
    public List ListeQuestions(Devis d) {
        List<Historique_Question> result;
        String txt = "SELECT ql FROM Historique_Question AS ql WHERE ql.leDevis=:d";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("d", d);
        result = req.getResultList();
        return result;
    }

    @Override
    public void ModifDevisA_traiter(long id, int montant) {
        Devis d = rechercheDevis(id);
        d.setMontant_Devis(montant);
        d.setStatut(statut_Devis.envoye);
        em.merge(d);
    }

    @Override
    public void ModifDevisEn_negociation(long id, int montant, Date dateinter) {
        Devis d = rechercheDevis(id);
        d.setMontant_Devis(montant);
        d.setDate_Intervention(dateinter);
        d.setStatut(statut_Devis.valide);
        em.merge(d);
        
    }
    
    }

    
     
>>>>>>> exilessmath
    
    
    
    
<<<<<<< HEAD
}
=======
    

>>>>>>> exilessmath
