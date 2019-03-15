<%-- 
    Document   : Contact
    Created on : 15 mars 2019, 10:19:35
    Author     : 3133973
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Demande de contact</h1>
        <form method="get" action="demandeContact">
            <fieldset>
                <h1>Formulaire de demande de contact</h1>
                <label for="nom"> Nom <span class="requis">*</span></label>
                <input type="text" name="nom" value="" size="20" maxlength="20"/>
                <br/>
                <label for="prenom"> Prenom <span class="requis">*</span></label>
                <input type="text" name="prenom" value="" size="20" maxlength="20"/>
                <br/>
                <label for="numtel"> Numéro de de téléphone <span class="requis">*</span></label>
                <input type="text" name="numtel" value="" size="20" maxlenght="20"/>
                <br/>
                <label for="noment"> Nom de votre entreprise <span class="requis">*</span></label>
                <input type="text" name="noment" value="" size="20" maxlenght="20"/>
                <br/>
                <label for="objdemande"> Objet de la demande <span class="requis">*</span></label>
                <input type="text" name="objdemande" value="" size="20" maxlenght="20"/>
                <br/>
                <label for="demande"> Demande <span class="requis">*</span></label>
                <input type="text" name="demande" value="" size="20" maxlenght="400"/>
                <br/>               
            </fieldset>
              <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
    </body>
</html>
