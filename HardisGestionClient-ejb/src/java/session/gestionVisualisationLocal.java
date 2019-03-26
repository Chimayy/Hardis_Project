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
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionVisualisationLocal {

   

  

    List<Client> afficherClient2();

    List<Devis> afficherDevis();

    List<Utilisateur> afficherUtilisateur();

    List<Service> afficherService();

    List<Agence> afficherAgence();

    /*List<Consentement_RGPD> afficherConsentement();*/

    /*List<Historique_Document> afficherHistoriqueDocuments();*/

    List<Historique_Echange> afficherHistorique_Echange();

    List<Interlocuteur> afficherInterlocuteur();

    List<Offre> afficherOffre();

    List<Prestation> afficherPrestation();

    List<Entreprise> afficherEntreprise();

    Client rechercheNomClient(String nom);

    Utilisateur rechercherNomUtilisateur(String nom);

    /*Service rechercheService(String description_Service);*/

    /*Devis rechercherDevis(Date date_Intervention);*/

    Entreprise rechercheEntreprisenom(String nom);

    /*Consentement_RGPD rechercherconsentement(String date);*/

    Historique_Document rechercherHistoriquedocuement(long id);

    Historique_Echange rechercherHistoriqueechange(long id);

    /*Interlocuteur rechercheinterlocuteur(String nom_Interlocuteur);*/

    Agence rechercheragence(String ville_Agence);

    Offre rechercheOffre(String nom_Offre);

    public Utilisateur_Hardis rechercherNomUtilisateurHardis(String nom);
   
}
