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

    void demandeDevis(String zoneLibre, Client client, long idService);

    void affecterDevisReferentLocal(long idDevis);

    Client rechercheClient(long id);

    void objectPersist(Object object);

    List<Devis> listeDevis();

    Devis rechercheDevis(long idDevis);
    
}
