

<%@page import="java.util.List"%>
<%-- 
    Document   : AcceuilGestionnaire
    Created on : 14 mars 2019, 10:55:51
    Author     : Mathieu Harmand
--%>


<%@page import="entite.profil_Technique"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Utilisateur"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="User" scope="session" class="entite.Utilisateur_Hardis"></jsp:useBean>
        <jsp:useBean id="listUser" scope="session" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="UserARecup" scope="session" class = "entite.Utilisateur"> </jsp:useBean>
        <%@include file="jsp_reused/style.jsp" %>
        <title>Acceuil Gestionnaire</title>
    </head>
    <body>
        
                <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <% 
                        List<Utilisateur> listeUser = listUser;
                        entite.Utilisateur user = UserARecup;
                    
                    if (!listeUser.contains(user)){%>
                    <%@include file="jsp_reused/header.jsp" %>
                    <%}
                if(listUser.contains(user)){%>
                <%@include file="jsp_reused/header_deconnexion.jsp" %><%}%>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Acceuil Gestionaire</h1>
                    </div>

                    <hr class="my-6">
                    <div class="row">


                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%;min-height: 110px; min-width: 450px;" href="AcceuilGestionnaire?action=ReponseQuestions">Répondre aux questions sur les devis</a></div>
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%;min-height: 110px; min-width: 450px;" href="AcceuilGestionnaire?action=AffectationDevis">Affectation des devis</a></div>  
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%;min-height: 110px; min-width: 450px;" href="AcceuilGestionnaire?action=VisuClients">Gestion des devis clients</a></div>


                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%;min-height: 110px; min-width: 450px;" href="AcceuilGestionnaire?action=QuestionsForum">Répondre aux questions du Forum</a></div>

                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%;min-height: 110px; min-width: 450px;" href="AcceuilGestionnaire?action=creerPeriode">Renseigner une date de disponibilité</a></div>


                    </div>
                      </div>
                <hr class="my-6">
                <% Utilisateur_Hardis guest =User;
               if(guest.getProfil_Technique().equals(profil_Technique.administrateur)){%>
                   <form method="get" action="AcceuilGestionnaire">
                   <input type ="hidden" name="action" value="RetourAdmin">
                   <input class="btn btn-outline-teal right" type="submit" value="Retour Menu Admin">
                   </form>
               <%}%>
               
                    <a class="btn btn-outline-teal right" href="Accueil" value="retour"> Retour Menu</a>
                </div>
               
          

            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>

</html>


</html>


