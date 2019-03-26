<%-- 
    Document   : CreationProfilMetier
    Created on : 21 mars 2019, 16:08:45
    Author     : Utilisateur
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="java.util.List"%>
<%@page import="entite.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeOffre" scope="request" class = "java.util.List"> </jsp:useBean>
<jsp:useBean id="listeUser" scope="request" class = "java.util.List"> </jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Créer un profil métier</title>
        <%@include file="jsp_reused/style.jsp" %>

    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>
                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Créer un profil métier</h1>
                    </div>

                    <% List<Offre> lesOffres = listeOffre;%>
                    <% List<Utilisateur_Hardis> lesUser = listeUser;%>
                    <form method="get" action="ServletAdmin">
                        <div class="form-group">
                            <label for="niveau">Niveau </label>
                            <input type="text" placeholder='Niveau' name="niveau" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="Offre" class='textinput'> Offre  </label>
                            <select name="idOffre" class='form-control'>
                                <% for (Offre offre : lesOffres) {%>
                                <option value="<%=offre.getId()%>"><%=offre.getNom_Offre()%>
                                </option>
                                <%}%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="User" class='textinput'> Utilisateur Hardis : </label>
                            <select name="idUser" class='custom-dropdown__select custom-dropdown__select--white'>
                                <% for (Utilisateur_Hardis user : lesUser) {%>
                                <option value="<%=user.getId()%>"><%=user.getPrenom_Utilisateur()%> <%=user.getNom_Utilisateur()%>
                                </option>
                                <%}%>
                            </select>
                        </div>
                        <input type ="hidden" name="action" value="CreerProfilMetier">

                        <input  class='btn btn-indigo' type="submit" value="Valider"/>
                        <input  class='btn btn-indigo' type="reset" value="Effacer"/> 
                        <hr class="my-6">
                        <a class="btn btn-outline-teal right" href="MenuAdmin.jsp" value="retour"> Retour </a>

                    </form>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>

        </div>
        <%@include file="jsp_reused/javascript.jsp" %>

    </body>
</html>