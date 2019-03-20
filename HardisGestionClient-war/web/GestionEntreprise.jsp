<%-- 
    Document   : GestionEntreprise
    Created on : 18 mars 2019, 09:53:50
    Author     : Utilisateur
--%>

<%@page import="entite.Entreprise"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="listeEnt" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="jsp_reused/style.jsp"%>
        <title>Entreprises</title>
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
                    <h1>Liste des entreprises</h1>
                    <hr class="my-6">
                    <p><form method ="get" action="ServletAdmin"class="form-inline">
                        
                        <label style="margin-right:10px" > Nom </label>
                        <input type ="text" placeholder='nom' name="nom" class='form-control'/>
                        <input class='btn btn-indigo' type="submit" value="Valider"/></br>
                        <input type ="hidden" name="action" value="RechercherEntreprise">
                    </form>
                        <table class="table table-bordered">
                   
                    
                            </p>
                            <p>
                                <a class="btn btn-outline-light-green right" style="margin-bottom: 20px" href = "ServletAdmin?action=CreationEntreprise"> Créer une nouvelle entreprise </a>
                            </p>
                            <tr> <td>Id</td>
                                <td>Nom</td>
                                <td>N° SIRET</td>
                                <td>Adresse</td>
                                <td>Code postal</td>
                                <td>Ville</td>
                                <td>Agence Hardis</td>
                            </tr>
                            <% List<Entreprise> lesEnt = listeEnt;
                                    for (Entreprise ent : lesEnt) {%>
                            <tr> <td Width=15%><%=ent.getId()%></td>
                                <td Width=15%><%=ent.getNom_Entreprise()%></td>
                                <td Width=15%><%=ent.getNumero_SIRET()%></td>
                                <td Width=15%><%=ent.getRue_Entreprise()%></td>
                                <td Width=15%><%=ent.getCP_Entreprise()%></td>
                                <td Width=15%><%=ent.getVille_Entreprise()%></td>
                                <td Wifth=15%><%=ent.getlAgence().getVille_Agence()%></td>
                                <td Width=15%><a style="color:grey" href="ServletAdmin?action=ModifierEntreprise&idEnt=<%=ent.getId()%>">Modifier</a>
                                <td Width=15%><a style="color:grey"href="ServletAdmin?action=SupprimerEntreprise&idEnt=<%=ent.getId()%>">Supprimer</a>
                                    <%}%>
                        </table></hr>
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