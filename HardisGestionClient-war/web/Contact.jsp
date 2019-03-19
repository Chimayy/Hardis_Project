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
                        <div class="navbar-brand"> <a href="Menu_principal.jsp" style="color: black"><h1> HARDIS </h1></a> </div>
                    </div>
                    <div>
                        <!--                    <div class="col right"><a  href="Connexion.jsp" > <img src="Images/person-3x.png" alt=""></a></div> -->
                        <div class="dropdown">
                            <div class="btn-group">
                                <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    connexion
                                </button>
                                <div class="dropdown-menu dropdown-menu-right">
                                    <form method="get" action="authentification" class="container">
                                        <fieldset >
                                            <h1>Connexion</h1>
                                            <div class="form-group">
                                                <label for="login"> Login <span class="requis">*</span></label>
                                                <input type="text" class="form-control" name="login" value="" size="20" maxlength="20"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="pass"> Pass <span class="requis">*</span></label>
                                                <input type="password" class="form-control" name="pass" value="" size="20" maxlength="20"/>
                                            </div>
                                            <br/>           
                                        </fieldset>
                                          <input class="btn btn-secondary" type="submit" value="Valider"/>
                                        <input class="btn btn-secondary" type="reset" value="Remettre à zéro"/><br/>
                                    </form>
                                </div>
                            </div>
                        </div>  
                    </div>
                </div>
            </nav>
       
        
        </header>
        <div class="container">
            <form method="get" action="demandeContact">
                <fieldset>
                    <div  style=" margin-top:1%;margin-bottom: 1%">
                        <h1>Formulaire de demande de contact</h1>
                    </div>
                     <hr class="my-6">
                    <div class="form-group">
                        <label for="nom"> Nom <span class="requis">*</span></label>
                        <input type="text"class="form-control" name="nom" value="" size="20" maxlength="20"/>
                    </div>
                    <div class="form-group">
                        <label for="prenom"> Prenom <span class="requis">*</span></label>
                        <input type="text"class="form-control" name="prenom" value="" size="20" maxlength="20"/>
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
            </form>
        </div>
    </body>
</html>
