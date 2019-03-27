<%-- 
    Document   : Catalogue_service
    Created on : 15 mars 2019, 09:28:56
    Author     : 3133973
--%>

<%@page import="entite.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="listeServ" scope="request" class="java.util.List"></jsp:useBean> 
        <%@include file="jsp_reused/style.jsp"%>     
        <title>Services</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>
                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Visiteur</h1>
                    </div>

                    <hr class="my-6">
                    <h1>Catalogue des services</h1>
                    <hr class="my-6">

                    <form method ="get" action="Accueil" class='form-inline'>
                        <label for='nom' style='padding-right:5px   '> Recherche </label>
                        <input type ="text" placeholder='Nom' name="nom" class='form-control'/>
                        <input class='btn btn-secondary' type="submit" value="Valider"/>
                        <input type ="hidden" name="action" value="RechercherService">
                    </form>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Description</th>
                                <th>Coût du service</th>
                                <th>Offre</th>
                            </tr>
                        </thead>
                        <% List<Service> lesServ = listeServ;
                            for (Service serv : lesServ) {%>
                        <tr>
                            <td Width=15%><%=serv.getNom_Service()%></td>
                            <td Width=15%><%=serv.getDescription_Service()%></td>
                            <td Width=15%><%=serv.getCout_Service()%></td>
                            <td Width=15%><%=serv.getlOffre().getNom_Offre()%></td> 
                            <%}%>
                        </tr>
                    </table>
                    <hr class="my-6">
                    <form method="get" action="Accueil">
                    <input type ="hidden" name="action" value="vide">
                    <input class="btn btn-outline-teal right" type="submit" value="Retour">
                    </form>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>

    </body>
</html>