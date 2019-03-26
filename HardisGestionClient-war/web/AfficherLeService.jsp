<%-- 
    Document   : AfficherServices
    Created on : 14 mars 2019, 17:20:32
    Author     : 3096764
--%>

<%@page import="entite.Prestation"%>
<%@page import="entite.Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeService" scope="request" class="java.util.List"></jsp:useBean>
        <title>Article</title>
    </head>
    <body>
        <h1>Afficher Les Services</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
             private List<Prestation> prestations = new ArrayList<Prestation>();

            <tr> 
                <td>Prestation</td>
                <td>description service</td>
                <td>cout service</td>
                <td>Offre</td>
            </tr>
            <% Service cp = (Service) request.getAttribute("Description_Service");
                {%>
            
                <tr>
                    <% List<Prestation> lesPers=cp.getPrestations();
                         for(Prestation p : lesPers){%>
                    <td width=15%><ul><li><a href="AccessVisualisation?action=rechercheprestations&Nom_Prestation=<%=p.getNom_Prestation()%>"><%=p.getNom_Prestation()%></a></li></ul></td><%}%> 
                    <td width=15%><%=cp.getDescription_Service()%></td>
                    <td width=15%><%=cp.getCout_Service()%></td>
                    <td width=15%><a href="AccessVisualisation?action=rechercheoffres&Nom_Offre=<%=cp.getlOffre().getNom_Offre()%>"><%=cp.getlOffre().getNom_Offre()%></a></td>
                </tr><%}%> 
                <input type="hidden" value="afficherLeService" name="action">
        </table>
        <hr>
    <td width=25%><a href="AccessVisualisation?action=afficherLeService"> Retour Menu </a></td>
    <hr>
    </br>
    <a href="/MenuVisualisation">Retour</a>
</body>
</html>