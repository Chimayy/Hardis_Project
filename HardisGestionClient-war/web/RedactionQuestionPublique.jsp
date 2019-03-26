

<%@page import="entite.Offre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeOffre" scope="request" class = "java.util.List"> </jsp:useBean>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rédiger une question publique</title>
    </head>
    <body>
        <h1>Rédiger une question publique</h1>
        <% List<Offre> lesOffres= listeOffre;%>
        <form method ="get" action="ServletAdmin?action=CreationQuestionPublique">
                <textarea type ="text" name="question" placeholder="Tapez votre question" rows="4" cols="50"></textarea><br/>
                <input type ="text" placeholder='Pseudo'name="pseudo" class='input'><br/>
                <select name="idOffre" class='custom-dropdown__select custom-dropdown__select--white'>
                    <% for (Offre offre : lesOffres ){%>
                    <option value="<%=offre.getId()%>"><%=offre.getNom_Offre()%>
                    </option>
                    <%}%>
                </select><br/>
      
                <input type ="hidden" name="action" value="CreerQuestionPublique">
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Effacer"/>       
            </div>
            </form>
            <div class="message"><% String attribut = (String)request.getAttribute("message");
            out.println(attribut);
           %></div>
            </br>
            <div class='retour'>
            <a href ="Menu_principal.jsp"> Retour Menu </a>
            <a href ="Accueil?action=VoirLeForum"> Voir le Forum des questions </a>
            </div>
    </body>

</html>