<%-- 
    Document   : AffectationDevis
    Created on : 14 mars 2019, 14:49:15
    Author     : Mathieu Harmand
--%>

<%@page import="entite.Profil_Metier"%>
<%@page import="entite.Utilisateur"%>
<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <jsp:useBean id="User" scope="session" class="Utilisateur"></jsp:useBean>
           <jsp:useBean id="profil" scope="request" class="java.util.List"></jsp:useBean> 
           <jsp:useBean id="ListeProfil" scope="request" class="java.util.List"></jsp:useBean> 
         <jsp:useBean id="ListeDevisNonAttribue" scope="request" class="java.util.List"></jsp:useBean>
         
        <title>Affectation devis</title>
    </head>
    <body>
      
        <form method="get" action="AcceuilGestionnaire">
         <%List <Profil_Metier> ToutLesProfil = ListeProfil;%>
          <% List<Devis> d= ListeDevisNonAttribue; %>  
          <%Utilisateur gest = User;List<Profil_Metier> ListePM = profil;%>
        <h1>Affectation des devis</h1>
        <table border width=50%>
            <tr> 
                
                <td>Id</td>
                <td>Client</td>
                <td>Date</td>
                <td>Offre</td>
                <td>Affecter</td>                
               
            </tr>
           <%
                for(Devis devis : d){%>
                <tr>
                    <%
                    
                    for(Profil_Metier pm : ListePM){
                        if(pm.getlOffre().getId()==devis.getlOffre().getId()&&pm.getNiveau_Habilitation()>=4){%>
                        
                        <td width=15%><%=devis.getId()%></td>                    
                    <td width=15%><%=devis.getLeClient().getNom_Utilisateur()%></td>                    
                    <td width=15%><input type="text" readonly name="NomCli" readonly value ="<%=devis.getDate_Devis() %>" required minlength="0" maxlength="100" size="35"></td>    
                    
                    <td width=15%><%=devis.getlOffre().getNom_Offre()%></td> 
                    
                    <%if(pm.getNiveau_Habilitation()==4){%>
                                                          
                    <td width=15%><input type="text" readonly name="NomAaffecter" value ="<%=gest.getNom_Utilisateur()%>" required minlength="0" maxlength="100" size="10"></td>   <%}%>    
                    
                    <%if(pm.getNiveau_Habilitation()>=5){%>
                    
                    <td width=15%><select name="NomAaffecter" class='custom-dropdown__select custom-dropdown__select--white'>
                   <% for (Profil_Metier pm1 : ToutLesProfil ){
                       if(pm1.getlOffre().getId()== devis.getlOffre().getId()){
                   %>
                   <option value="<%=pm1.getlUtilisateur().getNom_Utilisateur() %>"><%=pm1.getlUtilisateur().getNom_Utilisateur() %></option>
                   <%}%><%}%>
               </select></td>   <%}%>
               
                    <input type="hidden" name="action" value="DevisAffecte">
                    
                    <input type="hidden" name="devis" value="<%=devis.getId()%>">
                     
                    <td width=15%><input type="submit" value="Valider L'affectation"></td>
                    
                    
                          
                            
                        <%}%>
                    <%}%>
                   
                                                                                
                </tr>   <%}%>
        </table>
         </form>  
    </body>
</html>


