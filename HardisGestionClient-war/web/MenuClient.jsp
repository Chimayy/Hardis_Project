<%-- 
    Document   : MenuClient
    Created on : 15 mars 2019, 11:46:59
    Author     : thoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu Client</h1>
        <%
               String attribut = (String) request.getAttribute("message");
               out.println(attribut);
           %>
        <a href="DemandeDevis.jsp">Demander un devis</a><br>
        <a href="ServletClient?action=visuDevis">Visualiser un formulaire</a><br>
        <a href=""> faire d'autres trucs</a>
    </body>
</html>
