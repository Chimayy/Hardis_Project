<%-- 
    Document   : Temporaire
    Created on : 20 mars 2019, 17:17:06
    Author     : thoma
--%>

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
            <META HTTP-EQUIV="Refresh" CONTENT="0.1; URL=/HardisGestionClient-war/ServletClient">
        <%}%>
    <%if (UserARecup instanceof Utilisateur_Hardis) 
        {
            Utilisateur_Hardis user_H = (Utilisateur_Hardis) UserARecup;
            if (user_H.getProfil_Technique().toString().equals("administrateur")) 
            {%>
                <META HTTP-EQUIV="Refresh" CONTENT="0.1; URL=/HardisGestionClient-war/ServletAdmin">
            <%}%>
            <% if (user_H.getProfil_Technique().toString().equals("gestionnaire")) 
            {%>
                <META HTTP-EQUIV="Refresh" CONTENT="0.1; URL=/HardisGestionClient-war/AcceuilGestionnaire">
            <%}
        }%>

   
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form method ="get" action="ServletClient">
        <% if (UserARecup instanceof Client) {
        Client client =(Client)UserARecup;%>
        <input type="text" name="user" value="<%=client%>">
        <%}
                if (UserARecup instanceof Utilisateur_Hardis) {
        Utilisateur_Hardis user_H =(Utilisateur_Hardis) UserARecup;%>
        <input type="texte" name="user" value="<%=user_H%>">
        <%}%>
        <input type="hidden" name="action" value="">
    </form>
</body>

