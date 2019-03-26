/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Client;
import entite.Consentement_RGPD;
import entite.Entreprise;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface ClientFacadeLocal {

    void create(Client client);

    void edit(Client client);

    void remove(Client client);

    Client find(Object id);

    List<Client> findAll();

    List<Client> findRange(int[] range);

    int count();

    List<Client> listeClient();

    Client rechercheClient(long id);

    void creerClient(String nom_Client, String prenom_Client, String mdp, String mail, Entreprise etp);

    Client authentif(String mail, String mdp);


    public Client rechercheClientNom(String nom);

    List<Entreprise> listeEntreprise();

    Client rechercheClientMail(String mail);

}
