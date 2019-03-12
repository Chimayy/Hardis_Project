/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Prestation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface PrestationFacadeLocal {

    void create(Prestation prestation);

    void edit(Prestation prestation);

    void remove(Prestation prestation);

    Prestation find(Object id);

    List<Prestation> findAll();

    List<Prestation> findRange(int[] range);

    int count();

    List<Prestation> listePrestation();

    Prestation recherchePrestation(long id);
    
}
