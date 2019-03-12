/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;



import entite.Facture;
import entite.etat_Facture;
import java.sql.Date;
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
public class FactureFacade extends AbstractFacade<Facture> implements FactureFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FactureFacade() {
        super(Facture.class);
    }

    @Override
    public List<Facture> listeFacture() {
        String txt = "SELECT f FROM Facture AS f";
        Query req = getEntityManager().createQuery(txt);
        List<Facture> liste = req.getResultList();
        return liste;
    }

    @Override
    public Facture rechercheFacture(long id) {
        Facture result;
        String txt = "SELECT f FROM Facture AS f WHERE f.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Facture)req.getSingleResult();
        return result;
    }

    @Override
    public void creerFacture(Date dateFacture, double montant, int pourcentage) {
        Facture factureACreer = new Facture();
        factureACreer.setDate_Facture(dateFacture);
        factureACreer.setMontant_Facture(montant);
        factureACreer.setPourcentage_avancement_Facture(pourcentage);
        factureACreer.setEtat_Facture(etat_Facture.en_cours);
        em.persist(factureACreer);
    }
    
    
    
}
