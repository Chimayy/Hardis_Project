
package Client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entite.Client;
import entite.Devis;
import entite.Entreprise;
import entite.Historique_QuestionPublique;
import entite.Offre;
import entite.Periode_Disponible;
import entite.Profil_Metier;
import entite.Utilisateur_Hardis;
import facade.Historique_QuestionPubliqueFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.gestionAdminLocal;
import session.gestionClientLocal;
import session.gestionHardisLocal;
import session.gestionVisiteurLocal;

/**
 *
 * @author thoma
 */
@WebServlet(name = "ServletClient", urlPatterns = {"/ServletClient"})
public class ServletClient extends HttpServlet {

    @EJB
    private gestionAdminLocal gestionAdmin;

    @EJB
    private gestionVisiteurLocal gestionVisiteur;

    @EJB
    private gestionHardisLocal gestionHardis;

   

    @EJB
    private gestionClientLocal gestionClient;

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
            HttpSession sess= request.getSession(true);
            String jspClient="";
            String message="";
            String act=request.getParameter("action");
        
                     
      

//récupération de l'id Client envoyé par la servlet d'authentification         
           Client user = (Client)sess.getAttribute("UserARecup");
               
            if((act==null)||(act.equals("vide")))
            {
                sess.setAttribute("user", user);
                jspClient="/MenuClient.jsp";
            }
            else if(act.equals("demandeDevis"))
            {
             
                String zoneLibre = request.getParameter("zoneLibre");
              String idServiceString = request.getParameter("idService");
                Long idServiceLong = Long.valueOf(idServiceString);              
               Devis demandeDevisClient = gestionClient.demandeDevis(zoneLibre, user, idServiceLong);
               // recuperation de l'id du devis qui vient d'être enregistré pour l'affecter au referent local
               gestionClient.affecterDevisReferentLocal(demandeDevisClient.getId());
                jspClient="/MenuClient.jsp";
                request.setAttribute("message", "devis bien envoyé au référent local");
            }
            
            else if (act.equals("visuDevis"))
            {
                jspClient="/listDevisClient.jsp";
                List<Devis> list = gestionClient.devisAtraiter(user.getId());
                request.setAttribute("listeDevis", list);
                request.setAttribute("message","yo");
                request.setAttribute("clientTest", user);
            }
            else if(act.equals("modifDevis"))
            {
                jspClient="/visuUnDevis.jsp";
                String idDevis = request.getParameter("idDevis");
                Long idDevisLong = Long.parseLong(idDevis);
                Devis devis = gestionClient.rechercheDevis(idDevisLong);
                request.setAttribute("devis", devis);
                request.setAttribute("message", "et mais yo ça marche pas");
            }
            else if(act.equals("Valider"))
            {
                jspClient="/MenuClient.jsp";
                String idDevisString = request.getParameter("devis");
                Long idDevisLong = Long.valueOf(idDevisString);
                gestionClient.accepterDevisClient(idDevisLong);
                request.setAttribute("message", "cimer pour l'acceptation, mtn propose une date");
            }
            else if(act.equals("Modifier"))
            {
                jspClient="/MenuClient.jsp";
                String remarques = request.getParameter("zoneLibre");
                String idDevisString = request.getParameter("devis");
                Long idDevisLong = Long.valueOf(idDevisString);
                String montantString = request.getParameter("montant");
                Double montantDouble = Double.valueOf(montantString);
                Devis devisAModifier = gestionClient.rechercheDevis(idDevisLong);
                String motifRefus = request.getParameter("refus");
                gestionClient.modifierDevis(remarques,montantDouble, devisAModifier, motifRefus );
                request.setAttribute("message", "ceban modification du devis transmise au gestionnaire");
            }
            else if(act.equals("Refuser"))
            {
                jspClient="/MenuClient.jsp";
                String motifRefus = request.getParameter("refus");
                String idDevisString = request.getParameter("devis");
                Long idDevisLong = Long.valueOf(idDevisString);
                gestionClient.refuserDevis(idDevisLong, motifRefus);
                request.setAttribute("message", "ceban refus c'est OK");
            }
            else if(act.equals("consultantsEtDate"))
            {
                jspClient="/Devis_Envoye/listDevisEnvoye.jsp";
                List<Devis> devisEnvoye = gestionClient.listDevisAccepte(user);
                request.setAttribute("listDevis", devisEnvoye);
            }
            
             
             
            else if(act.equals("choixDateDevis"))
            {
                jspClient="/Devis_Envoye/choixConsultant.jsp";
                String idDevisRecu = request.getParameter("idDevis");
                Long idDevis= Long.valueOf(idDevisRecu);
                Devis d = gestionClient.rechercheDevis(idDevis);
                request.setAttribute("devis", d);
                List<Profil_Metier> list = gestionClient.listPMOffre(d.getlOffre());
                request.setAttribute("listPM", list);
            }
            else if(act.equals("propositionconsultant"))
            {
                jspClient="/MenuClient.jsp";
                String[] checkbox = request.getParameterValues("checkbox");
                List<Utilisateur_Hardis> propositionClient = new ArrayList();
                String[] ArrayidConsultants = request.getParameterValues("consultant");
                for(int i =0; i<checkbox.length;i++)
                {
                    String checkboxEnCours = checkbox[i];
                    if(checkboxEnCours != null)
                    {
                        String idConsultantSelectionneString = ArrayidConsultants[i];
                        long idConsultantSelectionneLong = Long.valueOf(idConsultantSelectionneString);
                        Utilisateur_Hardis consultantSelectionne = gestionClient.rechercherUtilisateurHardisId(idConsultantSelectionneLong);
                        propositionClient.add(consultantSelectionne);
                    }
                }
                String idDevisString = request.getParameter("devis");
                Long idDevisLong = Long.valueOf(idDevisString);
                String dateString = request.getParameter("dateIntervention");
                Date dateIntervention = Date.valueOf(dateString);
                boolean testPasOK = false;
                for(int j=0;j<propositionClient.size();j++)
                {
                    Utilisateur_Hardis consultantEnCours = propositionClient.get(j);
                    List<Periode_Disponible> periodeOccupe =consultantEnCours.getPeriode_Disponibles();                    
                    if(dateIntervention.after(periodeOccupe.get(j).getDate_Debut())&&dateIntervention.before(periodeOccupe.get(j).getDate_Fin()))
                    {
                        testPasOK = true;
                        String nomConsultantOccupe = consultantEnCours.getNom_Utilisateur() +" " + consultantEnCours.getPrenom_Utilisateur();
                       request.setAttribute("message", "Le consultant " + nomConsultantOccupe + " est occupé à cette période");
                       jspClient="/MenuClient.jsp";
                       break;
                    }
                 
                }
                if(testPasOK == false)
                {
                gestionClient.propositionDateetConsultant(user, propositionClient, idDevisLong, dateIntervention);
                }
                
            }
            RequestDispatcher Rd;
            Rd = getServletContext().getRequestDispatcher(jspClient);
            Rd.forward(request, response);
            response.setContentType("text/html;charset=UTF-8");
                     

        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code.
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletClient at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>"); */
        }
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