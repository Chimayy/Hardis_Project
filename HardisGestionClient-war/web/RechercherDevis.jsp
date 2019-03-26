<%-- 
    Document   : RechercherDevis
    Created on : 18 mars 2019, 13:45:34
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
        <jsp:useBean id="listeClient" scope="request" class="java.util.List"></jsp:useBean>
            <title>Recherche devis</title>
        </head>
        <body>
            <h1>Rechercher Devis</h1>
            <p><%
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %></p>
        <form action="./AccessUtilisateurHardis" method="POST">
            <table border width=50%>
                <tr>
                    <td align="right"><b>rechercher date intervention</b></td>
                    <td> 
                        <input type="text" name="Date_Intervention" size="75" value="${Devis.date_Intervention}">
                    </td>
                </tr>
                <tr> 
                <tr>
                    <td></td>
                    <td> 
                        <input type="hidden" value="rechercheDevis" name="action">
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
