<%-- 
    Document   : AfficherHistoriqueDocuments
    Created on : 18 mars 2019, 10:20:57
    Author     : 3096764
--%>

<%@page import="entite.Historique_Document"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeHistoriqueDocuments" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>

        <title>Les Historiques documents</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Afficher Les Historiques des documents</h1>
                    </div>

                    <p><%
                        String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></p>
                    <table class='table table-bordered'>
                        <thead>
                            <tr>
                                <th>les documents</th>
                                <th>le devis</th>
                            </tr>
                        </thead>
                        <% Historique_Document cp = (Historique_Document) request.getAttribute("Id");
                            {%>

                        <tr>
                            <td width=15%><%=cp.getPath_Document()%></td>
                            <td width=15%><a href="AccessVisualisation?action=recherchedevishd&DateIntervention=<%=cp.getLeDevis().getDate_Intervention()%>"><%=cp.getLeDevis().getDate_Intervention()%></a></td>              
                        </tr><%}%>   
                        <input type="hidden" value="afficherHistoriqueDocuments" name="action">
                    </table>
                    <hr>
                    <td width=25%><a href="AccessVisualisation?action=afficherHistoriqueDocuments"> Retour Menu </a></td>
                    <hr>

                    </br>
                    <a class="btn btn-outline-teal right" href="/MenuVisualisation">Retour</a>
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>

        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>

    </body>
</html>
