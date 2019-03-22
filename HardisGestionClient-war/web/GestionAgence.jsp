<%-- 
    Document   : GestionAgence
    Created on : 19 mars 2019, 10:09:19
    Author     : Utilisateur
--%>

<%@page import="entite.Agence"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="listeAgence" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="jsp_reused/style.jsp" %>
        <title>Agence</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Menu Administrateur</h1>
                    </div>

                    <hr class="my-6">

                    <h1>Liste des agences</h1>
                    <hr class="my-6">
                    <form method ="get" action="ServletAdmin" class="form-inline">
                        <label style="margin-right:10px" > Nom de l'agence   </label>                        
                        <input type ="text"  name="nom" class='form-control'/>
                        <input class='btn btn-indigo' type="submit" value="Valider"/></br>
                        <input type ="hidden" name="action" value="RechercherAgence">
                    </form>

                    <a class="btn btn-outline-light-green right" style="margin-bottom: 20px" href = "CreationAgence.jsp"> Créer une nouvelle agence </a>
                    <table class='table table-bordered' >


                        <thead class='thead-light'>
                            <tr>    
                                <th>Id</th>
                                <th>Code postal</th>
                                <th>Pays</th>
                                <th>Adresse</th>
                                <th>Ville</th>
                            </tr>
                        </thead>
                        <% List<Agence> lAgence = listeAgence;
                            for (Agence agence : lAgence) {%>
                        <tr> 
                            <td Width=15%><%=agence.getId()%></td>
                            <td Width=15%><%=agence.getCP_Agence()%></td>
                            <td Width=15%><%=agence.getPays_Agence()%></td>
                            <td Width=15%><%=agence.getRue_Agence()%></td>
                            <td Width=15%><%=agence.getVille_Agence()%></td>
                            <td Width=15%><a href="ServletAdmin?action=ModifierAgence&idAgence=<%=agence.getId()%>">Modifier</a></td>
                            <td Width=15%><a href="ServletAdmin?action=SupprimerAgence&idAgence=<%=agence.getId()%>">Supprimer</a></td>
                                <%}%>
                        </tr>   
                    </table>
                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="MenuAdmin.jsp" value="retour"> Retour </a>
                    <div class="message"><% String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></div>


                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>