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
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Client</title>
    </head>
    <body>

       

        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Afficher Client</h1>
                    </div>

                    <p><%
                        String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></p>
                    <table class='table table-bordered'>
                        <thead>
                            <tr> 
                                
                                <th>L'email</th>
                                <th>Le Nom</th>
                                <th>Le Prénom</th>
                                <th>Les entreprises</th>
                                <th>Les dates de consentement</th>
                            </tr>
                        </thead>
                        <% List<Client> lesCli = listeClient;
                            for (Client cp : lesCli) {%>
                        <tr>
                            
                            <td width=15%><%=cp.getMail_Connexion()%></td>
                            <td width=15%><%=cp.getNom_Utilisateur()%></td>
                            <td width=15%><%=cp.getPrenom_Utilisateur()%></td>
                            <td width=15%><%=cp.getlEntreprise().getNom_Entreprise()%></td>
                            <%if(cp.getLeConsentement()==null){%>
                            <td width=15%>Consentemment pas encore acquis</td>
                            <%}
                            if(cp.getLeConsentement()!=null){%>
                            <td width=15%><%=cp.getLeConsentement().getDateConsentement()%>"></td>
                            <%}%>
                        </tr><%}%> 
                        <input type="hidden" value="afficherClient" name="action">
                    </table>
                    <form method="get" action="AccessVisualisation">
                        <input type="hidden" value="RetourMenuVisu" name="action">
                        <input class="btn btn-outline-light-green" style="margin-bottom: 20px" type="submit" value="Retour">
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
