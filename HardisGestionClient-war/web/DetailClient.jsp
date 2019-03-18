<%-- 
    Document   : DetailClient
    Created on : 15 mars 2019, 11:13:43
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>
<%@page import="entite.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="Client" scope="request" class="Client"></jsp:useBean>
        <title>Detail du Client</title>
    </head>
    <body>
    <%  
        String nom = Client.getNom_Utilisateur();%>
        <h1>Detail du client <%=nom%> </h1>
        
        <table border width=50%>
            <tr> 
                
                <td>id</td>
                <td>Nom</td>
                <td>Prenom</td>
                <td>Devis</td>
                
            </tr>
            
                <tr>
                         
                                                         
                    <td width=15%><%=Client.getId()%></td>
                    <td width=15%><%=Client.getNom_Utilisateur()%></td>
                    <td width=15%><%=Client.getPrenom_Utilisateur()%></td>  
                    <% List<Devis> ListeDevis = Client.getLesDevis();
                        for (Devis d : ListeDevis){%>
                        <td>id</td>
                        <td>Date</td>
                        <td>Montant</td>
                        <td>Statut</td> </tr><tr>  
                    <td width=15%><%=d.getId()%></td>
                    <td width=15%><%=d.getDate_Devis()%></td>
                    <td width=15%><%=d.getMontant_Devis()%></td>
                    <td width=15%><%=d.getStatut()%></td></tr>
                    <%}%>
                     
                   
                    </tr>
                                  
                </tr>    
                
        </table>
    
        
    </body>
</html>
