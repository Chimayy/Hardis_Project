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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Utilisateur
 */
@Stateless
public class Historique_QuestionPubliqueFacade extends AbstractFacade<Historique_QuestionPublique> implements Historique_QuestionPubliqueFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Historique_QuestionPubliqueFacade() {
        super(Historique_QuestionPublique.class);
    }
    
    @Override
    public void creerHistorique_QuestionPublique(String question, String pseudo, Offre offre){
        Historique_QuestionPublique question_publique = new Historique_QuestionPublique();
        question_publique.setQuestion(question);
        question_publique.setPseudo(pseudo);
        question_publique.setlOffre(offre);
        em.persist(question_publique);
    }
    
    @Override
    public Historique_QuestionPublique rechercheQuestionPubliquePseudo(String pseudo){
        String txt = "SELECT h FROM Historique_QuestionPublique AS h WHERE h.pseudo=:pseudo";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("pseudo", pseudo);
        Historique_QuestionPublique resultat = (Historique_QuestionPublique)req.getSingleResult();
        return resultat;
    }
    
    @Override
     public List<Historique_QuestionPublique> listeQuestionPublique() {
        String txt = "SELECT h FROM Historique_QuestionPublique AS h WHERE h.gestionnaire IS NULL";
        Query req = getEntityManager().createQuery(txt);
        List<Historique_QuestionPublique> liste = req.getResultList();
        return liste;
    }
    
    @Override
     public List<Historique_QuestionPublique> rechercheQuestionPubliqueId(long id){
        String txt = "SELECT h FROM Historique_QuestionPublique AS h where h.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req = req.setParameter("id", id);
        List<Historique_QuestionPublique> liste = req.getResultList();
        return liste;
     }
     
    @Override
     public void attribuerQuestionPublique(Historique_QuestionPublique question, Utilisateur_Hardis gestionnaire){
         question.setGestionnaire(gestionnaire);
         em.merge(question);
     }
}
