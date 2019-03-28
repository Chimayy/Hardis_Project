<%-- 
    Document   : choixConsultant
    Created on : 22 mars 2019, 16:13:28
    Author     : thoma
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="entite.Profil_Metier"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%--<jsp:useBean id="listCV" scope="request" class="java.util.List"></jsp:useBean>--%>
        <jsp:useBean id="listPM" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="devis" scope="request" class="entite.Devis"></jsp:useBean>
        <%--<jsp:useBean id="listConsultant" scope="request" class="java.util.List"></jsp:useBean>--%>

        <%@include file="../jsp_reused/style.jsp" %>


        <title>JSP Page</title>
    </head>
    <body><div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>
                <div class="container">
                    <div class="mx-auto" style="width: 800px ; text-align: center; margin-top:5%;margin-bottom: 5%">

                        <h1>Devis sélectionné : Devis n°<%=devis.getId()%> pour une prestation : <%=devis.getLaPrestation().getLeService().getNom_Service()%></h1></div>
       <hr class="my-6">

                    <h5>Liste des consultants disponibles sur ce service :</h5>
       
        <table class="table table-bordered">
            <thead>
                                <tr> 
                                    <th>Nom</th>
                                    <th>Prenom</th>
                                    <th>CV</th>
                                    <th>Choix</th>
                                </tr>
                            </thead>

            <% List PM = listPM;
            List<Profil_Metier> list = new ArrayList();
            for(Object o : listPM){
                Profil_Metier pm = (Profil_Metier)o;
                list.add(pm);
            }
            for(Profil_Metier PMenCours : list) {%>
                <tr><form method="post" action="ServletClient" class="form form-inline">
                    <td width=15%><%= PMenCours.getlUtilisateur().getNom_Utilisateur()%></td>
                    <td width=15%><%= PMenCours.getlUtilisateur().getPrenom_Utilisateur()%></td>
                   <td width=15%><a href="METRRE LE PATH CV">Accéder au CV</td>
                    <td width=15%> <input type="checkbox" value="<%=PMenCours.getlUtilisateur().getId()%>" name="checkbox"/> choisir ce consultant</td>
                     

                    
   
                
                </tr><%}%>     
        </table>
                        
                        <input type="date" name="dateIntervention" placeholder="ptipote" class="form-control">
                        <input type="hidden" name="action" value="propositionConsultant">
                        <input type="hidden" name="devis" value="<%=devis.getId()%>">
                        <input  class='btn btn-secondary' type="submit" value="Valider"/>
                    </form>

                

         <hr>
                    <a class="btn btn-outline-teal right" href ="ServletClient"> Retour Menu </a>
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>
        </div> 
        <%@include file="../jsp_reused/javascript.jsp" %>
    </body>
</html>
