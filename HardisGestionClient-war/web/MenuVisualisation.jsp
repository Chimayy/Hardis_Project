<%-- 
    Document   : MenuVisualisation
    Created on : 14 mars 2019, 17:38:10
    Author     : 3096764
--%>
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
                            <h1>Menu Visualisation</h1>
                    </div> 
                    <hr class="my-6">
                    <div class="row">         
                <div class="col-3"><a class = "btn btn-indigo" style="padding:12%" href="AccessVisualisation?action=AfficherClient">Afficher les clients</a></div>             
                <div class="col-3"><a class = "btn btn-indigo" style="padding:12%" href="AccessVisualisation?action=AfficherServices">Afficher les Services</a></div>
                <div class="col-3"><a class = "btn btn-indigo" style="padding:12%" href="AccessVisualisation?action=AfficherUtilisateurs">Afficher les Utilisateurs</a></div>
                <div class="col-3"><a class = "btn btn-indigo" style="padding:12%" href="AccessVisualisation?action=AfficherDevis">Afficher les Devis</a></div>
                    </div>
                     <hr class="my-6">                           
                </div>
                <form method="get" action="AccessVisualisation">
                <input type="hidden" value="RetourMenu" name="action">
                <input class="btn btn-outline-light-green" style="margin-bottom: 20px" type="submit" value="Retour">
            </form>  
    </body>
</html>
