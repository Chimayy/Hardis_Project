<%-- 
    Document   : CreationAgence
    Created on : 19 mars 2019, 10:21:27
    Author     : Utilisateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="jsp_reused/style.jsp"%>
        <title>Créer une agence</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>
                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Menu Administrateur</h1>
                    </div>

                    <hr class="my-6">
                    <h1>Créer une entreprise</h1>
                    <hr class="my-6">
        
        <form method ="get" action="ServletAdmin">
            
                <input type ="text" placeholder='Code postal' name="cp" class='form-control'/>
                <input type ="text" placeholder='Pays'name="pays" class='input'/>
                <input type ="text" placeholder='Adresse' name="adresse" class='input'/>
                <input type ="text" placeholder='Ville' name="ville" classe='input'/>
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
                </div>
            </div>
                <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <%@include file="jsp_reused/javascript.jsp"%>
    </body>
</html>