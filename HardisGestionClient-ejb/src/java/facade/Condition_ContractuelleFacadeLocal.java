/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Condition_Contractuelle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Condition_ContractuelleFacadeLocal {

    void create(Condition_Contractuelle condition_Contractuelle);

    void edit(Condition_Contractuelle condition_Contractuelle);

    void remove(Condition_Contractuelle condition_Contractuelle);

    Condition_Contractuelle find(Object id);

    List<Condition_Contractuelle> findAll();

    List<Condition_Contractuelle> findRange(int[] range);

    int count();

    List<Condition_Contractuelle> listeConditions();

    void creerCondition(String contenu);
    
}
