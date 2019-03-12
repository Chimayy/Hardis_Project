/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Agence;
import entite.Bon_De_Commande;
import entite.Facture;
import entite.Prestation;
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
public class Bon_De_CommandeFacade extends AbstractFacade<Bon_De_Commande> implements Bon_De_CommandeFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Bon_De_CommandeFacade() {
        super(Bon_De_Commande.class);
    }

    @Override
    public List<Bon_De_Commande> listeBonDeCommande() {
        String txt = "SELECT bdc FROM Bon_De_Commande AS bdc";
        Query req = getEntityManager().createQuery(txt);
        List<Bon_De_Commande> liste = req.getResultList();
        return liste;
    }

    @Override
    public Bon_De_Commande rechercheBDC(long id) {
        Bon_De_Commande result;
        String txt = "SELECT bdc FROM Bon_De_Commande AS bdc WHERE bdc.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Bon_De_Commande)req.getSingleResult();
        return result;
    }

    @Override
    public void creerBonDeCommande(double montantBonDeCommande, String descriptifBonDeCommande, Facture facture, Prestation prestation) {
        Bon_De_Commande BonACreer = new Bon_De_Commande();
        BonACreer.setDescriptif_BonDeCommande(descriptifBonDeCommande);
        BonACreer.setMontant_BonDeCommande(montantBonDeCommande);
        BonACreer.setLaFacture(facture);
        BonACreer.setLaPrestation(prestation);
        em.persist(BonACreer);
    }
    
    
    
}
