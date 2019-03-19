<%-- 
    Document   : DemandeDevis
    Created on : 15 mars 2019, 14:47:08
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
        <h1>Hello World!</h1>
        <form method="get" action="ServletClient">
            <fieldset>
                <legend>Informations Arbitre</legend>
                <label for="zoneLibre"> zone libre</label>
                <input type="text" name="zoneLibre" value="" size="20" maxlength="20"/>
                <br/>
                <label for="idService"> idService</label>
                <input type="text" name="idService" value="" size="80" maxlength="80"/>
                <br/>

                <input type="hidden" name="action" value="changerDevis">
            </fieldset>
            <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
              <td width=25%><a href="MenuClient.jsp"> Retour Menu </a></td>
    </body>
</html>
