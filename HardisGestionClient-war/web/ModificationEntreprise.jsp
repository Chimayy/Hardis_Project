<%-- 
    Document   : ModificationEntreprise
    Created on : 19 mars 2019, 09:06:25
    Author     : Utilisateur
--%>

<%@page import="entite.Agence"%>
<%@page import="entite.Entreprise"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeEnt" scope="request" class = "java.util.List"> </jsp:useBean>
<jsp:useBean id="listeAgence" scope="request" class = "java.util.List"> </jsp:useBean>
<%@include file="jsp_reused/style.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifier une entreprise</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Modifier un entreprise</h1>
                    </div>

                    <% List<Entreprise> lesEnt = listeEnt;%>
                    <% List<Agence> lesAgences = listeAgence;%>

                    <% for (Entreprise ent : lesEnt) {%>
                    <form method ="get" action="ServletAdmin">
                        <input type="hidden" name="id" value="<%=ent.getId()%>" class='input'/>
                        <div class="form-group">
                            <label for="nom"> Nom </label> 
                            <input type ="text" name="nom" value="<%=ent.getNom_Entreprise()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="siret"> N° SIRET </label>
                            <input type ="text" name="siret" value="<%=ent.getNumero_SIRET()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="adresse">Adresse</label>
                            <input type ="text" name="adresse" value="<%=ent.getRue_Entreprise()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="cp">Code postal </label>
                            <input type ="text" name="cp" value="<%=ent.getCP_Entreprise()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="ville">Ville</label>
                            <input type ="text" name="ville" value="<%=ent.getVille_Entreprise()%>" class='form-control'/>
                        </div>
                        <label for="Agence" class='textinput'> Agence : </label>
                        <select name="idAgence" class='form-control'>
                            <% for (Agence agence : lesAgences) {%>
                            <option value="<%=agence.getId()%>"><%=agence.getVille_Agence()%>
                            </option>
                            <%}%>
                        </select> 

                        
                            <input type ="hidden" name="action" value="ActionModifierEntreprise"/>     
                            <%}%>
                            <input  class='btn btn-indigo' type="submit" value="Valider"/>
                            <input  class='btn btn-indigo' type="reset" value="Effacer"/>                             
                    </form>                   
                   <hr class="my-6">
                        
                            <a class="btn btn-outline-teal right" href ="MenuAdmin.jsp"> Retour Menu </a>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>