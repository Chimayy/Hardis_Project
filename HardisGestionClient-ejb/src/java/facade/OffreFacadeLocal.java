/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Offre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface OffreFacadeLocal {

    void create(Offre offre);

    void edit(Offre offre);

    void remove(Offre offre);

    Offre find(Object id);

    List<Offre> findAll();

    List<Offre> findRange(int[] range);

    int count();

    List<Offre> listeOffre();

    Offre rechercheOffre(long id);

    void creerOffre(String description, String nom);
    
}
