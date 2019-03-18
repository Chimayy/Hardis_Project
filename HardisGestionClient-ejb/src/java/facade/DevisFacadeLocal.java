/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Agence;
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
public interface DevisFacadeLocal {

    void create(Devis devis);

    void edit(Devis devis);

    void remove(Devis devis);

    Devis find(Object id);

    List<Devis> findAll();

    List<Devis> findRange(int[] range);

    int count();

    List<Devis> listeDevis();

    void demandeDevisClient(String zoneLibre, Client Client, Service service);

    void affecterDevisAuReferentLocal(Devis devis);

    Devis rechercheDevis(long id);
    
}
