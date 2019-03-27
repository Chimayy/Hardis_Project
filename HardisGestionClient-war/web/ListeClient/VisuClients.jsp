<%-- 
    Document   : VisuClient
    Created on : 14 mars 2019, 15:12:48
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Historique_Consultant"%>
<%@page import="entite.Client"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="ListeClient" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Visualisation Client</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Visualisation Client</h1>
                    </div>



                    <table class='table table-bordered'>
                        <thead class='thead-light'>
                            <tr> 
                                <td>num</td>
                                <td>id</td>
                                <td>Nom</td>
                                <td>Prenom</td>
                                <td>Informations</td>
                                <%int y = 0;%>
                            </tr>
                        </thead>
                        <% List<Client> lesCli = ListeClient;                        
                                for (Client c : lesCli) {%>
                        <tr>
                            <%y = y + 1;%>
                            <td width=15%><%=y%></td>

                            <td width=15%><%=c.getId() %></td>
                            <td width=15%><%=c.getNom_Utilisateur() %></td>
                            <td width=15%><%=c.getPrenom_Utilisateur() %></td>                                       

                            <td width=15%><a style='color:orange' href="AcceuilGestionnaire?action=DetailClient&x=<%=c.getId()%>">Voir plus</a></td>
                        </tr>
                        <%}%>     
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
