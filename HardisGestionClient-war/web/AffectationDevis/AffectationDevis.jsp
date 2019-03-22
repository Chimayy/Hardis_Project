<%-- 
    Document   : AffectationDevis
    Created on : 14 mars 2019, 14:49:15
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="ListeDevisNonAttribue" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Affectation devis</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Acceuil Gestionaire</h1>
                    </div>

                    <hr class="my-6">

                    <h1>Affectation des devis</h1>
                    <table class="table table-bordered">
                        <thead>
                            <tr> 
                                <th>Id</th>
                                <th>Client</th>
                                <th>Date</th>
                                <th>Offre</th>
                                <th>Affecter</th>   
                            </tr>
                        </thead>
                        <% List<Devis> d = ListeDevisNonAttribue;
                            for (Devis devis : d) {%>
                        <tr>

                            <td width=15%><%=devis.getId()%></td>                    
                            <td width=15%><%=devis.getLeClient().getNom_Utilisateur()%></td>                    
                            <td width=15%><input type="text" readonly name="NomCli" readonly value ="<%=devis.getDate_Devis()%>" required minlength="0" maxlength="100" size="35"></td>    

                            <td width=15%><%=devis.getlOffre().getNom_Offre()%></td> 

                            <td width=15%><select name="Gestionnairee" class='form-control'>
                                    <!--faire recup liste gestionnaire offre corres si lvl dans l'offre > =5 et juste nom du mec si lvl =4-->
                                    <option> 
                                </option>

                            </select> 

                        <td width=15%><a class="btn btn-green" href="AcceuilGestionnaire?action=DevisAffecte&Did=<%=devis.getId()%>">Valider L'affectation</a></td>

                    </tr>   <%}%>
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
