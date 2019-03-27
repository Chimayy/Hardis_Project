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
        <%@include file="jsp_reused/style.jsp"%>
        <title>Créer une offre</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Créer une offre</h1>
                    </div>

                    <form method ="get" action="ServletAdmin">
                        <div class="form-group">
                            <label for="Nom">Nom </Label>
                            <input type ="text" name="nom" class='form-control'>
                        </div>
                        <div class="form-group">
                            <label for='description'> Description </label>
                            <input type ="text" name="description" class='form-control'>                           
                        </div>

                        <input type ="hidden" name="action" value="CreerOffre">                      
                        <input  class='btn btn-indigo' type="submit" value="Valider">
                        <input  class='btn btn-indigo' type="reset" value="Effacer">       


                        <hr class="my-6">
                        <a class="btn btn-outline-teal right" href="ServletAdmin" value="retour"> Retour </a>  
                    </form>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <%@include file="jsp_reused/javascript.jsp"%>
    </body>
</html>