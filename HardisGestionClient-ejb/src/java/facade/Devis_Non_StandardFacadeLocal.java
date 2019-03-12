/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Client;
import entite.Devis_Non_Standard;
import entite.Offre;
import entite.Prestation_Non_Standard;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Devis_Non_StandardFacadeLocal {

    void create(Devis_Non_Standard devis_Non_Standard);

    void edit(Devis_Non_Standard devis_Non_Standard);

    void remove(Devis_Non_Standard devis_Non_Standard);

    Devis_Non_Standard find(Object id);

    List<Devis_Non_Standard> findAll();

    List<Devis_Non_Standard> findRange(int[] range);

    int count();

    void creerDevisNonStandard(double montant, boolean facturation_Auto, Date dateDevis, Date date_Intervention, Date dateDebut, String dateFin, String path, Offre offre, Prestation_Non_Standard presta, Client client);
    
}
