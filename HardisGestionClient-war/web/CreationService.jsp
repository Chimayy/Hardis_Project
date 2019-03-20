<%-- 
    Document   : CreationService
    Created on : 19 mars 2019, 15:08:50
    Author     : Utilisateur
--%>

<%@page import="java.util.List"%>
<%@page import="entite.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeOffre" scope="request" class = "java.util.List"> </jsp:useBean>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer un service</title>
    </head>
    <body>
        <h1>Créer un service</h1>
        <% List<Offre> lesOffres= listeOffre;%>
        <form method ="get" action="ServletAdmin">
                <input type ="text" placeholder='Coût du service' name="cout" class='input'/>
                <input type ="text" placeholder='Description'name="description" class='input'/>
                <input type ="text" placeholder="Nom du service" name="nom" class='input'/>
                <label for="Offre" class='textinput'> Offre : </label>
                <select name="idOffre" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Offre offre : lesOffres ){%>
                    <option value="<%=offre.getId()%>"><%=offre.getNom_Offre()%>
                    </option>
                    <%}%>
                </select><br/>
                <div class="input1">
                <input type ="hidden" name="action" value="CreerService">
            </div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Effacer"/>       
            </div>
            </br>
            <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
            </div>            
        </form>
    </body>
</html>