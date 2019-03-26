/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

<<<<<<< HEAD
import entite.Client;
import entite.Entreprise;
=======
import entite.Offre;
>>>>>>> exiless6
import entite.Service;
import entite.Utilisateur;
import java.util.List;
import entite.Utilisateur;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionVisiteurLocal {
    Utilisateur authentification(String mail, String mdp);
    List<Service> AffichageService();

<<<<<<< HEAD
    void creerClient(String nom_Client, String prenom_Client, String mdp, String mail, Entreprise etp);

    List<Entreprise> listEntreprise();

    Client rechercheClientMail(String mail);

    Entreprise rechercheEntreprise(long id);
=======
   List ListeQuestionPubliqueRep();

    List ListeQPOffre(Offre Offre);
>>>>>>> exiless6


    
}

