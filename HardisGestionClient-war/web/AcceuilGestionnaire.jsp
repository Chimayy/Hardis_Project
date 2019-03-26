<<<<<<< HEAD

<%-- 
    Document   : AcceuilGestionnaire
    Created on : 14 mars 2019, 10:55:51
    Author     : Mathieu Harmand
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="jsp_reused/style.jsp" %>
        <title>Acceuil Gestionnaire</title>
    </head>
    <body>
        
                <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Acceuil Gestionaire</h1>
                    </div>

                    <hr class="my-6">
                    <div class="row">
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=ReponseQuestions">Répondre aux questions</a></div>
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=AffectationDevis">Affectation des devis</a></div>  
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=VisuClients">Gestion des devis clients</a></div>
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=QuestionsForum"> questions du Forum </a></div>
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=creerPeriode">Renseigner une date de disponibilité</a></div>
                    </div>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>

=======
<<<<<<< HEAD
=======

>>>>>>> exiless6
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
        <%@include file="jsp_reused/style.jsp" %>       
        <jsp:useBean id="User" scope="session" class="entite.Utilisateur_Hardis"></jsp:useBean>
        <title>Acceuil Gestionnaire</title>
    </head>
    <body>
        
                <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Acceuil Gestionaire</h1>
                    </div>

                    <hr class="my-6">
                    <div class="row">
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=ReponseQuestions">Répondre aux questions</a></div>
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=AffectationDevis">Affectation des devis</a></div>  
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=VisuClients">Gestion des devis clients</a></div>
<<<<<<< HEAD
<<<<<<< HEAD
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=QuestionsForum"> questions du Forum </a></div>
=======
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=QuestionsForum">Répondre aux questions du Forum</a></div>
>>>>>>> exiless6
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=creerPeriode">Renseigner une date de disponibilité</a></div>
=======
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=QuestionsForum">Répondre aux questions du Forum</a></div>                        
>>>>>>> schellen3
                    </div>
                </div>
            </div>
           <% Utilisateur_Hardis guest = User;
               if(guest.getProfil_Technique().equals(profil_Technique.administrateur)){%>
                   <form method="get" action="AcceuilGestionnaire">
                   <input type ="hidden" name="action" value="RetourAdmin">
                   <input class="btn btn-outline-teal right" type="submit" value="Retour">
                   </form>
               <%}%>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
<<<<<<< HEAD
</html>
=======
</html>

>>>>>>> exiless6
>>>>>>> 175cd39839dcb7efed3ba667e78c9528dfdafc39
