<%-- 
    Document   : GestionOffre
    Created on : 20 mars 2019, 08:58:20
    Author     : Utilisateur
--%>

<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <jsp:useBean id="listeOffre" scope="request" class="java.util.List"></jsp:useBean>
             <title>Offres</title>
    </head>
    <body>
        <h1>Liste des offres</h1>
        <p><form method ="get" action="ServletAdmin">
        <div style="overflow-x:auto;"> 
        <input type ="text" placeholder='Nom' name="nom" class='input'/>
        <input class='bouton' type="submit" value="Valider"/></br>
        <input type ="hidden" name="action" value="RechercherOffre">
        <table border width="50%">
        </p>
        <p>
             <a href = "CreationOffre.jsp"> Créer une nouvelle offre</a>
        </p>
            <tr><td>Id</td>
                <td>Nom</td>
                <td>Description</td>
            </tr>
                 <% List <Offre> lesOffres = listeOffre;
                 for(Offre offre : lesOffres){%>
            <tr><td Width=15%><%=offre.getId()%></td>
                <td Width=15%><%=offre.getNom_Offre()%></td>
                <td Width=15%><%=offre.getDescription_Offre()%></td>
                <td Width=15%><a href="ServletAdmin?action=ModifierOffre&idOffre=<%=offre.getId()%>">Modifier</a>
                <td Width=15%><a href="ServletAdmin?action=SupprimerOffre&idOffre=<%=offre.getId()%>">Supprimer</a>
              <%}%>
        </table></hr>
        <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
        </div>
        <div class="message"><% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %></div>
      
        </form>
    </body>
</html>