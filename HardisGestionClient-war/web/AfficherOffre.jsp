<%-- 
    Document   : AfficherOffre
    Created on : 18 mars 2019, 10:18:40
    Author     : 3096764
--%>

<%@page import="entite.Devis"%>
<%@page import="entite.Service"%>
<%@page import="entite.Profil_Metier"%>
<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--<jsp:useBean id="listeOffre" scope="request" class="java.util.List"></jsp:useBean>--%>
        <title>Les Offres</title>
    </head>
    <body>
        <h1>Afficher Les Offres</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr>
                <td>Profil métiers</td>
                <td>les devis</td>
                <td>Service</td>
                <td>Nom de l'offre</td>
                <td>Description de l'offre</td>
            </tr>
             <% Offre cp = (Offre) request.getAttribute("Nom_Offre");
                {%>
                <tr>
                    <% List<Profil_Metier> lespro=cp.getProfil_Metiers();
                        for(Profil_Metier pm : lespro){%>
                    <td width=15%><ul><li><a href=""><%=pm.getNiveau_Habilitation()%></a></li></ul></td><%}%> 
                    <% List<Devis> lesDev=cp.getLesDevis();
                        for(Devis d : lesDev){%>
                    <td width=15%><ul><li><a href="AccessVisualisation?action=recherchedeviso&Date_Intervention=<%=d.getDate_Intervention()%>"><%=d.getDate_Intervention()%></a></li></ul></td><%}%>
                    <% List<Service> lesServ=cp.getServices();
                        for(Service s : lesServ){%>
                    <td width=15%><ul><li><a href="AccessVisualisation?action=rechercheserviceo&Description_Service=<%=s.getDescription_Service()%>"><%=s.getDescription_Service()%></a></li></ul></td><%}%>  
                    <td width=15%><%=cp.getNom_Offre()%></td>
                    <td width=15%><%=cp.getDescription_Offre()%></td>               
                </tr><%}%>    
                <input type="hidden" value="afficherOffre" name="action">
        </table>
        <hr>
    <td width=25%><a href="AccessVisualisation?action=afficherOffre"> Retour Menu </a></td>
    <hr>
    </br>
    <a href="/MenuVisualisation">Retour</a>
    </body>
</html>
