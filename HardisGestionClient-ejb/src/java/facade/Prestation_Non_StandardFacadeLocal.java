/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Prestation_Non_Standard;
import entite.Service;
import entite.lieu_Intervention;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Prestation_Non_StandardFacadeLocal {

    void create(Prestation_Non_Standard prestation_Non_Standard);

    void edit(Prestation_Non_Standard prestation_Non_Standard);

    void remove(Prestation_Non_Standard prestation_Non_Standard);

    Prestation_Non_Standard find(Object id);

    List<Prestation_Non_Standard> findAll();

    List<Prestation_Non_Standard> findRange(int[] range);

    int count();

    void creerPrestationNonStandard(String description, String nomresp, String telresp, String mailresp, double cout, boolean facturation, int delai, Service service, lieu_Intervention lieu);

    void creerPrestaNS(Service service);
    
}
