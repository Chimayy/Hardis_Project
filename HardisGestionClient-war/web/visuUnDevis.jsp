<%-- 
    Document   : visuUnDevis
    Created on : 18 mars 2019, 11:07:28
    Author     : thoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entite.Devis"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="devis" scope="request" class="entite.Devis"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
      <% devis.getStatut();%>
    </body>
</html>
