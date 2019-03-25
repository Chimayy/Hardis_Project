/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Client;
import facade.ClientFacadeLocal;
import entite.Devis;
import entite.Offre;
import entite.Prestation;
import entite.Prestation_Non_Standard;
import entite.Prestation_Standard;
import entite.Profil_Metier;
import entite.Service;
import entite.Utilisateur_Hardis;
import facade.ClientFacadeLocal;
import facade.DevisFacadeLocal;
import facade.Historique_ConsultantFacadeLocal;
import facade.OffreFacadeLocal;
import facade.Prestation_Non_StandardFacadeLocal;
import facade.Prestation_StandardFacadeLocal;
import facade.Profil_MetierFacadeLocal;
import facade.ServiceFacadeLocal;
import facade.Utilisateur_HardisFacadeLocal;
import java.util.ArrayList;

import java.util.Date;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author thoma
 */
@Stateless
public class gestionClient implements gestionClientLocal {

    @EJB
    private Historique_ConsultantFacadeLocal historique_ConsultantFacade;

    @EJB
    private Profil_MetierFacadeLocal profil_MetierFacade;

    @EJB
    private Utilisateur_HardisFacadeLocal utilisateur_HardisFacade;

    @EJB
    private OffreFacadeLocal offreFacade;
    
    @EJB
    private ClientFacadeLocal ClientFacade;
    
    
    
        

    @EJB
    private Prestation_StandardFacadeLocal prestation_StandardFacade;

    @EJB
    private Prestation_Non_StandardFacadeLocal prestation_Non_StandardFacade;

    @EJB
    private ServiceFacadeLocal serviceFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private DevisFacadeLocal devisFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Client> ListeClient() {
        return ClientFacade.listeClient();
    }

  
    @Override
    public Client RechercheClient(Long id) {
        
        Client c = ClientFacade.rechercheClient(id);
        return c;
    }
    
    


    public Devis demandeDevis(String zoneLibre, Client client, long idService) {
        Service service = serviceFacade.rechercheService(idService).get(0);
        Prestation presta = null;
        
        //si le service fait partie de la liste des services standards, on lie le brouillon de devis à une nouvelle prestation standard
        if(service.getNom_Service().equals("prestation standard")||service.getNom_Service().equals("prestation standard 2"))
        {
            presta = prestation_StandardFacade.creerPrestaS(service);
        }
        if(service.getNom_Service().equals("prestation non standard")||service.getNom_Service().equals("prestation non standard 2"))
        {
           presta =  prestation_Non_StandardFacade.creerPrestaNS(service);
        }
       Devis demandeDevisClient = devisFacade.demandeDevisClient(zoneLibre, client, presta);
       return demandeDevisClient;
        }

    @Override
    public void affecterDevisReferentLocal(long idDevis) {
        Devis devis = devisFacade.rechercheDevis(idDevis);
        devisFacade.affecterDevisAuReferentLocal(devis);
    }

    @Override
    public Client rechercheClient(long id) {
      Client c =  clientFacade.rechercheClient(id);
      return c;
    }

    

    @Override
    public List<Devis> listeDevis() {
        return devisFacade.listeDevis();
    }

    @Override
    public Devis rechercheDevis(long idDevis) {
        return devisFacade.rechercheDevis(idDevis);
    }


    @Override
    public void ModifDevisA_traiter(long id, int montant) {
        devisFacade.ModifDevisA_traiter(id, montant);
    }

    @Override
    public void ModifDevisEn_negociation(long id, int montant, Date dateinter) {
        devisFacade.ModifDevisEn_negociation(id, montant, dateinter);
    }


    @Override
    public List ListeDevisNonAttribue() {
        List<Devis> ListeDevisNonAttribue =devisFacade.ListeDevisNonAttribue();
        return ListeDevisNonAttribue;
    }


    @Override
    public void modifierDevis(String zoneLibre, double montant, Devis Devis, String motifRefus) {
        devisFacade.modifierDevis(montant, Devis, zoneLibre, motifRefus);
    }

    @Override
    public void accepterDevisClient(long idDevis) {
        Devis devisAccepte = devisFacade.rechercheDevis(idDevis);
        devisFacade.accepterDevis(devisAccepte);
    }

    @Override
    public void refuserDevis(long idDevis, String motif) {
        Devis devisRefuse = devisFacade.rechercheDevis(idDevis);
        devisFacade.refuserDevis(devisRefuse, motif);
    }

    @Override
    public List<Devis> devisAtraiter(long id) {
        return devisFacade.listDevisAtraiter(id);
    }

    @Override
<<<<<<< HEAD
    public void AffecterDevis(Devis Devis) {
        devisFacade.AffecterDevis(Devis);
    }
=======
    public void propositionDateetConsultant(Client client, List<Utilisateur_Hardis> ListeConsultants, long idDevis, Date DateIntervention) {
        Devis devisConcerne = devisFacade.rechercheDevis(idDevis);
        devisFacade.proposerDateIntervention(devisConcerne, DateIntervention);
        historique_ConsultantFacade.proposerConsultants(devisConcerne, ListeConsultants);
        
    }

    @Override
    public List<Devis> listDevisEnvoye(Client client) {
        return devisFacade.listeDevisEnvoye(client);
    }

    @Override
    public List<Profil_Metier> listeCVOffre(long idDevis) {
        Devis devis = devisFacade.rechercheDevis(idDevis);
        Offre offre = devis.getlOffre();
        Long idOffre = offre.getId();
        List<Profil_Metier> CVOffre = profil_MetierFacade.listCVOffre(idOffre);
        return CVOffre;
    }

    
    
    @Override
    public List<Devis> listDevisEnNegociation(Client Client) {
        return devisFacade.listDevisEnNegociation(Client);
    }

    @Override
    public List<Utilisateur_Hardis> listConsultantOffre(long idOffre) {
        return utilisateur_HardisFacade.ListeConsultantDuneOffre(idOffre);
    }

    @Override
    public List<Profil_Metier> listPMOffre(Offre Offre) {
        return profil_MetierFacade.listPMOffre(Offre);
    }

    @Override
    public List<Devis> listDevisAccepte(Client Client) {
        return devisFacade.listDevisAccepte(Client);
    }

    @Override
    public Utilisateur_Hardis rechercherUtilisateurHardisId(long id) {
        return utilisateur_HardisFacade.rechercherUtilisateurHaridsParId(id);
    }

    
    
>>>>>>> LabranchedAlleau
    
}

