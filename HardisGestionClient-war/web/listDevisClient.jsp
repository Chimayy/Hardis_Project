<%-- 
    Document   : listDevisClient
    Created on : 18 mars 2019, 10:10:14
    Author     : thoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeDevis" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="jsp_reused/style.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                     <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <h1>Hello World!</h1>

                    <table class="table">
                        <thead class="thead-light">
                            <tr> 
                                <th scope="col">Numero</th>
                                <th scope="col">Statut</th>
                            </tr>
                        </thead>
                        <% List<Devis> lesDevis=listeDevis;
                            for(Devis devisEnCours : lesDevis){%>s
                            <tr>                               
                                <td width=15%><%=devisEnCours.getId()%></td>
                                <td width=15%><%=devisEnCours.getStatut() %></td>
                            <td><a href="ServletClient?action=modifDevis&idDevis=<%=devisEnCours.getId()%>">voir + </a></td>

                            </tr><%}%>     
                        </table>
                        
                     <hr class="my-6">
                <a class="btn btn-outline-teal right" href="MenuClient.jsp" value="retour"> Retour </a> 
                    
                </div>
            </div> 
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <%@include file="jsp_reused/javascript.jsp"%>
    </body>
</html>
