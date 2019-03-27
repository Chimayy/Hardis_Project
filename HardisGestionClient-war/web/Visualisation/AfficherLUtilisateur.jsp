
<%@page import="entite.Utilisateur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeUtilisateur" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>

        <title>Utilisateur</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Afficher Les Utilisateurs</h1>
                    </div>


                    <p><%
                        String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></p>
                    <table class='table table-bordered'>
                        <thead>
                            <tr> 
                                <th>Mail</th>
                                <th>Prénom</th>
                                <th>Nom</th>
                                <th>Consentement</th>
                            </tr>
                        </thead>
                        <% Utilisateur cp = (Utilisateur) request.getAttribute("Nom_Utilisateur");
                            {%>

                        <tr>
                            <td width=15%><%=cp.getMail_Connexion()%></td>
                            <td width=15%><%=cp.getNom_Utilisateur()%></td>
                            <td width=15%><%=cp.getPrenom_Utilisateur()%></td>
                            <td width=15%><a href="AccessVisualisation?action=rechercheconsentementlu&DateConsentement=<%=cp.getLeConsentement().getDateConsentement()%>"><%=cp.getLeConsentement().getDateConsentement()%></a></td>
                        </tr><%}%> 
                        <input type="hidden" value="afficherLUtilisateur" name="action">
                    </table>
                    <hr>

                    <td width=25%><a href="AccessVisualisation?action=afficherLUtilisateur"> Retour Menu </a></td>

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
