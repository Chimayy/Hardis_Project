<%-- 
    Document   : ModificationAgence
    Created on : 19 mars 2019, 11:51:21
    Author     : Utilisateur
--%>

<%@page import="entite.Agence"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeAgence" scope="request" class = "java.util.List"> </jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
    <title>Modifier une agence</title>
    </head>
    <body>
        <h1>Modifier une agence</h1>
        <% List<Agence> lesAgences = listeAgence;%>
            <div class="input1">
                <% for (Agence agence : lesAgences) {%>
                <form method ="get" action="ServletAdmin">
                <input type="hidden" name="id" value="<%=agence.getId()%>" class='input'/>
                <p> Code postal : <input type ="text" name="cp" value="<%=agence.getCP_Agence()%>" readonly class='input'/></p> 
                <p> Pays : <input type="text" name="pays" value="<%=agence.getPays_Agence()%>" readonly class ="input"/></p>
                <p> Adresse : <input type ="text" name="adresse" value="<%=agence.getRue_Agence()%>" class='input'/></p>            
                <p> Ville : <input type ="text" name="ville" value="<%=agence.getVille_Agence()%>" readonly class='input'/></p>
            </div>
            <div class='bouton1'>
            </br>
            <input type ="hidden" name="action" value="ActionModifierAgence"/>     
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