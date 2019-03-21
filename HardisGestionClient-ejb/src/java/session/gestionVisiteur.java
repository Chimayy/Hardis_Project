/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;
import entite.Service;
import entite.Utilisateur;
import facade.UtilisateurFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import facade.ServiceFacadeLocal;

/**
 *
 * @author thoma
 */
@Stateless
public class gestionVisiteur implements gestionVisiteurLocal {

    @EJB
    private ServiceFacadeLocal serviceFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;
    // Add business logic below. (Right-click in editor and choose


    @Override
    public List<Service> AffichageService() {
        List<Service> liste = serviceFacade.listeService(); 
        return liste;
    }      
    @Override
    public Utilisateur authentification(String log, String mdp) {
       Utilisateur user = null;
        if( !log.equals("")&&!mdp.equals(""))
       {
          user = utilisateurFacade.authentification(log, mdp);
       }
        return user;
    }

   
}
