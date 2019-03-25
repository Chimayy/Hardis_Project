/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Devis;
import entite.Historique_Consultant;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Historique_ConsultantFacadeLocal {

    void create(Historique_Consultant historique_Consultant);

    void edit(Historique_Consultant historique_Consultant);

    void remove(Historique_Consultant historique_Consultant);

    Historique_Consultant find(Object id);

    List<Historique_Consultant> findAll();

    List<Historique_Consultant> findRange(int[] range);

    int count();

    void CreerHistoriqueConsultant(Utilisateur_Hardis Gest, Devis Devis, String Fct);
    
}
