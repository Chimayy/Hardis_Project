/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;



import entite.Agence;

import entite.Consentement_RGPD;
import entite.Entreprise;
import entite.Offre;
import entite.Service;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import facade.AgenceFacadeLocal;
import facade.EntrepriseFacadeLocal;
import facade.OffreFacadeLocal;
import facade.ServiceFacadeLocal;
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
    private OffreFacadeLocal offreFacade;

    @EJB
    private ServiceFacadeLocal serviceFacade;

    @EJB
    private AgenceFacadeLocal agenceFacade;

    @EJB
    private EntrepriseFacadeLocal entrepriseFacade;

    @EJB
    private Utilisateur_HardisFacadeLocal utilisateur_HardisFacade;

     
    @Override
    public void creationUtilisateurHardis(String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif){
        utilisateur_HardisFacade.creerUtilisateurHardis(mail, mdp, nom, prenom, plafond, profiltechnique, statut_actif);   
    }
    
    @Override
    public void creationEntreprise(String cp, String nom, String siret, String rue, String ville, Agence agence){
        entrepriseFacade.creerEntreprise(cp, nom, siret, rue, ville, agence);
    }
    
    @Override
    public void creationAgence(String cp, String pays, String adresse, String ville){
        agenceFacade.creerAgence(adresse, ville, cp, pays);
    }
    
    @Override
    public void creationService(String description, String nom, double cout, Offre offre){
        serviceFacade.creerService(description, nom, cout, offre);
    }
    
    @Override
    public void creationOffre(String description, String nom){
        offreFacade.creerOffre(description, nom);
    }
            
    @Override
    public void modificationUtilisateurHardis(long id, String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif){
        Utilisateur_Hardis user = utilisateur_HardisFacade.rechercherUtilisateurHardisId(id).get(0);
        utilisateur_HardisFacade.modifierUtilisateurHardis(user, mail, mdp, nom, prenom, plafond, profiltechnique, statut_actif);
    }
    
    @Override
    public void modificationEntreprise(long id, String nom, String siret, String cp, String adresse, String ville, Agence agence){
        Entreprise ent = entrepriseFacade.rechercherEntrepriseParId(id).get(0);
        entrepriseFacade.modifierEntreprise(ent, nom, siret, cp, adresse, ville, agence);
    }
    
    @Override
    public void modificationAgence(long id, String cp, String pays, String adresse, String ville){
        Agence agence = agenceFacade.rechercherAgenceParId(id).get(0);
        agenceFacade.modifierAgence(agence, cp, pays, adresse, ville);
    }
    
    @Override
    public void modificationService(long id, String nom, String description, double cout, Offre offre){
        Service service = serviceFacade.rechercheService(id).get(0);
        serviceFacade.modifierService(service, description, nom, cout, offre);
    }
    
    @Override
    public void suppressionUtilisateurHardis(long id){
        Utilisateur_Hardis user = utilisateur_HardisFacade.rechercherUtilisateurHardisId(id).get(0);
        utilisateur_HardisFacade.supprimerUtilisateurHardis(user);
    }
    
    @Override
    public void suppressionEntreprise(long id){
        Entreprise ent = entrepriseFacade.rechercherEntrepriseParId(id).get(0);
        entrepriseFacade.supprimerEntreprise(ent);
    }
    
    @Override
    public void suppressionAgence(long id){
        Agence agence = agenceFacade.rechercherAgenceParId(id).get(0);
        agenceFacade.supprimerAgence(agence);
    }
    
    public void suppressionService(long id){
        
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
    public List<Service> affichageServices(){
        return serviceFacade.listeService();
    }
    
    @Override
    public List<Offre> affichageOffres(){
        return offreFacade.listeOffre();
    }
    
    @Override
    public Utilisateur_Hardis rechercherUtilisateurHardisMail(String mail){
        Utilisateur_Hardis user = utilisateur_HardisFacade.rechercherUtilisateurHardisMail(mail);
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


    
//    public Utilisateur rechercherUtilisateurHardisParId(long id){
//        return utilisateur_HardisFacade.rechercherUtilisateurHaridsParId(id);
//    }


    
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
     public List<Entreprise> rechercherEntrepriseParId(long id){
        return entrepriseFacade.rechercherEntrepriseParId(id);
     }
     
    @Override
     public List<Entreprise> rechercherEntrepriseParAgence(Agence agence){
         return entrepriseFacade.rechercherEntrepriseParAgence(agence);
     }
     
    @Override
    public Agence rechercherAgenceParVille(String ville){
        return agenceFacade.rechercherAgenceParVille(ville);
    }
    
    @Override
    public List<Agence> rechercherAgenceParId(long id){
        return agenceFacade.rechercherAgenceParId(id);
    }
    
    @Override
    public List<Offre> rechercherOffreParId(long id){
        return offreFacade.rechercheOffre(id);
    }
    
    @Override
    public List<Service> rechercherServiceParId(long id){
        return serviceFacade.rechercheService(id);
    }
    
    @Override
    public Offre rechercherOffreParNom(String nom){
        return offreFacade.rechercheOffreNom(nom);
    }
    
    @Override
    public List<Offre> rechercherListeOffreParNom(String nom){
        return offreFacade.rechercherListeOffreNom(nom);
    }
}  

