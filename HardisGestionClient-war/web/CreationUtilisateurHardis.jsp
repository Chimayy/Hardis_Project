<%-- 
    Document   : CreationUtilisateurHardis
    Created on : 14 mars 2019, 13:49:48
    Author     : Utilisateur
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer un utilisateur</title>
    </head>
    <body>
        <h1>Créer un utilisateur</h1>
        <form method ="get" action="ServletAdmin">
            <div class="input1">
            </br>
                <input type ="text" placeholder='Nom' name="nom" class='input'/>
                <input type ="text" placeholder='Prénom'name="prenom" class='input'/>
                <input type ="text" placeholder='Mail' name="mail" class='input'/>
                <input type ="text" placeholder='Mot de passe' name="motdepasse" class='input'/>
                <input type ="text" placeholder='Plafond' name='plafond' classe='input' class='input'/></br>                
                </select></br>
                 <a> Profil Technique </a><select name="profil" size="1">
                    <option> administrateur
                    <option> gestionnaire
                    <option> visualisation        
                </select>
                <input type ="hidden" name="action" value="CreerUtilisateur">

            </div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
            <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
            </div>
            
        </form>
    </body>
</html>
