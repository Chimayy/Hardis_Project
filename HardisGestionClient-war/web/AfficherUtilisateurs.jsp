<%-- 
    Document   : AfficherUtilisateurs
    Created on : 14 mars 2019, 17:20:55
    Author     : 3096764
--%>

<%@page import="entite.Utilisateur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeUtilisateur" scope="request" class="java.util.List"></jsp:useBean>
        <title>Utilisateur</title>
    </head>
    <body>
        <h1>Afficher Les Utilisateurs</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Mail</td>
                <td>Prénom</td>
                <td>Nom</td>
                <td>Consentement</td>
            </tr>
            <% List<Utilisateur> util=listeUtilisateur;
                for(Utilisateur cp : util){%>
                <tr>
                    <td width=15%><%=cp.getMail_Connexion()%></td>
                    <td width=15%><%=cp.getNom_Utilisateur()%></td>
                    <td width=15%><%=cp.getPrenom_Utilisateur()%></td>
                    <td width=15%><a href="AccessVisualisation?action=rechercheconsentementu&DateConsentement=<%=cp.getLeConsentement().getDateConsentement()%>"><%=cp.getLeConsentement().getDateConsentement()%></a></td>
                </tr><%}%>  
                <input type="hidden" value="afficherUtilisateurs" name="action">
        </table>
        <hr>
    
    <td width=25%><a href="AccessVisualisation?action=afficherUtilisateurs"> Retour Menu </a></td>
     
    <hr>
    </br>
    <a href="/MenuVisualisation">Retour</a>
</body>
</html>
