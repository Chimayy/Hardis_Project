/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardis;

import entite.Client;
import entite.Devis;
import entite.Historique_Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
        
        
      
       String jspClient=null;
       String act=request.getParameter("action");
           if((act==null)||(act.equals("vide")))
           {
               jspClient="/AcceuilGestionnaire.jsp";
               request.setAttribute("message","pas d'information");
           }
           else if (act.equals("ReponseQuestions")) {
               
               List<Devis> ListeDevis = gestionHardis.listeDevis();
               request.setAttribute("Devis", ListeDevis);
               
               jspClient="/QuestionGestionnaire/ReponseQuestions.jsp";
               
            }
           
           else if (act.equals("AffectationDevis")){
               jspClient="/AffectationDevis.jsp";
           }
           
           else if (act.equals("GestionDevis")){
               jspClient="/GestionDevis.jsp";
           }
           
           else if(act.equals("VisuClients")){
               List<Client> ListeCli = gestionClient.ListeClient();
              jspClient="/ListeClient/VisuClients.jsp";
              request.setAttribute("ListeClient", ListeCli);
                
           }
           else if (act.equals("DetailClient")){             
                String x = request.getParameter("x");           
                long x1 = Long.valueOf(x);
                Client c = gestionClient.RechercheClient(x1);        
                request.setAttribute("Client", c);
                
                jspClient="/ListeClient/DetailClient.jsp";              
               
           }
           else if (act.equals("DetailQuestions")){
                String x = request.getParameter("x");
                long x1 = Long.valueOf(x);
                Devis d = gestionClient.rechercheDevis(x1);
                List <Historique_Question> Questions =gestionHardis.ListeQuestion(d);
                Client c = d.getLeClient();
                request.setAttribute("ListeQuestions", Questions);
                request.setAttribute("Client", c);
                jspClient="/QuestionGestionnaire/QuestionsparDevis.jsp";
           }
           
           else if (act.equals("RepondreQuestion")){
               String x= request.getParameter("x");
               long x1= Long.valueOf(x);
               Historique_Question q = gestionHardis.RechercheQuestion(x1);
               request.setAttribute("Question", q);
               String ok ="0";
               request.setAttribute("ok", ok);
               jspClient="/QuestionGestionnaire/RepondreQuestion.jsp";
           }
           
         else if(act.equals("EnregistrerReponse")){
               String r = request.getParameter("reponse");
               
               String x= request.getParameter("x");               
               long x1= Long.valueOf(x);
               Historique_Question q = gestionHardis.RechercheQuestion(x1);
               gestionHardis.setReponse(x1, r);
                String ok ="1";
               request.setAttribute("ok", ok);
               request.setAttribute("Question", q);
               jspClient="/QuestionGestionnaire/RepondreQuestion.jsp";
         }
           
         else if (act.equals("DetailDevis")){
             String x = request.getParameter("x");
             long x1= Long.valueOf(x);
             Devis d = gestionClient.rechercheDevis(x1);
             request.setAttribute("Devis", d );
             jspClient="/ListeClient/DetailDevis.jsp";               
         }
           
         else if(act.equals("EnvoyerDevis")){
             String id= request.getParameter("x");
             long idDevis= Long.valueOf(id);             
             String montant = request.getParameter("Montant");
             int m= Integer.valueOf(montant);
             gestionClient.ModifDevisA_traiter(idDevis, m);
             Devis d = gestionClient.rechercheDevis(idDevis);
             Client c = d.getLeClient();
             request.setAttribute("Client", c);
             jspClient="/ListeClient/DetailClient.jsp";
             
         }
           
         else if(act.equals("ValiderDevis")){
             String id = request.getParameter("x");
             long idDevis = Long.valueOf(id);
             String montant = request.getParameter("Montant");
             int m= Integer.valueOf(montant);
             String da = request.getParameter("DateModif");
             Date date= Date.valueOf(da);
             gestionClient.ModifDevisEn_negociation(idDevis, m, date);
             Devis d = gestionClient.rechercheDevis(idDevis);
             Client c = d.getLeClient();
             request.setAttribute("Client", c);
             jspClient="/ListeClient/DetailClient.jsp";
             
             
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