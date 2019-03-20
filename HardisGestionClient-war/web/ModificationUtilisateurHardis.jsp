<%-- 
    Document   : ModificationUtilisateurHardis
    Created on : 14 mars 2019, 16:22:28
    Author     : Utilisateur
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Utilisateur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeUser" scope="request" class = "java.util.List"> </jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
    <title>Modifier un utilisateur</title>
    </head>
    <body>
        <h1>Modifier un utilisateur</h1>
        <% List<Utilisateur_Hardis> leUser = listeUser;%>
            <div class="input1">
                <% for (Utilisateur_Hardis user : leUser) {%>
                <form method ="get" action="ServletAdmin">
                <input type="hidden" name="id" value="<%=user.getId()%>" class='input'/>
                <p> Nom : <input type ="text" name="nom" value="<%=user.getNom_Utilisateur()%>" class='input'/></p>
                <p> Prénom : <input type ="text" name="prenom" value="<%=user.getPrenom_Utilisateur()%>" class='input'/></p>
                <p> Mail : <input type ="text" name="mail" value="<%=user.getMail_Connexion()%>" class='input'/></p>
                <p> Mot de passe : <input type ="text" name="motdepasse" value="<%=user.getMot_De_Passe()%>" class='input'/></P>
                <p> Plafond de délégation : <input type ="text" name="plafond" value="<%=user.getPlafond_Delegation()%>"class='input'/></p>
              
                </select>
                 <a> Profil technique </a><select name="profil" size="1">
                    <option> administrateur
                    <option> gestionnaire
                    <option> visualisation        
                </select>
          
            </div>
            <div class='bouton1'>
            </br>
            <input type ="hidden" name="action" value="ActionModifierUtilisateur"/>     
            <%}%>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Effacer"/>       
            </div>
            </br>
            <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
            </div>
        </form>
    </body>
</html>