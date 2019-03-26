<%-- 
    Document   : GestionOffre
    Created on : 20 mars 2019, 08:58:20
    Author     : Utilisateur
--%>

<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="listeOffre" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="jsp_reused/style.jsp"%>
        <title>Offres</title>
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
                    <h1>Liste des offres</h1>
                    <hr class="my-6">

                    <form method ="get" action="ServletAdmin" class="form-inline">
                        <label for="nom" style="margin-right: 5px"> Nom </label>
                            <input type ="text"  name="nom" class='form-control'/>
                            <input class='btn btn-indigo' type="submit" value="Valider"/>
                            <input type ="hidden" name="action" value="RechercherOffre"/>
                    </form>
                    <table class="table table-bordered">

                        <a class="btn btn-outline-light-green right" href = "CreationOffre.jsp"> Créer une nouvelle offre</a>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nom</th>
                                <th>Description</th>
                            </tr>
                        </thead>
                        <% List<Offre> lesOffres = listeOffre;
                                    for (Offre offre : lesOffres) {%>
                        <tr>
                            <td Width=15%><%=offre.getId()%></td>
                            <td Width=15%><%=offre.getNom_Offre()%></td>
                            <td Width=15%><%=offre.getDescription_Offre()%></td>
                            <td Width=15%><a href="ServletAdmin?action=ModifierOffre&idOffre=<%=offre.getId()%>">Modifier</a></td>
                            <td Width=15%><a href="ServletAdmin?action=SupprimerOffre&idOffre=<%=offre.getId()%>">Supprimer</a></td>
                                <%}%>
                        </tr>
                    </table>
                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="MenuAdmin.jsp" value="retour"> Retour </a>
                    <div class="message"><% String attribut = (String) request.getAttribute("message");
                                out.println(attribut);
                        %></div>
                </div>
            </div>

            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>