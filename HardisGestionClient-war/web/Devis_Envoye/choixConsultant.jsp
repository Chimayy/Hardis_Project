<%-- 
    Document   : choixConsultant
    Created on : 22 mars 2019, 16:13:28
    Author     : thoma
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entite.Profil_Metier"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--<jsp:useBean id="listCV" scope="request" class="java.util.List"></jsp:useBean>--%>
        <jsp:useBean id="listPM" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="devis" scope="request" class="entite.Devis"></jsp:useBean>
        <%--<jsp:useBean id="listConsultant" scope="request" class="java.util.List"></jsp:useBean>--%>
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Devis sélectionné : Devis n°<%=devis.getId()%> pour une prestation : <%=devis.getLaPrestation().getLeService().getNom_Service()%></h1>
        Liste des consultants disponibles sur ce service :
        <form method="get" action="ServletClient">
        <table border width=50%>
            <tr> 
                <td>Nom</td>
                <td>Prenom</td>
                <td>CV</td>
                <td>checkbox</td>
            </tr>
            <% List PM = listPM;
            List<Profil_Metier> list = new ArrayList();
            for(Object o : listPM){
                Profil_Metier pm = (Profil_Metier)o;
                list.add(pm);
            }
            for(Profil_Metier PMenCours : list) {%>
                <tr>
                    <td width=15%><%= PMenCours.getlUtilisateur().getNom_Utilisateur()%></td>
                    <td width=15%><%= PMenCours.getlUtilisateur().getPrenom_Utilisateur()%></td>
                   <td width=15%><a href="METRRE LE PATH CV">Accéder au CV</td>
                    <td width=15%> <input type="checkbox" name="checkbox"/> choisir ce consultant</td>
                    <input type="hidden" name="consultant" value="<%=PMenCours.getlUtilisateur().getId()%>">
                    
   
                
                </tr><%}%>     
        </table>
                <input type="date" name="dateIntervention" placeholder="ptipote">
                <input type="hidden" name="action" value="propositionconsultant">
                <input type="hidden" name="devis" value="<%=devis.getId()%>">
                <input  class='bouton' type="submit" value="Valider"/>
        </form>

        <hr>
    <td width=25%><a href="MenuClient.jsp"> Retour Menu </a></td>
    </body>
</html>
