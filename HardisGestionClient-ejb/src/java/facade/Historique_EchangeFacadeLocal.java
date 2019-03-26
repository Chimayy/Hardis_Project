/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Devis;
import entite.Historique_Echange;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Historique_EchangeFacadeLocal {

    void create(Historique_Echange historique_Echange);

    void edit(Historique_Echange historique_Echange);

    void remove(Historique_Echange historique_Echange);

    Historique_Echange find(Object id);

    List<Historique_Echange> findAll();

    List<Historique_Echange> findRange(int[] range);

    int count();

    List<Historique_Echange> listeEchange();

    Historique_Echange rechercheEchange(long id);

    void creerEchange(String contenu, Date date, String path, Devis devis);
    
}
