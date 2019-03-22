<%-- 
    Document   : CreationEntreprise
    Created on : 18 mars 2019, 10:16:44
    Author     : Utilisateur
--%>

<%@page import="java.util.List"%>
<%@page import="entite.Agence"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeAgence" scope="request" class = "java.util.List"> </jsp:useBean>
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="jsp_reused/style.jsp"%>
        <title>Créer une entreprise</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Créer une entreprise</h1>
                    </div>


                    <% List<Agence> lesAgences = listeAgence;%>
                    <form method ="get" action="ServletAdmin">
                        <div class="form-group">
                            <label for="Nom"> Nom </label>
                            <input type ="text"  name="nom" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="SIRET"> N° SIRET </label>
                            <input type ="text"  name="siret" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="Adresse"> Adresse </label>
                            <input type ="text"  name="adresse" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="cPostal"> Code Postal </label>
                            <input type ="text" name="code_postal" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="Ville"> Ville </label>
                            <input type ="text"  name="ville" class='form-control'/><br/> 
                        </div>
                        
                        <div class="form-group">
                            <label for="Agence" > Agence  </label>
                            <select name="idAgence" class='form-control'>
                                <% for (Agence agence : lesAgences) {%>
                                <option value="<%=agence.getId()%>"><%=agence.getVille_Agence()%>
                                </option>
                                <%}%>
                            </select>
                            <a style="color:orange" class="right" href="ServletAdmin?action=AfficherAgences" >L'agence n'est pas dans la liste ? </a>
                            <input type ="hidden" name="action" value="CreerEntreprise">
                        </div>
                        
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