<%-- 
    Document   : ModificationAgence
    Created on : 19 mars 2019, 11:51:21
    Author     : Utilisateur
--%>

<%@page import="entite.Agence"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeAgence" scope="request" class = "java.util.List"> </jsp:useBean>
<%@include file="jsp_reused/style.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifier une agence</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Modifier une agence</h1>
                    </div>

                    <% List<Agence> lesAgences = listeAgence;%>
                    <% for (Agence agence : lesAgences) {%>
                    <form method ="get" action="ServletAdmin">
                        <input type="hidden" name="id" value="<%=agence.getId()%>" class='input'/>

                        <div class="form-group">
                            <label for="cp">Code postal </label>
                            <input type ="text" name="cp" value="<%=agence.getCP_Agence()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="pays"> Pays </label>
                            <input type="text" name="pays" value="<%=agence.getPays_Agence()%>" readonly class ="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="adresse">Adresse</label>
                            <input type ="text" name="adresse" value="<%=agence.getRue_Agence()%>" class='form-control'/>
                        </div>            
                        <div class="form-group">
                            <label for="ville">Ville</label>
                            <input type ="text" name="ville" value="<%=agence.getVille_Agence()%>" class='form-control'/>
                        </div>
                        <div class='bouton1'>
                            </br>
                            <input type ="hidden" name="action" value="ActionModifierAgence"/>     
                            <%}%>
                            <input  class='btn btn-indigo' type="submit" value="Valider"/>
                            <input  class='btn btn-indigo' type="reset" value="Effacer"/>       
                        </div>
                        </br>
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