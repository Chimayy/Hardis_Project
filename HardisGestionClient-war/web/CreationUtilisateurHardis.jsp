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
        <%@include file="jsp_reused/style.jsp" %>
        <title>Créer un utilisateur</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Créer utilisateur</h1>
                    </div>

                    <form method ="get" action="ServletAdmin">
                        <div class="form-group">
                            <label for="nom"> Nom <span class="requis">*</span></label>
                            <input type ="text" class="form-control" name="nom" class='input'/>
                        </div>
                        <div class="form-group">
                            <label for="nom"> Prenom <span class="requis">*</span></label>
                            <input type ="text" class="form-control" name="prenom" class='input'/>
                        </div>
                        <div class="form-group">
                            <label for="nom"> Mail <span class="requis">*</span></label>
                            <input type ="text" class="form-control"  name="mail" class='input'/>
                        </div>
                        <div class="form-group">
                            <label for="nom"> Mot de passe <span class="requis">*</span></label>
                            <input type ="text" class="form-control"  name="motdepasse" class='input'/>
                        </div>
                        <div class="form-group">
                            <label for="nom"> Plafond de délégation <span class="requis">*</span></label>
                            <input type ="text" class="form-control"  name='plafond' classe='input' class='input'/>
                        </div> 
                            <a> Profil Technique </a>
                            <select class="custom-select mr-sm-2"name="profil" size="1">
                                <option> administrateur
                                <option> gestionnaire
                                <option> visualisation        
                            </select>
                            <input  type ="hidden" name="action" value="CreerUtilisateur">

                       
                        <div class='bouton1'>
                            </br>
                            <input  class='btn btn-indigo' type="submit" value="Valider"/>
                            <input  class='btn btn-indigo'type="reset" value="Remise à 0"/>       
                        </div>
                            </br>
                            <hr class="my-6">
                            <a class="btn btn-outline-teal right" href="MenuAdmin.jsp" value="retour"> Retour </a> 


                    </form>
                </div>
            </div>
                <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>