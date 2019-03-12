/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Agence;
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
public class AgenceFacade extends AbstractFacade<Agence> implements AgenceFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AgenceFacade() {
        super(Agence.class);
    }

    @Override
    public List<Agence> listeAgence() {
        String txt = "SELECT a FROM Agence AS a";
        Query req = getEntityManager().createQuery(txt);
        List<Agence> liste = req.getResultList();
        return liste;
    }

    @Override
    public Agence rechercheAgence(long id) {
        Agence result;
        String txt = "SELECT a FROM Agence AS a WHERE a.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Agence)req.getSingleResult();
        return result;
    }

    @Override
    public void creerAgence(String rue_Agence, String ville_Agence, String CP_Agence, String pays_Agence) {
        Agence agenceACreer = new Agence();
        agenceACreer.setRue_Agence(rue_Agence);
        agenceACreer.setCP_Agence(CP_Agence);
        agenceACreer.setPays_Agence(pays_Agence);
        agenceACreer.setVille_Agence(ville_Agence);
        em.persist(agenceACreer);
    }
    
    
    
}
