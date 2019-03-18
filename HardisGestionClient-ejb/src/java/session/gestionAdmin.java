/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Agence;
import entite.Consentement_RGPD;
import entite.Entreprise;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import facade.AgenceFacadeLocal;
import facade.EntrepriseFacadeLocal;
import facade.UtilisateurFacadeLocal;
import facade.Utilisateur_HardisFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author thoma
 */
@Stateless
public class gestionAdmin implements gestionAdminLocal {

    @EJB
    private AgenceFacadeLocal agenceFacade;

    @EJB
    private EntrepriseFacadeLocal entrepriseFacade;

    @EJB
    private Utilisateur_HardisFacadeLocal utilisateur_HardisFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    
    @Override
    public void creationUtilisateurHardis(String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif){
        utilisateur_HardisFacade.creerUtilisateurHardis(mail, mdp, nom, prenom, plafond, profiltechnique, statut_actif);   
    }
    
    @Override
    public void creationEntreprise(String cp, String nom, String siret, String rue, String ville, Agence agence){
        entrepriseFacade.creerEntreprise(cp, nom, siret, rue, ville, agence);
    }
    @Override
    public void modificationUtilisateurHardis(int id, String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif){
        Utilisateur_Hardis user = utilisateur_HardisFacade.rechercherUtilisateurHardisId(id).get(0);
        utilisateur_HardisFacade.modifierUtilisateurHardis(user, mail, mdp, nom, prenom, plafond, profiltechnique, statut_actif);
    }
    
    @Override
    public void suppressionUtilisateurHardis(long id){
        Utilisateur_Hardis user = utilisateur_HardisFacade.rechercherUtilisateurHardisId(id).get(0);
        utilisateur_HardisFacade.supprimerUtilisateurHardis(user);
    }
    
    @Override
    public void suppressionEntreprise(long id){
        Entreprise ent = entrepriseFacade.rechercherEntrepriseParId(id);
        entrepriseFacade.supprimerEntreprise(ent);
    }
    
    @Override
    public List<Utilisateur_Hardis> affichageUtilisateursHardis(){
        return utilisateur_HardisFacade.afficherUtilisateurs_Hardis();
    }
    
    @Override
    public List<Entreprise> affichageEntreprises(){
        return entrepriseFacade.listeEntreprise();
    }
    
    @Override
    public List<Agence> affichageAgences(){
        return agenceFacade.listeAgence();
    }
    
    @Override
    public Utilisateur_Hardis rechercherUtilisateurHardisMail(String mail){
        Utilisateur_Hardis user = null;
        user = utilisateur_HardisFacade.rechercherUtilisateurHardisMail(mail);
        return user;
    }
    
    @Override
    public List<Utilisateur_Hardis> rechercherUtilisateurHardisNom(String nom){
       return utilisateur_HardisFacade.rechercherUtilisateurHardisNom(nom);
    }
    
    @Override
    public List<Utilisateur_Hardis> recherchercherUtilisateurHardisId(long id){
        return utilisateur_HardisFacade.rechercherUtilisateurHardisId(id);
    }
    
    @Override
    public Utilisateur rechercherUtilisateurHardisParId(long id){
        return utilisateur_HardisFacade.rechercherUtilisateurHaridsParId(id);
    }
    
    @Override
    public Entreprise rechercherEntrepriseParSiret(String siret){
        return entrepriseFacade.rechercherEntrepriseParSiret(siret);
    }
    
    @Override
     public List<Entreprise> rechercherEntrepriseParNom(String nom){
        return entrepriseFacade.rechercherEntrepriseParNom(nom);
     }
     
    @Override
     public Entreprise rechercherEntrepriseParId(long id){
        return entrepriseFacade.rechercherEntrepriseParId(id);
     }
     
    @Override
    public Agence rechercherAgenceParVille(String ville){
        return agenceFacade.rechercherAgenceParVille(ville);
    }
    
    @Override
    public Agence rechercherAgenceParId(long id){
        return agenceFacade.rechercherAgenceParId(id);
    }
    
}  
