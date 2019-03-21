/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Historique_Question;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Historique_QuestionFacadeLocal {

    void create(Historique_Question historique_Question);

    void edit(Historique_Question historique_Question);

    void remove(Historique_Question historique_Question);

    Historique_Question find(Object id);

    List<Historique_Question> findAll();

    List<Historique_Question> findRange(int[] range);

    int count();

    List<Historique_Question> listeQuestion();

    List<Historique_Question> rechercherQuestionUser(long id);

    Historique_Question RechercheQuestion(long id);

    void setReponse(long id,String reponse);
    
}
