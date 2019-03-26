/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardis;

import entite.Agence;
import entite.Client;
import entite.Consentement_RGPD;
import entite.Devis;
import entite.Entreprise;
import entite.Historique_Document;
import entite.Historique_Echange;
import entite.Interlocuteur;
import entite.Offre;
import entite.Prestation;
import entite.Service;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.gestionVisualisationLocal;

/**
 *
 * @author 3096764
 */
@WebServlet(name = "AccessVisualisation", urlPatterns = {"/AccessVisualisation"})
public class AccessVisualisation extends HttpServlet {

    @EJB
    private gestionVisualisationLocal gestionVisualisation;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String jspClient = null;
        String act = request.getParameter("action");

        /*
        String nom = request.getParameter("nom_Utilisateur");
        Client client = gestionVisualisation.rechercheNomClient(nom);
        request.setAttribute("client", client);
        request.getRequestDispatcher("RechercheClient.jsp").forward(request, response);
         */
 /*
        String nom = request.getParameter("nom_Utilisateur");
        Utilisateur utilisateur = gestionVisualisation.rechercherNomUtilisateur(nom);
        request.setAttribute("utilisateur", utilisateur);
        request.getRequestDispatcher("RechercheUtilisateur.jsp").forward(request, response);
         */
        if ((act == null) || (act.equals("vide"))) {
            jspClient = "/MenuVisualisation.jsp";
            request.setAttribute("message", "pas d'information");
            
        } else if (act.equals("AfficherClient")) {
            jspClient = "/AfficherClient.jsp";
            List<Client> list = gestionVisualisation.afficherClient2();
            request.setAttribute("listeClient", list);
            request.setAttribute("message", "Liste des clients existants");
        } 
        
        else if (act.equals("AfficherDevis")) {
            jspClient = "/AfficherDevis.jsp";
            List<Devis> list = gestionVisualisation.afficherDevis();
            request.setAttribute("listeDevis", list);
            request.setAttribute("message", "Liste des devis existants");
            
        } else if (act.equals("AfficherServices")) {
            jspClient = "/AfficherServices.jsp";
            List<Service> list = gestionVisualisation.afficherService();
            request.setAttribute("listeService", list);
            request.setAttribute("message", "Liste des services existants");
            
        } else if (act.equals("AfficherUtilisateurs")) {
            jspClient = "/AfficherUtilisateurs.jsp";
            List<Utilisateur> list = gestionVisualisation.afficherUtilisateur();
            request.setAttribute("listeEquipe", list);
            request.setAttribute("message", "Liste des utilisateurs existants");
        }  /*else if (act.equals("rechercheService")) {
            String description_Service = request.getParameter("description_Service");
            Service service = gestionVisualisation.rechercheService(description_Service);
            request.setAttribute("Description_Service", service);
            jspClient = "/AfficherLeService.jsp";
        }*/
        
        /*else if (act.equals("rechercheDevis")) {
            String date_Intervention = request.getParameter("date_Intervention");
           Date d = Date.valueOf(date_Intervention);
            Devis devis = gestionVisualisation.rechercherDevis(d);
            request.setAttribute("Date_Intervention", devis);
            jspClient = "/AfficherLeDevis.jsp";
        }
        */
        else if (act.equals("rechercheUtilisateur")) {
            String nom = request.getParameter("Nom_Utilisateur");
            Utilisateur utilisateur = gestionVisualisation.rechercherNomUtilisateur(nom);
            request.setAttribute("Nom_Utilisateur", utilisateur);
            jspClient = "/AfficherLUtilisateur.jsp";
        }
           else if (act.equals("rechercheClient")) {
            String nom = request.getParameter("Nom_Utilisateur");
            Client client = gestionVisualisation.rechercheNomClient(nom);
            request.setAttribute("Nom_Utilisateur", client);
            jspClient = "/AfficherAgence.jsp";
        }   
        /*else if (act.equals("recherchedevislcl")) {
            String date = request.getParameter("Date_Intervention");
            Devis devis = gestionVisualisation.rechercherDevis(date);
            request.setAttribute("Date_Intervention", devis);
            jspClient = "/AfficherLeDevis.jsp";
        }*/
        else if (act.equals("rechercheentrepriselcl")) {
            String nom = request.getParameter("Nom_Entreprise");
            Entreprise entreprise = gestionVisualisation.rechercheEntreprisenom(nom);
            request.setAttribute("Nom_Entreprise", entreprise);
            jspClient = "/AfficherlEntreprise.jsp";
        } 
        
