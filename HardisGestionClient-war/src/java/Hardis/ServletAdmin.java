/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardis;

import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.gestionAdminLocal;

/**
 *
 * @author Utilisateur
 */
@WebServlet(name = "ServletAdmin", urlPatterns = {"/ServletAdmin"})
public class ServletAdmin extends HttpServlet {

    @EJB
    private gestionAdminLocal gestionAdmin;
    
    protected void creerUtilisateurHardis(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String nom= request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String motdepasse = request.getParameter("motdepasse");
        String plafond = request.getParameter("plafond");
        String profil_t = request.getParameter("profil");
        String statut = request.getParameter("statut");
        Utilisateur_Hardis user = gestionAdmin.rechercheUtilisateurHardisMail(mail);
      
        String message;
        if (nom.trim().trim().isEmpty()||prenom.trim().isEmpty()||mail.trim().isEmpty()||motdepasse.trim().isEmpty()||plafond.trim().isEmpty()
                ||profil_t.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour creer un Entraineur";
        }
        
        else if (user != null){
            message = "Erreur, un compte utilisateur existe déjà pour ce mail";
            
        }
        else {
            double pla = Double.parseDouble(plafond);
            profil_Technique profil = profil_Technique.valueOf(profil_t);
            boolean stat = Boolean.parseBoolean(statut);
            gestionAdmin.creationUtilisateurHardis(mail, motdepasse, nom, prenom, pla, profil, stat);
            message = "Utilisateur crée avec succès !";          
        }
        request.setAttribute("message", message);
    }
    
    protected void modifierUtilisateurHardis(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String idUser = request.getParameter("idUser");
        String nom= request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String mail = request.getParameter("mail");
        String motdepasse = request.getParameter("motdepasse");
        String plafond = request.getParameter("plafond");
        String profil_t = request.getParameter("profil");
        String statut = request.getParameter("statut");
        String message ;
       if (idUser.trim().isEmpty()||nom.trim().trim().isEmpty()||prenom.trim().isEmpty()||mail.trim().isEmpty()||motdepasse.trim().isEmpty()||plafond.isEmpty()
                ||profil_t.isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour modifier l'utilisateur";
        }
        else {
            int id= Integer.valueOf(idUser);
            double pla = Double.parseDouble(plafond);
            profil_Technique profil = profil_Technique.valueOf(profil_t);
            boolean stat = Boolean.parseBoolean(statut);
            gestionAdmin.modificationUtilisateurHardis(id ,mail, motdepasse, nom, prenom, pla, profil, stat);
            message = "Utilisateur modifié avec succès !";          
        }
        request.setAttribute("message", message);   
    }    
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
        response.setContentType("text/html;charset=UTF-8");
        
        String message="";
        String jspClient = null;
               
        String act = request.getParameter("action");
        System.out.println("Action : "+ act);
   
        if(act.equals("AfficherUtilisateursHardis")) 
        {
            List <Utilisateur_Hardis> listeUser  = gestionAdmin.affichageUtilisateursHardis();
            request.setAttribute("listeUser", listeUser);
            jspClient="/GestionUtilisateurHardis.jsp";
        }
        
        else if(act.equals("AfficherEntreprises")){
            
        }
        
        else if(act.equals("RechercherUtilisateurHardis"))
        {        
           String nom = request.getParameter("nom");
            if(!nom.trim().isEmpty()){
            List <Utilisateur_Hardis> listeUser  = gestionAdmin.rechercherUtilisateurHardisNom(nom);
                if(listeUser.size()>0){
            request.setAttribute("listeUser", listeUser);
            jspClient="/GestionUtilisateurHardis.jsp";
                }
                else{
                List <Utilisateur_Hardis> listeUser2  = gestionAdmin.affichageUtilisateursHardis();
                request.setAttribute("listeUser", listeUser2);
                jspClient="/GestionUtilisateurHardis.jsp";
                }                    
            }
            else{
            List <Utilisateur_Hardis> listeUser2  = gestionAdmin.affichageUtilisateursHardis();
            request.setAttribute("listeUser", listeUser2);
            jspClient="/GestionUtilisateurHardis.jsp";
            message = "Veuillez rentrer une valeur";
            request.setAttribute("message", message);  
            }
             }
        
        else if(act.equals("RechercherUtilisateurHardisModif"))
        {   
            String idUser = request.getParameter("idUser");
            long id = Long.parseLong(idUser);
            List<Utilisateur_Hardis> ListeUser = gestionAdmin.recherchercherUtilisateurHardisId(id);
            request.setAttribute("listeUser",ListeUser);
            jspClient="/ModificationUtilisateurHardis.jsp";
        }
        
        else if(act.equals("SupprimerUtilisateurHardis"))
        {
            String idUser = request.getParameter("idUser");
            long id = Long.parseLong(idUser);
            Utilisateur_Hardis User = gestionAdmin.recherchercherUtilisateurHardisId(id).get(0);
            
            if(User != null){   
            gestionAdmin.suppressionUtilisateurHardis(id);  
            List <Utilisateur_Hardis> listeUser  = gestionAdmin.affichageUtilisateursHardis();
            request.setAttribute("listeUser", listeUser);
            jspClient="/GestionUtilisateurHardis.jsp";
            }
            
            else 
            {
                message = "Cet utilisateur n'existe pas";
                request.setAttribute("message", message); 
            }
        }
        else if (act.equals("CreerUtilisateur"))
        {      
            jspClient = "/GestionUtilisateurHardis.jsp";
            creerUtilisateurHardis(request,response);
            List <Utilisateur_Hardis> listeUser  = gestionAdmin.affichageUtilisateursHardis();
            request.setAttribute("listeUser", listeUser);
        }
        
        else if (act.equals("ActionModifierUtilisateur")){
            jspClient ="/GestionUtilisateurHardis.jsp";
            modifierUtilisateurHardis(request,response);
            List <Utilisateur_Hardis> listeUser  = gestionAdmin.affichageUtilisateursHardis();
            request.setAttribute("listeUser", listeUser);
        }
         else if (act.equals("ModifierUtilisateur"))
        {
            List <Utilisateur_Hardis> listeUser = gestionAdmin.affichageUtilisateursHardis();
            request.setAttribute("listeUser", listeUser);
            jspClient="/ModificationUtilisateurHardis.jsp";
        }
        
         else if(act.isEmpty()){
             jspClient = "/MenuAdmin.jsp";
             
         }
     
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletAdmin</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
