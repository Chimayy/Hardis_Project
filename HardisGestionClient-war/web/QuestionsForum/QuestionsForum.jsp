<%-- 
    Document   : QuestionsForum
    Created on : 22 mars 2019, 09:45:21
    Author     : Mathieu Harmand
--%>


<%@page import="entite.Historique_QuestionPublique"%>
<%@page import="entite.Historique_Question"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="ListeQuestion" scope="request" class="java.util.List"></jsp:useBean>
         <jsp:useBean id="User" scope="session" class="Utilisateur_Hardis"></jsp:useBean>
         <jsp:useBean id="test" scope="request" class="String"></jsp:useBean>
        <title>Gestion des question publique</title>
    </head>
    <body>
        <form method="get" action="AcceuilGestionnaire">
        <%String test1 =test; if( test1 =="ok"){ %>
        <h1>Vous avez bien répondu à la question</h1><%}%>
        <% Utilisateur_Hardis u = User;%>
        <h1>Gestion des question publique de M.<%=u.getNom_Utilisateur() %></h1>
         <table border width=50%>
            <tr> 
                
                <td>Id</td>
                <td>Utilisateur</td>
                <td>Question</td>                
                <td>Répondre</td>                
               
            </tr>
            <% List<Historique_QuestionPublique> q= ListeQuestion ;
                for(Historique_QuestionPublique question : q){%>
                <tr>
                    
                    <td width=15%><%=question.getId()%></td>                    
                    <td width=15%><%=question.getPseudo()%></td>                    
                    <td width=15%><%=question.getQuestion()%></td>  
                    
                    <td width=15%><input type="text" value=""   name="reponse"  minlength="0" maxlength="100" size="100"  ></td> 
                     <input type="hidden" name="action" value="EnregistrerReponsePublique">
                     <input type="hidden" name="x" value="<%=question.getId()%>">
                     
                     <td width=15%><input type="submit" value="Répondre à <%=question.getPseudo()%>" name="RepondreQuestion"></td></tr>
                      
                    
                                                            
                </tr><%}%>   
        </table>
        </form>
    </body>
</html>
