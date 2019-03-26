
<%@page import="entite.Profil_Metier"%>
<%@page import="entite.Utilisateur_Hardis"%>
<%@page import="entite.Historique_QuestionPublique"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="listeQuestion" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeUser" scope="request" class="java.util.List"></jsp:useBean>
        <jsp:useBean id="listeProfil" scope="request" class="java.util.List"></jsp:useBean>
        <%@include file="jsp_reused/style.jsp" %>
        <title>Questions Publiques</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Menu Administrateur</h1>
                    </div>

                    <hr class="my-6">

                    <h2>Liste des questions publiques</h2>
                    <hr class="my-4"> 
                    <table class='table table-bordered'>
                        <thead >
                            <tr>
                                <th>Offre</th>
                                <th>Question</th>
                                <th>Réponse</th>
                                <th>Pseudo visiteur</th>
                                <th>Gestionnaire</th>
                            </tr>
                        </thead>
                        <% List<Historique_QuestionPublique> lesQuestions = listeQuestion;%>
                        <% List<Utilisateur_Hardis> lesUser = listeUser;%>
                        <% List<Profil_Metier> lesProfils = listeProfil;%>
                                <%for (Historique_QuestionPublique historique : lesQuestions) {
                                 %>
                        <tr><form method="get" action="ServletAdmin">
                            <input type="hidden" name="idQuestion" value="<%=historique.getId()%>"</td>
                            <td Width=15%><%=historique.getlOffre().getNom_Offre()%></td>
                            <td Width=15%><%=historique.getQuestion()%></td>
                            <td Width=15%> </td>
                            <td Width=15%><%=historique.getPseudo()%></td>
                            <td Width=15%><select name="idUser">
                            <%for(Profil_Metier profil : lesProfils){
                                for (Utilisateur_Hardis user: lesUser){  
                                if(user.getId() == profil.getlUtilisateur().getId() && profil.getlOffre().getId() == historique.getlOffre().getId()){%>
                                 <option value="<%=user.getId()%>"><%=user.getPrenom_Utilisateur()%> <%=user.getNom_Utilisateur()%></option>     
                                <%}}}%>
                                    </select></td> 
                            <td Width=15%><a style="color:grey"href="ServletAdmin?action=SupprimerQuestionPublique&idQuestion=<%=historique.getId()%>">Supprimer</a> 
                            <input type ="hidden" name="action" value="AttribuerQuestionPublique">
                            <td Width=15%><input class='bouton' type="submit" value="Attribuer"/>    
                              </form>
                           <%--<td Width=15%><a style="color:grey"href="ServletAdmin?action=AttribuerQuestionPublique&idQuestion=<%=historique.getId()%>">Attribuer</a>--%>                                     
                                <%}%> 
                    </table>
                    <hr class="my-6">
                    <a class="btn btn-outline-teal right" href="MenuAdmin.jsp" value="retour"> Retour </a> 

                    <div class="message"><% String attribut = (String) request.getAttribute("message");
                        out.println(attribut);
                        %></div>
                </div>              
            </div>
            <%@include file="jsp_reused/footer.jsp"%>
        </div>
        <%@include file="jsp_reused/javascript.jsp"%>
    </body>
</html>

