/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entite.Utilisateur;

import entite.Devis;
import entite.Historique_Question;
import entite.Historique_QuestionPublique;
import entite.Utilisateur_Hardis;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionHardisLocal {


//    Utilisateur_Hardis authentif(String mail, String mdp);

    List listeDevis();

    List ListeQuestion(Devis d);

    Historique_Question RechercheQuestion(long id);

    void setReponse(long id, String reponse);

    List GetUtilisateurParOffre(long idOffre);


    List ListeMetier(Utilisateur User);

    List ListeToutLesMetier();

    void CreerHistoriqueConsultant(Utilisateur_Hardis gest, Devis devis, String fct);

    List rechercherUtilisateurHardisNom(String Nom);

    void creerDateDispo(Utilisateur_Hardis user, Date Datedebut, Date Daefin);

    List ListeHistGest(Utilisateur_Hardis Gest);

    List ListeQuestionGest(Utilisateur_Hardis Gest);

    void RepQP(Historique_QuestionPublique h, String rep);

    List RechercheQP(long id);


    
}
