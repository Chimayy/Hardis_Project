/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Prestation_Standard;
import entite.Service;
import entite.lieu_Intervention;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Prestation_StandardFacadeLocal {

    void create(Prestation_Standard prestation_Standard);

    void edit(Prestation_Standard prestation_Standard);

    void remove(Prestation_Standard prestation_Standard);

    Prestation_Standard find(Object id);

    List<Prestation_Standard> findAll();

    List<Prestation_Standard> findRange(int[] range);

    int count();

    void creerPrestationStandard(String nom, String description, String nomresp, String telresp, String mailresp, double cout, boolean facturation, int delai, Service service, lieu_Intervention lieu, String Expertise, double montantJour, double nbJour );
    
}
