/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

<<<<<<< HEAD
import entite.Utilisateur;
=======
import entite.Devis;
import entite.Historique_Question;
import entite.Utilisateur_Hardis;
import java.util.List;
>>>>>>> exilessmath
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionHardisLocal {

<<<<<<< HEAD
    
=======
    Utilisateur_Hardis authentif(String mail, String mdp);

    List listeDevis();

    List ListeQuestion(Devis d);

    Historique_Question RechercheQuestion(long id);

    void setReponse(long id, String reponse);
>>>>>>> exilessmath
    
}
