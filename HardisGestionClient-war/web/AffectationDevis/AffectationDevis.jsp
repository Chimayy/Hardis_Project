<%-- 
    Document   : AffectationDevis
    Created on : 14 mars 2019, 14:49:15
    Author     : Mathieu Harmand
--%>

<<<<<<< HEAD
=======
<%@page import="entite.Profil_Metier"%>
<%@page import="entite.Utilisateur"%>
>>>>>>> exiless3
<%@page import="entite.Devis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
        <jsp:useBean id="ListeDevisNonAttribue" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
        <title>Affectation devis</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Acceuil Gestionaire</h1>
                    </div>

                    <hr class="my-6">

                    <h1>Affectation des devis</h1>
                    <table class="table table-bordered">
                        <thead>
                            <tr> 
                                <th>Id</th>
                                <th>Client</th>
                                <th>Date</th>
                                <th>Offre</th>
                                <th>Affecter</th>   
                            </tr>
                        </thead>
                        <% List<Devis> d = ListeDevisNonAttribue;
                            for (Devis devis : d) {%>
                        <tr>

                            <td width=15%><%=devis.getId()%></td>                    
                            <td width=15%><%=devis.getLeClient().getNom_Utilisateur()%></td>                    
                            <td width=15%><input type="text" readonly name="NomCli" readonly value ="<%=devis.getDate_Devis()%>" required minlength="0" maxlength="100" size="35"></td>    

                            <td width=15%><%=devis.getlOffre().getNom_Offre()%></td> 

                            <td width=15%><select name="Gestionnairee" class='form-control'>
                                    <!--faire recup liste gestionnaire offre corres si lvl dans l'offre > =5 et juste nom du mec si lvl =4-->
                                    <option> 
                                </option>

                            </select> 

                        <td width=15%><a class="btn btn-green" href="AcceuilGestionnaire?action=DevisAffecte&Did=<%=devis.getId()%>">Valider L'affectation</a></td>

                    </tr>   <%}%>
                </table>
                <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="AcceuilGestionnaire" value="retour"> Retour </a>    
            </div>
        </div>
        <%@include file="../jsp_reused/footer.jsp" %>
    </div>
    <%@include file="../jsp_reused/javascript.jsp" %>
</body>
</html>
=======
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


>>>>>>> exiless3
