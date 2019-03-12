/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Livrable;
import entite.Prestation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface LivrableFacadeLocal {

    void create(Livrable livrable);

    void edit(Livrable livrable);

    void remove(Livrable livrable);

    Livrable find(Object id);

    List<Livrable> findAll();

    List<Livrable> findRange(int[] range);

    int count();

    void creerLivrable(String path, String type, Prestation prestation);
    
}
