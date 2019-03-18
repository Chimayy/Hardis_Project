/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardis;

import entite.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.gestionClientLocal;

/**
 *
 * @author Mathieu Harmand
 */
@WebServlet(name = "AcceuilGestionnaire", urlPatterns = {"/AcceuilGestionnaire"})
public class AcceuilGestionnaire extends HttpServlet {

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
        
        
      
       String jspClient=null;
       String act=request.getParameter("action");
           if((act==null)||(act.equals("vide")))
           {
               jspClient="/AcceuilGestionnaire.jsp";
               request.setAttribute("message","pas d'information");
           }
           else if (act.equals("ReponseQuestions")) {
               jspClient="/ReponseQuestions.jsp";
               
            }
           
           else if (act.equals("AffectationDevis")){
               jspClient="/AffectationDevis.jsp";
           }
           
           else if (act.equals("GestionDevis")){
               jspClient="/GestionDevis.jsp";
           }
           
           else if(act.equals("VisuClients")){
               List<Client> ListeCli = gestionClient.ListeClient();
              jspClient="/VisuClients.jsp";
              request.setAttribute("ListeClient", ListeCli);
                
           } 
           else if (act.endsWith("0")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
               
           else if (act.endsWith("1")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
               
               else if (act.endsWith("2")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
           
           else if (act.endsWith("3")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
           
           else if (act.endsWith("4")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
           
           else if (act.endsWith("5")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
           else if (act.endsWith("6")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
           else if (act.endsWith("7")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
           else if (act.endsWith("8")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
           else if (act.endsWith("9")) {
                long id = Long.parseLong(act);
               Client c = gestionClient.RechercheClient(id);
               request.setAttribute("Client", c);
               jspClient="/DetailClient.jsp";}
               
               
           

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
        
