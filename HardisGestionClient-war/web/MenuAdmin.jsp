


<%@page import="entite.Utilisateur"%>
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
        <jsp:useBean id="listUser" scope="session" class = "java.util.List"> </jsp:useBean>
<jsp:useBean id="UserARecup" scope="session" class = "entite.Utilisateur"> </jsp:useBean>
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
                        <h1>Menu Administrateur</h1>
                    </div> 
                    <hr class="my-6">
                    <div class="row">  

                        <div class="col-3"><a class = "btn btn-indigo" style="padding:12%;min-height: 110px; min-width: 250px; " href ="ServletAdmin?action=AfficherUtilisateursHardis"> Gestion des utilisateurs Hardis </a></div>
                        <div class="col-3"><a class = "btn btn-indigo" style="padding:12%;min-height: 110px; min-width: 250px;" href ="ServletAdmin?action=AfficherEntreprises"> Gestion des entreprises </a></div>
                        <div class="col-3"><a class = "btn btn-indigo" style="padding:15%;min-height: 110px; min-width: 250px;" href="ServletAdmin?action=AfficherAgences">  Gestion des agences   </a></div>
                        <div class="col-3"><a class = "btn btn-indigo" style="padding:15%;min-height: 110px; min-width: 250px;" href="ServletAdmin?action=AfficherServices"> Gestion des services </a></div>
                        <div class="col-3"><a class = "btn btn-indigo" style="padding:18%;min-height: 110px; min-width: 250px;" href="ServletAdmin?action=AfficherOffres"> Gestion des offres </a></div>

                        <div class="col-3"><a class = "btn btn-indigo" style="padding:15%;min-height: 110px; min-width: 250px;" href="ServletAdmin?action=GestionQuestionPublique"> Attribuer les questions publiques</a></div>
                        <div class="col-3"><a class = "btn btn-indigo" style="padding:18%;min-height: 110px; min-width: 250px;" href="ServletAdmin?action=MenuGestionnaire"> Menu gestionnaire</a></div>

                    </div>
                     
                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="Accueil" value="retour"> Retour Menu </a>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <!--pages de script-->
        <%@include file="jsp_reused/javascript.jsp"%>

    </body>

</html>

