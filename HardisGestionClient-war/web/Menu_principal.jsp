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
            </nav>
        </header>
        
        <div class="container"> 
            <div class="col-12 center"><h1> Menu utilisateur </h1></div>
            <hr class="my-6">
        </div>

        <div class="container">
            <div class="row">
                <div class="col-sm"> 
                    <a href="Accueil?action=Catalogue" style ="color:black">
                        <div class="view overlay">
                            <img src="Images/catalogue.jpg" class="img-thumbnail " alt="">    
                            <div class="mask flex-center rgba-white-strong"> 
                                <h2>Catalogue</h2>
                            </div>
                         </a>
                    </div>
                </div>
                <div class="col-sm col-md  ">
                    <a href="Interface_question.jsp" style ="color:black">
                        <div class="view overlay">
                            <img src="Images/question.jpg"class="img-thumbnail " alt="" >
                            <div class="mask flex-center rgba-white-strong"> 
                                <h2>Interface Question</h2>
                            </div> 
                    </a>
                </div>

            </div>   
            <div class="col-sm">
                <a href="Contact.jsp" style="color:black">
                    <div class="view overlay">
                        <img src="Images/contact.jpg"class="img-thumbnail" alt="">
                        <div class="mask flex-center rgba-white-strong"> 
                            <h2> Nous Contacter </h2>
                        </div>
                </a>
            </div>
        </div> 
    </div>
   
<!--pages de script-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/Style/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/Style/bootstrap.bundle.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/Style/bootstrap.min.js"></script>
</body>
</html>
