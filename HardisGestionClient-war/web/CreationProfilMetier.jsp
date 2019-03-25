<%-- 
    Document   : CreationProfilMetier
    Created on : 21 mars 2019, 16:08:45
    Author     : Utilisateur
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="java.util.List"%>
<%@page import="entite.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeOffre" scope="request" class = "java.util.List"> </jsp:useBean>
<jsp:useBean id="listeUser" scope="request" class = "java.util.List"> </jsp:useBean>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer un profil métier</title>
    </head>
    <body>
        <h1>Créer un profil métier</h1>
        <% List<Offre> lesOffres = listeOffre;%>
        <% List<Utilisateur_Hardis> lesUser = listeUser;%>
        <form method ="get" action="ServletAdmin">
                <input type ="text" placeholder='Niveau' name="niveau" class='input'/>
                <label for="Offre" class='textinput'> Offre : </label>
                <select name="idOffre" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Offre offre : lesOffres ){%>
                    <option value="<%=offre.getId()%>"><%=offre.getNom_Offre()%>
                    </option>
                    <%}%>
                </select><br/>
                <label for="User" class='textinput'> Utilisateur Hardis : </label>
                <select name="idUser" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Utilisateur_Hardis user: lesUser ){%>
                    <option value="<%=user.getId()%>"><%=user.getPrenom_Utilisateur()%> <%=user.getNom_Utilisateur()%>
                    </option>
                    <%}%>
                </select><br/>
                <input type ="hidden" name="action" value="CreerProfilMetier">
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