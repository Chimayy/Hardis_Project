
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
                    <h1>Créer une agence</h1>
                    <hr class="my-6">
                    <form method ="get" action="ServletAdmin">                       
                    <form method ="get" action="ServletAdmin">
                      
                        <div class="form-group">
                            <label for="Pays"> Pays </label>
                            <input type ="text"  name="pays" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="Adresse"> Adresse </label>
                            <input type ="text"  name="adresse" class='form-control'/>
                        </div>
                        <div class="form-group">

                            <label for="cp"> Code Postal </label>
                            <input type ="text"  name="cp" class='form-control'/>
                        </div>
                        <div class="form-group">

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

                    </form>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <%@include file="jsp_reused/javascript.jsp"%>
    </body>

</html>
