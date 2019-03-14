<%-- 
    Document   : VisuClient
    Created on : 14 mars 2019, 15:12:48
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Client"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="ListeClient" scope="request" class="java.util.List"></jsp:useBean>
        <title>Visualisation Client</title>
    </head>
    <body>
        <h1>Visualisation Client</h1>
        <table border width=50%>
            <tr> 
                <td>Nom</td>
                <td>Prenom</td>
                <td>mail</td>
                <td>Entrepris</td>
            </tr>
            <% List<Client> lesCli = ListeClient;
                for(Client c : lesCli){%>
                <tr>
                    <td width=15%><%=c.getNom_Utilisateur()%></td>
                    <td width=15%><%=c.getPrenom_Utilisateur()%></td>
                    <td width=15%><a href="AcceuilGestionnaire?action=DetailClient">Voir </a></td>
                    
                </tr><%}%>     
        </table>
    </body>
</html>