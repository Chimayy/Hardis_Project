<%-- 
    Document   : ModificationService
    Created on : 19 mars 2019, 16:40:10
    Author     : Utilisateur
--%>

<%@page import="entite.Offre"%>
<%@page import="entite.Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeServ" scope="request" class = "java.util.List"> </jsp:useBean>
<jsp:useBean id="listeOffre" scope="request" class = "java.util.List"> </jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
    <title>Modifier un service</title>
    </head>
    <body>
        <h1>Modifier un service</h1>
        <% List<Service> lesServices = listeServ;%>
        <% List<Offre> lesOffres = listeOffre;%>
            <div class="input1">
                <% for (Service serv : lesServices) {%>
                <form method ="get" action="ServletAdmin">
                <input type="hidden" name="id" value="<%=serv.getId()%>" class='input'/>
                <p> Nom : <input type ="text" name="nom" value="<%=serv.getNom_Service()%>" class='input'/></p>
                <p> Description : <input type ="text" name="description" value="<%=serv.getDescription_Service()%>" class='input'/></p>
                <p> Coût du service : <input type ="text" name=cout value="<%=serv.getCout_Service()%>" class='input'/></p>
                <label for="Offre" class='textinput'> Offre : </label>
                    <select name="idOffre" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Offre offre : lesOffres){%>
                    <option value="<%=offre.getId()%>"><%=offre.getNom_Offre()%>
                    </option>
                    <%}%>
                    </select> 
            </div>
            <div class='bouton1'>
            </br>
            <input type ="hidden" name="action" value="ActionModifierService"/>     
            <%}%>
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