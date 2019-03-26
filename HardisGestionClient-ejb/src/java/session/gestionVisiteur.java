/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;
<<<<<<< HEAD
import entite.Client;
import entite.Entreprise;
import entite.Service;
import entite.Utilisateur;
import facade.ClientFacadeLocal;
import facade.EntrepriseFacadeLocal;
=======
import entite.Offre;
import entite.Service;
import entite.Utilisateur;
import facade.Historique_QuestionPubliqueFacadeLocal;
>>>>>>> exiless6
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
<<<<<<< HEAD
    private EntrepriseFacadeLocal entrepriseFacade;

    @EJB
    private ClientFacadeLocal clientFacade;
=======
    private Historique_QuestionPubliqueFacadeLocal historique_QuestionPubliqueFacade;
>>>>>>> exiless6

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

    @Override
<<<<<<< HEAD
    public void creerClient(String nom_Client, String prenom_Client, String mdp, String mail, Entreprise etp) {
        clientFacade.creerClient(nom_Client, prenom_Client, mdp, mail, etp);
    }

    @Override
    public List<Entreprise> listEntreprise() {
        return clientFacade.listeEntreprise();
    }

    @Override
    public Client rechercheClientMail(String mail) {
        return clientFacade.rechercheClientMail(mail);
    }

    @Override
    public Entreprise rechercheEntreprise(long id) {
        return entrepriseFacade.rechercherEntrepriseParId(id).get(0);
    }

    
=======
    public List ListeQuestionPubliqueRep() {
       return historique_QuestionPubliqueFacade.ListeQuestionPublicRep();
        
    }

    @Override
    public List ListeQPOffre(Offre Offre) {
        return historique_QuestionPubliqueFacade.ListeQPOfrre(Offre);
    }

>>>>>>> exiless6
   
}
