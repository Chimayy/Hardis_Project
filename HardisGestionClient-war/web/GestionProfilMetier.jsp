<%-- 
    Document   : GestionProfilMetier
    Created on : 21 mars 2019, 15:53:51
    Author     : Utilisateur
--%>

<%@page import="entite.Profil_Metier"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="listeProfil" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="jsp_reused/header.jsp" %>
        <title>Profils Métier</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Liste des profils métier</h1>
                    </div>

                    <form method ="get" action="ServletAdmin">

                        <div class="form-group">
                            <label for="nom">Nom</label>
                            <input type ="text" name="nom" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <input class='btn btn-indigo' type="submit" value="Valider"/>
                        </div>
                        <input type ="hidden" name="action" value="RechercherProfilMetier">
                        <table class="table table-bordered">
                            <a class="btn btn-outline-light-green right" style="margin-bottom: 20px" href="ServletAdmin?action=CreationProfilMetier"> Créer un nouveau profil métier </a>      
                            <thead>
                                <tr>
                                    <th>Id</th>
                                    <th>Niveau d'habilitation</th>
                                    <th>Offre</th>
                                    <th>Utilisateur Hardis</th>
                                </tr>
                            </thead>
                            <% List<Profil_Metier> lesProfils = listeProfil;
                                for (Profil_Metier profil : lesProfils) {%>
                            <tr> <td Width=15%><%=profil.getId()%></td>
                                <td Width=15%><%=profil.getNiveau_Habilitation()%></td>
                                <td Width=15%><%=profil.getlOffre().getNom_Offre()%></td>
                                <td Width=15%><%=profil.getlUtilisateur().getPrenom_Utilisateur()%><%=" "%><%=profil.getlUtilisateur().getNom_Utilisateur()%></td>
                                <td Width=15%><a href="ServletAdmin?action=ModifierProfilMetier&idProfilMetier=<%=profil.getId()%>">Modifier</a></td>
                                <td Width=15%><a href="ServletAdmin?action=SupprimerProfilMetier&idProfilMetier=<%=profil.getId()%>">Supprimer</a></td>
                                <%}%>   
                            </tr>
                        </table>  
                        <hr class="my-6">
                        <a class="btn btn-outline-teal right" href="MenuAdmin.jsp" value="retour"> Retour </a>
                        <div class="message"><% String attribut = (String) request.getAttribute("message");
                            out.println(attribut);
                            %></div>
                    </form>
                </div>
                <%@include file="jsp_reused/footer.jsp" %>
            </div>
            <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>