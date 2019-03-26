/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Offre;
import entite.Service;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface ServiceFacadeLocal {

    void create(Service service);

    void edit(Service service);

    void remove(Service service);

    Service find(Object id);

    List<Service> findAll();

    List<Service> findRange(int[] range);

    int count();

    List<Service> listeService();

    List<Service> rechercheService(long id);

    public void creerService(String description_Service, String nom, double cout_Service, Offre offre);

    public void modifierService(Service service, String description, String nom, double cout, Offre offre);

    public void supprimerService(Service service);

    public List<Service> rechercherServiceOffre(Offre offre);

    public List<Service> rechercherServiceNom(String nom);
    
}
