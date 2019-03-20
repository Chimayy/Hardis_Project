<%-- 
    Document   : ModificationEntreprise
    Created on : 19 mars 2019, 09:06:25
    Author     : Utilisateur
--%>

<%@page import="entite.Agence"%>
<%@page import="entite.Entreprise"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeEnt" scope="request" class = "java.util.List"> </jsp:useBean>
<jsp:useBean id="listeAgence" scope="request" class = "java.util.List"> </jsp:useBean>
<!DOCTYPE html>
<html>
    <head>
    <title>Modifier une entreprise</title>
    </head>
    <body>
        <h1>Modifier un entreprise</h1>
        <% List<Entreprise> lesEnt = listeEnt;%>
        <% List<Agence> lesAgences = listeAgence;%>
            <div class="input1">
                <% for (Entreprise ent : lesEnt) {%>
                <form method ="get" action="ServletAdmin">
                <input type="hidden" name="id" value="<%=ent.getId()%>" class='input'/>
                <p> Nom : <input type ="text" name="nom" value="<%=ent.getNom_Entreprise()%>" class='input'/></p>
                <p> N° SIRET : <input type ="text" name="siret" value="<%=ent.getNumero_SIRET()%>" class='input'/></p>
                <p> Adresse : <input type ="text" name="adresse" value="<%=ent.getRue_Entreprise()%>" class='input'/></p>
                <p> Code postal : <input type ="text" name="cp" value="<%=ent.getCP_Entreprise()%>" class='input'/></P>
                <p> Ville : <input type ="text" name="ville" value="<%=ent.getVille_Entreprise()%>"class='input'/></p>
                <label for="Agence" class='textinput'> Agence : </label>
                    <select name="idAgence" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Agence agence : lesAgences ){%>
                    <option value="<%=agence.getId()%>"><%=agence.getVille_Agence()%>
                    </option>
                    <%}%>
                    </select> 
            </div>
            <div class='bouton1'>
            </br>
            <input type ="hidden" name="action" value="ActionModifierEntreprise"/>     
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