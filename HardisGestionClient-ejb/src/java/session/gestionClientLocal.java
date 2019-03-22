/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Client;

import entite.Devis;
import entite.Service;


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


    void demandeDevis(String zoneLibre, Client client, long idService);

    void affecterDevisReferentLocal(long idDevis);

    Client rechercheClient(long id);

    List<Devis> listeDevis();

    Devis rechercheDevis(long idDevis);

    void ModifDevisA_traiter(long id, int montant);

    void ModifDevisEn_negociation(long id, int montant, Date dateinter);


    void modifierDevis(String zoneLibre, double montant, Devis Devis);

    void accepterDevisClient(long idDevis);

    void refuserDevis(long idDevis, String motif);

    List ListeDevisNonAttribue();


    List<Devis> devisAtraiter(long id);

    void propositionDateetConsultant();
    
}
