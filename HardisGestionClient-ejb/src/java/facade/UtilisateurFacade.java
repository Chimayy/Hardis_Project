/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Utilisateur;
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
public class UtilisateurFacade extends AbstractFacade<Utilisateur> implements UtilisateurFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UtilisateurFacade() {
        super(Utilisateur.class);
    }

    @Override
    public List<Utilisateur> listeUtilisateur() {
        String txt = "SELECT u FROM Utilisateur AS u";
        Query req = getEntityManager().createQuery(txt);
        List<Utilisateur> liste = req.getResultList();
        return liste;
    }

    @Override
    public Utilisateur rechercheUtilisateur(long id) {
        Utilisateur result;
        String txt = "SELECT u FROM Utilisateur AS u WHERE u.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Utilisateur)req.getSingleResult();
        return result;
    }
    
     @Override
    public Utilisateur rechercheUtilisateurNom(String nom) {
        Utilisateur result;
        String txt = "SELECT u FROM Utilisateur AS u WHERE u.nom_Utilisateur=:nom";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("nom", nom);
        result=(Utilisateur)req.getSingleResult();
        return result;
    }

    @Override
    public Utilisateur authentification(String log, String mdp) {
         Utilisateur user;
        String txt = "SELECT a FROM Utilisateur AS a WHERE a.mail_Connexion=:lo AND a.mot_De_Passe=:motp";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("lo", log);
        req=req.setParameter("motp", mdp);
        user=(Utilisateur)req.getSingleResult();
        return user;
    }

    @Override
    public List GetUtilisateurParOffre(long idOffre) {
        List <Utilisateur> ListeUtilisateurParOffre;
        String txt ="SELECT u FROM Utilisateur AS u JOIN u.profil_metier profil_metier  JOIN profil_metier.lOffre Offre WHERE offre.id=:idOffre";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("idOffre",idOffre);
        ListeUtilisateurParOffre= req.getResultList();
        return ListeUtilisateurParOffre;
    }
    
   

   


}
