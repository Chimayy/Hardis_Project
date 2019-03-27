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
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Article</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Afficher Les Services</h1>
                    </div>

                    <p><%
                        String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></p>
                    <table class='table table-bordered' >
                        <!--                        private List<Prestation> prestations = new ArrayList<Prestation>();-->
                        <thead>
                            <tr> 
                                <th>Prestation</th>
                                <th>description service</th>
                                <th>cout service</th>
                                <th>Offre</th>
                            </tr>
                        </thead>
                        <% Service cp = (Service) request.getAttribute("Description_Service");
                            {%>

                        <tr>
                            <% List<Prestation> lesPers = cp.getPrestations();
                                for (Prestation p : lesPers) {%>
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
                    <a class="btn btn-outline-teal right" href="/MenuVisualisation">Retour</a>
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>
        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>

    </body>
</html>