<%-- 
    Document   : AfficherClient
    Created on : 14 mars 2019, 17:20:06
    Author     : 3096764
--%>

<%@page import="entite.Devis"%>
<%@page import="entite.Consentement_RGPD"%>
<%@page import="entite.Entreprise"%>
<%@page import="entite.Client"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeClient" scope="request" class="java.util.List"></jsp:useBean>
        <title>Client</title>
    </head>
    <body>
        <h1>Afficher Client</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr> 
                <td>Les devis</td>
                <td>Les entreprises</td>
                <td>L'email</td>
                <td>Le Nom</td>
                <td>Le Prénom</td>
                <td>Les dates de consentement</td>
            </tr>
            <% List<Client> lesCli=listeClient;
                for(Client cp : lesCli){%>
                <tr>
                    <% List<Devis> lesDev=cp.getLesDevis();
                for(Devis d : lesDev){%>
                    <td width=15%><ul><li><a href="AccessVisualisation?action=recherchedeviscl&Date_Intervention=<%=d.getDate_Intervention()%>"><%=d.getDate_Intervention()%></a></li></ul></td><%}%>
                    <td width=15%><a href="AccessVisualisation?action=rechercheentreprisecl&Nom_Entreprise=<%=cp.getlEntreprise().getNom_Entreprise()%>"><%=cp.getlEntreprise().getNom_Entreprise()%></a></td>
                    <td width=15%><%=cp.getMail_Connexion()%></td>
                    <td width=15%><%=cp.getNom_Utilisateur()%></td>
                    <td width=15%><%=cp.getPrenom_Utilisateur()%></td>
                    <td width=15%><a href="AccessVisualisation?action=rechercheconsentementcl&DateConsentement=<%=cp.getLeConsentement().getDateConsentement()%>"><%=cp.getLeConsentement().getDateConsentement()%></a></td>
                    
                </tr><%}%> 
                <input type="hidden" value="afficherClient" name="action">
        </table>
        <form method="get" action="AccessVisualisation">
        <input type="hidden" value="RetourMenuVisu" name="action">
        <input class="btn btn-outline-light-green" style="margin-bottom: 20px" type="submit" value="Retour">
        </form>
    </body>
</html>