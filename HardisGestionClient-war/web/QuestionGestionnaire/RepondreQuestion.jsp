<%-- 
    Document   : RepondreQuestion
    Created on : 19 mars 2019, 10:31:57
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Historique_Question"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="Question" scope="request" class="Historique_Question"></jsp:useBean>
        <jsp:useBean id="ok" scope="request" class="String"></jsp:useBean>
        <title>Répondre à la question concernant le devis </title>
    </head>
    <body>
        <h1>Répondre à la question concernant le devis</h1>
    <form method="get" action="AcceuilGestionnaire">
    
    <% if (ok=="1"){%>
    <h2>La réponse à bien été enregistrée</h2><%}%>
     <table border width=50%>
            <tr> 
            
                <td>Id Question</td>
                <td>Question</td>
                <td>Rédiger la réponse</td>
                <td>Valider</td>                
               
            </tr>
            <% Historique_Question q = Question ; %>
                
            <tr>
                    <td width=15%><%=q.getId()%></td>
                    
                    <td width=15%><%=q.getContenu_Question()%></td>
                    
                
                    
                     <% if (q.getReponse()==null){ %>                              
                     <td width=100% height="100"><input type="text"   name="reponse" required minlength="0" maxlength="100" size="100"></td><%}%>
                     
                     <% if (q.getReponse()!=null){ %>   
                       
                     <td width=100% height="100"><input type="text" value="<%=q.getReponse()%>"   name="reponse" required minlength="0" maxlength="100" size="100"  ></td> <%}%>
                     <input type="hidden" name="action" value="EnregistrerReponse">
                     <input type="hidden" name="x" value="<%=q.getId()%>">
                     
                     <td width=15%><input type="submit" name="Valider la réponse"></td></tr>
     
                   </table>                                       
               </body>
                    
           </form>                                                 
                
</html>
