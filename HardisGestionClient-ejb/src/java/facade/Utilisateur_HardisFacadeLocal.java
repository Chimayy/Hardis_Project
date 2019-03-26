/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Agence;
import entite.Consentement_RGPD;
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
public interface Utilisateur_HardisFacadeLocal {

    void create(Utilisateur_Hardis utilisateur_Hardis);

    void edit(Utilisateur_Hardis utilisateur_Hardis);

    void remove(Utilisateur_Hardis utilisateur_Hardis);

    Utilisateur_Hardis find(Object id);

    List<Utilisateur_Hardis> findAll();

    List<Utilisateur_Hardis> findRange(int[] range);

    int count();

    //void creerUtilisateurHardis(String mail, String mdp, String nom, String prenom,  Consentement_RGPD leConsentement, double plafond, profil_Technique profiltechnique, boolean statut_actif);

   // Utilisateur_Hardis authentification(String mail, String mdp);

    public List<Utilisateur_Hardis> rechercherUtilisateurHardisId(long id);

    public void supprimerUtilisateurHardis(Utilisateur_Hardis user);

    public List<Utilisateur_Hardis> afficherUtilisateurs_Hardis();

    public Utilisateur_Hardis creerUtilisateurHardis(String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif, Agence agence);

    public Utilisateur_Hardis modifierUtilisateurHardis(Utilisateur_Hardis user, String mail, String mdp, String nom, String prenom, double plafond, profil_Technique profiltechnique, boolean statut_actif);

    public Utilisateur_Hardis rechercherUtilisateurHardisMail(String mail);

    public List<Utilisateur_Hardis> rechercherUtilisateurHardisNom(String nom);

    public Utilisateur_Hardis rechercherUtilisateurHaridsParId(long id);

    public List<Utilisateur_Hardis> rechercherUtilisateurHardisOffre(long id);
    
    public List<Utilisateur_Hardis> ListeConsultantDuneOffre(long idOffre);
    
}
