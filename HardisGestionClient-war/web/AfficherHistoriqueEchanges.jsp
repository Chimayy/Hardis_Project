<%-- 
    Document   : AfficherHistoriqueEchanges
    Created on : 18 mars 2019, 10:20:12
    Author     : 3096764
--%>

<%@page import="entite.Historique_Echange"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeHistoriqueEchanges" scope="request" class="java.util.List"></jsp:useBean>
        <title>Les Historiques des Echanges</title>
    </head>
    <body>
        <h1>Afficher Les Historiques des Echanges</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr>
                <td>Contenu Echange</td>
                <td>Date echange</td>
                <td>documents compte rendu</td>
                <td>devis</td>
            </tr>
            <% Historique_Echange cp = (Historique_Echange) request.getAttribute("Id");
                {%>
                <tr>
                    <td width=15%><%=cp.getContenu_Echange()%></td>
                    <td width=15%><%=cp.getDate_Echange()%></td>
                    <td width=15%><%=cp.getPath_Compte_Rendu()%></td>  
                    <td width=15%><a href="AccessVisualisation?action=recherchedevise&DateIntervention=<%=cp.getLeDevis().getDate_Intervention()%>"><%=cp.getLeDevis().getDate_Intervention()%></a></td>                
                </tr><%}%> 
                <input type="hidden" value="afficherHistoriqueEchanges" name="action">
        </table>
        <hr>
    <td width=25%><a href="AccessVisualisation?action=afficherHistoriqueEchanges"> Retour Menu </a></td>
    <hr>
    </br>
    <a href="/MenuVisualisation">Retour</a>
    </body>
</html>
