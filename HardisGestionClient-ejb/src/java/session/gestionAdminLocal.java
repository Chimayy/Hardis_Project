/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Agence;
import entite.Consentement_RGPD;
import entite.Entreprise;
import entite.Historique_QuestionPublique;
import entite.Offre;
import entite.Profil_Metier;
import entite.Service;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface gestionAdminLocal {

    public Utilisateur_Hardis creationUtilisateurHardis(String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif, Agence agence);

    public Utilisateur_Hardis modificationUtilisateurHardis(long id, String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif);

    public List<Utilisateur_Hardis> affichageUtilisateursHardis();

    public Utilisateur_Hardis rechercherUtilisateurHardisMail(String mail);

    public List<Utilisateur_Hardis> rechercherUtilisateurHardisNom(String nom);

    public List<Utilisateur_Hardis> recherchercherUtilisateurHardisId(long id);

    public void suppressionUtilisateurHardis(long id);

    public List<Entreprise> affichageEntreprises();

    public Entreprise rechercherEntrepriseParSiret(String siret);

    public Utilisateur_Hardis rechercherUtilisateurHardisParId(long id);

    public void creationEntreprise(String cp, String nom, String siret, String rue, String ville, Agence agence);

    public Agence rechercherAgenceParVille(String ville);

    public List<Agence> affichageAgences();

    public List<Agence> rechercherAgenceParId(long id);

    public List<Entreprise> rechercherEntrepriseParNom(String nom);

    public List<Entreprise> rechercherEntrepriseParId(long id);

    public void suppressionEntreprise(long id);

    public void modificationEntreprise(long id, String nom, String siret, String cp, String adresse, String ville, Agence agence);

    public void creationAgence(String cp, String pays, String adresse, String ville);

    public void suppressionAgence(long id);

    public List<Entreprise> rechercherEntrepriseParAgence(Agence agence);

    public void modificationAgence(long id, String cp, String pays, String adresse, String ville);

    public List<Service> affichageServices();

    public List<Offre> affichageOffres();

    public List<Offre> rechercherOffreParId(long id);

    public void creationService(String description, String nom, double cout, Offre offre);

    public List<Service> rechercherServiceParId(long id);

    public void modificationService(long id, String nom, String description, double cout, Offre offre);

    public void creationOffre(String description, String nom);

    public Offre rechercherOffreParNom(String nom);

    public List<Offre> rechercherListeOffreParNom(String nom);

    public void creationQuestionPublique(String question, String pseudo, Offre offre);

    public Historique_QuestionPublique rechercherQuestionPubliqueParPseudo(String pseudo);

    public List<Historique_QuestionPublique> affichageQuestionsPubliques();

    public List<Profil_Metier> affichageProfilsMetier();

    public List<Historique_QuestionPublique> rechercherQuestionPubliqueParId(long id);

    public List<Profil_Metier> rechercherProfilMetierParIdUser(long idUser);

    public void creationProfilMetier(int niveau_habilitation, Offre offre, Utilisateur_Hardis user);

    public void modificationProfilMetier(long id, int niveau);

    public void modificationOffre(long id, String nom, String description);

    public List<Profil_Metier> rechercherProfilMetierParId(long id);

    public void suppressionService(long id);

    public void suppressionProfilMetier(long id);

    public List<Utilisateur_Hardis> rechercherUtilisateurHardisParOffre(long id);

    public void suppressionOffre(long id);

    public Profil_Metier rechercherProfilMetier(long idUser, long idOffre);

    public void attributionQuestionPublique(Historique_QuestionPublique question, Utilisateur_Hardis gestionnaire);


    public List<Service> rechercherServiceParOffre(Offre offre);

    public List<Service> rechercherServiceParNom(String nom);

    List ListeQPPseudo(String pseudo);


}