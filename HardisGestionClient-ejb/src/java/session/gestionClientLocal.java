/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Client;

import entite.Devis;
import entite.Service;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionClientLocal {

    List<Client> ListeClient();

    void demandeDevis(String zoneLibre, Client client, long idService);

    void affecterDevisReferentLocal(long idDevis);

    Client rechercheClient(long id);

    void objectPersist(Object object);

    List<Devis> listeDevis();

    Devis rechercheDevis(long idDevis);

    void modifierDevis(String zoneLibre, double montant, Devis Devis);

    void accepterDevisClient(long idDevis);

    void refuserDevis(long idDevis, String motif);

    List<Devis> devisAtraiter(long id);
    
}
