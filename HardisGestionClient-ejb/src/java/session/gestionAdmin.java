/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;


import entite.Consentement_RGPD;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import facade.UtilisateurFacadeLocal;
import facade.Utilisateur_HardisFacadeLocal;
import java.util.List;
import facade.UtilisateurFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author thoma
 */
@Stateless
public class gestionAdmin implements gestionAdminLocal {

    @EJB
    private Utilisateur_HardisFacadeLocal utilisateur_HardisFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    @Override
    public void creationUtilisateurHardis(String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif){
        utilisateur_HardisFacade.creerUtilisateurHardis(mail, mdp, nom, prenom, plafond, profiltechnique, statut_actif);   
    }
    
    @Override
    public void modificationUtilisateurHardis(int id, String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif){
        Utilisateur_Hardis user = utilisateur_HardisFacade.rechercherUtilisateurHardisId(id);
        utilisateur_HardisFacade.modifierUtilisateurHardis(user, mail, mdp, nom, prenom, plafond, profiltechnique, statut_actif);
    }
    
    @Override
    public void suppressionUtilisateurHardis(int id){
        Utilisateur_Hardis user = utilisateur_HardisFacade.rechercherUtilisateurHardisId(id);
        utilisateur_HardisFacade.supprimerUtilisateurHardis(user);
    }
    
    @Override
    public List<Utilisateur> affichageUtilisateursHardis(){
        return utilisateur_HardisFacade.afficherUtilisateurs_Hardis();
    }
    

    private UtilisateurFacadeLocal utilisateurFacade;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
