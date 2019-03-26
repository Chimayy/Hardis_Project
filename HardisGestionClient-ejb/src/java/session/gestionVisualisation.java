/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Agence;
import entite.Client;
import entite.Consentement_RGPD;
import entite.Devis;
import entite.Entreprise;
import entite.Historique_Document;
import entite.Historique_Echange;
import entite.Interlocuteur;
import entite.Offre;
import entite.Prestation;
import entite.Service;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import facade.AgenceFacadeLocal;
import facade.ClientFacade;
import facade.ClientFacadeLocal;
import facade.Consentement_RGPDFacadeLocal;
import facade.DevisFacade;
import facade.DevisFacadeLocal;
import facade.EntrepriseFacadeLocal;
import facade.Historique_DocumentFacadeLocal;
import facade.Historique_EchangeFacadeLocal;
import facade.InterlocuteurFacadeLocal;
import facade.OffreFacadeLocal;
import facade.PrestationFacadeLocal;
import facade.ServiceFacade;
import facade.ServiceFacadeLocal;
import facade.UtilisateurFacade;
import facade.UtilisateurFacadeLocal;
import facade.Utilisateur_HardisFacade;
import facade.Utilisateur_HardisFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author thoma
 */
@Stateless
public class gestionVisualisation implements gestionVisualisationLocal {

    @EJB
    private EntrepriseFacadeLocal entrepriseFacade1;

    @EJB
    private EntrepriseFacadeLocal entrepriseFacade;

    @EJB
    private PrestationFacadeLocal prestationFacade;

    @EJB
    private OffreFacadeLocal offreFacade;

    @EJB
    private InterlocuteurFacadeLocal interlocuteurFacade;

    @EJB
    private Historique_EchangeFacadeLocal historique_EchangeFacade;

    @EJB
    private Historique_DocumentFacadeLocal historique_DocumentFacade;

    @EJB
    private Consentement_RGPDFacadeLocal consentement_RGPDFacade;

    @EJB
    private AgenceFacadeLocal agenceFacade;

    @EJB
    private ServiceFacadeLocal serviceFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @EJB
    private ClientFacadeLocal clientFacade;

    @EJB
    private DevisFacadeLocal devisFacade;

    @EJB
    private Utilisateur_HardisFacadeLocal utilisateur_HardisFacade;
    
    @Override
    public List<Client> afficherClient2() {
        List<Client> liste = clientFacade.listeClient();
        return liste;
    }

    @Override
    public List<Devis> afficherDevis() {
         List<Devis> liste = devisFacade.listeDevis();
        return liste;
    }

    @Override
    public List<Utilisateur_Hardis> afficherUtilisateur() {
         List<Utilisateur_Hardis> liste = utilisateur_HardisFacade.afficherUtilisateurs_Hardis();
        return liste;
    }

    @Override
    public List<Service> afficherService() {
         List<Service> liste = serviceFacade.listeService();
        return liste;
    }

    @Override
    public List<Agence> afficherAgence() {
          List<Agence> liste = agenceFacade.listeAgence();
        return liste;
    }

    @Override
    public List<Historique_Echange> afficherHistorique_Echange() {
         List<Historique_Echange> liste = historique_EchangeFacade.listeEchange();
        return liste;
    }

    @Override
    public List<Interlocuteur> afficherInterlocuteur() {
         List<Interlocuteur> liste = interlocuteurFacade.listeInterlocuteur();
        return liste;
    }

    @Override
    public List<Offre> afficherOffre() {
      List<Offre> liste = offreFacade.listeOffre();
        return liste;
    }

    @Override
    public List<Prestation> afficherPrestation() {
         List<Prestation> liste = prestationFacade.listePrestation();
        return liste;
    }

    @Override
    public List<Entreprise> afficherEntreprise() {
       List<Entreprise> liste = entrepriseFacade.listeEntreprise();
        return liste;
    }

    @Override
    public Client rechercheNomClient(String nom) {
        Client c = clientFacade.rechercheClientNom(nom);
        return c;
    }
    
    @Override
    public Utilisateur rechercherNomUtilisateur(String nom) {
       Utilisateur u = utilisateurFacade.rechercheUtilisateurNom(nom);
        return u;
    }
    
    @Override
    public Utilisateur_Hardis rechercherNomUtilisateurHardis(String nom){
        Utilisateur_Hardis user = utilisateur_HardisFacade.rechercherUtilisateurHardisNom(nom).get(0);
        return user;
    }
      
    /*@Override
    public Service rechercheService(String description_Service) {
        Service s = serviceFacade.rechercheService(description_Service);
        return s;
    }*/

    /*@Override
    public Devis rechercherDevis(Date date_Intervention) {
        Devis d = devisFacade.recherchedateintervention(date_Intervention);
        return d;
    }*/

    @Override
    public Entreprise rechercheEntreprisenom(String nom) {
        Entreprise e = entrepriseFacade.rechercherEntrepriseParNom(nom).get(0);
        return e;
    }

    /*@Override
    public Consentement_RGPD rechercherconsentement(String date) {
        Consentement_RGPD co = consentement_RGPDFacade.rechercherConsentement(date);
        return co;
    }*/

    @Override
    public Historique_Document rechercherHistoriquedocuement(long id) {
        Historique_Document hd = historique_DocumentFacade.rechercheDocument(id);
                return hd;
    }

    @Override
    public Historique_Echange rechercherHistoriqueechange(long id) {
        Historique_Echange he = historique_EchangeFacade.rechercheEchange(id);
        return he;
    }

    /*@Override
    public Interlocuteur rechercheinterlocuteur(String nom_Interlocuteur) {
        Interlocuteur inter = interlocuteurFacade.rechercheInterlocuteurNom(nom_Interlocuteur);
        return inter;
    }*/
    

    @Override
    public Agence rechercheragence(String ville_Agence) {
    Agence ag = agenceFacade.rechercherAgenceParVille(ville_Agence);
        return ag;
    }
   
    @Override
    public Offre rechercheOffre(String nom_Offre) {
        Offre of = offreFacade.rechercheOffreNom(nom_Offre);
        return of;
    }
    
}
