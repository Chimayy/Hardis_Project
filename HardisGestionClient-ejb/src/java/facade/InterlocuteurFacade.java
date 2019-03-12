/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Entreprise;
import entite.Interlocuteur;
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
public class InterlocuteurFacade extends AbstractFacade<Interlocuteur> implements InterlocuteurFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InterlocuteurFacade() {
        super(Interlocuteur.class);
    }

    @Override
    public List<Interlocuteur> listeInterlocuteur() {
        String txt = "SELECT i FROM Interlocuteur AS i";
        Query req = getEntityManager().createQuery(txt);
        List<Interlocuteur> liste = req.getResultList();
        return liste;

    }

    @Override
    public Interlocuteur rechercheInterlocuteur(long id) {
        Interlocuteur result;
        String txt = "SELECT i FROM Interlocuteur  AS  WHERE i.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Interlocuteur)req.getSingleResult();
        return result;
    }

    @Override
    public void creerInterlocuteur(String mail, String nom, String numtel, String prenom, Entreprise entreprise) {
        Interlocuteur interlocuteurACreer = new Interlocuteur();
        interlocuteurACreer.setMail_Interlocuteur(mail);
        interlocuteurACreer.setNom_Interlocuteur(nom);
        interlocuteurACreer.setNum_Tel_Interlocuteur(numtel);
        interlocuteurACreer.setPrenom_Interlocuteur(prenom);
        em.persist(interlocuteurACreer);
    }
 
    
    
}
