/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Agence;
import entite.Client;
import entite.Devis;
import entite.Prestation;
import entite.Service;


import java.util.Date;

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

    Devis demandeDevisClient(String zoneLibre, Client Client, Prestation presta);

    void affecterDevisAuReferentLocal(Devis devis);

    Devis rechercheDevis(long id);

    List ListeQuestions(Devis d);

    void ModifDevisA_traiter(long id, int montant);

    void ModifDevisEn_negociation(long id, int montant, Date dateinter);


    void modifierDevis(double montant, Devis d, String zoneLibre, String motifRefus);

    void accepterDevis(Devis Devis);

    List<Devis> listDevisAtraiter(long id);

    void refuserDevis(Devis Devis, String motif);

    List ListeDevisNonAttribue();

    void AffecterDevis(Devis Devis);

    void  proposerDateIntervention(Devis devis, Date DateIntervention);

    List<Devis> listeDevisEnvoye(Client Client);

    List<Devis> listDevisEnNegociation(Client Client);

    List<Devis> listDevisAccepte(Client Client);

    void ModifDevisANegocier(long id, int motant, Date date);

}
