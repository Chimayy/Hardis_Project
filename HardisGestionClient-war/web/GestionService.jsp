<%-- 
    Document   : GestionService
    Created on : 19 mars 2019, 14:56:51
    Author     : Utilisateur
--%>

<%@page import="entite.Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <h1>Menu Administrateur</h1>
                    </div>

                    <hr class="my-6">
                    <h1>Liste des services</h1>
                    <hr class="my-6">

                    <form method ="get" action="ServletAdmin" class='form-inline'>
                        <label for='nom' style='padding-right:5px   '> Nom </label>
                        <input type ="text" placeholder='Nom' name="nom" class='form-control'/>
                        <input class='btn btn-indigo' type="submit" value="Valider"/>
                        <input type ="hidden" name="action" value="RechercherService">
                    </form>
                    
                    <div class="alert alert-info col-4"><% String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %><a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                    </div>

                    <table class="table table-bordered">

                        <a class="btn btn-outline-light-green right" href = "ServletAdmin?action=CreationService"> Créer un nouveau service </a>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nom</th>
                                <th>Description</th>
                                <th>Coût du service</th>
                                <th>Offre</th>
                            </tr>
                        </thead>
                        <% List<Service> lesServ = listeServ;
                            for (Service serv : lesServ) {%>
                        <tr>
                            <td Width=15%><%=serv.getId()%></td>
                            <td Width=15%><%=serv.getNom_Service()%></td>
                            <td Width=15%><%=serv.getDescription_Service()%></td>
                            <td Width=15%><%=serv.getCout_Service()%></td>
                            <td Width=15%><%=serv.getlOffre().getNom_Offre()%></td>
                            <td Width=15%><a href="ServletAdmin?action=ModifierService&idServ=<%=serv.getId()%>">Modifier</a></td>
                            <td Width=15%><a href="ServletAdmin?action=SupprimerService&idServ=<%=serv.getId()%>">Supprimer</a></td>
                            <%}%>
                        </tr>
                    </table>

                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="MenuAdmin.jsp" value="retour"> Retour </a>

                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>

    </body>
</html>