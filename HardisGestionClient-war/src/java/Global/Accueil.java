package Global;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entite.Client;
import entite.Utilisateur;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.gestionVisiteur;
import session.gestionVisiteurLocal;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import javax.servlet.http.HttpSession;

/**
 *
 * @author thoma
 */
@WebServlet(urlPatterns = {"/Accueil"})
public class Accueil extends HttpServlet {

    @EJB
    private gestionVisiteurLocal gestionVisiteur;
    String jspClient = "/Connexion.jsp";
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
        act = request.getParameter("action");

        if ((act == null) || (act.equals("vide"))) {
            jspClient = "/Connexion.jsp";
            request.setAttribute("message", "pas d'information");
        } else if ((act.equals("authentif"))) {
            String login = request.getParameter("mail");
            String pass = request.getParameter("mdp");
            Utilisateur utilisateur = gestionVisiteur.authentification(login, pass);

            //fail de message d'erreur en cas de champs vides ==> à coriger
            if (utilisateur.toString().equalsIgnoreCase("")) {
                request.setAttribute("problème de connexion, merci de réessayer", message);;
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

        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");

        /* try (PrintWriter out = response.getWriter()) {
            TODO output your page here. You may use following sample code. 
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
