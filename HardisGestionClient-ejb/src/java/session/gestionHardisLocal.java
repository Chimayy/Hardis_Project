/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Utilisateur_Hardis;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionHardisLocal {

    Utilisateur_Hardis authentif(String mail, String mdp);
    
}
