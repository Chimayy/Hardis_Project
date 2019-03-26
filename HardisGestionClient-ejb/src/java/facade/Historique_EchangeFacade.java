/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Devis;
import entite.Historique_Echange;
import java.util.Date;
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
public class Historique_EchangeFacade extends AbstractFacade<Historique_Echange> implements Historique_EchangeFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Historique_EchangeFacade() {
        super(Historique_Echange.class);
    }

    @Override
    public List<Historique_Echange> listeEchange() {
         String txt = "SELECT he FROM Historique_Echange AS he";
        Query req = getEntityManager().createQuery(txt);
        List<Historique_Echange> liste = req.getResultList();
        return liste;
    }

    @Override
    public Historique_Echange rechercheEchange(long id) {
        Historique_Echange result;
        String txt = "SELECT he FROM Historique_Echange AS  WHERE he.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Historique_Echange)req.getSingleResult();
        return result;
    }

    @Override
    public void creerEchange(String contenu, Date date, String path, Devis devis) {
        Historique_Echange histo = new Historique_Echange();
        histo.setContenu_Echange(contenu);
        histo.setDate_Echange(date);
        histo.setLeDevis(devis);
        histo.setPath_Compte_Rendu(path);
        em.persist(histo);
    }
    
    
    
}
