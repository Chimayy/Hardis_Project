<%-- 
    Document   : AfficherConsentement
    Created on : 18 mars 2019, 10:16:13
    Author     : 3096764
--%>

<%@page import="java.util.Date"%>
<%@page import="entite.Consentement_RGPD"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeConsentement" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Les Consentements</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Afficher Les Consentements</h1>
                    </div>

                    <p><%
                        String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></p>
                    <table class='table table-bordered'>
                        <thead>
                            <tr>
                                <th>Statut du consentement</th>
                                <th>Date du consentement</th>
                                <th>Nom de l'utilisateur</th>
                            </tr>
                        </thead>
                        <% Consentement_RGPD d = (Consentement_RGPD) request.getAttribute("consentement");
                            {%>
                        <tr>
                            <td width=15%><%=d.isBoolConsentement()%></td>
                            <td width=15%><%=d.getDateConsentement()%></td>
                            <td width=15%><a href="AccessVisualisation?action=rechercheutilisateurc&Nom_Utilisateur=<%=d.getUser().getNom_Utilisateur()%>"><%=d.getUser().getNom_Utilisateur()%></a></td>                 
                        </tr><%}%>  
                        <input type="hidden" value="afficherConsentement" name="action">
                    </table>
                    <hr>
                    <td width=25%><a href="AccessVisualisation?action=afficherConsentement"> Retour Menu </a></td>
                    <hr>

                    </br>
                    <a class="btn btn-outline-teal right" href="/MenuVisualisation">Retour</a>
                </div>
            </div>
        </div>
    </body>
</html>
