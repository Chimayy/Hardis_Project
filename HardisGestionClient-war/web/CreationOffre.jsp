<%-- 
    Document   : CreationOffre
    Created on : 20 mars 2019, 09:09:42
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer une offre</title>
    </head>
    <body>
        <h1>Créer une offre</h1>
        <form method ="get" action="ServletAdmin">
                <input type ="text" placeholder='Nom' name="nom" class='input'>
                <input type ="text" placeholder='Description'name="description" class='input'> 
                <div class="input1">
                <input type ="hidden" name="action" value="CreerOffre">
            </div>
            <div class='bouton1'>
            <br/>
            <input  class='bouton' type="submit" value="Valider">
            <input  class='bouton'type="reset" value="Effacer">       
            </div>
            <br/>
            <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
            </div>   
        </form>
    </body>
</html>