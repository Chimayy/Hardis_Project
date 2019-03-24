<%-- 
    Document   : choixConsultant
    Created on : 22 mars 2019, 16:13:28
    Author     : thoma
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listConsultant" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="devis" scope="request" class="entite.Devis"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Devis sélectionné : Devis n°<%=devis.getId()%> pour une prestation : <%=devis.getLaPrestation().getLeService().getNom_Service()%></h1>
        Liste des consultants disponibles sur ce service :
        <table border width=50%>
            <tr> 
                <td>Nom</td>
                <td>Prenom</td>
                <td>CV</td>
                <td>checkbox</td>
            </tr>
            <% List<Utilisateur_Hardis> lesConsultants=listConsultant;
                for(Utilisateur_Hardis consultantEnCours : lesConsultants){%>
                <tr>
                    <td width=15%><%=consultantEnCours.getNom_Utilisateur()%></td>
                    <td width=15%><%=consultantEnCours.getPrenom_Utilisateur()%></td>
                <td><a href="<%=consultantEnCours.%>">voir CV </a></td>
                
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="MenuClient.jsp"> Retour Menu </a></td>
    </body>
</html>
