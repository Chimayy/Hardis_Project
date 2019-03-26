<%-- 
    Document   : AfficherHistoriqueDocuments
    Created on : 18 mars 2019, 10:20:57
    Author     : 3096764
--%>

<%@page import="entite.Historique_Document"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeHistoriqueDocuments" scope="request" class="java.util.List"></jsp:useBean>
        <title>Les Historiques documents</title>
    </head>
    <body>
        <h1>Afficher Les Historiques des documents</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr>
                <td>les documents</td>
                <td>le devis</td>
            </tr>
             <% Historique_Document cp = (Historique_Document) request.getAttribute("Id");
                {%>
            
                <tr>
                    <td width=15%><%=cp.getPath_Document()%></td>
                    <td width=15%><a href="AccessVisualisation?action=recherchedevishd&DateIntervention=<%=cp.getLeDevis().getDate_Intervention()%>"><%=cp.getLeDevis().getDate_Intervention()%></a></td>              
                </tr><%}%>   
                <input type="hidden" value="afficherHistoriqueDocuments" name="action">
        </table>
        <hr>
    <td width=25%><a href="AccessVisualisation?action=afficherHistoriqueDocuments"> Retour Menu </a></td>
    <hr>
    
    </br>
    <a href="/MenuVisualisation">Retour</a>
    </body>
</html>
