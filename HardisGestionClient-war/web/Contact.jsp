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
       <%@include file="jsp_reused/style.jsp"%>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>
                <div class="container">
                    <form method="get" action="ServletVisiteur">
                        <fieldset>
                            <div  style=" margin-top:1%;margin-bottom: 1%">
                                <h1>Formulaire de demande de contact</h1>
                            </div>
                            <hr class="my-6">
                            <div class="form-group">
                                <label for="nom"> Nom <span class="requis">*</span></label>
                                <input type="text" class="form-control" name="nom" value="" size="20" maxlength="20"/>
                            </div>
                            <div class="form-group">
                                <label for="prenom"> Prenom <span class="requis">*</span></label>
                                <input type="text" class="form-control" name="prenom" value="" size="20" maxlength="20"/>
                            </div>
                            <div class="form-group">
                                <label for="numtel"> Numéro de de téléphone <span class="requis">*</span></label>
                                <input type="text"class="form-control" name="numtel" value="" size="20" maxlenght="20"/>
                            </div>
                            <div class="form-group">
                                <label for="noment"> Nom de votre entreprise <span class="requis">*</span></label>
                                <input type="text"class="form-control" name="noment" value="" size="20" maxlenght="20"/>
                            </div>
                            <div class="form-group">
                                <label for="objdemande"> Objet de la demande <span class="requis">*</span></label>
                                <input type="text"class="form-control" name="objdemande" value="" size="20" maxlenght="20"/>
                            </div>
                            <div class="form-group">
                                <label for="demande"> Demande <span class="requis">*</span></label>
                                <textarea type="text"class="form-control" name="demande" value="" rows="4"/></textarea>
                            </div>

                        </fieldset>
                        <input class="btn btn-secondary" type="submit" value="Valider"/>
                        <input class="btn btn-secondary" ype="reset" value="Remettre à zéro"/><br/>
                        <input class=""
                    </form>
                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="Menu_principal.jsp" value="retour"> Retour </a> 
                </div>
            </div>
        </div>
    
<!--                footer-->
                <%@include file="jsp_reused/footer.jsp"%>
        </div>
                 <%@include file="jsp_reused/javascript.jsp"%>
    </body>
</html>
