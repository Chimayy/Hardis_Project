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
          <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/bootstrap.min.css"> 
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/mdb.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/Style/MyStyle.css">
        <title>JSP Page</title>
    </head>
    <body>
        <header>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <!--                   <img src="Images/Logo_Hardis_Group.png" class="rounded mx-auto d-block" alt="" max-height="10%" width="10%">  -->
                        <div class="navbar-brand"> <h1> HARDIS </h1> </div>
                    </div>
                    <div>
                        <!--                    <div class="col right"><a  href="Connexion.jsp" > <img src="Images/person-3x.png" alt=""></a></div> -->
                        <div class="dropdown">
                            <div class="btn-group">
                                <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    connexion
                                </button>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <div class="container">
                                        <form method="get" action="authentification">
                                            <fieldset>
                                                <h1>Connexion</h1>
                                                <label for="login"> Login <span class="requis">*</span></label>
                                                <input type="text" name="login" value="" size="20" maxlength="20"/>
                                                <br/>
                                                <label for="pass"> Pass <span class="requis">*</span></label>
                                                <input type="text" name="pass" value="" size="20" maxlength="20"/>
                                                <br/>           
                                            </fieldset>
                                              <input type="submit" value="Valider"/>
                                            <input type="reset" value="Remettre à zéro"/><br/>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>  
                    </div>
                </div>
            </nav>
        </header>
        <h1>Demande de contact</h1>
        <form method="get" action="demandeContact">
            <fieldset>
                <h1>Formulaire de demande de contact</h1>
                <label for="nom"> Nom <span class="requis">*</span></label>
                <input type="text" name="nom" value="" size="20" maxlength="20"/>
                <br/>
                <label for="prenom"> Prenom <span class="requis">*</span></label>
                <input type="text" name="prenom" value="" size="20" maxlength="20"/>
                <br/>
                <label for="numtel"> Numéro de de téléphone <span class="requis">*</span></label>
                <input type="text" name="numtel" value="" size="20" maxlenght="20"/>
                <br/>
                <label for="noment"> Nom de votre entreprise <span class="requis">*</span></label>
                <input type="text" name="noment" value="" size="20" maxlenght="20"/>
                <br/>
                <label for="objdemande"> Objet de la demande <span class="requis">*</span></label>
                <input type="text" name="objdemande" value="" size="20" maxlenght="20"/>
                <br/>
                <label for="demande"> Demande <span class="requis">*</span></label>
                <input type="text" name="demande" value="" size="20" maxlenght="400"/>
                <br/>               
            </fieldset>
              <input type="submit" value="Valider"/>
            <input type="reset" value="Remettre à zéro"/><br/>
        </form>
    </body>
</html>
