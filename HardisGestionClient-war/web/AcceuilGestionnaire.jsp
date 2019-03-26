
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
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=AffectationDevis">Affectation devis</a></div>  
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=VisuClients">Gestion des devis clients</a></div>
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=QuestionsForum">Répondre aux questions du Forum</a></div>
                        <div class="col-3 col-sm-6"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=creerPeriode">Renseigner une date de disponibilité</a></div>
                    </div>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>

