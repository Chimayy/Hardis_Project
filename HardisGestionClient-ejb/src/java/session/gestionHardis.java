/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Utilisateur_Hardis;
import facade.AgenceFacadeLocal;
import facade.Bon_De_CommandeFacadeLocal;
import facade.CVFacadeLocal;
import facade.Condition_ContractuelleFacadeLocal;
import facade.DevisFacadeLocal;
import facade.Historique_EchangeFacadeLocal;
import facade.InterlocuteurFacadeLocal;
import facade.LivrableFacadeLocal;
import facade.OffreFacadeLocal;
import facade.Periode_DisponibleFacadeLocal;
import facade.PrestationFacadeLocal;
import facade.Profil_MetierFacadeLocal;
import facade.ServiceFacadeLocal;
import facade.UtilisateurFacadeLocal;
import facade.Utilisateur_HardisFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import entite.Utilisateur;

/**
 *
 * @author thoma
 */
@Stateless
public class gestionHardis implements gestionHardisLocal {

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade1;

    @EJB
    private Historique_EchangeFacadeLocal historique_EchangeFacade;

    @EJB
    private InterlocuteurFacadeLocal interlocuteurFacade;

    @EJB
    private LivrableFacadeLocal livrableFacade;

    @EJB
    private OffreFacadeLocal offreFacade;

    @EJB
    private Periode_DisponibleFacadeLocal periode_DisponibleFacade1;

    @EJB
    private PrestationFacadeLocal prestationFacade;

    @EJB
    private Profil_MetierFacadeLocal profil_MetierFacade;

    @EJB
    private Periode_DisponibleFacadeLocal periode_DisponibleFacade;

    @EJB
    private ServiceFacadeLocal serviceFacade;

    @EJB
    private Utilisateur_HardisFacadeLocal utilisateur_HardisFacade;

    @EJB
    private UtilisateurFacadeLocal utilisateurFacade;

    @EJB
    private DevisFacadeLocal devisFacade;

    @EJB
    private Condition_ContractuelleFacadeLocal condition_ContractuelleFacade;

    @EJB
    private CVFacadeLocal cVFacade;

    @EJB
    private Bon_De_CommandeFacadeLocal bon_De_CommandeFacade;

    @EJB
    private AgenceFacadeLocal agenceFacade;

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
    
    
}
