
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer une agence</title>
    </head>
    <body>
        <h1>Créer une agence</h1>
        <form method ="get" action="ServletAdmin">
                <input type ="text" placeholder='Code postal' name="cp" class='input'/>
                <input type ="text" placeholder='Pays'name="pays" class='input'/>
                <input type ="text" placeholder='Adresse' name="adresse" class='input'/>
                <input type ="text" placeholder='Ville' name="ville" classe='input' class='input'/><br/>    
                <div class="input1">
                <input type ="hidden" name="action" value="CreerAgence">
            </div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Effacer"/>       
            </div>
            </br>
            <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
            </div>
            
        </form>
    </body>
</html>