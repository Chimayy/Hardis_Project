<%-- 
    Document   : GestionUtilisateurHardis
    Created on : 14 mars 2019, 10:36:58
    Author     : Utilisateur
--%>
<%@page import="entite.Utilisateur"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeUser" scope="request" class="java.util.List"></jsp:useBean>
             <title>Utilisateurs Hardis</title>
    </head>
    <body>
        <h1>Liste des utilisateurs Hardis</h1>
        
        <div style="overflow-x:auto;">       
        <table border width="50%">
            <tr> <td>Numéro</td>
                 <td>Nom</td>
                 <td>Prénom</td>
                 <td>Mail</td>
                 <td>Mot de passe</td>
                 <td>Plafond de délégation</td>
                 <td>Profil technique</td>
                 <% List <Utilisateur> lesUser = listeUser;
                 for(Utilisateur user : lesUser){%>
            <tr> <td Width=15%><%=user.getId()%></td>
                 <td Width=15%><%=user.getNom_Utilisateur()%></td>
                 <td Width=15%><%=user.getPrenom_Utilisateur()%></td>
                 <td Width=15%><%=user.getMail_Connexion()%></td>
                 <td Width=15%><%=user.getMot_De_Passe()%></td>  
            </tr>       
              <%}%>
        </table></hr>
        <div class='retour'>
            <a href ="/MenuAdmin.jsp"> Retour Menu </a>
        </div>
    </body>
</html>
