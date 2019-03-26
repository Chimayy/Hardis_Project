
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hardis;

import entite.Agence;
import entite.Entreprise;
import entite.Historique_QuestionPublique;
import entite.Offre;
import entite.Profil_Metier;
import entite.Service;
import entite.Utilisateur;
import entite.Utilisateur_Hardis;
import entite.profil_Technique;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
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
        String idAgence = request.getParameter("idAgence");
        Utilisateur_Hardis user = gestionAdmin.rechercherUtilisateurHardisMail(mail);
      
        String message="";
        if (nom.trim().trim().isEmpty()||prenom.trim().isEmpty()||mail.trim().isEmpty()||motdepasse.trim().isEmpty()||plafond.trim().isEmpty()
                ||profil_t.trim().isEmpty()||idAgence.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer un utilisateur";
        }
        
        else if (user != null){
            message = "Erreur, un compte utilisateur existe déjà pour ce mail";
            
        }
        else {
            double pla = Double.parseDouble(plafond);
            profil_Technique profil = profil_Technique.valueOf(profil_t);
            boolean stat = Boolean.parseBoolean(statut);
            long id = Long.parseLong(idAgence);
            Agence agence = gestionAdmin.rechercherAgenceParId(id).get(0);
            Utilisateur_Hardis admin = gestionAdmin.creationUtilisateurHardis(mail, motdepasse, nom, prenom, pla, profil, stat, agence);
            List<Offre> listeOffre = gestionAdmin.affichageOffres();
            if(!listeOffre.isEmpty() && profil.equals(profil_Technique.administrateur)){        
            for(Offre offre : listeOffre){
                         gestionAdmin.creationProfilMetier(6, offre, admin);
                    }    
            }
        message = "Utilisateur crée avec succès !";   
            gestionAdmin.creationUtilisateurHardis(mail, motdepasse, nom, prenom, pla, profil, stat, agence);
            message = "Utilisateur crée avec succès !";          
        }
        request.setAttribute("message", message);
        }
    
    protected void creerEntreprise(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String nom = request.getParameter("nom");
        String siret = request.getParameter("siret");
        String adresse = request.getParameter("adresse");
        String code_postal = request.getParameter("code_postal");
        String ville = request.getParameter("ville");
        Entreprise ent = gestionAdmin.rechercherEntrepriseParSiret(siret);
        String idAgence = request.getParameter("idAgence");
        
        String message;
        if (nom.trim().trim().isEmpty()||siret.trim().isEmpty()||adresse.trim().isEmpty()||code_postal.trim().isEmpty()||ville.trim().isEmpty())
                
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer une entreprise";
        }
        
        else if (ent != null){
            message = "Erreur, entreprise déjà existante";
            
        }
        else {
            Long id = Long.parseLong(idAgence);
            Agence agence = gestionAdmin.rechercherAgenceParId(id).get(0);
            gestionAdmin.creationEntreprise(code_postal, nom, siret, adresse, ville, agence);
            message = "Entreprise créée avec succès !";          
        }
        request.setAttribute("message", message);
    }
    
    protected void creerAgence(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String cp = request.getParameter("cp");
        String pays = request.getParameter("pays");
        String adresse = request.getParameter("adresse");
        String ville = request.getParameter("ville");
        Agence agence = gestionAdmin.rechercherAgenceParVille(ville);
        
        String message;
        if (cp.trim().trim().isEmpty()||pays.trim().isEmpty()||adresse.trim().isEmpty()||ville.trim().isEmpty())
                
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer une agence";
        }
        
        else if (agence != null){
            message = "Erreur, il existe déjà une agence dans cette ville";
            
        }
        else {
            gestionAdmin.creationAgence(cp, pays, adresse, ville);
            message = "Agence créée avec succès !";          
        }
        request.setAttribute("message", message);
    }
    
    protected void creerService(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String cout_offre = request.getParameter("cout");
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String idOffre = request.getParameter("idOffre");
        String message;
        
        if (cout_offre.trim().trim().isEmpty()||nom.trim().isEmpty()||description.trim().isEmpty()||idOffre.trim().isEmpty())              
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer un service";
        }
       
        else {
            double cout = Double.parseDouble(cout_offre);
            long id = Long.parseLong(idOffre);
            Offre offre = gestionAdmin.rechercherOffreParId(id).get(0);
            gestionAdmin.creationService(description, nom, cout, offre);
            message = "Service créé avec succès !";          
        }
        request.setAttribute("message", message);
    }

    
    protected void creerOffre(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String description = request.getParameter("description");
        String nom = request.getParameter("nom");
        Offre offre = gestionAdmin.rechercherOffreParNom(nom);
        String message;
        
        if (description.trim().trim().isEmpty()||nom.trim().isEmpty())            
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer une offre";
        }
        
        else if(offre !=null){
            
            message = "Erreur, cette offre existe déjà";
        }
       
        else {
            gestionAdmin.creationOffre(description, nom);
            message = "Offre créée avec succès !";          
        }
        request.setAttribute("message", message);
    }
    
    protected void creerQuestionPublique(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String question = request.getParameter("question");
        String pseudo = request.getParameter("pseudo");
        String idOffre = request.getParameter("idOffre");

        String message;
       
        if (question.trim().trim().isEmpty()||pseudo.trim().isEmpty()||idOffre.trim().isEmpty())            
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour enregistrer une question";
        }

        else {
            long id = Long.parseLong(idOffre);
            Offre offre = gestionAdmin.rechercherOffreParId(id).get(0);
            gestionAdmin.creationQuestionPublique(question, pseudo, offre);
            message = "Question enregistrée !";          
        }
        request.setAttribute("message", message);
    }
    protected void creerProfilMetier(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String niveau = request.getParameter("niveau");
        String idUser = request.getParameter("idUser");
        String idOffre = request.getParameter("idOffre");
        long idU = Long.parseLong(idUser);
        long idO = Long.parseLong(idOffre);
        Profil_Metier profil = gestionAdmin.rechercherProfilMetier(idU,idO);               
        String message;
       
        if (niveau.trim().trim().isEmpty()||idUser.trim().isEmpty()||idOffre.trim().isEmpty())            
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour créer un profil";
        }
        
        else if(profil!=null){
            message = "Un profil métier existe déjà pour cet utilisateur et cette offre";
        }

        else {
            Offre offre = gestionAdmin.rechercherOffreParId(idO).get(0);
            int niv = Integer.parseInt(niveau);
            Utilisateur_Hardis user = gestionAdmin.recherchercherUtilisateurHardisId(idU).get(0);
            gestionAdmin.creationProfilMetier(niv, offre, user);
            message = "Profil métier créé avec succès !";          
        }
        
        request.setAttribute("message", message);
    }
    
    protected void modifierUtilisateurHardis(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String idUser = request.getParameter("id");
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
            int id = Integer.parseInt(idUser);
            double pla = Double.parseDouble(plafond);
            profil_Technique profil = profil_Technique.valueOf(profil_t);
            boolean stat = Boolean.parseBoolean(statut);
            Utilisateur_Hardis admin = gestionAdmin.modificationUtilisateurHardis(id ,mail, motdepasse, nom, prenom, pla, profil, stat);
            List<Offre> listeOffre = gestionAdmin.affichageOffres();
            if(!listeOffre.isEmpty() && admin.getProfil_Technique().equals(profil_Technique.administrateur) ){        
            for(Offre offre : listeOffre){
                        Profil_Metier pm = gestionAdmin.rechercherProfilMetier(admin.getId(), offre.getId());
                        if(pm != null){
                        gestionAdmin.suppressionProfilMetier(pm.getId());}
                        gestionAdmin.creationProfilMetier(6, offre, admin);
                    }    
            }
            
            message = "Utilisateur modifié avec succès !";          
        }
        request.setAttribute("message", message);   
    }
    
     protected void modifierEntreprise(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String idEnt = request.getParameter("id");
        String nom = request.getParameter("nom");
        String siret = request.getParameter("siret");
        String adresse = request.getParameter("adresse");
        String cp = request.getParameter("cp");
        String ville = request.getParameter("ville");
        String idAgence = request.getParameter("idAgence");
        String message ;
       if (idEnt.trim().isEmpty()||nom.trim().trim().isEmpty()||siret.trim().isEmpty()||adresse.trim().isEmpty()||cp.trim().isEmpty()||ville.isEmpty()
                ||idAgence.isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour modifier l'entreprise";
        }
        else {
            long id = Long.parseLong(idEnt);
            long idAg = Long.parseLong(idAgence);
            Agence agence = gestionAdmin.rechercherAgenceParId(idAg).get(0);
            gestionAdmin.modificationEntreprise(id, nom, siret, cp, adresse, ville, agence);
            message = "Entreprise modifiée avec succès !";          
        }
        request.setAttribute("message", message);
    }    
     
    protected void modifierAgence(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String idAgence = request.getParameter("id");
        String adresse = request.getParameter("adresse");
        String cp = request.getParameter("cp");
        String ville = request.getParameter("ville");
        String pays = request.getParameter("pays");
        String message ;
       if (idAgence.trim().isEmpty()||adresse.trim().isEmpty()||cp.trim().isEmpty()||ville.isEmpty()
                ||pays.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour modifier l'agence";
        }
        
       else {
            long id = Long.parseLong(idAgence);
            gestionAdmin.modificationAgence(id, cp, pays, adresse, ville);
            message = "Agence modifiée avec succès !";          
        }
        request.setAttribute("message", message);
    }

    protected void modifierService(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String idService = request.getParameter("id");
        String cout_service = request.getParameter("cout");
        String description = request.getParameter("description");
        String nom = request.getParameter("nom");
        String idOffre = request.getParameter("idOffre");
        String message ;
       if (idService.trim().isEmpty()||cout_service.trim().isEmpty()||description.trim().isEmpty()||nom.isEmpty()
                ||idOffre.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour modifier le service";
        }
        
       else {
            long id = Long.parseLong(idService);
            long idO = Long.parseLong(idOffre);
            double cout = Double.parseDouble(cout_service);
            Offre offre = gestionAdmin.rechercherOffreParId(idO).get(0);
            gestionAdmin.modificationService(id, nom, description, cout, offre);
            message = "Service modifié avec succès !";          
        }
        request.setAttribute("message", message);
    }    
    
    protected void modifierOffre(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String idOffre = request.getParameter("id");
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String message ;
       if (idOffre.trim().isEmpty()||nom.trim().isEmpty()||description.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour modifier l'offre";
        }
        
       else {
            long id = Long.parseLong(idOffre);
            gestionAdmin.modificationOffre(id, nom, description);
            message = "Offre modifiée avec succès !";          
        }
        request.setAttribute("message", message);
    }    
    
    protected void modifierProfilMetier(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException           
    {
        String idProfil = request.getParameter("id");
        String niveau = request.getParameter("niveau");
        String message ;
       if (idProfil.trim().isEmpty()||niveau.trim().isEmpty())
        {
            message = "Erreur, vous n'avez pas rempli tous les champs pour modifier le profil métier";
        }
        
       else {
            long id = Long.parseLong(idProfil);
            int niv = Integer.parseInt(niveau);
            gestionAdmin.modificationProfilMetier(id, niv);
            message = "Profil métier modifié avec succès !";          
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
       
         HttpSession sess= request.getSession(true);
        String message="";
        String jspClient = null;
               
        String act = request.getParameter("action");
      
        
        // récupération de l'utilisateur qui s'est loggué
        Utilisateur_Hardis user =(Utilisateur_Hardis)sess.getAttribute("UserARecup");
         
        if(act==null||act==""){
             jspClient = "/MenuAdmin.jsp";
             
         }
        else if(act.equals("AfficherUtilisateursHardis")) 
        {
            List <Utilisateur_Hardis> listeUser  = gestionAdmin.affichageUtilisateursHardis();
            if(listeUser.isEmpty()){
                listeUser = new ArrayList<>();
            }
            request.setAttribute("listeUser", listeUser);
            request.setAttribute("message",message);
            jspClient="/GestionUtilisateurHardis.jsp";
        }
        
        else if(act.equals("AfficherEntreprises")){
            List<Entreprise> listeEnt = gestionAdmin.affichageEntreprises();
            request.setAttribute("listeEnt", listeEnt);
            jspClient="/GestionEntreprise.jsp";
        }
        
        else if(act.equals("AfficherAgences")){
            List<Agence> listeAgence = gestionAdmin.affichageAgences();
            request.setAttribute("listeAgence", listeAgence);
            jspClient="/GestionAgence.jsp";
        }
        
        else if(act.equals("AfficherServices")){
            List<Service> listeServ = gestionAdmin.affichageServices();
            request.setAttribute("listeServ", listeServ);
            jspClient="/GestionService.jsp";
        }
        
        else if(act.equals("AfficherOffres")){
            List<Offre> listeOffre = gestionAdmin.affichageOffres();
            request.setAttribute("listeOffre", listeOffre);
            jspClient="/GestionOffre.jsp";
        }

        else if(act.equals("AfficherProfilsMetier")){
            String idUser = request.getParameter("idUser");
            long id = Long.parseLong(idUser);
            List<Profil_Metier> listeProfil = gestionAdmin.rechercherProfilMetierParIdUser(id);
            request.setAttribute("listeProfil", listeProfil);
            jspClient="/GestionProfilMetier.jsp";
        }
        
        else if(act.equals("RechercherUtilisateurHardis"))
        {        
            request.setAttribute("message","");
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
        
         else if(act.equals("RechercherEntreprise"))
        {        
            String nom = request.getParameter("nom");
            if(!nom.trim().isEmpty()){
            List <Entreprise> listeEnt  = gestionAdmin.rechercherEntrepriseParNom(nom);
                if(listeEnt.size()>0){
            request.setAttribute("listeEnt", listeEnt);
            jspClient="/GestionEntreprise.jsp";
                }
                else{
                List <Entreprise> listeEnt2  = gestionAdmin.affichageEntreprises();
                request.setAttribute("listeEnt", listeEnt2);
                jspClient="/GestionEntreprise.jsp";
                }                    
            }
            else{
            List <Entreprise> listeEnt2  = gestionAdmin.affichageEntreprises();
            request.setAttribute("listeEnt", listeEnt2);
            jspClient="/GestionEntreprise.jsp";
            message = "Veuillez rentrer une valeur";
            request.setAttribute("message", message);  
            }
        }
          else if(act.equals("RechercherOffre"))
        {        
            String nom = request.getParameter("nom");
            if(!nom.trim().isEmpty()){
            List <Offre> listeOffre  = gestionAdmin.rechercherListeOffreParNom(nom);
                if(listeOffre.size()>0){
            request.setAttribute("listeOffre", listeOffre);
            jspClient="/GestionOffre.jsp";
                }
                else{
                List <Offre> listeOffre2 = gestionAdmin.affichageOffres();
                request.setAttribute("listeOffre", listeOffre2);
                jspClient="/GestionOffre.jsp";
                }                    
            }
            else{
            List <Offre> listeOffre  = gestionAdmin.affichageOffres();
            request.setAttribute("listeOffre", listeOffre);
            jspClient="/GestionOffre.jsp";
            message = "Veuillez rentrer une valeur";
            request.setAttribute("message", message);  
            }
        }
          
        else if(act.equals("RechercherService"))
        {        
            String nom = request.getParameter("nom");
            if(!nom.trim().isEmpty()){
            List <Service> listeService  = gestionAdmin.rechercherServiceParNom(nom);
                if(listeService.size()>0){
            request.setAttribute("listeServ", listeService);
            jspClient="/GestionService.jsp";
                }
                else{
                List <Service> listeService2 = gestionAdmin.affichageServices();
                request.setAttribute("listeServ", listeService2);
                jspClient="/GestionService.jsp";
                }                    
            }
            else{
            List <Service> listeService = gestionAdmin.affichageServices();
            request.setAttribute("listeServ", listeService);
            jspClient="/GestionService.jsp";
            message = "Veuillez rentrer une valeur";
            request.setAttribute("message", message);  
            }
        }
        
        else if(act.equals("RechercherUtilisateurHardisModif"))
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
        
        else if(act.equals("SupprimerUtilisateurHardis"))
        {
            String idUser = request.getParameter("idUser");
            long id = Long.parseLong(idUser);
            Utilisateur_Hardis User = gestionAdmin.rechercherUtilisateurHardisParId(id);
            
            if(User != null){   
            List<Profil_Metier> listeprofil = gestionAdmin.rechercherProfilMetierParIdUser(id);
            for(Profil_Metier profil : listeprofil){
                gestionAdmin.suppressionProfilMetier(profil.getId());
            }
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
         
        
        else if(act.equals("SupprimerEntreprise"))
        {
            String idEnt = request.getParameter("idEnt");
            long id = Long.parseLong(idEnt);
            Entreprise Ent = gestionAdmin.rechercherEntrepriseParId(id).get(0);
            
            if(Ent != null){   
            gestionAdmin.suppressionEntreprise(id);
            List <Entreprise> listeEnt  = gestionAdmin.affichageEntreprises();
            request.setAttribute("listeEnt", listeEnt);
            jspClient="/GestionEntreprise.jsp";
            }
            
            else 
            {
                message = "Cette entreprise n'existe pas";
                request.setAttribute("message", message); 
            }
        }
         
        else if(act.equals("SupprimerAgence"))
        {
            String idAgence = request.getParameter("idAgence");
            long id = Long.parseLong(idAgence);
            Agence agence = gestionAdmin.rechercherAgenceParId(id).get(0);
            List<Entreprise> ListeEnt = gestionAdmin.rechercherEntrepriseParAgence(agence);
            
            if(agence != null){
     
                if(ListeEnt.isEmpty()){
                    gestionAdmin.suppressionAgence(id);
                    List <Agence> listeAgence  = gestionAdmin.affichageAgences();
                    request.setAttribute("listeAgence", listeAgence);
                    jspClient="/GestionAgence.jsp";
                }
                
                else {
                     message = "Impossible, il existe des entreprises liées à cette agence";
                     request.setAttribute("message", message);
                     List <Agence> listeAgence  = gestionAdmin.affichageAgences();
                     request.setAttribute("listeAgence", listeAgence);
                     jspClient="/GestionAgence.jsp";
                }
            }                
            else 
            {
                message = "Cette agence n'existe pas";
                request.setAttribute("message", message); 
                 List <Agence> listeAgence  = gestionAdmin.affichageAgences();
                request.setAttribute("listeAgence", listeAgence);
                jspClient="/GestionAgence.jsp";
                }
            }
        
         else if(act.equals("SupprimerProfilMetier"))
        {
            String idProfil = request.getParameter("idProfilMetier");
            long id = Long.parseLong(idProfil);
            Profil_Metier profil = gestionAdmin.rechercherProfilMetierParId(id).get(0);
            
            if(profil != null){   
            gestionAdmin.suppressionProfilMetier(id);
            List <Profil_Metier> listeProfil  = gestionAdmin.affichageProfilsMetier();
            request.setAttribute("listeProfil", listeProfil);
            jspClient="/GestionProfilMetier.jsp";
            message = "Profil métier supprimé avec succès";
            request.setAttribute("message", message); 
            }
            
            else 
            {
                message = "Ce profil métier n'existe pas";
                request.setAttribute("message", message); 
            }
        }
         
         else if(act.equals("SupprimerOffre")){
             String idOffre = request.getParameter("idOffre");
             long idO = Long.parseLong(idOffre);
             Offre offre = gestionAdmin.rechercherOffreParId(idO).get(0);
             List<Service> listeservice = gestionAdmin.rechercherServiceParOffre(offre);
             
            if(offre!=null){
                 
                if(listeservice.isEmpty()){
                gestionAdmin.suppressionOffre(idO);
                List<Offre> listeOffre = gestionAdmin.affichageOffres();
                request.setAttribute("listeOffre", listeOffre);
                jspClient = "/GestionOffre.jsp";
                message = "Offre supprimée avec succès";
                request.setAttribute("message", message); 
            }
                else{
                     message = "Impossible, il existe des services liés à cette offre";
                     request.setAttribute("message", message);
                     List <Offre> listeOffre  = gestionAdmin.affichageOffres();
                     request.setAttribute("listeOffre", listeOffre);
                     jspClient="/GestionOffre.jsp";
                }
                    
            }
             
             else{
                message = "Cette offre n'existe pas";
                request.setAttribute("message", message); 
                 
             }
             
         }
         
        else if(act.equals("SupprimerService")){
            String idServ = request.getParameter("idServ");
            long id = Long.parseLong(idServ);
            Service Serv = gestionAdmin.rechercherServiceParId(id).get(0);
            
            if(Serv != null){   
            gestionAdmin.suppressionService(id);
            List <Service> listeServ  = gestionAdmin.affichageServices();
            request.setAttribute("listeServ", listeServ);
            jspClient="/GestionService.jsp";
            message = "Service supprimé avec succès !";
            request.setAttribute("message", message); 
            }
            
            else 
            {
                message = "Ce service n'existe pas";
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
        
        else if (act.equals("CreerEntreprise"))
        {      
            jspClient = "/GestionEntreprise.jsp";
            creerEntreprise(request,response);
            List <Entreprise> listeEnt = gestionAdmin.affichageEntreprises();
            request.setAttribute("listeEnt", listeEnt);
        }
        
        else if (act.equals("CreerAgence"))
        {      
            jspClient = "/GestionAgence.jsp";
            creerAgence(request,response);
            List <Agence> listeAgence = gestionAdmin.affichageAgences();
            request.setAttribute("listeAgence", listeAgence);
        }
        
        else if (act.equals("CreerService"))
        {      
            jspClient = "/GestionService.jsp";
            creerService(request,response);
            List <Service> listeServ = gestionAdmin.affichageServices();
            request.setAttribute("listeServ", listeServ);
        }
        
        else if (act.equals("CreerOffre"))
        {      
            jspClient = "/GestionOffre.jsp";
            creerOffre(request,response);
            List <Offre> listeOffre = gestionAdmin.affichageOffres();
            request.setAttribute("listeOffre", listeOffre);
        }
        
        else if (act.equals("CreerProfilMetier")){
            jspClient = "/GestionProfilMetier.jsp";
            creerProfilMetier(request,response);
            List<Profil_Metier> listeProfil = gestionAdmin.affichageProfilsMetier();
            String idUser = request.getParameter("idUser");
            long idU = Long.parseLong(idUser);
            List<Utilisateur_Hardis> listeUser = gestionAdmin.recherchercherUtilisateurHardisId(idU);
            request.setAttribute("listeProfil",listeProfil);
            request.setAttribute("listeUser", listeUser);
        }
        
         else if (act.equals("CreerQuestionPublique"))
        {      
            jspClient = "/RedactionQuestionPublique.jsp";
            creerQuestionPublique(request,response);
            List <Offre> listeOffre = gestionAdmin.affichageOffres();
            request.setAttribute("listeOffre", listeOffre);
        }
        
         else if (act.equals("CreationEntreprise"))
        {      
            List<Agence> ListeAgence= gestionAdmin.affichageAgences();
            request.setAttribute("listeAgence",ListeAgence);
            jspClient="/CreationEntreprise.jsp";
        }
        
        else if (act.equals("CreationService"))
        {      
            List<Offre> ListeOffre= gestionAdmin.affichageOffres();
            request.setAttribute("listeOffre",ListeOffre);
            jspClient="/CreationService.jsp";
        }
        
        else if (act.equals("CreationQuestionPublique"))
        {      
            List<Offre> ListeOffre= gestionAdmin.affichageOffres();
            request.setAttribute("listeOffre",ListeOffre);
            jspClient="/RedactionQuestionPublique.jsp";
        }
        
        else if(act.equals("CreationProfilMetier")){
            List<Offre> listeOffre = gestionAdmin.affichageOffres();
            List<Utilisateur_Hardis> listeUser = gestionAdmin.affichageUtilisateursHardis();
            request.setAttribute("listeUser", listeUser);
            request.setAttribute("listeOffre", listeOffre);
            jspClient = "/CreationProfilMetier.jsp";
        }
        
        else if (act.equals("GestionQuestionPublique"))
        {    
            List<Historique_QuestionPublique> listeQuestion = gestionAdmin.affichageQuestionsPubliques();
            List<Profil_Metier> listeProfil = gestionAdmin.affichageProfilsMetier();
            List<Utilisateur_Hardis> listeUser = gestionAdmin.affichageUtilisateursHardis();
            request.setAttribute("listeProfil", listeProfil);  
            request.setAttribute("listeUser", listeUser);  
            request.setAttribute("listeQuestion", listeQuestion);  
            jspClient="/GestionQuestionPublique.jsp";
        }
              
         else if (act.equals("CreationUtilisateurHardis"))
        {      
            List<Agence> ListeAgence= gestionAdmin.affichageAgences();
            request.setAttribute("listeAgence",ListeAgence);
            jspClient="/CreationUtilisateurHardis.jsp";
        }
        
        else if (act.equals("ActionModifierUtilisateur")){
            jspClient ="/GestionUtilisateurHardis.jsp";
            modifierUtilisateurHardis(request,response);
            List <Utilisateur_Hardis> listeUser  = gestionAdmin.affichageUtilisateursHardis();
            request.setAttribute("listeUser", listeUser);
        }
        
        else if (act.equals("ActionModifierEntreprise")){
            jspClient ="/GestionEntreprise.jsp";
            modifierEntreprise(request,response);
            List <Entreprise> listeEnt  = gestionAdmin.affichageEntreprises();
            request.setAttribute("listeEnt", listeEnt);
        }
        
        else if (act.equals("ActionModifierAgence")){
            jspClient ="/GestionAgence.jsp";
            modifierAgence(request,response);
            List <Agence> listeAgence  = gestionAdmin.affichageAgences();
            request.setAttribute("listeAgence", listeAgence);
        }
        
        else if (act.equals("ActionModifierService")){
            jspClient ="/GestionService.jsp";
            modifierService(request,response);
            List <Service> listeServ  = gestionAdmin.affichageServices();
            request.setAttribute("listeServ", listeServ);
        }
        
        else if(act.equals("ActionModifierOffre")){
            jspClient = "/GestionOffre.jsp";
            modifierOffre(request,response);
            List <Offre> listeOffre = gestionAdmin.affichageOffres();
            request.setAttribute("listeOffre", listeOffre);
        }
        
        else if (act.equals("ActionModifierProfilMetier")){
            jspClient ="/GestionProfilMetier.jsp";
            modifierProfilMetier(request,response);
            List <Profil_Metier> listeProfil = gestionAdmin.affichageProfilsMetier();
            request.setAttribute("listeProfil", listeProfil);
        }
        
        else if (act.equals("ModifierUtilisateurHardis"))
        {
            String idUser = request.getParameter("idUser");
            long id = Long.parseLong(idUser);
            List<Utilisateur_Hardis> ListeUser = gestionAdmin.recherchercherUtilisateurHardisId(id);
            request.setAttribute("listeUser",ListeUser);
            jspClient="/ModificationUtilisateurHardis.jsp";
        }
         
        else if (act.equals("ModifierEntreprise"))
        {   
            List<Agence> ListeAgence= gestionAdmin.affichageAgences();
            request.setAttribute("listeAgence",ListeAgence);
            String idEnt = request.getParameter("idEnt");
            long id = Long.parseLong(idEnt);
            List <Entreprise> listeEnt = gestionAdmin.rechercherEntrepriseParId(id);
            request.setAttribute("listeEnt", listeEnt);
            jspClient="/ModificationEntreprise.jsp";
        }

         else if (act.equals("ModifierAgence"))
        {   
            String idAgence = request.getParameter("idAgence");
            long id = Long.parseLong(idAgence);
            List <Agence> listeAgence = gestionAdmin.rechercherAgenceParId(id);
            request.setAttribute("listeAgence", listeAgence);
            jspClient="/ModificationAgence.jsp";
        }
         
        else if (act.equals("ModifierService"))
        {   
            List<Offre> ListeOffre = gestionAdmin.affichageOffres();
            request.setAttribute("listeOffre",ListeOffre);
            String idServ = request.getParameter("idServ");
            long id = Long.parseLong(idServ);
            List <Service> listeServ = gestionAdmin.rechercherServiceParId(id);
            request.setAttribute("listeServ", listeServ);
            jspClient="/ModificationService.jsp";
        }
        
         else if (act.equals("ModifierOffre"))
        {   
            String idOffre = request.getParameter("idOffre");
            long id = Long.parseLong(idOffre);
            List <Offre> listeOffre = gestionAdmin.rechercherOffreParId(id);
            request.setAttribute("listeOffre", listeOffre);
            jspClient="/ModificationOffre.jsp";
        }
         
         else if (act.equals("ModifierProfilMetier")){
            String idProfilMetier = request.getParameter("idProfilMetier");
            long id = Long.parseLong(idProfilMetier);         
            List <Profil_Metier> listeProfil = gestionAdmin.rechercherProfilMetierParId(id);
            request.setAttribute("listeProfil", listeProfil);  
            jspClient = "/ModificationProfilMetier.jsp";         
         }
         
         else if(act.equals("AttribuerQuestionPublique")){
            String idQuestion = request.getParameter("idQuestion");
            long idQ = Long.parseLong(idQuestion);
            Historique_QuestionPublique question = gestionAdmin.rechercherQuestionPubliqueParId(idQ).get(0);
            String idUser = request.getParameter("idUser");
            long idU = Long.parseLong(idUser);
            Utilisateur_Hardis gestionnaire = gestionAdmin.rechercherUtilisateurHardisParId(idU);
            gestionAdmin.attributionQuestionPublique(question, gestionnaire);
            jspClient = "/MenuAdmin.jsp";
            message = "Question attribuée !";
            request.setAttribute("message", message);  
          
         }
         
         else if(act.equals("MenuGestionnaire")){
             jspClient = "/AcceuilGestionnaire.jsp";
         }
         
         else if(act.equals("Menu")){
             jspClient = "/MenuAdmin.jsp";
             
             
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


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
