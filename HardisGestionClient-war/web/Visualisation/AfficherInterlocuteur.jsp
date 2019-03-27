<%-- 
    Document   : AfficherInterlocuteur
    Created on : 18 mars 2019, 13:47:47
    Author     : 3096764
--%>

<%@page import="entite.Interlocuteur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeInterlocuteur" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>

        <title>Interlocuteur</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Afficher Les Interlocuteurs</h1>
                    </div>

                    <p><%
                        String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></p>
                    <table border width=50%>
                        <tr> 
                            <td>L'entreprise de l'interlocuteur</td>
                            <td>Le nom de l'interlocuteur</td>
                            <td>Le prénom de l'interlocuteur</td>
                            <td>Mail de l'interlocuteur</td>
                            <td>Le Numéro de l'interlocuteur</td>
                        </tr>
                        <% Interlocuteur cp = (Interlocuteur) request.getAttribute("Nom_Interlocuteur");
                            {%>
                        <tr>
                            <td width=15%><a href="AccessVisualisation?action=rechercheentrepriseet&Nom_Entreprise=<%=cp.getlEntreprise().getNom_Entreprise()%>"><%=cp.getlEntreprise().getNom_Entreprise()%></a></td>
                            <td width=15%><%=cp.getNom_Interlocuteur()%></td>
                            <td width=15%><%=cp.getPrenom_Interlocuteur()%></td>
                            <td width=15%><%=cp.getMail_Interlocuteur()%></td>
                            <td width=15%><%=cp.getNum_Tel_Interlocuteur()%></td>

                        </tr><%}%> 
                        <input type="hidden" value="afficherInterlocuteur" name="action">
                    </table>
                    <hr>
                    <td width=25%><a href="AccessVisualisation?action=afficherInterlocuteur"> Retour Menu </a></td>
                    <hr>
                    </br>
                    <a href="/MenuVisualisation">Retour</a>
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>
        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>

    </body>
</html>
