<%-- 
    Document   : GestionProfilMetier
    Created on : 21 mars 2019, 15:53:51
    Author     : Utilisateur
--%>

<%@page import="entite.Profil_Metier"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <jsp:useBean id="listeProfil" scope="request" class="java.util.List"></jsp:useBean>
             <title>Profils Métier</title>
    </head>
    <body>
        <h1>Liste des profils métier</h1>
        <p><form method ="get" action="ServletAdmin">
        <div style="overflow-x:auto;"> 
        <input type ="text" placeholder='Nom' name="nom" class='input'/>
        <input class='bouton' type="submit" value="Valider"/></br>
        <input type ="hidden" name="action" value="RechercherProfilMetier">
        <table border width="50%">
        <a href="ServletAdmin?action=CreationProfilMetier"> Créer un nouveau profil métier </a>      
            <tr> <td>Id</td>
                 <td>Niveau d'habilitation</td>
                 <td>Offre</td>
                 <td>Utilisateur Hardis</td>
            </tr>
                 <% List <Profil_Metier> lesProfils = listeProfil;
                 for(Profil_Metier profil : lesProfils){%>
            <tr> <td Width=15%><%=profil.getId()%></td>
                 <td Width=15%><%=profil.getNiveau_Habilitation()%></td>
                 <td Width=15%><%=profil.getlOffre().getNom_Offre()%></td>
                 <td Width=15%><%=profil.getlUtilisateur().getPrenom_Utilisateur()%><%=" "%><%=profil.getlUtilisateur().getNom_Utilisateur()%></td>
                 <td Width=15%><a href="ServletAdmin?action=ModifierProfilMetier&idProfilMetier=<%=profil.getId()%>">Modifier</a>
                 <td Width=15%><a href="ServletAdmin?action=SupprimerProfilMetier&idProfilMetier=<%=profil.getId()%>">Supprimer</a>
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