<%-- 
    Document   : AfficherAgence
    Created on : 18 mars 2019, 13:42:45
    Author     : 3096764
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Entreprise"%>
<%@page import="entite.Agence"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agence</title>
    </head>
    <body>
        <h1>Afficher Les Agences</h1>
        <table border width=50%>
            <tr> 
                <td>L'entreprise</td>
                <td>La rue de l'agence</td>
                <td>La ville de l'agence</td>
                <td>Code postale de l'agence</td>
                <td>Pays de l'agence </td>
            </tr>
            <% Agence cp = (Agence) request.getAttribute("Ville_Agence");
                {%>
                <tr> 
                    <% List<Entreprise> ntr=cp.getEntreprises();
                for(Entreprise e : ntr){%>
                    <td width=15%><%=e.getNom_Entreprise()%></a></td><%}%> 
                    <td width=15%><%=cp.getRue_Agence()%></td>
                    <td width=15%><%=cp.getVille_Agence()%></td>
                    <td width=15%><%=cp.getCP_Agence()%></td>
                    <td width=15%><%=cp.getPays_Agence()%></td>
                    
                </tr><%}%> 
                <input type="hidden" value="afficherAgence" name="action">
        </table>
    <a href="AccessVisualisation?action=RetourMenuVisu">Retour</a>
</body>
</html>
