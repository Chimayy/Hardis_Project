<%-- 
    Document   : ModificationOffre
    Created on : 20 mars 2019, 11:01:37
    Author     : Utilisateur
--%>

<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeOffre" scope="request" class="java.util.List"></jsp:useBean>
<%@include file="jsp_reused/style.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifier une offre</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Modifier une offre</h1>
                    </div>

                    <% List<Offre> lesOffres = listeOffre;%>               
                    <% for (Offre offre : lesOffres) {%>
                    <form method ="get" action="ServletAdmin">
                        <input type="hidden" name="id" value="<%=offre.getId()%>" class='input'/>
                        <div class="form-group">
                            <label for="nom"> Nom </label>
                            <input type ="text" name="nom" value="<%=offre.getNom_Offre()%>" readonly class='form-control'/> 
                        </div>
                        <div class="form-group">
                            <label for="decription"> Description </label>
                            <input type="text" name="description" value="<%=offre.getDescription_Offre()%>" readonly class ="form-control"/>                
                        </div>
                        <input type ="hidden" name="action" value="ActionModifierOffre"/>     
                        <%}%>
                        <input  class='btn btn-indigo' type="submit" value="Valider"/>
                        <input  class='btn btn-indigo' type="reset" value="Effacer"/>       


                        <hr class="my-6">                      
                        <a class="btn btn-outline-teal right" href ="MenuAdmin.jsp"> Retour Menu </a>

                    </form>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>

        </div>
        <%@include file="jsp_reused/javascript.jsp" %>

    </body>
</html>