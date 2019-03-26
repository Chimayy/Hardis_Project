<%-- 
    Document   : AfficherPrestation
    Created on : 18 mars 2019, 10:19:07
    Author     : 3096764
--%>

<%@page import="entite.Bon_De_Commande"%>
<%@page import="entite.Condition_Contractuelle"%>
<%@page import="entite.Livrable"%>
<%@page import="entite.Devis"%>
<%@page import="entite.Prestation"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listePrestation" scope="request" class="java.util.List"></jsp:useBean>
        <title>Les Prestations</title>
    </head>
    <body>
        <h1>Afficher Les Prestations</h1>
        <p><% 
            String attribut = (String) request.getAttribute("message");
            out.println(attribut);
            %></p>
        <table border width=50%>
            <tr>
                <td>Dates d'intervention devis </td>
                <td>Date fin</td>
                <td>Statut</td>
                <td>Motif Refus</td>
                <td>Date devis</td>
                <td>Montant devis</td>
                <td>Formulaire client</td>
                <td>Facturation auto</td>
                <td>Date intervention</td>
                <td>Historique échanges</td>
                <td>Historique documents</td>
                <td>Le Client</td>
                <td>L'offre</td>
                <td>La prestation</td>
            </tr>
            <% List<Prestation> lesDev=listePrestation;
                for(Prestation cp : lesDev){%>
                <tr>
                     <% List<Devis> lesDe=cp.getLesDevis();
                        for(Devis d : lesDe){%>
                    <td width=15%><ul><li><a href="AccessVisualisation?action=recherchedevis&DateIntervention=<%=d.getDate_Intervention()%>"><%=d.getDate_Intervention()%></a></li></ul></td><%}%>
                    <% List<Livrable> lesLi=cp.getLivrables();
                        for(Livrable l : lesLi){%>
                    <td width=15%><ul><li><a href=""><%=l.getType_Livrable()%></a></li></ul></td><%}%>
                    <% List<Condition_Contractuelle> lesCC=cp.getCondition_Contractuelles();
                        for(Condition_Contractuelle c : lesCC){%>
                    <td width=15%><ul><li><a href=""><%=c.getContenu_Condition()%></a></li></ul></td><%}%> 
                    <% List<Bon_De_Commande> lesBC=cp.getBon_De_Commandes();
                        for(Bon_De_Commande b : lesBC){%>
                    <td width=15%><ul><li><a href=""><%=b.getDescriptif_BonDeCommande()%></a></li></ul></td><%}%> 
                    <td width=15%><%=cp.getNom_Prestation()%></td>
                    <td width=15%><%=cp.getDescription_Prestation()%></td>
                    <td width=15%><%=cp.getCout_Prestation()%></td>
                    <td width=15%><%=cp.isFacturation_Frais_Inclus()%></td>
                    <td width=15%><a href="AccessVisualisation?action=rechercheservicep&Description_Service=<%=cp.getLeService().getDescription_Service()%>"><%=cp.getLeService().getDescription_Service()%></a></td>
                    <td width=15%><%=cp.getLieu_Intervention()%></td>
                    <td width=15%><%=cp.getnom_Prestation()%></td>
                    <td width=15%><%=cp.getdescription_Prestation()%></td>
                    <td width=15%><%=cp.getNom_Responsable()%></td>
                    <td width=15%><%=cp.getTel_Responsable()%></td>  
                    <td width=15%><%=cp.getMail_Responsable()%></td>
                    <td width=15%><%=cp.getcout_Prestation()%></td>
                    <td width=15%><%=cp.isfacturation_Frais_Inclus()%></td>
                    <td width=15%><%=cp.getDelai_Relance()%></td>
                     
                </tr><%}%>  
                <input type="hidden" value="afficherPrestation" name="action">
        </table>
        <hr>
    <td width=25%><a href="AccessVisualisation?action=afficherPrestation"> Retour Menu </a></td>
    <hr>
    </br>
    <a href="/MenuVisualisation">Retour</a>
    </body>
</html>
