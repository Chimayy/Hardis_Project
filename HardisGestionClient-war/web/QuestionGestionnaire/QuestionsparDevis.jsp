<%-- 
    Document   : QuestionsparDevis
    Created on : 18 mars 2019, 17:46:10
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Historique_Question"%>
<%@page import="java.util.List"%>
<%@page import="entite.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="ListeQuestions" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="Client" scope="request" class="Client"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Question pour le Devis de <%=Client.getNom_Utilisateur()%> </title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container "> 
                    <div class="mx-auto" style="width: 600px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Question pour le Devis de <%=Client.getNom_Utilisateur()%></h1>
                    </div>
                    <hr class="my-6">

                    <table class='table table-bordered'>
                        <thead>
                            <tr> 
                                <th>Id</th>
                                <th>Questions</th>
                                <th>Date</th>
                                <th>Etat</th>
                                <th>Répondre</th> 
                            </tr>
                        </thead>
                        <% List<Historique_Question> q = ListeQuestions;
                            for (Historique_Question question : q) {%>
                        <tr>
                            <td width=15%><%=question.getId()%></td>                    
                            <td width=15%><%=question.getContenu_Question()%></td>                    
                            <td width=15%><%=question.getDate_Question()%></td>    
                            <% if (question.getReponse() != null) {%>
                            <td width=15%>REPONDU</td> <%}%>
                            <% if (question.getReponse() == null) {%>
                            <td width=15%>EN ATTENTE DE REPONSE</td> <%}%>

                            <td width=15%><a style='color:grey' href="AcceuilGestionnaire?action=RepondreQuestion&x=<%=question.getId()%>">Rédiger/Modifier une réponse</a></td>

                        </tr><%}%>   
                    </table>
                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="AcceuilGestionnaire" value="retour"> Retour </a>
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>

        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>

    </body>
</html>
