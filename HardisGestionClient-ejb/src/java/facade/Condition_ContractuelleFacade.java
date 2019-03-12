/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Condition_Contractuelle;
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
public class Condition_ContractuelleFacade extends AbstractFacade<Condition_Contractuelle> implements Condition_ContractuelleFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Condition_ContractuelleFacade() {
        super(Condition_Contractuelle.class);
    }

    @Override
    public List<Condition_Contractuelle> listeConditions() {
        String txt = "SELECT cc FROM Condition_Contractuelle AS cc";
        Query req = getEntityManager().createQuery(txt);
        List<Condition_Contractuelle> liste = req.getResultList();
        return liste;
    }

    @Override
    public void creerCondition(String contenu) {
        Condition_Contractuelle conditionACreer = new Condition_Contractuelle();
        conditionACreer.setContenu_Condition(contenu);
        em.persist(conditionACreer);
   
    }
    
    
   
    
}
