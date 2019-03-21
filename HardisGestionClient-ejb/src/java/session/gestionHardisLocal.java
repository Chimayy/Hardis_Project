/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Devis;
import entite.Historique_Question;
import entite.Utilisateur_Hardis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionHardisLocal {

    Utilisateur_Hardis authentif(String mail, String mdp);

    List listeDevis();

    List ListeQuestion(Devis d);

    Historique_Question RechercheQuestion(long id);

    void setReponse(long id, String reponse);
    
}
