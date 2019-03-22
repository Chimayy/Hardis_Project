<%-- 
    Document   : ReponseQuestions
    Created on : 14 mars 2019, 14:36:40
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Historique_Question"%>
<%@page import="entite.Utilisateur"%>
<%@page import="entite.Client"%>
<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="Devis" scope="request" class="java.util.List"></jsp:useBean>
        <title>Répondre aux questions</title>
    </head>
    <body>
        <h1>Répondre aux question concernant les devis</h1>
        <table border width=50%>
            <tr> 
                
                <td>Devis</td>
                <td>Client</td>
                <td>Nb questions</td>
                <td>Action</td>                
               
            </tr>
            <% List<Devis> lesDevis = Devis ;
                for(Devis d : lesDevis){%><%Client c = d.getLeClient();int i =0;
                if (!d.getHistorique_Questions().isEmpty()){ %>
                <tr>
                    
                    <td width=15%><%=d.getId()%></td>
                    
                    <td width=15%><%=c.getNom_Utilisateur() %></td>
                    <%List<Historique_Question> Questions= d.getHistorique_Questions();
                    for (Historique_Question Q : Questions){i = i+1;}%>
                    <td width=15%><%=i%></td>
                                                          
                      
                    <td width=15%><a href="AcceuilGestionnaire?action=DetailQuestions&x=<%=d.getId()%>">Voir +</a></td>
                                                            </tr>
                </tr><%}%>   <%}%>  
        </table>
    </body>
</html>
