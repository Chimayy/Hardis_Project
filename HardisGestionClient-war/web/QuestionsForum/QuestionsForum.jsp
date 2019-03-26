<%-- 
    Document   : QuestionsForum
    Created on : 22 mars 2019, 09:45:21
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Historique_QuestionPublique"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="entite.Utilisateur"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="User" scope="session" class="Utilisateur_Hardis"></jsp:useBean>
        <jsp:useBean id="ListQG" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Gestion des question publique</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <%Utilisateur_Hardis u = User;%>
                        <h1>Gestion des question publiquede M<%=u.getNom_Utilisateur()%></h1>
                    </div>

<form method="get" action="AcceuilGestionnaire">

                    <table class='table table-bordered'>
                        <thead class='thead-light'>
                            <tr> 
                                <td>num</td>
                                <td>id</td>
                                <td>Offre</td>
                                <td>Question</td>
                                <td>Repondre</td>
                                <%int y = 0;%>
                            </tr>
                        </thead>
                        <% List<Historique_QuestionPublique> LQ = ListQG;
                                for (Historique_QuestionPublique q : LQ) {
                        if(q.getReponse()==null){ %>
                        <tr>
                            <%y = y + 1;%>
                            <td width=15%><%=y%></td>

                            <td width=15%><%=q.getId() %></td>
                            <td width=15%><%=q.getlOffre().getNom_Offre() %></td>
                            <td width=15%><%=q.getQuestion() %></td>  
                            <td width=100% height="100"><input type="text" value=""   name="reponsep" required minlength="0" maxlength="100" size="100"  ></td>
                            <input type="hidden" name="action" value="EnregistrerReponsePublique">
                            <input type="hidden" name="x" value="<%=q.getId() %>">
                     
                            <td width=15%><input type="submit" name = "reponse" value="Répondre à <%=q.getPseudo() %>"></td></tr><%}%><%}%>
                        </tr>
                          
                    </table></form>
                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="AcceuilGestionnaire" value="retour"> Retour </a>
                </div>
            </div>
                    <%@include file="../jsp_reused/footer.jsp" %>
        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>
    </body>
</html>
