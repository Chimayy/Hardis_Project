/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Client;
import entite.Devis_Standard;
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
public interface Devis_StandardFacadeLocal {

    void create(Devis_Standard devis_Standard);

    void edit(Devis_Standard devis_Standard);

    void remove(Devis_Standard devis_Standard);

    Devis_Standard find(Object id);

    List<Devis_Standard> findAll();

    List<Devis_Standard> findRange(int[] range);

    int count();

    void creerDevisStandard(double montant, boolean facturation_Auto, Date date_Devis,  Date date_Intervention, Date dateDebut, Date dateFin, Offre offre, Prestation_Non_Standard presta, Client client);
    
}
