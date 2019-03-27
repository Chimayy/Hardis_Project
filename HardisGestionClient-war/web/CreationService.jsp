<%-- 
    Document   : CreationService
    Created on : 19 mars 2019, 15:08:50
    Author     : Utilisateur
--%>

<%@page import="java.util.List"%>
<%@page import="entite.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeOffre" scope="request" class = "java.util.List"> </jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="jsp_reused/style.jsp"%>
        <title>Créer un service</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Créer un service</h1>
                    </div>
                    <% List<Offre> lesOffres = listeOffre;%>
                    <form method ="get" action="ServletAdmin">
                        <div class="form-groupe">
                            <label for="coutService">Coût du service </label>
                            <input type ="text"  name="cout" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="NomService"> Nom du service </label>
                            <input type ="text"  name="nom" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="Description">Description</label>
                            <input type ="text"  name="description" class='form-control'/>
                        </div>
                        <label for="Offre" > Offre  </label>
                        <select name="idOffre" class='form-control'>
                            <% for (Offre offre : lesOffres) {%>
                            <option value="<%=offre.getId()%>"><%=offre.getNom_Offre()%>
                            </option>
                            <%}%>
                        </select><br/>
                        <a style="color:orange" class="right" href="ServletAdmin?action=AfficherOffres" >L'offre n'est pas dans la liste ? </a>
                        <div class="input1">
                            <input type ="hidden" name="action" value="CreerService">
                        </div>
                        <input  class='btn btn-indigo' type="submit" value="Valider"/>
                        <input  class='btn btn-indigo' type="reset" value="Effacer"/>       

                        <hr class="my-6">
                        <a class="btn btn-outline-teal right" href ="ServletAdmin"> Retour </a>
                    </form>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <%@include file="jsp_reused/javascript.jsp"%>
    </body>
</html>