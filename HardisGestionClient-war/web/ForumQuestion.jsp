<%-- 
    Document   : ForumQuestion
    Created on : 26 mars 2019, 09:10:31
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Historique_QuestionPublique"%>
<%@page import="java.util.List"%>
<%@page import="entite.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="ListeQPR" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="ListeDesOffre" scope="request" class="java.util.List"></jsp:useBean>  
                          
        <%@include file="/jsp_reused/style.jsp" %>
        <title>Forum Question</title>
    </head>
   <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="/jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        
                        <h1>Forum des question publique</h1>
                    </div>
                     <form method="get" action="Accueil"class="form-inline">
                    <select class="form form-control" style="width:400px" name="Offre" class='custom-dropdown__select custom-dropdown__select--white'>
                   <%  List<Offre> List =  ListeDesOffre;
                       for (Offre o :  List){%>
                   <option value="<%=o.getId() %>"><%=o.getNom_Offre() %>
                   </option>
                   <%}%>
                   </select>
                   
                   <input type="hidden" name="action" value="ForumChoixOffre">
                   <input class=" btn btn-secondary" type="submit" name = "reponse" ></form>
                   <form method="get" action="Accueil" class="form-inline">
                   <input class= "form-control" style="width:400px"type="text" placeholder = "Veuillez renseigner votre pseudo "name="pseudo" value="">                   
                   <input type="hidden" name="action" value="ForumChoixPseudo">
                   <input class="btn btn-secondary"type="submit" name = "reponse" value ="Choisir" >
                   
                   </Form><hr class="my-6">

                    <table class='table table-bordered'>
                        <thead class='thead-light'>
                            <tr> 
                                <td>Num</td>
                                <td>Pseudo</td>
                                <td>Question</td>
                                <td>Réponse</td>
                                
                                <%int y = 0;%>
                            </tr>
                        </thead>
                        
                        <% List<Historique_QuestionPublique> LP = ListeQPR;
                                for (Historique_QuestionPublique q : LP) {
                        if(q.getReponse()!=null){ %>
                        <tr>
                            <%y = y + 1;%>
                            <td width=15%><%=y%></td>

                            <td width=15%><%=q.getPseudo() %></td>
                            <td width=15%><%=q.getQuestion() %></td>
                            <td width=15%><%=q.getReponse() %></td>  
                            
                     
                            <%}}%></tr>
                        
                        <%if (LP.isEmpty()){ %>
                        
                        <td width=140%>Pas de question pour les critères sélectionnés</td><%}%>
                         
                    </table></form>
                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="Accueil" value="retour"> Retour </a>
                </div>
            </div>
                    <%@include file="/jsp_reused/footer.jsp" %>
        </div>
        <%@include file="/jsp_reused/javascript.jsp" %>
    </body>
</html>
