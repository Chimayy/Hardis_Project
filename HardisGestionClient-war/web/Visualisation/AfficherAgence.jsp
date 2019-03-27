<%-- 
    Document   : AfficherAgence
    Created on : 18 mars 2019, 13:42:45
    Author     : 3096764
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Entreprise"%>
<%@page import="entite.Agence"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeAgence" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Agence</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Afficher Les Agences</h1>
                    </div>

                    <p><%
                        String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></p>
                    <table class='table table-bordered'>
                        <tr> 
                            <th>L'entreprise</th>
                            <th>La rue de l'agence</th>
                            <th>La ville de l'agence</th>
                            <th>Code postale de l'agence</th>
                            <th>Pays de l'agence </th>
                        </tr>
                        <% Agence cp = (Agence) request.getAttribute("Ville_Agence");
                            {%>
                        <tr>
                            <% List<Utilisateur_Hardis> UtiHar = cp.getLesUtilisateur_Hardis();
                                for (Utilisateur_Hardis a : UtiHar) {%>
                            <td width=15%><ul><li><a href="AccessVisualisation?action=rechercheutilisateura&Nom_Utilisateur=<%=a.getNom_Utilisateur()%>"><%=a.getNom_Utilisateur()%></a></li></ul></td><%}%> 
                                        <% List<Entreprise> ntr = cp.getEntreprises();
                                            for (Entreprise e : ntr) {%>
                            <td width=15%><ul><li><a href="AccessVisualisation?action=rechercheentreprisea&Nom_Entreprise=<%=e.getNom_Entreprise()%>"><%=e.getNom_Entreprise()%></a></li></ul></td><%}%> 
                            <td width=15%><%=cp.getRue_Agence()%></td>
                            <td width=15%><%=cp.getVille_Agence()%></td>
                            <td width=15%><%=cp.getCP_Agence()%></td>
                            <td width=15%><%=cp.getPays_Agence()%></td>

                        </tr><%}%> 
                        <input type="hidden" value="afficherAgence" name="action">
                    </table>
                    <hr>
                    <a href="AccessVisualisation?action=afficherAgence"> Retour Menu </a>
                    <hr>
                    
                    <a class="btn btn-outline-teal right" href="/MenuVisualisation" > Retour </a>
                    
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>

        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>

    </body>
</html>
