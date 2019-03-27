/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardis;

import entite.Client;
import entite.Devis;
import entite.Historique_Consultant;
import entite.Historique_Question;
import entite.Historique_QuestionPublique;
import entite.Profil_Metier;
import entite.Utilisateur;

import entite.Utilisateur_Hardis;
import entite.profil_Technique;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.gestionClientLocal;
import session.gestionHardisLocal;

/**
 *
 * @author Mathieu Harmand
 */
@WebServlet(name = "AcceuilGestionnaire", urlPatterns = {"/AcceuilGestionnaire"})
public class AcceuilGestionnaire extends HttpServlet {

    @EJB
    private gestionHardisLocal gestionHardis;

    @EJB
    private gestionClientLocal gestionClient;

    private EntityManager em;

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
        String jspClient = null;
        String act = request.getParameter("action");

        // récupération de l'utilisateur qui s'est loggué
        Utilisateur_Hardis user = (Utilisateur_Hardis) sess.getAttribute("UserARecup");

        if ((act == null) || (act.equals(""))) {
            sess.setAttribute("User", user);
            jspClient = "/AcceuilGestionnaire.jsp";
            request.setAttribute("message", "pas d'information");
        } else if (act.equals("ReponseQuestions")) {

            List<Devis> ListeDevis = gestionHardis.listeDevis();
            request.setAttribute("Devis", ListeDevis);

            jspClient = "/QuestionGestionnaire/ReponseQuestions.jsp";

        } else if (act.equals("AffectationDevis")) {
            Utilisateur user1 = (Utilisateur) user;
            List<Profil_Metier> ProfilUser = gestionHardis.ListeMetier(user1);
            List<Profil_Metier> ToutLesMetiers = gestionHardis.ListeToutLesMetier();
            List<Devis> DevisNonAttribue = gestionClient.ListeDevisNonAttribue();
            request.setAttribute("ListeProfil", ToutLesMetiers);
            request.setAttribute("ListeDevisNonAttribue", DevisNonAttribue);
            request.setAttribute("profil", ProfilUser);
            sess.setAttribute("User", user);

            jspClient = "/AffectationDevis/AffectationDevis.jsp";
        } else if (act.equals("GestionDevis")) {
            jspClient = "/GestionDevis.jsp";
        } else if (act.equals("VisuClients")) {
            Utilisateur_Hardis u = user;
            List<Historique_Consultant> HistoGest = gestionHardis.ListeHistGest(u);
            List<Client> LC= new ArrayList();
            for(Historique_Consultant d : HistoGest){
                if (!LC.contains(d.getLeDevis().getLeClient())){
                    LC.add(d.getLeDevis().getLeClient());
                }
            }
                    
//               List<Client> ListeCli = gestionClient.ListeClient();
            jspClient = "/ListeClient/VisuClients.jsp";
            request.setAttribute("ListeClient", LC);

        } else if (act.equals("DetailClient")) {
            String x = request.getParameter("x");
            long x1 = Long.valueOf(x);
            Client c = gestionClient.RechercheClient(x1);
            request.setAttribute("Client", c);
            sess.setAttribute("User", user);

            jspClient = "/ListeClient/DetailClient.jsp";

        } else if (act.equals("DetailQuestions")) {
            String x = request.getParameter("x");
            long x1 = Long.valueOf(x);
            Devis d = gestionClient.rechercheDevis(x1);
            List<Historique_Question> Questions = gestionHardis.ListeQuestion(d);
            Client c = d.getLeClient();
            request.setAttribute("ListeQuestions", Questions);
            request.setAttribute("Client", c);
            jspClient = "/QuestionGestionnaire/QuestionsparDevis.jsp";
            
        } else if (act.equals("RepondreQuestion")) {
            String x = request.getParameter("x");
            long x1 = Long.valueOf(x);
            Historique_Question q = gestionHardis.RechercheQuestion(x1);
            request.setAttribute("Question", q);
            String ok = "0";
            request.setAttribute("ok", ok);
            jspClient = "/QuestionGestionnaire/RepondreQuestion.jsp";
            
        } else if (act.equals("EnregistrerReponse")) {
            String r = request.getParameter("reponse");

            String x = request.getParameter("x");
            long x1 = Long.valueOf(x);
            Historique_Question q = gestionHardis.RechercheQuestion(x1);
            gestionHardis.setReponse(x1, r);
            String ok = "1";
            request.setAttribute("ok", ok);
            request.setAttribute("Question", q);
            jspClient = "/QuestionGestionnaire/RepondreQuestion.jsp";
        } else if (act.equals("DetailDevis")) {
            String x = request.getParameter("x");
            long x1 = Long.valueOf(x);
            Devis d = gestionClient.rechercheDevis(x1);
            request.setAttribute("Devis", d);
            jspClient = "/ListeClient/DetailDevis.jsp";
        } else if (act.equals("EnvoyerDevis")) {
            String id = request.getParameter("x");
            long idDevis = Long.valueOf(id);
            String montant = request.getParameter("Montant");
            int m = Integer.valueOf(montant);
            gestionClient.ModifDevisA_traiter(idDevis, m);
            Devis d = gestionClient.rechercheDevis(idDevis);
            Client c = d.getLeClient();
            request.setAttribute("Client", c);
            jspClient = "/ListeClient/DetailClient.jsp";

        } else if (act.equals("ValiderDevis")) {
            String id = request.getParameter("x");
            long idDevis = Long.valueOf(id);
            String montant = request.getParameter("Montantfixe");
            int m = Integer.valueOf(montant);
            String da = request.getParameter("DateModif");
            Date date;
            if (da != "") {
                date = Date.valueOf(da);

                gestionClient.ModifDevisANegocier(idDevis, m, date);
            } else {
                Devis dde = gestionClient.rechercheDevis(idDevis);
                gestionClient.ModifDevisEn_negociation(idDevis, m, dde.getDate_Intervention());

            }
            Devis d = gestionClient.rechercheDevis(idDevis);
            Client c = d.getLeClient();
            request.setAttribute("Client", c);
            jspClient = "/ListeClient/DetailClient.jsp";

        } else if (act.equals("RetourAdmin")) {
            jspClient = "/MenuAdmin.jsp";
        } else if (act.equals("QuestionsForum")) {

            List<Historique_QuestionPublique> ListeQuestionGest = gestionHardis.ListeQuestionGest(user);
            request.setAttribute("ListQG", ListeQuestionGest);

//              des question qui lui sont affectées
            sess.setAttribute("User", user);
            jspClient = "/QuestionsForum/QuestionsForum.jsp";

        } else if (act.equals("DevisAffecte")) {
            String NomGest = request.getParameter("NomAaffecter");
            List<Utilisateur_Hardis> ListGest = gestionHardis.rechercherUtilisateurHardisNom(NomGest);
            Utilisateur_Hardis gest = ListGest.get(0);
            String d1 = request.getParameter("devis");
            Long d = Long.valueOf(d1);
            Devis devis = gestionClient.rechercheDevis(d);
            String fct = "gestionnaire Devis";
            request.getAttribute("NomAaffecter");
            gestionHardis.CreerHistoriqueConsultant(gest, devis, fct);
            gestionClient.AffecterDevis(devis);
            jspClient = "/AcceuilGestionnaire.jsp";
        } else if (act.equals("creerPeriode")) {
            jspClient = "/Periode/creerPeriode.jsp";
        } else if (act.equals("creationDispo")) {
            String dateDebutString = request.getParameter("dateDebut");
            String dateFinString = request.getParameter("dateFin");
            Date dateDebut = Date.valueOf(dateDebutString);
            Date dateFin = Date.valueOf(dateFinString);
            gestionHardis.creerDateDispo(user, dateDebut, dateFin);
            jspClient = "/AcceuilGestionnaire.jsp";

        } else if (act.equals("EnregistrerReponsePublique")) {
            String id = request.getParameter("x");
            Long id1 = Long.valueOf(id);
            String rep = request.getParameter("reponsep");
            Historique_QuestionPublique h = (Historique_QuestionPublique) gestionHardis.RechercheQP(id1).get(0);
            gestionHardis.RepQP(h, rep);
            jspClient = "/AcceuilGestionnaire.jsp";
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

    protected Client doChercherClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String x = request.getParameter("x");

        long x1 = Long.valueOf(x);

        return gestionClient.RechercheClient(x1);

    }

}
