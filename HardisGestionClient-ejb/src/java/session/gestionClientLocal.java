/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Client;

import entite.Devis;
import entite.Service;
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> exilessmath

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionClientLocal {

    List<Client> ListeClient();

<<<<<<< HEAD
=======

    Client RechercheClient(Long id);

>>>>>>> exilessmath
    void demandeDevis(String zoneLibre, Client client, long idService);

    void affecterDevisReferentLocal(long idDevis);

    Client rechercheClient(long id);

    void objectPersist(Object object);

    List<Devis> listeDevis();

    Devis rechercheDevis(long idDevis);
<<<<<<< HEAD
    
=======

    void ModifDevisA_traiter(long id, int montant);

    void ModifDevisEn_negociation(long id, int montant, Date dateinter);

>>>>>>> exilessmath
}
