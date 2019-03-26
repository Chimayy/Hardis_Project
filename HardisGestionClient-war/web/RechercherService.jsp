<%-- 
    Document   : RechercherService
    Created on : 18 mars 2019, 13:45:58
    Author     : 3096764
--%>

<%@page import="entite.Devis"%>
<%@page import="entite.Entreprise"%>
<%@page import="entite.Client"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <a href="RechercherUtilisateur.jsp"></a>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeClient" scope="request" class="java.util.List"></jsp:useBean>
            <title>Recherche service</title>
        </head>
        <body>
            <h1>Rechercher Service</h1>
            <p><%
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %></p>
        <form action="./AccessUtilisateurHardis" method="POST">
            <table border width=50%>
                <tr>
                    <td align="right"><b>rechercher nom client</b></td>
                    <td> 
                        <input type="text" name="Description_Service" size="75" value="${Service.description_Service}">
                    </td>
                </tr>
                <tr> 
                <tr>
                    <td></td>
                    <td> 
                        <input type="hidden" value="rechercheService" name="action">
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
