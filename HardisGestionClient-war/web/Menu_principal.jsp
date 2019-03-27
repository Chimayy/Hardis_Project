
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="entite.Utilisateur"%>
<%@page import="session.gestionVisiteur"%>
<%@page import="session.gestionVisiteurLocal"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
        <jsp:useBean id="UserARecup" scope="session" class = "entite.Utilisateur"> </jsp:useBean>
                     <jsp:useBean id="listUser" scope="session" class = "java.util.List"> </jsp:useBean>
        <title>JSP Page</title>
=======

        <title>Menu principal</title>
>>>>>>> schellen4
    </head>
    <%@include file="jsp_reused/style.jsp" %>

    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    
                    <% 
                        List<Utilisateur> listeUser = listUser;
                        entite.Utilisateur user = UserARecup;
                    
    if (!listeUser.contains(user)){%>
                    <%@include file="jsp_reused/header.jsp" %>
                    <%}
if(listUser.contains(user)){%>
<%@include file="jsp_reused/header_deconnexion.jsp" %><%}%>
            
                    
                </header>

                <div class="container "> 
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Menu Principal</h1>
                    </div>
                    <hr class="my-6">
                </div>

                <div class="container">
                    <div class="row">
                        <div class="col-sm-6 col-md-4 col-xl-4" > 
                            <a href="Accueil?action=Catalogue" style ="color:black">
                                <div class="view overlay">
                                    <img src="Images/catalogue.jpg" class="img-thumbnail " alt="">    
                                    <div class="mask flex-center rgba-white-strong"> 
                                        <h2>Catalogue</h2>
                                    </div>
                            
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-4 col-xl-4 ">
                        <a href="Accueil?action=CreationQuestionPublique" style ="color:black">
                            <div class="view overlay">
                                <img src="Images/question.jpg"class="img-thumbnail " alt="" >
                                <div class="mask flex-center rgba-white-strong"> 
                                    <h2>Interface Question</h2>
                                </div> 
                        </a>
                    </div>

                </div>   
                <div class="col-sm-6 col-md-4 col-xl-4">
                    <a href="Contact.jsp" style="color:black">
                        <div class="view overlay">
                            <img src="Images/contact.jpg"class="img-thumbnail" alt="">
                            <div class="mask flex-center rgba-white-strong "> 
                                <h2> Nous Contacter </h2>
                            </div>
                    </a>
                </div>
            </div> 
            <div class="mx-auto col-sm-6 col-md-4 col-xl-4">
                <a href="Accueil?action=demandeClient" style="color:black">
                    <div class="view overlay">
                        <img src="Images/compte.jpg"class="img-thumbnail" alt="">
                        <div class="mask flex-center rgba-white-strong "> 
                            <h2> Créer un compte </h2>
                        </div>
                </a>
            </div>
        </div> 
    </div>
                      <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="/Menu_Principal.jsp" value="retour"> Retour </a>
                    <div class="message">
                        </div>
</div>
</div>

<%@include file="jsp_reused/footer.jsp"%>
</div>

<!--pages de script String attribut = (String) request.getAttribute("message");
                    if(!attribut.equals(""))    
                    {
                        out.println(attribut);
                    }
                        %>-->
<%@include file="jsp_reused/javascript.jsp"%>
</body>
</html>
