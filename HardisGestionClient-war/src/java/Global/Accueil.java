package Global;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import entite.Client;
import entite.Service;
import java.io.IOException;
import java.io.PrintWriter;
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
/**
 *
 * @author thoma
 */
@WebServlet(urlPatterns = {"/Accueil"})
public class Accueil extends HttpServlet {

    @EJB
    private gestionVisiteurLocal gestionVisiteur;

       
 
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
                jspClient="/Menu_principal.jsp";
                request.setAttribute("message","pas d'information");
            }
            else if ((act.equals("authentification")))
            {
                //doActionAuthentifier(request,response);
                request.setAttribute("message","pas d'information");
            }
            else if (act.equals("Catalogue"))
            {
             jspClient="/Catalogue_service.jsp";
             List<Service> liste = gestionVisiteur.AffichageService();
             request.setAttribute("listeService",liste);
             
            }
            
            
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");       
       
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Global</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>boulou boulouloulou " + request.getContextPath() + "</h1>");

            out.println("<p> git c chiant</p>");
            out.println("<h1>Servlet Global at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet Global at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet Global at " + request.getContextPath() + "</h1>");
            out.println("<h1>C'est le TEST</h1>");
            out.println("<h1>C'est la branche du Totsi</h1>");

            out.println("<font color='red'>coucocu c alleau</font>");

            out.println("</body>");
            out.println("</html>");
            
            
        }
        
    }
    
    
    
    //Authentification de l'utilisateur
   /* protected void doActionAuthentifier(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");        
        Utilisateur utilisateur;
        String message;
        message="";
         String jspClient=null;
        //fail de message d'erreur en cas de champs vides ==> à coriger
        if(login.trim().isEmpty()|| pass.trim().isEmpty())
        {
            message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.";
        }
<<<<<<< HEAD
     
        
        if (!utilisateur.equals(null))
        {
        
     //on verifie le type de l'utilisateur pour le rediriger la page qui lui correspond
        if (utilisateur instanceof entite.Client)
            {
                Client utilisateur_C = (Client)utilisateur;
                request.setAttribute("idClient", utilisateur_C.getId());
                jspClient = "MenuClient";
            }
        else if (utilisateur instanceof Utilisateur_Hardis){
            Utilisateur_Hardis utilisateur_H = (Utilisateur_Hardis)utilisateur;
            if(utilisateur_H.getProfil_Technique().toString().equals("admin"))
            {
                jspClient="ServletAdmin.java";
            }
            else if (utilisateur_H.getProfil_Technique().toString().equals("gestionnaire"))
            {
                jspClient="ServletGestionnaire.java";
            }
            else
            {
                jspClient="ServletVisualisation.java";
            }
            message = "utilisateur connecté";
           }
        }
        else
            {
                message="utilisateur introuvable";
            }
        }
        
        request.setAttribute("message", message);
      //  request.setAttribute("idClient",client );
        }

        request.setAttribute("message", message);*/
   
    

//        else {
//        utilisateur = gestionVisiteur.authentification(login,pass);
//        
//    // on verifie le type de l'utilisateur pour le rediriger la page qui lui correspond
//        if (utilisateur instanceof entite.Client)
//            {
//                jspClient = "MenuClient";
//            }
//        else if (utilisateur instanceof Utilisateur_Hardis){
//            Utilisateur_Hardis utilisateur_H = (Utilisateur_Hardis)utilisateur;
//            if(utilisateur_H.getProfil_Technique().toString().equals("admin"))
//            {
//                jspClient="MenuAdmin";
//            }
//            else if (utilisateur_H.getProfil_Technique().toString().equals("gestionnaire"))
//            {
//                jspClient="MenuGestionnaire";
//            }
//            else
//            {
//                jspClient="MenuVisualisation";
//            }
//            message = "utilisateur connecté";
//           }
//        }
//        request.setAttribute("message", message);
//        }
   

    

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


