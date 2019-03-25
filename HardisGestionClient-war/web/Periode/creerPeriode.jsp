<%-- 
    Document   : creerPeriode
    Created on : 25 mars 2019, 09:15:18
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
        <h1>Creer date de disponibilité</h1>
        <form method="get" action="AcceuilGestionnaire">
            <input type="date" name="dateDebut" placeholder="date début"/>
            <input type="date" name="dateFin" placeholder="date fin"/>
            <input type="submit" name="Valider"/>
            <input type="hidden" name="action" value="creationDispo">
        </form>
    </body>
</html>
