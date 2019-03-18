<%-- 
    Document   : CreationEntreprise
    Created on : 18 mars 2019, 10:16:44
    Author     : Utilisateur
--%>

<%@page import="java.util.List"%>
<%@page import="entite.Agence"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeAgence" scope="request" class = "java.util.List"> </jsp:useBean>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Créer une entreprise</title>
    </head>
    <body>
        <h1>Créer une entreprise</h1>
        <% List<Agence> lesAgences = listeAgence;%>
        <form method ="get" action="ServletAdmin">
                <input type ="text" placeholder='Nom' name="nom" class='input'/>
                <input type ="text" placeholder='N° SIRET'name="siret" class='input'/>
                <input type ="text" placeholder='Adresse' name="adresse" class='input'/>
                <input type ="text" placeholder='Code postal' name="code_postal" class='input'/>
                <input type ="text" placeholder='Ville' name="ville" classe='input' class='input'/></br>     
                <div class="input1">
                <label for="Agence" class='textinput'> Agence : </label>
                <select name="idAgence" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Agence agence : lesAgences ){%>
                    <option value="<%=agence.getId()%>"><%=agence.getVille_Agence()%>
                    </option>
                    <%}%>
                </select> 
            </br>
                <input type ="hidden" name="action" value="CreerEntreprise">

            </div>
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>
            <div class='retour'>
            <a href ="MenuAdmin.jsp"> Retour Menu </a>
            </div>
            
        </form>
    </body>
</html>