        /*else if (act.equals("rechercheconsentementlcl")) {
            String date = request.getParameter("DateConsentement");
            Consentement_RGPD consentement = gestionVisualisation.rechercherconsentement(date);
            request.setAttribute("consentement", consentement);
            jspClient = "/AfficherConsentement.jsp";
        } */
        else if (act.equals("rechercheentreprisea")) {
            String nom = request.getParameter("Nom_Entreprise");
            Entreprise entreprise = gestionVisualisation.rechercheEntreprisenom(nom);
            request.setAttribute("Nom_Entreprise", entreprise);
            jspClient = "/AfficherlEntreprise.jsp";
        } 
         else if (act.equals("rechercheutilisateura")) {
            String nom = request.getParameter("Nom_Utilisateur");
            Utilisateur_Hardis utilisateur_hardis = gestionVisualisation.rechercherNomUtilisateurHardis(nom);
            request.setAttribute("Nom_Utilisateur", utilisateur_hardis);
            jspClient = "/AfficherUtilisateurhardis.jsp";
        } 
        /*else if (act.equals("recherchedeviscl")) {
            String date = request.getParameter("Date_Intervention");
            Devis devis = gestionVisualisation.rechercherDevis(date);
            request.setAttribute("Date_Intervention", devis);
            jspClient = "/AfficherLeDevis.jsp";
        } */
        else if (act.equals("rechercheentreprisecl")) {
            String nom = request.getParameter("Nom_Entreprise");
            Entreprise entreprise = gestionVisualisation.rechercheEntreprisenom(nom);
            request.setAttribute("Nom_Entreprise", entreprise);
            jspClient = "/AfficherlEntreprise.jsp";
        } 
        /*else if (act.equals("recherchedevishd")) {
            String date = request.getParameter("Date_Intervention");
            Devis devis = gestionVisualisation.rechercherDevis(date);
            request.setAttribute("Date_Intervention", devis);
            jspClient = "/AfficherLeDevis.jsp";
        }*/ 
          else if (act.equals("rechercheutilisateurc")) {
            String nom = request.getParameter("Nom_Utilisateur");
            Utilisateur utilisateur = gestionVisualisation.rechercherNomUtilisateur(nom);
            request.setAttribute("Nom_Utilisateur", utilisateur);
            jspClient = "/AfficherLeDevis.jsp";
        } 
          else if (act.equals("recherchehistoriqueechanged")) {
            String id = request.getParameter("Id");
            long idh = Long.parseLong(id);
            Historique_Echange historique_echange = gestionVisualisation.rechercherHistoriqueechange(idh);
            request.setAttribute("Id", historique_echange);
            jspClient = "/AfficherHistoriqueEchanges.jsp";
        } 
          else if (act.equals("recherchehistoriquedocumentd")) {
            String id = request.getParameter("Id");
            long idh = Long.parseLong(id);
            Historique_Document historique_document = gestionVisualisation.rechercherHistoriquedocuement(idh);
            request.setAttribute("Id", historique_document);
            jspClient = "/AfficherHistoriqueDocuments.jsp";
        } 
          else if (act.equals("rechercheclientd")) {
            String nom = request.getParameter("Nom_Utilisateur");
            Client client = gestionVisualisation.rechercheNomClient(nom);
            request.setAttribute("Id", client);
            jspClient = "/AfficherLeClient.jsp";
        }  
          else if (act.equals("rechercheOffred")) {
            String nom = request.getParameter("Nom_Offre");
            Offre offre = gestionVisualisation.rechercheOffre(nom);
            request.setAttribute("Nom_Offre", offre);
            jspClient = "/AfficherOffre.jsp";
        }  
          /*else if (act.equals("rechercheprestationd")) {
            String nom = request.getParameter("Nom_Prestation");
            Prestation prestation = gestionVisualisation.recherchePrestation(nom);
            request.setAttribute("Nom_Prestation", prestation);
            jspClient = "/AfficherPrestation.jsp";
        }
        else if (act.equals("recherchedevishd")) {
            String date = request.getParameter("Date_Intervention");
            Devis devis = gestionVisualisation.rechercherDevis(date_Intervention);
            request.setAttribute("Date_Intervention", devis);
            jspClient = "/AfficherLeDevis.jsp";
        }
        else if (act.equals("recherchedevise")) {
            String date = request.getParameter("Date_Intervention");
            Devis devis = gestionVisualisation.rechercherDevis(date_Intervention);
            request.setAttribute("Date_Intervention", devis);
            jspClient = "/AfficherLeDevis.jsp";
        }*/
        else if (act.equals("rechercheentrepriseet")) {
            String nom = request.getParameter("Nom_Entreprise");
            Entreprise entreprise = gestionVisualisation.rechercheEntreprisenom(nom);
            request.setAttribute("Nom_Entreprise", entreprise);
            jspClient = "/AfficherlEntreprise.jsp";
        }
        /*   else if (act.equals("rechercheconsentementlu")) {
            String date = request.getParameter("DateConsentement");
            Consentement_RGPD consentement = gestionVisualisation.rechercherconsentement(date);
            request.setAttribute("consentement", consentement);
            jspClient = "/AfficherConsentement.jsp";
        }*/
         else if (act.equals("recherchehistoriqueechangeld")) {
            String id = request.getParameter("Id");
            long idh = Long.parseLong(id);
            Historique_Echange historique_echange = gestionVisualisation.rechercherHistoriqueechange(idh);
            request.setAttribute("Id", historique_echange);
            jspClient = "/AfficherHistoriqueEchanges.jsp";
        } 
          else if (act.equals("recherchehistoriquedocumentld")) {
            String id = request.getParameter("Id");
            long idh = Long.parseLong(id);
            Historique_Document historique_document = gestionVisualisation.rechercherHistoriquedocuement(idh);
            request.setAttribute("Id", historique_document);
            jspClient = "/AfficherHistoriqueDocuments.jsp";
        } 
          else if (act.equals("rechercheclientld")) {
            String nom = request.getParameter("Nom_Utilisateur");
            Client client = gestionVisualisation.rechercheNomClient(nom);
            request.setAttribute("Id", client);
            jspClient = "/AfficherLeClient.jsp";
        }  
          else if (act.equals("rechercheOffreld")) {
            String nom = request.getParameter("Nom_Offre");
            Offre offre = gestionVisualisation.rechercheOffre(nom);
            request.setAttribute("Nom_Offre", offre);
            jspClient = "/AfficherOffre.jsp";
        }  
         /* else if (act.equals("rechercheprestationld")) {
            String nom = request.getParameter("Nom_Prestation");
            Prestation prestation = gestionVisualisation.recherchePrestation(nom);
            request.setAttribute("Nom_Prestation", prestation);
            jspClient = "/AfficherPrestation.jsp";
        }
         else if (act.equals("rechercheprestations")) {
            String nom = request.getParameter("Nom_Prestation");
            Prestation prestation = gestionVisualisation.recherchePrestation(nom);
            request.setAttribute("Nom_Prestation", prestation);
            jspClient = "/AfficherPrestation.jsp";
        }*/
        else if (act.equals("rechercheoffres")) {
            String nom = request.getParameter("Nom_Offre");
            Offre offre = gestionVisualisation.rechercheOffre(nom);
            request.setAttribute("Nom_Offre", offre);
            jspClient = "/AfficherOffre.jsp";
        }
        /*else if (act.equals("recherchedeviso")) {
            String date = request.getParameter("Date_Intervention");
            Devis devis = gestionVisualisation.rechercherDevis(date_Intervention);
            request.setAttribute("Date_Intervention", devis);
            jspClient = "/AfficherLeDevis.jsp";
        }
        else if (act.equals("rechercheserviceo")) {
            String date = request.getParameter("Description_Service");
            Service service = gestionVisualisation.rechercherDevis(date_Intervention);
            request.setAttribute("Description_Service", service);
            jspClient = "/AfficherLeService.jsp";
        }
         else if (act.equals("recherchedevisp")) {
            String date = request.getParameter("Date_Intervention");
            Devis devis = gestionVisualisation.rechercherDevis(date_Intervention);
            request.setAttribute("Date_Intervention", devis);
            jspClient = "/AfficherLeDevis.jsp";
        }
        else if (act.equals("rechercheservicep")) {
            String date = request.getParameter("Description_Service");
            Service service = gestionVisualisation.rechercherDevis(date_Intervention);
            request.setAttribute("Description_Service", service);
            jspClient = "/AfficherLeService.jsp";
        }
         else if (act.equals("rechercheprestations")) {
            String nom = request.getParameter("Nom_Prestation");
            Prestation prestation = gestionVisualisation.recherchePrestation(nom);
            request.setAttribute("Nom_Prestation", prestation);
            jspClient = "/AfficherPrestation.jsp";
        }*/
        else if (act.equals("rechercheoffres")) {
            String nom = request.getParameter("Nom_Offre");
            Offre offre = gestionVisualisation.rechercheOffre(nom);
            request.setAttribute("Nom_Offre", offre);
            jspClient = "/AfficherOffre.jsp";
        }
        /*else if (act.equals("rechercheconsentementu")) {
            String date = request.getParameter("DateConsentement");
            Consentement_RGPD consentement = gestionVisualisation.rechercherconsentement(date);
            request.setAttribute("consentement", consentement);
            jspClient = "/AfficherConsentement.jsp";
        }*/
           else if (act.equals("rechercheutilisateuren")) {
            String nom = request.getParameter("Nom_Utilisateur");
            Utilisateur utilisateur = gestionVisualisation.rechercherNomUtilisateur(nom);
            request.setAttribute("Nom_Utilisateur", utilisateur);
            jspClient = "/AfficherLUtilisateur.jsp";
        }
         else if (act.equals("rechercheagenceen")) {
            String nom = request.getParameter("Ville_Agence");
            Agence agence = gestionVisualisation.rechercheragence(nom);
            request.setAttribute("Ville_Agence", agence);
            jspClient = "/AfficherAgence.jsp";
        }
        /*else if (act.equals("rechercheinterlocuteuren")) {
            String nom = request.getParameter("Nom_Interlocuteur");
            Interlocuteur interlocuteur = gestionVisualisation.rechercheinterlocuteur(nom);
            request.setAttribute("Nom_Interlocuteur", interlocuteur);
            jspClient = "/AfficherInterlocuteur.jsp";
        }*/
       
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccesArbitre</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccesArbitre at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        /**
         * Processes requests for both HTTP <code>GET</code> and
         * <code>POST</code> methods.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */

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
