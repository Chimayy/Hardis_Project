/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Consentement_RGPD;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thoma
 */
@Stateless
public class Utilisateur_HardisFacade extends AbstractFacade<Utilisateur_Hardis> implements Utilisateur_HardisFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Utilisateur_HardisFacade() {
        super(Utilisateur_Hardis.class);
    }

    @Override
    public void creerUtilisateurHardis(String mail, String mdp, String nom, String prenom, Consentement_RGPD leConsentement, double plafond, profil_Technique profiltechnique, boolean statut_actif) {
        Utilisateur_Hardis userACreer = new Utilisateur_Hardis();
        userACreer.setPlafond_Delegation(plafond);
        userACreer.setLeConsentement(leConsentement);
        userACreer.setMail_Connexion(mail);
        userACreer.setMot_De_Passe(mdp);
        userACreer.setNom_Utilisateur(nom);
        userACreer.setProfil_Technique(profiltechnique);
        userACreer.setPrenom_Utilisateur(prenom);
        userACreer.setStatut_Actif(statut_actif);
        em.persist(userACreer);
    }

    @Override
    public Utilisateur_Hardis authentification(String mail, String mdp) {
        Utilisateur_Hardis user;
        String txt = "SELECT a FROM Utilisateur AS a WHERE a.mail_Connexion=:lo AND a.mot_De_Passe=:motp";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("lo", mail);
        req=req.setParameter("motp", mdp);
        user=(Utilisateur_Hardis)req.getSingleResult();
        return user;
    }
    
}
