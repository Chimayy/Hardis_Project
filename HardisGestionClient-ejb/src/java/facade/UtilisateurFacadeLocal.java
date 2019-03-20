/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface UtilisateurFacadeLocal {

    void create(Utilisateur utilisateur);

    void edit(Utilisateur utilisateur);

    void remove(Utilisateur utilisateur);

    Utilisateur find(Object id);

    List<Utilisateur> findAll();

    List<Utilisateur> findRange(int[] range);

    int count();

    List<Utilisateur> listeUtilisateur();

    Utilisateur rechercheUtilisateur(long id);

    public Utilisateur authentification(String mail, String mdp);

    
}
