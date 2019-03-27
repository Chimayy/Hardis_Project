

<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeOffre" scope="request" class = "java.util.List"> </jsp:useBean>
<%@include file="jsp_reused/style.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rédiger une question publique</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container "> 
                    <div class="mx-auto" style="width: 600px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Rédiger une question publique</h1>
                    </div>
                    <hr class="my-6">


                    <% List<Offre> lesOffres = listeOffre;%>
                    <form method ="get" action="ServletAdmin?action=CreationQuestionPublique">
                        <div class="form-group">
                            <label for="question"> Question </label>
                            <textarea class="form-control" type ="text" name="question" placeholder="Tapez votre question" rows="4" cols="50"></textarea><br/>
                        </div>
                        <div class="form-group">
                            <label for="pseudo">Pseudo</label>
                            <input type ="text" name="pseudo" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="offre"> Selectionnez l'offre concernée</label>
                            <select name="idOffre" class='form-control'>
                                <% for (Offre offre : lesOffres) {%>
                                <option value="<%=offre.getId()%>"><%=offre.getNom_Offre()%>
                                </option>
                                <%}%>
                            </select>
                        </div>

                        <input type ="hidden" name="action" value="CreerQuestionPublique">
                        <div class='bouton1'>
                            </br>
                            <input  class='btn  btn-secondary   ' type="submit" value="Valider"/>
                            <input  class='btn  btn-secondary'type="reset" value="Effacer"/>       
                        </div>
                    </form>
                    <div class="message"><% String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></div>
                    
                    <div class='retour'>
                        <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="Menu_principal.jsp" > Retour </a> 
                        <a class='btn btn-outline-secondary' href ="Accueil?action=VoirLeForum"> Voir le Forum des questions </a>
                    </div>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>

        </div>
        <%@include file="jsp_reused/javascript.jsp" %>

    </body>

</html>