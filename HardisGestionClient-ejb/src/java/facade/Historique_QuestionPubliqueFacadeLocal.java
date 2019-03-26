/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Historique_QuestionPublique;
import entite.Offre;
import entite.Utilisateur_Hardis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Utilisateur
 */
@Local
public interface Historique_QuestionPubliqueFacadeLocal {

    void create(Historique_QuestionPublique historique_QuestionPublique);

    void edit(Historique_QuestionPublique historique_QuestionPublique);

    void remove(Historique_QuestionPublique historique_QuestionPublique);

    Historique_QuestionPublique find(Object id);

    List<Historique_QuestionPublique> findAll();

    List<Historique_QuestionPublique> findRange(int[] range);

    int count();

    public void creerHistorique_QuestionPublique(String question, String pseudo, Offre offre);

    public Historique_QuestionPublique rechercheQuestionPubliquePseudo(String pseudo);

    public List<Historique_QuestionPublique> listeQuestionPublique();

    public List<Historique_QuestionPublique> rechercheQuestionPubliqueId(long id);

    public void attribuerQuestionPublique(Historique_QuestionPublique question, Utilisateur_Hardis gestionnaire);

    List QuestionPubliqueGestionnaire(Utilisateur_Hardis Gest);

    void AffecterRep(Historique_QuestionPublique h, String rep);

    List ListeQuestionPublicRep();

    List ListeQPOfrre(Offre Offre);

    List ListeQPPseudo(String pseudo);
    
}
