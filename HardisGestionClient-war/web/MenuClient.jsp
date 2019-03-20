<%-- 
    Document   : MenuClient
    Created on : 15 mars 2019, 11:46:59
    Author     : thoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <%@include file="jsp_reused/style.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
    
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                     <%@include file="jsp_reused/header.jsp" %>
                </header>
        
                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                            <h1>Menu Client</h1>
                        </div>

                        <hr class="my-6">
                        <div class="row">
                            <div class="col-4"><a class="btn btn-secondary" style="padding:15%" href="DemandeDevis.jsp">Demander un devis</a><br></div>
                            <div class="col-4"><a class="btn btn-secondary" style="padding:15%"href="ServletClient?action=visuDevis">Visualiser un formulaire</a><br></div>
                            <div class="col-4"><a class="btn btn-secondary" style="padding:15%"href=""> faire d'autres trucs</a></div>
                        </div>
                </div>
            </div>    
        <%@include file="jsp_reused/footer.jsp"%>
     </div>
        
        <!--pages de script-->
        <%@include file="jsp_reused/javascript.jsp"%>
    </body>
</html>
