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
       
       <title>Question pour le Devis de <%=Client.getNom_Utilisateur()%> </title>
    </head>
    <body>
        <h1>Question pour le Devis de <%=Client.getNom_Utilisateur()%></h1>
        <table border width=50%>
            <tr> 
                
                <td>Id</td>
                <td>Questions</td>
                <td>Date</td>
                <td>Etat</td>
                <td>Répondre</td>                
               
            </tr>
            <% List<Historique_Question> q= ListeQuestions ;
                for(Historique_Question question : q){%>
                <tr>
                    
                    <td width=15%><%=question.getId()%></td>                    
                    <td width=15%><%=question.getContenu_Question()%></td>                    
                    <td width=15%><%=question.getDate_Question()%></td>    
                    <% if (question.getReponse()!=null){%>
                    <td width=15%>REPONDU</td> <%}%>
                    <% if (question.getReponse()==null){%>
                    <td width=15%>EN ATTENTE DE REPONSE</td> <%}%>
                      
                    <td width=15%><a href="AcceuilGestionnaire?action=RepondreQuestion&x=<%=question.getId()%>">Rédiger/Modifier une réponse</a></td>
                                                            
                </tr><%}%>   
        </table>
    </body>
</html>
