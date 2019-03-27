<%-- 
    Document   : Temporaire
    Created on : 20 mars 2019, 17:17:06
    Author     : thoma
--%>

<%@page import="entite.profil_Technique"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Utilisateur"%>
<%@page import="entite.Client"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <jsp:useBean id="UserARecup" scope="session" class = "Utilisateur"> </jsp:useBean>
     <% if (UserARecup instanceof Client) 
        {%>
            <META HTTP-EQUIV="Refresh" CONTENT="1; URL=/HardisGestionClient-war/ServletClient">
        <%}%>
    <%if (UserARecup instanceof Utilisateur_Hardis) 
        {
            Utilisateur_Hardis user_H = (Utilisateur_Hardis) UserARecup;
            if (user_H.getProfil_Technique().toString().equals("administrateur")) 
            {%>
                <META HTTP-EQUIV="Refresh" CONTENT="1; URL=/HardisGestionClient-war/ServletAdmin">
            <%}%>
            <% if (user_H.getProfil_Technique().toString().equals("gestionnaire")) 
            {%>
                <META HTTP-EQUIV="Refresh" CONTENT="1; URL=/HardisGestionClient-war/AcceuilGestionnaire">
            <%}
     if (user_H.getProfil_Technique().toString().equals("visualisation")) 
            {%>
                <META HTTP-EQUIV="Refresh" CONTENT="1; URL=/HardisGestionClient-war/MenuVisualisation.jsp">
            <%}    
    }%>

   
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Chargement ...</h1>
        <form method ="get" action="ServletClient">
        <% if (UserARecup instanceof Client) {
        Client client =(Client)UserARecup;
        out.println("Merci de cliquer sur <a href='HardisGestionClient-war/MenuClient.jsp'>ce lien</a> si cette page ne se charge pas :");%>
        <input type="hidden" name="user" value="<%=client%>">
        <%}
                if (UserARecup instanceof Utilisateur_Hardis) {
        Utilisateur_Hardis user_H =(Utilisateur_Hardis) UserARecup;
if(user_H.getProfil_Technique().equals(profil_Technique.administrateur)){
out.println("Merci de cliquer sur <a href='HardisGestionClient-war/MenuAdmin.jsp'>ce lien</a> si cette page ne se charge pas :");
}
if(user_H.getProfil_Technique().equals(profil_Technique.gestionnaire))
{
        out.println("Merci de cliquer sur <a href='HardisGestionClient-war/MenuGestionnaire.jsp'>ce lien</a> si cette page ne se charge pas :");
}
        if(user_H.getProfil_Technique().equals(profil_Technique.visualisation))
{
        out.println("Merci de cliquer sur <a href='HardisGestionClient-war/MenuVisualisationjsp'>ce lien</a> si cette page ne se charge pas :");
}}%>
        
        <!--<input type="hidden" name="user" value="">-->
        <input type="hidden" name="action" value="">
    </form>
</body>

