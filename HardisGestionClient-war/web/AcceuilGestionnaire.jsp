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
        <h1>Acceuil Gestionaire</h1>
                <td width="25%"><a href="AcceuilGestionnaire?action=ReponseQuestions">Répondre aux questions des devis</a></td>
                <td width="25%"><a href="AcceuilGestionnaire?action=AffectationDevis">Affectation devis</a></td>                
                <td width="25%"><a href="AcceuilGestionnaire?action=VisuClients">Gestion des devis clients</a></td>
                <td width="25%"><a href="AcceuilGestionnaire?action=QuestionsForum">Répondre aux questions du Forum</a></td>
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
                        <div class="col-4"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=ReponseQuestions">Répondre aux questions</a></td></div>
                        <div class="col-4"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=AffectationDevis">Affectation devis</a></td>              </div>  
                        <div class="col-4"><a class="btn btn-blue" style="padding:15%" href="AcceuilGestionnaire?action=VisuClients">Gestion des devis clients</a></td></div>
                    </div>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>
