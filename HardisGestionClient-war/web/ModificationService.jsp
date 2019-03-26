<%-- 
    Document   : ModificationService
    Created on : 19 mars 2019, 16:40:10
    Author     : Utilisateur
--%>

<%@page import="entite.Offre"%>
<%@page import="entite.Service"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeServ" scope="request" class = "java.util.List"> </jsp:useBean>
<jsp:useBean id="listeOffre" scope="request" class = "java.util.List"> </jsp:useBean>
<%@include file="jsp_reused/style.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifier un service</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Modifier un service</h1>
                    </div>

                    <% List<Service> lesServices = listeServ;%>
                    <% List<Offre> lesOffres = listeOffre;%>
                    <% for (Service serv : lesServices) {%>
                    <form method ="get" action="ServletAdmin">
                        <input type="hidden" name="id" value="<%=serv.getId()%>" class='input'/>
                        <div class="form-group">
                            <label for="nom"> Nom </label>
                            <input type ="text" name="nom" value="<%=serv.getNom_Service()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="description">Description</label>
                            <input type ="text" name="description" value="<%=serv.getDescription_Service()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="cout"> Coût du service </label>
                            <input type ="text" name=cout value="<%=serv.getCout_Service()%>" class='form-control'/>
                        </div>
                        <label for="Offre" > Offre : </label>
                        <select name="idOffre" class='form-control'>
                            <% for (Offre offre : lesOffres) {%>
                            <option value="<%=offre.getId()%>"><%=offre.getNom_Offre()%>
                            </option>
                            <%}%>
                        </select> 

                        <input type ="hidden" name="action" value="ActionModifierService"/>     
                        <%}%>
                        <input  class='btn btn-indigo' type="submit" value="Valider"/>
                        <input  class='btn btn-indigo' type="reset" value="Effacer"/>       
                        <hr class="my-6">                      
                        <a class="btn btn-outline-teal right" href ="MenuAdmin.jsp"> Retour Menu </a>
                    </form>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>