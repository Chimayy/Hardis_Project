<%-- 
    Document   : MenuVisualisation
    Created on : 14 mars 2019, 17:38:10
    Author     : 3096764
--%>
<%@page import="java.util.List"%>
<%@page import="entite.Utilisateur"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listUser" scope="session" class = "java.util.List"> </jsp:useBean>
        <jsp:useBean id="UserARecup" scope="session" class = "entite.Utilisateur"> </jsp:useBean>
        
        <%@include file="jsp_reused/style.jsp" %>
        <title>Menu Administrateur</title>
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
                            <h1>Menu Visualisation</h1>
                    </div> 
                    <hr class="my-6">
                    <div class="row">         
                <div class="col-3"><a class = "btn btn-indigo" style="padding:12%;min-height: 120px; min-width: 220px;" href="AccessVisualisation?action=AfficherClient">Afficher les clients</a></div>             
                <div class="col-3"><a class = "btn btn-indigo" style="padding:12%;min-height: 120px; min-width: 220px;" href="AccessVisualisation?action=AfficherServices">Afficher les Services</a></div>
                <div class="col-3"><a class = "btn btn-indigo" style="padding:12%;min-height: 120px; min-width: 220px;" href="AccessVisualisation?action=AfficherUtilisateurs">Afficher les Utilisateurs</a></div>
                <div class="col-3"><a class = "btn btn-indigo" style="padding:12%;min-height: 120px; min-width: 220px;" href="AccessVisualisation?action=AfficherDevis">Afficher les Devis</a></div>
                    </div>
                     <hr class="my-6">     
                     <a class="btn btn-outline-teal right" href="Accueil" value="retour"> Retour Menu </a>
                </div>
                
                 
                </div>
    </body>
</html>
