<%-- 
    Document   : DetailClient
    Created on : 15 mars 2019, 11:13:43
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Utilisateur"%>
<%@page import="entite.statut_Devis"%>
<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page import="entite.Devis"%>
<%@page import="entite.Client"%>
<%@page import="entite.Prestation"%>
<%@page import="entite.Historique_Consultant"%>
 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="Client" scope="request" class="entite.Client"></jsp:useBean>
        <jsp:useBean id="User" scope="session" class="Utilisateur_Hardis"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Detail du Client</title>
    </head>
    <body>
        <% Client c = Client;
        Utilisateur_Hardis u = User;%>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Detail du client <%=c.getNom_Utilisateur()%></h1>
                        <hr class="my-6">
                    </div>

                    <table class='table table-bordered'>

                        <thead>
                            <tr> 
                                <th>Nom</th>
                                <th>Prenom</th>
                            </tr>
                        </thead>
                        <tr>
                            
                            <td width=15%><%=c.getNom_Utilisateur()%></td>
                            <td width=15%><%=c.getPrenom_Utilisateur()%></td> 
                            <% List<Devis> ListeDevis = c.getLesDevis(); 
                                for (Devis d : ListeDevis) {
                                    
                                    List<Historique_Consultant> L1 = d.getHistorique_Consultants();
                                 for(Historique_Consultant LHS : L1){
                                     if(LHS.getLeConsultant().getId()== u.getId()){
                                %>
                        </tr>
                    </table>

                    <table class='table table-border'>
                        <thead class='thead-light'>
                            <tr>
                                <th>Devis n</th>
                                <th>Montant</th>
                                <th>Statut</th>
                                <th>Offre</th>
                                <th>Action </th>
                            </tr>
                        </thead>

                        <tr>
                            <td width=15%><%=d.getId()%></td>
                            <td width=15%><%=d.getMontant_Devis()%></td> 
                            <td width=15%><%=d.getStatut()%></td> 
                            <td width=15%><%=d.getlOffre().getNom_Offre()%></td>
                            <%if (d.getStatut() == statut_Devis.a_traiter) {%>
                            <td width=15%><a style='color:orange' href="AcceuilGestionnaire?action=DetailDevis&x=<%=d.getId()%>">Editer/Envoyer</a></td><%}%>
                            <%if (d.getStatut() == statut_Devis.en_negociation) {%>
                            <td width=15%><a style='color:green' href="AcceuilGestionnaire?action=DetailDevis&x=<%=d.getId()%>">Validation devis</a></td><%}%>
                            <%if (d.getStatut() == statut_Devis.incomplet) {%>
                            <td width=15%><a style='color:red' href="AcceuilGestionnaire?action=DetailDevis&x=<%=d.getId()%>">Reviser le devis</a></td><%}%>
                            <%if (d.getStatut() == statut_Devis.refuse || d.getStatut() == statut_Devis.envoye||d.getStatut() == statut_Devis.a_negocier) {%>
                            <td width=15%>Aucune action disponible pour ce devis</td><%}%>
                            <%if (d.getStatut() == statut_Devis.valide) {%>
                            <td width=15%>Devis validé! Bientôt la promotion</td><%}%>
                        </tr><%}%> <%}%> <%}%>     
                    </table>
                     <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="AcceuilGestionnaire?action=VisuClients" value="retour"> Retour </a>
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>  
        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>  
    </body>
</html>
