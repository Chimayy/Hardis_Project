/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import entite.Client;
import entite.Devis;
import entite.Entreprise;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.gestionClientLocal;

/**
 *
 * @author thoma
 */
@WebServlet(name = "ServletClient", urlPatterns = {"/ServletClient"})
public class ServletClient extends HttpServlet {

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
            String act=request.getParameter("action");
            
    
            

//récupération de l'id Client envoyé par la servlet d'authentification
//            String cli = request.getParameter("idClient");
//            Long id = Long.valueOf(cli);
//            Client c = gestionClient.rechercheClient(id);
            



// TEMPORAIRE EN ATTENDANT AUTHENTIF
                Client c = new Client();
                c.setMail_Connexion("ptipote");
                c.setNom_Utilisateur("jean");
               c.setPrenom_Utilisateur("coucou");
               gestionClient.objectPersist(c);
               
               
               
            if((act==null)||(act.equals("vide")))
            {
                jspClient="/MenuClient.jsp";
            }
            else if(act.equals("demandeDevis"))
            {
             
                String zoneLibre = request.getParameter("zoneLibre");
              String idServiceString = request.getParameter("idService");
                Long idServiceLong = Long.valueOf(idServiceString);              
             gestionClient.demandeDevis(zoneLibre, c, idServiceLong);
//             gestionClient.affecterDevisReferentLocal(d.getId());
                jspClient="/MenuClient.jsp";
                request.setAttribute("message", "devis bien envoyé au référent local");
            }
            
            else if (act.equals("visuDevis"))
            {
                jspClient="/listDevisClient.jsp";
                List<Devis> list = gestionClient.devisAtraiter(c.getId());
                request.setAttribute("listeDevis", list);
                request.setAttribute("message","yo");
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
            else if(act.equals("Accepter"))
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
                gestionClient.modifierDevis(remarques,montantDouble, devisAModifier );
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
                       
                
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        response.setContentType("text/html;charset=UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletClient</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletClient at " + request.getContextPath() + "</h1>");
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
