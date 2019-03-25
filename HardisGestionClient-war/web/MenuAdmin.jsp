
<%-- 
    Document   : MenuAdmin
    Created on : 14 mars 2019, 11:34:31
    Author     : Utilisateur
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="jsp_reused/style.jsp" %>
        <title>Menu Administrateur</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Menu Administrateur</h1>
                    </div> 
                    <hr class="my-6">
                    <div class="row">  
                        <div class="col-3"><a class = "btn btn-indigo menuBox" style="padding:12%" href ="ServletAdmin?action=AfficherUtilisateursHardis"> Gestion des utilisateurs Hardis </a></div>
                        <div class="col-3"><a class = "btn btn-indigo menuBox" style="padding:12%" href ="ServletAdmin?action=AfficherEntreprises"> Gestion des entreprises </a></div>
                        <div class="col-3"><a class = "btn btn-indigo menuBox" style="padding:17%" href="ServletAdmin?action=AfficherAgences">  Gestion des agences   </a></div>
                        <div class="col-3"><a class = "btn btn-indigo menuBox" style="padding:16.5%" href="ServletAdmin?action=AfficherServices"> Gestion des services </a></div>
                        <div class="col-3"><a class = "btn btn-indigo menuBox" style="padding:18%" href="ServletAdmin?action=AfficherOffres"> Gestion des offres </a></div>
                        <div class="col-3"><a class = "btn btn-indigo menuBox" style="padding:15%" href="ServletAdmin?action=CreationQuestionPublique"> Rédiger question publique</a></div>
                        <div class="col-3"><a class = "btn btn-indigo menuBox" style="padding:14%" href="ServletAdmin?action=GestionQuestionPublique"> Attribuer les questions publiques</a></div>
                    </div>
                    <hr class="my-6">  
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <!--pages de script-->
        <%@include file="jsp_reused/javascript.jsp"%>

    </body>
</html>