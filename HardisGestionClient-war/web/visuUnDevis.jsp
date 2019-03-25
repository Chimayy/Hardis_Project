<%-- 
    Document   : visuUnDevis
    Created on : 18 mars 2019, 11:07:28
    Author     : thoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entite.Devis"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="devis" scope="request" class="entite.Devis"></jsp:useBean>
        <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Devis client </h1>
        <form method="get" action="ServletClient">
        <table>
            <tr>
                <td> numero du devis</td>
                <td> formulaire libre</td>
                <td> montant du devis</td>
            </tr>
            
            <tr>
                <td> 
                    <%out.println("Devis n° :" + devis.getId());%>
                <td>  
                    <label for="zoneLibre"> zone libre</label>
                    <input type="text" value="<%=devis.getFormulaire_Client()%>" name="zoneLibre"/>
                </td>
                <td>  
                    <label for="montant"> montant</label>
                    <input type="number" value="<%=devis.getMontant_Devis()%>" name="montant"/>
                </td>
            </tr>
        </table>
                <label for="refus"> motif de refus</label>
                    <input type="text" name="refus">
                
    <input type="hidden" name="devis" value="<%=devis.getId()%>">
            </fieldset>
           <button type="submit" name="action" value="Valider"> Valider</button>
           <button type="submit" name="action" value="Modifier"> Modifier</button>
           <button type="submit" name="action" value="Refuser"> Refuser le devis</button>
    </form>
    <a href="MenuClient.jsp"> Retour Menu </a>
    </body>
</html>
