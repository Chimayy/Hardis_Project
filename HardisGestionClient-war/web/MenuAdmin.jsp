<%-- 
    Document   : MenuAdmin
    Created on : 14 mars 2019, 11:34:31
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu Administrateur</title>
    </head>
    <body>
        <h1>Menu Administrateur</h1>
        <p> 
        
        <div clas='menu'>  
            <div class="menubis"><a href ="ServletAdmin?action=AfficherUtilisateursHardis"> Gestion des utilisateurs Hardis </a></div>
            <div class="menubis"><a href ="CreationUtilisateurHardis.jsp"> Création utilisateur Hardis </a></div>
            <div class="menubis"><a href ="ServletAdmin?action=ModifierUtilisateur"> Modification utilisateur Hardis </a></div>
            </div>
        <div class="retour">
            <a href =""> Retour Auth </a>
        </div>
    </body>
</html>