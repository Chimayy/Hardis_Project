<%-- 
    Document   : listDevisEnvoye
    Created on : 22 mars 2019, 16:08:07
    Author     : thoma
--%>

<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listDevis" scope="request" class="java.util.List"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <table border width=50%>
            <tr> 
                <td>Numero</td>
                <td>Statut</td>
            </tr>
            <% List<Devis> lesDevis=listDevis;
                for(Devis devisEnCours : lesDevis){%>
                <tr>
                    <td width=15%><%=devisEnCours.getId()%></td>
                    <td width=15%><%=devisEnCours.getStatut() %></td>
                <td><a href="ServletClient?action=choixDateDevis&idDevis=<%=devisEnCours.getId()%>">voir + </a></td>
                
                </tr><%}%>     
        </table>
        <hr>
    <td width=25%><a href="MenuClient.jsp"> Retour Menu </a></td>
    <hr>
    </body>
</html>
