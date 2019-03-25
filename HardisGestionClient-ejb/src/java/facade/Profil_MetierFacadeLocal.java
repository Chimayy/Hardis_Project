/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Offre;
import entite.Profil_Metier;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Profil_MetierFacadeLocal {

    void create(Profil_Metier profil_Metier);

    void edit(Profil_Metier profil_Metier);

    void remove(Profil_Metier profil_Metier);

    Profil_Metier find(Object id);

    List<Profil_Metier> findAll();

    List<Profil_Metier> findRange(int[] range);

    int count();

    List<Profil_Metier> listeProfilMetier();

    Profil_Metier rechercheProfilMetier(long idUser, long idOffre);

    void creerProfilMetier(int niveau_habilitation, Offre offre, Utilisateur_Hardis user);

    public List<Profil_Metier> rechercheProfilMetierUser(long idUser);

    public void modifierProfilMetier(Profil_Metier profil, int niveau_habilitation);

    public List<Profil_Metier> rechercherProfilMetierId(long id);

    public void supprimerProfilMetier(Profil_Metier profil);

    List <Profil_Metier> ListeMetier(Utilisateur User);
    
}
