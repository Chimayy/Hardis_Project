<%-- 
    Document   : ModificationProfilMetier
    Created on : 22 mars 2019, 08:19:03
    Author     : Utilisateur
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Offre"%>
<%@page import="entite.Profil_Metier"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeProfil" scope="request" class = "java.util.List"> </jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <title>Modifier un profil métier</title>
        <%@include file="jsp_reused/style.jsp" %>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>
                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Créer utilisateur</h1>
                    </div>
                    <h1>Modifier un profil métier</h1>
                    <% List<Profil_Metier> lesProfils = listeProfil;%>
                    <% for (Profil_Metier profil : lesProfils) {%>
                    <form method ="get" action="ServletAdmin" >
                        <input type="hidden" name="id" value="<%=profil.getId()%>" class='input'/>
                        <div class="form-group">
                            <p> Niveau d'habilitation : <input class="form-control" type ="text" name="niveau" value="<%=profil.getNiveau_Habilitation()%>"/></p>              
                            <input type ="hidden" name="action" value="ActionModifierProfilMetier"/>  
                        </div>
                            
                        <input  class='btn btn-indigo' type="submit" value="Valider"/>
                        <input  class='btn btn-indigo'type="reset" value="Effacer"/>
                        </form>
                        <%}%>
                        <div class='retour'>
                            <a class="btn btn-outline-teal right" href ="ServletAdmin"> Retour Menu </a>
                        </div>
                    
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>

        </div>
        <%@include file="jsp_reused/javascript.jsp" %>

    </body>
</html>