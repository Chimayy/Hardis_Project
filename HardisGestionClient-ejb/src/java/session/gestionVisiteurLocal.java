/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Service;
import entite.Utilisateur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionVisiteurLocal {
    Utilisateur authentification(String mail, String mdp);
    List<Service> AffichageService();
}

