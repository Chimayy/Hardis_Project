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
        <link rel="stylesheet" href="mdb.min.css">
        <title>JSP Page</title>
    </head>
    <body>
     

            <div class="container">
                <div class="col"><img src="Images/Logo_Hardis_Group.png" class="rounded mx-auto d-block" alt="" height="20%" width="30%"></div>   
                <div class="col"><a  href="Connexion.jsp" > <img src="Images/person-3x.png" alt=""></div>
            </div>
           

          
            <div class="container-fluid">
                <div class="row">
                    <div class="col-sm"> 
                        <div class="view overlay">
                            <a href="Accueil?action=Catalogue"><img src="Images/catalogue.jpg" class="img-thumbnail " alt=""></a>    
                                <div class="mask flex-center rgba-white-strong"> 
                                    <h2>Catalogue</h2>
                                </div>
                        </div>    
                    </div>
                    <div class="col-sm col-md  ">
                        <div class="view overlay">
                            <a href="Interface_question.jsp"><img src="Images/question.jpg"class="img-thumbnail " alt="" ></a> 
                                <div class="mask flex-center rgba-white-strong"> 
                                    <h2>Interface Question</h2>
                                </div>
                        </div>
                    </div>   
                    <div class="col-sm">
                        <a href="Contact.jsp">
                            <div class="view overlay">
                                <img src="Images/contact.jpg"class="img-thumbnail" alt="">
                                <div class="mask flex-center rgba-white-strong"> 
                                    <h2><span class=black> Nous Contacter </span></h2>
                            </div>
                        </a>
                    </div>
                </div> 
            </div>

    </body>
</html>
