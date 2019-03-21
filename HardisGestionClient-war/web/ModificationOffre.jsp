<%-- 
    Document   : ModificationOffre
    Created on : 20 mars 2019, 11:01:37
    Author     : Utilisateur
--%>

<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeOffre" scope="request" class="java.util.List"></jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
    <title>Modifier une offre</title>
    </head>
    <body>
        <h1>Modifier une offre</h1>
        <% List<Offre> lesOffres = listeOffre;%>
            <div class="input1">
                <% for (Offre offre : lesOffres) {%>
                <form method ="get" action="ServletAdmin">
                <input type="hidden" name="id" value="<%=offre.getId()%>" class='input'/>
                <p> Nom : <input type ="text" name="cp" value="<%=offre.getNom_Offre()%>" readonly class='input'/></p> 
                <p> Description : <input type="text" name="pays" value="<%=offre.getDescription_Offre()%>" readonly class ="input"/></p>
            </div>
            <div class='bouton1'>
            </br>
            <input type ="hidden" name="action" value="ActionModifierOffre"/>     
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