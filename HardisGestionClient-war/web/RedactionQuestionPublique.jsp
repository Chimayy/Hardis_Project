<%-- 
    Document   : RedactionQuestionPublique
    Created on : 21 mars 2019, 12:07:35
    Author     : Utilisateur
--%>

<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeOffre" scope="request" class = "java.util.List"> </jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="jsp_reused/style.jsp" %>
        <title>Rédiger une question publique</title>
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
                    <h2>Rédiger une question publique</h2>
                    <hr class="my-6">
                    <% List<Offre> lesOffres = listeOffre;%>
                    <form method ="get" action="ServletAdmin?action=CreationQuestionPublique">
                        <div class="form-group">
                            <label for="question"> Question </label>
                            <textarea class='form-control' type ="text" name="question" placeholder="Redigez votre question ici" rows="4" cols="50"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="Pseudo"> Pseudo </label>
                            <input class='form-control' type ="text" name="pseudo" class='input'>
                        </div>
                        <div class="form-group">
                            <label for="Offre"> Offre concernée </label>
                            <select class='form-control' name="idOffre" class='custom-dropdown__select custom-dropdown__select--white'>
                                <% for (Offre offre : lesOffres) {%>
                                <option value="<%=offre.getId()%>"><%=offre.getNom_Offre()%>
                                </option>
                                <%}%>
                            </select><br/>
                        </div>

                        <input type ="hidden" name="action" value="CreerQuestionPublique">
                       
                          
                            <input  class='btn btn-indigo' type="submit" value="Valider"/>
                            <input  class='btn btn-indigo'type="reset" value="Effacer"/>       
                        
                    </form>
                    <div class="message"><% String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></div>
                   
                     <hr class="my-6">
                     <a class="btn btn-outline-teal right" href="MenuAdmin.jsp" value="retour"> Retour </a>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <!--pages de script-->
        <%@include file="jsp_reused/javascript.jsp"%>       
    </body>
</html>