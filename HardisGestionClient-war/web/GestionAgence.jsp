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
             <title>Agence</title>
    </head>
    <body>
        <h1>Liste des agences</h1>
        <p><form method ="get" action="ServletAdmin">
        <div style="overflow-x:auto;"> 
        <input type ="text" placeholder='Nom' name="nom" class='input'/>
        <input class='bouton' type="submit" value="Valider"/></br>
        <input type ="hidden" name="action" value="RechercherAgence">
        <table border width="50%">
        </p>
        <p>
             <a href = "CreationAgence.jsp"> Créer une nouvelle agence </a>
        </p>
            <tr> <td>Id</td>
                 <td>Code postal</td>
                 <td>Pays</td>
                 <td>Adresse</td>
                 <td>Ville</td>
            </tr>
                 <% List <Agence> lAgence = listeAgence;
                 for(Agence agence : lAgence){%>
            <tr> <td Width=15%><%=agence.getId()%></td>
                 <td Width=15%><%=agence.getCP_Agence()%></td>
                 <td Width=15%><%=agence.getPays_Agence()%></td>
                 <td Width=15%><%=agence.getRue_Agence()%></td>
                 <td Width=15%><%=agence.getVille_Agence()%></td>
                 <td Width=15%><a href="ServletAdmin?action=ModifierAgence&idAgence=<%=agence.getId()%>">Modifier</a>
                 <td Width=15%><a href="ServletAdmin?action=SupprimerAgence&idAgence=<%=agence.getId()%>">Supprimer</a>
              <%}%>
        </table>
        <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
        </div>
        <div class="message"><% String attribut = (String)request.getAttribute("message");
        out.println(attribut);
        %></div>
      
        </form>
    </body>
</html>