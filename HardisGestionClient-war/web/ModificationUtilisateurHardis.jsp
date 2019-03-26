<%-- 
    Document   : ModificationUtilisateurHardis
    Created on : 14 mars 2019, 16:22:28
    Author     : Utilisateur
--%>

<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Utilisateur"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="listeUser" scope="request" class = "java.util.List"> </jsp:useBean>
<%@include file="jsp_reused/style.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Modifier un utilisateur</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Modifier un utilisateur</h1>
                    </div>

                    <% List<Utilisateur_Hardis> leUser = listeUser;%>

                    <% for (Utilisateur_Hardis user : leUser) {%>
                    <form method ="get" action="ServletAdmin">
                        <input type="hidden" name="id" value="<%=user.getId()%>" class='input'/>
                        <div class="form-group">
                            <label for="nom">Nom</label>
                            <input type ="text" name="nom" value="<%=user.getNom_Utilisateur()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="prenom">Prenom</label>
                            <input type ="text" name="prenom" value="<%=user.getPrenom_Utilisateur()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="mail"> Mail</label>
                            <input type ="text" name="mail" value="<%=user.getMail_Connexion()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="mdp"> Mot de passe </label>
                            <input type ="text" name="motdepasse" value="<%=user.getMot_De_Passe()%>" class='form-control'/>
                        </div>
                        <div class="form-group">
                            <label for="plafond">Plafond de délégation </label>
                            <input type ="text" name="plafond" value="<%=user.getPlafond_Delegation()%>"class='form-control'/>
                        </div>

                        <div class="form-group">
                            <label for="profil">Profil technique</label>

                            <select name="profil" size="1" class="form-control">
                                <option> administrateur
                                <option> gestionnaire
                                <option> visualisation        
                            </select>
                        </div>

                            
                            <input type ="hidden" name="action" value="ActionModifierUtilisateur"/>     
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