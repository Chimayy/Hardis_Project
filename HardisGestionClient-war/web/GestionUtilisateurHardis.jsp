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
        <p><form method ="get" action="ServletAdmin">
        <div style="overflow-x:auto;"> 
        <input type ="text" placeholder='Nom' name="nom" class='input'/>
        <input class='bouton' type="submit" value="Valider"/></br>
        <input type ="hidden" name="action" value="RechercherUtilisateurHardis">
        <table border width="50%">
        </p>
            <tr> <td>Id</td>
                 <td>Nom</td>
                 <td>Prénom</td>
                 <td>Mail</td>
                 <td>Mot de passe</td>
                 <td>Plafond de délégation</td>
                 <td>Profil technique</td>
            </tr>
                 <% List <Utilisateur_Hardis> lesUser = listeUser;
                 for(Utilisateur_Hardis user : lesUser){%>
            <tr> <td Width=15%><%=user.getId()%></td>
                 <td Width=15%><%=user.getNom_Utilisateur()%></td>
                 <td Width=15%><%=user.getPrenom_Utilisateur()%></td>
                 <td Width=15%><%=user.getMail_Connexion()%></td>
                 <td Width=15%><%=user.getMot_De_Passe()%></td>
                 <td Width=15%><%=user.getPlafond_Delegation()%></td>
                 <td Width=15%><%=user.getProfil_Technique()%></td>
                 <td Width=15%><a href="ServletAdmin?action=RechercherUtilisateurHardisModif&idUser=<%=user.getId()%>" >Modifier</a>
              <%}%>
        </table></hr>
        <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
        </div>
        <div class="message"><% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %></div>
      
        </form>
    </body>
</html>
