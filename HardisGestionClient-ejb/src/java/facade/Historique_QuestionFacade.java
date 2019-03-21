/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Historique_Question;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thoma
 */
@Stateless
public class Historique_QuestionFacade extends AbstractFacade<Historique_Question> implements Historique_QuestionFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Historique_QuestionFacade() {
        super(Historique_Question.class);
    }

    @Override
    public List<Historique_Question> listeQuestion() {
        String txt = "SELECT h FROM Historique_Question AS h";
        Query req = getEntityManager().createQuery(txt);
        List<Historique_Question> liste = req.getResultList();
        return liste;
    }

    @Override
    public List<Historique_Question> rechercherQuestionUser(long id) {
        List<Historique_Question> result = new ArrayList<Historique_Question>();
        String txt = "SELECT q FROM Historique_Question AS q JOIN q.leDevis devis JOIN devis.leClient client WHERE client.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=req.getResultList();
        return result;
    }

    @Override
    public Historique_Question RechercheQuestion(long id) {
        String txt = "SELECT q FROM Historique_Question AS q WHERE q.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        Historique_Question result  = (Historique_Question)req.getSingleResult();
        return result;
    }

    @Override
    public void setReponse(long id,String reponse) {
      Historique_Question q =  RechercheQuestion(id);
      q.setReponse(reponse);
      em.merge(q);
    }
    
    
    
    
    
}
