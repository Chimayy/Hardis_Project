<%-- 
    Document   : GestionService
    Created on : 19 mars 2019, 14:56:51
    Author     : Utilisateur
--%>

<%@page import="entite.Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <jsp:useBean id="listeServ" scope="request" class="java.util.List"></jsp:useBean>
             <title>Services</title>
    </head>
    <body>
        <h1>Liste des services</h1>
        <p><form method ="get" action="ServletAdmin">
        <div style="overflow-x:auto;"> 
        <input type ="text" placeholder='Nom' name="nom" class='input'/>
        <input class='bouton' type="submit" value="Valider"/></br>
        <input type ="hidden" name="action" value="">
        <table border width="50%">
        </p>
        <p>
             <a href = "ServletAdmin?action=CreationService"> Créer un nouveau service </a>
        </p>
            <tr><td>Id</td>
                <td>Nom</td>
                <td>Description</td>
                <td>Coût du service</td>
                <td>Offre</td>
            </tr>
                 <% List <Service> lesServ = listeServ;
                 for(Service serv : lesServ){%>
            <tr><td Width=15%><%=serv.getId()%></td>
                <td Width=15%><%=serv.getNom_Service()%></td>
                <td Width=15%><%=serv.getDescription_Service()%></td>
                <td Width=15%><%=serv.getCout_Service()%></td>
                <td Width=15%><%=serv.getlOffre().getNom_Offre()%></td>
                <td Width=15%><a href="ServletAdmin?action=ModifierService&idServ=<%=serv.getId()%>">Modifier</a>
                <td Width=15%><a href="ServletAdmin?action=SupprimerService&idServ=<%=serv.getId()%>">Supprimer</a>
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