/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Consentement_RGPD;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import java.util.ArrayList;
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
    public void creerUtilisateurHardis(String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif) {
        Utilisateur_Hardis userACreer = new Utilisateur_Hardis();
        userACreer.setPlafond_Delegation(plafond);
        userACreer.setMail_Connexion(mail);
        userACreer.setMot_De_Passe(mdp);
        userACreer.setNom_Utilisateur(nom);
        userACreer.setProfil_Technique(profiltechnique);
        userACreer.setPrenom_Utilisateur(prenom);
        userACreer.setStatut_Actif(false);
        em.persist(userACreer);
    }
    
    @Override
    public void modifierUtilisateurHardis(Utilisateur_Hardis user,String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif){
        user.setPlafond_Delegation(plafond);
        user.setMail_Connexion(mail);
        user.setMot_De_Passe(mdp);
        user.setNom_Utilisateur(nom);
        user.setProfil_Technique(profiltechnique);
        user.setPrenom_Utilisateur(prenom);
        user.setStatut_Actif(false);
        em.persist(user);        
    }
    
    @Override
    public void supprimerUtilisateurHardis(Utilisateur_Hardis user){
        em.remove(user);
    }
    
    @Override
    public List<Utilisateur_Hardis> rechercherUtilisateurHardisId(long id){
        Utilisateur_Hardis user ;
        String txt= "select user from Utilisateur AS user where user.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("id", id);     
        List<Utilisateur_Hardis> liste =  req.getResultList();
        if (!liste.isEmpty()){
            return liste;
        }           
        else {return null;}    
    }
    
    @Override
    public Utilisateur_Hardis rechercherUtilisateurHardisMail(String mail){
        Utilisateur_Hardis user;
        String txt = "SELECT user FROM Utilisateur AS user where user.mail_Connexion =:mail";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("mail",mail);
        List<Utilisateur_Hardis> liste = req.getResultList();
        if(!liste.isEmpty()){
            return liste.get(0);
        }
        else {return null;}    
    }
    
    @Override
    public List<Utilisateur_Hardis> rechercherUtilisateurHardisNom(String nom){
        Utilisateur_Hardis user;
        String txt = "SELECT user FROM Utilisateur AS user where user.nom_Utilisateur =:nom";
        Query req = getEntityManager().createQuery(txt);
        req.setParameter("nom",nom);
        List<Utilisateur_Hardis> liste = req.getResultList();
        return liste;
    }

  
    
    @Override
    public List<Utilisateur_Hardis> afficherUtilisateurs_Hardis(){
        List<Utilisateur_Hardis> user = new ArrayList<Utilisateur_Hardis>();
        String text ="SELECT user FROM Utilisateur AS user";
        Query req = getEntityManager().createQuery(text);
        user = (List<Utilisateur_Hardis>)req.getResultList();
        return user;
    }

}
