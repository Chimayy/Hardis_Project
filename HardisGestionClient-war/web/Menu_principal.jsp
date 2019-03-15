<%-- 
    Document   : Menu_principal
    Created on : 15 mars 2019, 09:18:05
    Author     : 3133973
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Menu Visisteur hardis</h1>
          <% 
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
            <a href="Connexion.jsp"> Connexion </a>
          <table>
            <tr>
                <td width="25%"><a href="Accueil?action=Catalogue">Catalogue des services</a></td>
                <td width="25%"><a href="Interface_question.jsp">Interface des questions</a></td>
                <td width="25%"><a href="Contact.jsp">Faire une demande de contact</a></td>
            </tr>
        </table>
    </body>
</html>
