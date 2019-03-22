<%-- 
    Document   : AffectationDevis
    Created on : 14 mars 2019, 14:49:15
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <jsp:useBean id="ListeDevisNonAttribue" scope="request" class="java.util.List"></jsp:useBean>
        <title>Affectation devis</title>
    </head>
    <body>
        <h1>Affectation des devis</h1>
        <table border width=50%>
            <tr> 
                
                <td>Id</td>
                <td>Client</td>
                <td>Date</td>
                <td>Offre</td>
                <td>Affecter</td>                
               
            </tr>
            <% List<Devis> d= ListeDevisNonAttribue ;
                for(Devis devis : d){%>
                <tr>
                    
                    <td width=15%><%=devis.getId()%></td>                    
                    <td width=15%><%=devis.getLeClient().getNom_Utilisateur()%></td>                    
                    <td width=15%><input type="text" readonly name="NomCli" readonly value ="<%=devis.getDate_Devis() %>" required minlength="0" maxlength="100" size="35"></td>    
                    
                    <td width=15%><%=devis.getlOffre().getNom_Offre()%></td> 
                   
                    <td width=15%><select name="Gestionnairee" class='custom-dropdown__select custom-dropdown__select--white'>
                    <!--faire recup liste gestionnaire offre corres si lvl dans l'offre > =5 et juste nom du mec si lvl =4-->
                   <option 
                   </option>
                  
               </select><br/></td</td> 
                     
                    <td width=15%><a href="AcceuilGestionnaire?action=DevisAffecte&Did=<%=devis.getId()%>">Valider L'affectation</a></td>
                                                            
                </tr>   <%}%>
        </table>
    </body>
</html>
