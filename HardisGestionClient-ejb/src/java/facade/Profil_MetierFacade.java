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
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thoma
 */
@Stateless
public class Profil_MetierFacade extends AbstractFacade<Profil_Metier> implements Profil_MetierFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Profil_MetierFacade() {
        super(Profil_Metier.class);
    }

    @Override
    public List<Profil_Metier> listeProfilMetier() {
        String txt = "SELECT pm FROM Profil_Metier AS pm";
        Query req = getEntityManager().createQuery(txt);
        List<Profil_Metier> liste = req.getResultList();
        return liste;

    }

    @Override
    public Profil_Metier rechercheProfilMetier(long idUser, long idOffre) {
        Profil_Metier result;
        String txt = "SELECT pm FROM Profil_Metier pm  WHERE pm.lUtilisateur=:idUser AND pm.lOffre=:idOffre";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("idUser", idUser);
        req=req.setParameter("idOffre", idOffre);
        result=(Profil_Metier)req.getSingleResult();
        return result;
    }

    @Override
    public void creerProfilMetier(int niveau_habilitation, Offre offre, Utilisateur_Hardis user) {
        Profil_Metier profilACreer = new Profil_Metier();
        profilACreer.setNiveau_Habilitation(niveau_habilitation);
        profilACreer.setlOffre(offre);
        profilACreer.setlUtilisateur(user);
        em.persist(profilACreer);
    }
    


    @Override
    public List<Profil_Metier> ListeMetier(Utilisateur User) {
         List<Profil_Metier> ListeMetier;
        String txt ="SELECT pm FROM Profil_Metier pm WHERE pm.lUtilisateur=:User";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("User", User);
        ListeMetier=req.getResultList();
        return ListeMetier;
       
    }
    
    
}
