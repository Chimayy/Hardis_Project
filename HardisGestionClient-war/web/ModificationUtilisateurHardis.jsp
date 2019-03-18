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
        <% List<Utilisateur> leUser = listeUser;%>
        <form method ="get" action="ServletAdmin">     
           <div class="input1">
           </br>   
           <div class ='input2'>  
           <label for="User" class='textinput'> Utilisateurs : </label>
                <select name="idUser" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Utilisateur user : leUser ){%>
                    <option value="<%=user.getId()%>"><%=user.getNom_Utilisateur()%><%=" "%><%=user.getPrenom_Utilisateur()%>
                    </option>
                    <%}%>
                </select> 
                <input type ="hidden" name="action" value="RechercherUtilisateurHardisModif">
                <input class='bouton' type="submit" value="Valider"/></br
            </div>
            <div class="input1">
            </br>
                <% for (Utilisateur user : leUser) {%>
                <input type ="text" name="nom" value="<%=user.getNom_Utilisateur()%>" class='input'/>
                <input type ="text" name="prenom" class='input'/>
                <input type ="text" name="mail" class='input'/>
                <input type ="text" name="motdepasse" class='input'/>
                <input type ="text" name='plafond' classe='input' class='input'/></br>
                <%}%>
                </select></br>
                 <a> Profil Technique </a><select name="profil" size="1">
                    <option> administrateur
                    <option> gestionnaire
                    <option> visualisation        
                </select>
                <input type ="hidden" name="action" value="ActionModifierUtilisateur">         
            </div>
            <div class='bouton1'>
            </br>
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