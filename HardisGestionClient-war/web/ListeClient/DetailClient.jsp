<%-- 
    Document   : DetailClient
    Created on : 15 mars 2019, 11:13:43
    Author     : Mathieu Harmand
--%>

<%@page import="entite.statut_Devis"%>
<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page import="entite.Devis"%>
<%@page import="entite.Client"%>
<%@page import="entite.Prestation"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <jsp:useBean id="Client" scope="request" class="entite.Client"></jsp:useBean>
         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Detail du Client</title>
    </head>
    <body>
        <% Client c = Client;%>
        
        <h1>Detail du client <%=c.getNom_Utilisateur()%></h1>
     <table border width=50%>
            <tr> 
                
                <td>Nom</td>
                <td>Prenom</td>
                
                                
            </tr>
            
                <tr>
                    
                    <td width=15%><%=c.getNom_Utilisateur()%></td>
                    <td width=15%><%=c.getPrenom_Utilisateur()%></td> 
                    
                      
                    
                    <% List <Devis> ListeDevis = c.getLesDevis();
                         for(Devis d : ListeDevis){%>
                    </tr>
                            </table>
                
                <table border width=50%>
                <td>Devis n</td>
                <td>Montant</td>
                <td>Statut</td>
                <td>Offre</td>
                <td>Action </td>
                
                <tr>
                    <td width=15%><%=d.getId()%></td>
                    <td width=15%><%=d.getMontant_Devis()%></td> 
                    <td width=15%><%=d.getStatut()%></td> 
                    <td width=15%><%=d.getlOffre().getNom_Offre()%></td>
                    <%if(d.getStatut()== statut_Devis.a_traiter) {%>
                    <td width=15%><a href="AcceuilGestionnaire?action=DetailDevis&x=<%=d.getId()%>">Editer/Envoyer</a></td><%}%>
                    <%if(d.getStatut()== statut_Devis.en_negociation) {%>
                    <td width=15%><a href="AcceuilGestionnaire?action=Validerdevis&x=<%=d.getId()%>">Validation devis</a></td><%}%>
                   <%if(d.getStatut()== statut_Devis.incomplet) {%>
                    <td width=15%><a href="AcceuilGestionnaire?action=DetailDevis&x=<%=d.getId()%>">Reviser le devis</a></td><%}%>
                    <%if(d.getStatut()== statut_Devis.refuse||d.getStatut()==statut_Devis.envoye) {%>
                    <td width=15%>Aucune action disponible pour ce devis</td><%}%>
                    <%if(d.getStatut()== statut_Devis.valide) {%>
                    <td width=15%>Devis validé! Bientôt la promotion</td><%}%>
                
                                        
                </tr><%}%>     
        </table>
        
    </body>
</html>
