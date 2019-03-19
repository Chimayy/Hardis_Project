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
             <title>Entreprises</title>
    </head>
    <body>
        <h1>Liste des entreprises</h1>
        <p><form method ="get" action="ServletAdmin">
        <div style="overflow-x:auto;"> 
        <input type ="text" placeholder='Nom' name="nom" class='input'/>
        <input class='bouton' type="submit" value="Valider"/></br>
        <input type ="hidden" name="action" value="RechercherEntreprise">
        <table border width="50%">
        </p>
        <p>
             <a href = "ServletAdmin?action=CreationEntreprise"> Créer une nouvelle entreprise </a>
        </p>
            <tr> <td>Id</td>
                 <td>Nom</td>
                 <td>N° SIRET</td>
                 <td>Adresse</td>
                 <td>Code postal</td>
                 <td>Ville</td>
                 <td>Agence Hardis</td>
            </tr>
                 <% List <Entreprise> lesEnt = listeEnt;
                 for(Entreprise ent : lesEnt){%>
            <tr> <td Width=15%><%=ent.getId()%></td>
                 <td Width=15%><%=ent.getNom_Entreprise()%></td>
                 <td Width=15%><%=ent.getNumero_SIRET()%></td>
                 <td Width=15%><%=ent.getRue_Entreprise()%></td>
                 <td Width=15%><%=ent.getCP_Entreprise()%></td>
                 <td Width=15%><%=ent.getVille_Entreprise()%></td>
                 <td Wifth=15%><%=ent.getlAgence().getVille_Agence()%></td>
                 <td Width=15%><a href="ServletAdmin?action=ModifierEntreprise&idEnt=<%=ent.getId()%>">Modifier</a>
                 <td Width=15%><a href="ServletAdmin?action=SupprimerEntreprise&idEnt=<%=ent.getId()%>">Supprimer</a>
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