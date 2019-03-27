
<%@page import="entite.Historique_Document"%>
<%@page import="entite.Historique_Echange"%>
<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeDevis" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>

        <title>Les Devis</title>
    </head>
    <body> 
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Afficher Les Devis</h1>
                    </div>


                    <p><%
                        String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></p>
                    <table class='table table-bordered'>
                        <thead>
                            <tr>
                                <th>Date debut</th>
                                <th>Date fin</th>
                                <th>Statut</th>
                                <th>Motif Refus</th>
                                <th>Date devis</th>
                                <th>Montant devis</th>
                                <th>Formulaire client</th>
                                <th>Facturation auto</th>
                                <th>Date intervention</th>
                                <th>Historique Consultants </th>
                                <th>Historique Question </th>
                                <th>Historique échanges</th>
                                <th>Historique documents</th>
                                <th>Le Client</th>
                                <th>L'offre</th>
                                <th>La prestation</th>
                            </tr>
                        </thead>
                        <% Devis cp = (Devis) request.getAttribute("Date_Intervention");
                            {%>
                        <tr>
                            <td width=15%><%=cp.getDate_Debut()%></td>
                            <td width=15%><%=cp.getDate_Fin()%></td>
                            <td width=15%><%=cp.getStatut()%></td>  
                            <td width=15%><%=cp.getMotif_Refus()%></td>
                            <td width=15%><%=cp.getDate_Devis()%></td>
                            <td width=15%><%=cp.getMontant_Devis()%></td>
                            <td width=15%><%=cp.getFormulaire_Client()%></td>
                            <td width=15%><%=cp.isFacturation_Auto()%></td>
                            <td width=15%><%=cp.getDate_Intervention()%></td>
                            <% List<Historique_Echange> lesHe = cp.getHistorique_Echanges();
                                for (Historique_Echange he : lesHe) {%>
                            <td width=15%><ul><li><a href="AccessVisualisation?action=recherchehistoriqueechangeld&id=<%=he.getId()%>"><%=he.getId()%></a></li></ul></td><%}%> 
                                        <% List<Historique_Document> lesHd = cp.getHistorique_Documents();
                                            for (Historique_Document hd : lesHd) {%>
                            <td width=15%><ul><li><a href="AccessVisualisation?action=recherchehistoriquedocumentld&id=<%=hd.getId()%>"><%=hd.getId()%></a></li></ul></td><%}%> 
                            <td width=15%><a href="AccessVisualisation?action=rechercheclientld&Nom_Utilisateur=<%=cp.getLeClient().getNom_Utilisateur()%>"><%=cp.getLeClient().getNom_Utilisateur()%></a></td>
                            <td width=15%><a href="AccessVisualisation?action=rechercheoffreld&Nom_Offre=<%=cp.getlOffre().getNom_Offre()%>"><%=cp.getlOffre().getNom_Offre()%></a></td>
                            <td width=15%><a href="AccessVisualisation?action=rechercheprestationld&Nom_Prestation=<%=cp.getLaPrestation().getNom_Prestation()%>"><%=cp.getLaPrestation().getNom_Prestation()%></a></td>            
                        </tr><%}%>  
                        <input type="hidden" value="afficherLeDevis" name="action">
                    </table>

                    <hr>
                    <td width=25%><a href="AccesUtilisateurHardis?action=afficherLeDevis"> Retour Menu </a></td>
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