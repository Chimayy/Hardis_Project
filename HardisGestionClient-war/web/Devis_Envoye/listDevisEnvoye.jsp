<%-- 
    Document   : listDevisEnvoye
    Created on : 22 mars 2019, 16:08:07
    Author     : thoma
--%>

<%@page import="entite.Utilisateur"%>
<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listDevis" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listUser" scope="session" class = "java.util.List"> </jsp:useBean>
            <jsp:useBean id="UserARecup" scope="session" class = "entite.Utilisateur"> </jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
            <title>JSP Page</title>
        </head>
        <body>
            <div class="flex-wrapper">
                <div class="container-fluid nopad">
                    <header>
                    <% 
                        List<Utilisateur> listeUser = listUser;
                        entite.Utilisateur user = UserARecup;
                    
                    if (!listeUser.contains(user)){%>
                    <%@include file="../jsp_reused/header.jsp" %>
                    <%}
                if(listUser.contains(user)){%>
                <%@include file="../jsp_reused/header_deconnexion.jsp" %><%}%>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1> Liste des devis </h1>
                    </div>

                    <hr class="my-6">


                    <table class="table table-bordered">
                        <thead>
                            <tr> 
                                <th>Numero</th>
                                <th>Statut</th>
                            </tr>
                        </thead>
                        <% List<Devis> lesDevis = listDevis;
                            for (Devis devisEnCours : lesDevis) {%>
                        <tr>
                            <td width=15%><%=devisEnCours.getId()%></td>
                            <td width=15%><%=devisEnCours.getStatut()%></td>
                            <td width=15%><a style="color:orange" href="ServletClient?action=choixDateDevis&idDevis=<%=devisEnCours.getId()%>">voir plus </a></td>

                        </tr><%}%>     
                    </table>
                    <hr class="my-6">
                    
                    <a class="btn btn-outline-teal right" href ="MenuClient.jsp"> Retour Menu </a>
                    
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>
        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>
    </body>
</html>
