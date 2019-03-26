<%-- 
    Document   : MenuVisualisation
    Created on : 14 mars 2019, 17:38:10
    Author     : 3096764
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Visualisation</title>
    </head>
    <body>
        <h1>Menu Visualisation</h1>
        <p>
            <% 
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
        </p>
        <table>
            <tr>
                <td width="25%"><a href="AccessVisualisation?action=AfficherClient">Afficher les clients</a></td>
                <td width="25%"><a href="AccessVisualisation?action=AfficherDevis">Afficher les Devis</a></td>
                <td width="25%"><a href="AccessVisualisation?action=AfficherServices">Afficher les Services</a></td>
                <td width="25%"><a href="AccessVisualisation?action=AfficherUtilisateurs">Afficher les Utilisateurs</a></td>
            </tr>
        </table>
        <table>
            <tr>
                <td width="25%"><a href="/Menu">Retour</a></td>
            </tr>
        </table>
    </body>
</html>
