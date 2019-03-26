<%-- 
    Document   : AfficherlEntreprise
    Created on : 18 mars 2019, 10:17:26
    Author     : 3096764
--%>

<%@page import="entite.Utilisateur"%>
<%@page import="entite.Agence"%>
<%@page import="entite.Interlocuteur"%>
<%@page import="entite.Client"%>
<%@page import="entite.Entreprise"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeEntreprise" scope="request" class="java.util.List"></jsp:useBean>
        <title>Entreprise</title>
    </head>
    <body>
        <h1>Afficher Les Entreprises</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Interlocuteurs</td>
                <td>Client</td>
                <td>Agence</td>
                <td>Nom de l'entreprise</td>
                <td>Numero siret</td>
                <td>Rue entreprise</td>
                <td>Ville entreprise</td>
                <td>code postal entreprise</td>
            </tr>
             <% Entreprise cp = (Entreprise) request.getAttribute("Nom_Entreprise");
                {%>
                <tr>
                <% List<Interlocuteur> lesInter=cp.getInterlocuteurs();
                for(Interlocuteur i : lesInter){%>
                    <td width=15%><ul><li><a href="AccessVisualisation?action=rechercheinterlocuteuren&Nom_Interlocuteur=<%=i.getNom_Interlocuteur()%>"><%=i.getNom_Interlocuteur()%></a></li></ul></td><%}%> 
                <% List<Client> lesCli=cp.getClients();
                for(Client c : lesCli){%>
                    <td width=15%><ul><li><a href="AccessVisualisation?action=rechercheutilisateuren&Nom_Utilisateur=<%=c.getNom_Utilisateur()%>"><%=c.getNom_Utilisateur()%></a></li></ul></td><%}%>  
                    <td width=15%><a href="AccessVisualisation?action=rechercheagenceen&Ville_Agence=<%=cp.getlAgence().getVille_Agence()%>"><%=cp.getlAgence().getVille_Agence()%></a></td>
                    <td width=15%><%=cp.getNom_Entreprise()%></td>
                    <td width=15%><%=cp.getNumero_SIRET()%></td>
                    <td width=15%><%=cp.getRue_Entreprise()%></td>
                    <td width=15%><%=cp.getVille_Entreprise()%></td>
                    <td width=15%><%=cp.getCP_Entreprise()%></td>
                </tr><%}%>     
                 <input type="hidden" value="afficherEntreprise" name="action">
        </table>
        <hr>
        
    <td width=25%><a href="AccessVisualisation?action=afficherEntreprise"> Retour Menu </a></td>
     
    <hr>
    </br>
    <a href="/MenuVisualisation">Retour</a>
</body>
</html>