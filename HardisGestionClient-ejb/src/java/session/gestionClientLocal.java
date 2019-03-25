/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Client;

import entite.Devis;
import entite.Offre;
import entite.Profil_Metier;
import entite.Service;
import entite.Utilisateur_Hardis;


import java.util.Date;


import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionClientLocal {

    List<Client> ListeClient();


    Client RechercheClient(Long id);


    Devis demandeDevis(String zoneLibre, Client client, long idService);

    void affecterDevisReferentLocal(long idDevis);

    Client rechercheClient(long id);

    List<Devis> listeDevis();

    Devis rechercheDevis(long idDevis);

    void ModifDevisA_traiter(long id, int montant);

    void ModifDevisEn_negociation(long id, int montant, Date dateinter);


    void modifierDevis(String zoneLibre, double montant, Devis Devis, String motifRefus);

    void accepterDevisClient(long idDevis);

    void refuserDevis(long idDevis, String motif);

    List ListeDevisNonAttribue();


    List<Devis> devisAtraiter(long id);

<<<<<<< HEAD
    void AffecterDevis(Devis Devis);
    
=======
    void propositionDateetConsultant(Client client, List<Utilisateur_Hardis> ListeConsultants, long idDevis, Date DateIntervention);

    List<Devis> listDevisEnvoye(Client client);

    List<Profil_Metier> listeCVOffre(long idDevis);

    List<Devis> listDevisEnNegociation(Client Client);

    List<Utilisateur_Hardis> listConsultantOffre(long idOffre);

    List<Profil_Metier> listPMOffre( Offre Offre);

    List<Devis> listDevisAccepte(Client Client);

    Utilisateur_Hardis rechercherUtilisateurHardisId(long id);

>>>>>>> LabranchedAlleau
}
