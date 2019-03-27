<%-- 
    Document   : RepondreQuestion
    Created on : 19 mars 2019, 10:31:57
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Client"%>
<%@page import="entite.Historique_Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="Question" scope="request" class="Historique_Question"></jsp:useBean>
        <jsp:useBean id="ok" scope="request" class="String"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Répondre à la question concernant le devis </title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container "> 
                    <div class="mx-auto" style="width: 600px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                      
                    </div>
                    <hr class="my-6">
                    <h1>Répondre à la question concernant le devis</h1>
                    </div>
                    <form method="get" action="AcceuilGestionnaire">

                        <% if (ok == "1") {%>
                        <h2>La réponse à bien été enregistrée</h2><%}%>
                        <table class='table table-bordered'>
                            <thead>
                                <tr> 
                                    <th>Id Question</th>
                                    <th>Question</th>
                                    <th>Rédiger la réponse</th>
                                    <th>Valider</th>                

                                </tr>
                            </thead>
                            <% Historique_Question q = Question;%>

                            <tr>
                                <td width=15%><%=q.getId()%></td>

                                <td width=15%><%=q.getContenu_Question()%></td>



                                <% if (q.getReponse() == null) { %>                              
                                <td width=100% height="100"><input class='form-control' type="text"   name="reponse" required minlength="0" maxlength="100" size="100"></td><%}%>

                                <% if (q.getReponse() != null) {%>   

                                <td width=100% height="100"><input class='form-control' type="text" value="<%=q.getReponse()%>"   name="reponse" required minlength="0" maxlength="100" size="100"  ></td> <%}%>
                            <input type="hidden" name="action" value="EnregistrerReponse">
                            <input type="hidden" name="x" value="<%=q.getId()%>">

                            <td width=15%><input class='btn btn-blue' type="submit" name="Valider la réponse"></td></tr>

                        </table>                                       

                    </form>  
                            <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="AcceuilGestionnaire" value="retour"> Retour </a>
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>
        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>
    </body>        
</html>
