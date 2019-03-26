<%-- 
    Document   : RechercherClient
    Created on : 18 mars 2019, 13:44:40
    Author     : 3096764
--%>
<%@page import="entite.Devis"%>
<%@page import="entite.Entreprise"%>
<%@page import="entite.Client"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="Client" scope="request" class="java.util.List"></jsp:useBean>
            <title>Recherche client</title>
        </head>
        <body>
            <h1>Rechercher Client</h1>
            <p><%
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %></p>
        <form action="./AccessUtilisateurHardis" method="POST">
            <table border width=50%>
                <tr>
                    <td align="right"><b>client du nom rechercher</b></td>
                    <td> 
                        <input type="text" name="Nom_Utilisateur" size="75" value="${Client.nom_Utilisateur}">
                    </td>
                </tr>
                <tr> 
                <tr>
                    <td></td>
                    <td> 
                        <input type="hidden" value="rechercheClient" name="action">
                        <input type="submit" value="recherche">
                    </td>
                </tr>
            </table>
        </form>
    <td width=25%><a href="AccessVisualisation?action=afficherClient"> Retour Menu </a></td>
    <hr>
    </br>
    <a href="/MenuVisualisation">Retour</a>
</body>
</html>