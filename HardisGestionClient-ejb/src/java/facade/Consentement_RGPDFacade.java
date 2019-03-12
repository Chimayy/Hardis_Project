/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Consentement_RGPD;
import entite.Utilisateur;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thoma
 */
@Stateless
public class Consentement_RGPDFacade extends AbstractFacade<Consentement_RGPD> implements Consentement_RGPDFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Consentement_RGPDFacade() {
        super(Consentement_RGPD.class);
    }

    @Override
    public void creerConsentement(boolean consentement, Date date, Utilisateur user) {
        Consentement_RGPD consentementACreer = new Consentement_RGPD();
        consentementACreer.setBoolConsentement(consentement);
        consentementACreer.setDateConsentement(date);
        consentementACreer.setUser(user);
        em.persist(consentementACreer);
    }
    
    
    
}
