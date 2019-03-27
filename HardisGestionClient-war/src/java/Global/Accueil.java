package Global;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entite.Client;

import entite.Service;
import entite.Entreprise;

import entite.Historique_QuestionPublique;
import entite.Offre;



import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.gestionVisiteurLocal;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import java.util.List;

import javax.servlet.http.HttpSession;
import session.gestionAdminLocal;


/**
 *
 * @author thoma
 */
@WebServlet(urlPatterns = {"/Accueil"})
public class Accueil extends HttpServlet {

    @EJB
    private gestionAdminLocal gestionAdmin;


    @EJB
    private gestionVisiteurLocal gestionVisiteur;


   

    String jspClient = "/Menu_principal.jsp";
    String act = null;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sess = request.getSession(true);
        String message = "";
        String act = request.getParameter("action");
        String jspClient="";

        if ((act == null) || (act.equals("vide"))) {
            jspClient = "/Menu_principal.jsp";
            request.setAttribute("message", "pas d'information");

        } 
        else if(act.equals("Catalogue")){
            List<Service> listeServ = gestionAdmin.affichageServices();
            request.setAttribute("listeServ", listeServ);
            jspClient = "/Catalogue_service.jsp";
		}           
        else if(act.equals("VoirLeForum")){
                    List<Historique_QuestionPublique> ListeQP = gestionVisiteur.ListeQuestionPubliqueRep();
                    List<Offre> ListeOffre = gestionAdmin.affichageOffres();
                    request.setAttribute("ListeDesOffre",ListeOffre );
                    request.setAttribute("ListeQPR", ListeQP);
                    jspClient="/ForumQuestion.jsp";
                }
             
             else if (act.equals("ForumChoixOffre")){
                    String o =request.getParameter("Offre");
                    Long Offre = Long.valueOf(o);
                    Offre OF = (Offre) gestionAdmin.rechercherOffreParId(Offre).get(0);
                    List<Historique_QuestionPublique> ListeQP = gestionVisiteur.ListeQPOffre(OF);
                    List<Offre> ListeOffre = gestionAdmin.affichageOffres();
                    request.setAttribute("ListeDesOffre",ListeOffre );
                    request.setAttribute("ListeQPR", ListeQP);
                    jspClient="/ForumQuestion.jsp";
                  
             }
             
             else if (act.equals("ForumChoixPseudo")){
                    String p =request.getParameter("pseudo");                    
                    
                    List<Historique_QuestionPublique> ListeQP = gestionAdmin.ListeQPPseudo(p);
                    List<Offre> ListeOffre = gestionAdmin.affichageOffres();
                    request.setAttribute("ListeDesOffre",ListeOffre );
                    request.setAttribute("ListeQPR", ListeQP);
                    jspClient="/ForumQuestion.jsp";
                  
             }
        

        else if ((act.equals("authentif"))) {
            String login = request.getParameter("mail");
            String pass = request.getParameter("mdp");
            Utilisateur utilisateur = gestionVisiteur.authentification(login, pass);
            

            //fail de message d'erreur en cas de champs vides ==> à coriger
            if (utilisateur.toString().equalsIgnoreCase("")) {
                request.setAttribute("problème de connexion, merci de réessayer", message);
            }

            // on verifie le type de l'utilisateur pour le rediriger la page qui lui correspond
            if (utilisateur instanceof entite.Client) {
                Client cli = (Client)utilisateur;
                sess.setAttribute("UserARecup", cli);
                jspClient = "/Temporaire.jsp";

            } else if (utilisateur instanceof Utilisateur_Hardis) {
                Utilisateur_Hardis utilisateur_H = (Utilisateur_Hardis) utilisateur;
                if (utilisateur_H.getProfil_Technique().toString().equals("administrateur")) {
                    sess.setAttribute("UserARecup",utilisateur);
                    jspClient = "/Temporaire.jsp";
                } else if (utilisateur_H.getProfil_Technique().toString().equals("gestionnaire")) {
                    sess.setAttribute("UserARecup",utilisateur_H);
                    jspClient = "/Temporaire.jsp";
                } else if (utilisateur_H.getProfil_Technique().toString().equals("visualisation")) {
                    sess.setAttribute("UserARecup",utilisateur_H);
                    jspClient = "/Temporaire.jsp";
                    
                }
               
                
                request.setAttribute("connexion OK !", message);
            } else {
                jspClient = "Connexion.jsp";
                request.setAttribute("oupsi", message);
            }
            
        }
        else if(act.equals("demandeClient"))
        {
            List<Entreprise> list = gestionVisiteur.listEntreprise();
            request.setAttribute("listeEntreprise", list);
            jspClient="/CreationClient.jsp";
        }
        
        else if(act.equals("CreerUtilisateur"))
        {
          
            String nom= request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String motdepasse = request.getParameter("motdepasse");
        String idEntreprise = request.getParameter("idEntreprise");
        Client user = gestionVisiteur.rechercheClientMail(mail);
        if (nom.trim().trim().isEmpty()||prenom.trim().isEmpty()||mail.trim().isEmpty()||motdepasse.trim().isEmpty()||idEntreprise.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer un utilisateur";
        }
        
        else if (user != null){
            message = "Erreur, un compte utilisateur existe déjà pour ce mail";
            
        }
        else {
            Long idEntrepriseLong = Long.valueOf(idEntreprise);
            Entreprise entreprise = gestionVisiteur.rechercheEntreprise(idEntrepriseLong);
            gestionVisiteur.creerClient(nom, prenom, motdepasse,mail, entreprise);
            message = "Client crée avec succès !";          
        }
        request.setAttribute("message", message);
        jspClient="/Menu_principal.jsp";
        }

        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");

    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
 }



