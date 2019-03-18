<%-- 
    Document   : Menu_principal
    Created on : 15 mars 2019, 09:18:05
    Author     : 3133973
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.min.css"> 
        <link rel="stylesheet" href="MyStyle.css">        
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu Visisteur hardis</h1>
=
            <div class="container">
                <div class="col"> </div>
                <div class="col"><img src="Images/Logo_Hardis_Group.png" alt="" height="20%" width="30%"></div>
                         </div> 
        <div class="container-fluid">
            <div class="row">
                <div class="col-sm-2">   <a class="btn btn-primary" href="Accueil?action=Catalogue" role="button">Catalogue des services</a></div>
                <div class="col-sm-2">   <a class="btn btn-primary" href="Interface_question.jsp" role="button">Interface des questions</a></div>
                <div class="col-sm-2 ">   <a class="btn btn-primary" href="Contact.jsp" role="button">Faire une demande de contact</a></div>
                <div class="col-sm-1 offset-5 right">   <a class="btn btn-secondary" href="Connexion.jsp" role="button"> connexion</a></div>    
            </div>
        </div> 
       
          
    </body>
</html>
