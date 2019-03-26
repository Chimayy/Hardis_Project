<<<<<<< HEAD
<<<<<<< HEAD

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
=======

=======
>>>>>>> exiless6
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

<<<<<<< HEAD
                    <form method ="get" action="ServletAdmin">                       
=======
                    <form method ="get" action="ServletAdmin">
                        <div class="form-group">
                            <label for="cp"> Code Postal </label>
                            <input type ="text"  name="cp" class='form-control'/>
                        </div>
>>>>>>> exiless6
                        <div class="form-group">
                            <label for="Pays"> Pays </label>
                            <input type ="text"  name="pays" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="Adresse"> Adresse </label>
                            <input type ="text"  name="adresse" class='form-control'/>
                        </div>
                        <div class="form-group">
<<<<<<< HEAD
                            <label for="cp"> Code Postal </label>
                            <input type ="text"  name="cp" class='form-control'/>
                        </div>
                        <div class="form-group">
=======
>>>>>>> exiless6
                            <label for="Ville"> Ville </label>
                            <input type ="text"  name="ville" class='form-control'/>
                        </div>
                        <div class="input1">
                            <input type ="hidden" name="action" value="CreerAgence">
                        </div>
                        
                            <input  class='btn btn-indigo' type="submit" value="Valider"/>
                            <input  class='btn btn-indigo' type="reset" value="Effacer"/>       
                        <hr class="my-6">
                       
                            <a class="btn btn-outline-teal right" href ="MenuAdmin.jsp"> Retour Menu </a>
<<<<<<< HEAD
=======
                       

>>>>>>> exiless6
                    </form>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <%@include file="jsp_reused/javascript.jsp"%>
    </body>
<<<<<<< HEAD
>>>>>>> origin/backup2mastercopy2beforthomasMerge123
</html>
=======
=======
<%-- 
    Document   : CreationAgence
    Created on : 19 mars 2019, 10:21:27
    Author     : Utilisateur
--%>

>>>>>>> exiless6
