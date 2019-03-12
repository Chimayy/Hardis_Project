/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Periode_Disponible;
import entite.Utilisateur_Hardis;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Periode_DisponibleFacadeLocal {

    void create(Periode_Disponible periode_Disponible);

    void edit(Periode_Disponible periode_Disponible);

    void remove(Periode_Disponible periode_Disponible);

    Periode_Disponible find(Object id);

    List<Periode_Disponible> findAll();

    List<Periode_Disponible> findRange(int[] range);

    int count();

    List<Periode_Disponible> listePeriodeUser(String idHardis);

    void creerPeriode(Date dateDebut, Date dateFin, Utilisateur_Hardis user);
    
}
