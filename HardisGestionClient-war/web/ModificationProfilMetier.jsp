<%-- 
    Document   : ModificationProfilMetier
    Created on : 22 mars 2019, 08:19:03
    Author     : Utilisateur
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Offre"%>
<%@page import="entite.Profil_Metier"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeProfil" scope="request" class = "java.util.List"> </jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
    <title>Modifier un profil métier</title>
    </head>
    <body>
        <h1>Modifier un profil métier</h1>
        <% List<Profil_Metier> lesProfils = listeProfil;%>
                <% for (Profil_Metier profil : lesProfils) {%>
                <form method ="get" action="ServletAdmin">
                <input type="hidden" name="id" value="<%=profil.getId()%>" class='input'/>
                <p> Niveau d'habilitation : <input type ="text" name="niveau" value="<%=profil.getNiveau_Habilitation()%>"/></p>              
            <input type ="hidden" name="action" value="ActionModifierProfilMetier"/>     
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Effacer"/>       
            <%}%>
            <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
            </div>
        </form>
    </body>
</html>