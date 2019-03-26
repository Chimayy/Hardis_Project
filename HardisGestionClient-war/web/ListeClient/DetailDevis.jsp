<%-- 
    Document   : DetailDevis
    Created on : 20 mars 2019, 11:56:43
    Author     : Mathieu Harmand
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="entite.statut_Devis"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="entite.Devis"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="Devis" scope="request" class="Devis"></jsp:useBean>
        <%@include file="../jsp_reused/style.jsp" %>
        <% DateFormat f = new SimpleDateFormat("dd/MM/yyyy");%>
        <title>Edition du devis</title>
    </head>

    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 600px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <%Devis d = Devis;
                           int x = 0;%>
                        <h1>Edition du devis  "<%=d.getStatut()%>"</h1>
                        <hr class="my-6">
                    </div>

                    <form  method="get" action="AcceuilGestionnaire">
                        <fieldset>
                            
                            <div class='form-group'>
                                <label for="idDevis"> Id du Devis </label>
                                <input class='form-control' type="text" readonly name="ID" value ="<%=d.getId()%>" ></td>
                            </div>
                            <div class='form-group'>
                                <label for="Client"> Client </label>
                                <input class="form-control"type="text" readonly name="NomCli" value ="<%=d.getLeClient().getNom_Utilisateur()%>" >
                            </div>
                            <div class='form-group'>
                                <label for="Date-Intervention"> Date du devis </label>
                                <input class="form-control" type="text" readonly  name="Datedevis" value ="<%=f.format(d.getDate_Devis())%>" >   
                            </div>
                            <% if (d.getStatut() == statut_Devis.en_negociation) {%>
                            <div class='form-group'>
                                <label for="Modifier-Intervetion">Date d'intervetion </label>
                                <input class="form-control" type="text" readonly name="Date" value ="<%=f.format(d.getDate_Intervention())%>">
                                
                            </div>
                            <div class='form-group'>
                                <label for="Modifier-Intervetion">Modifier la date d'intervetion </label>
                                <input class="form-control" type="date"  name="DateModif" value ="<%=f.format(d.getDate_Intervention())%>">
                            </div>
                            <%}%>
                            <div class='form-group'>
                                <label for="Formulaire-Client"> Formulaire Client </label>
                                <input class='form-control'type="text" readonly name="FClient" value ="<%=d.getFormulaire_Client()%>" required minlength="0" maxlength="100" size="10">
                            </div>
                            <div class='form-group'>
                                <label for="Type_presentation"> Type de presentation </label>
                                <input class='form-control' type="text" readonly name="Prestation" value ="<%=d.getlOffre().getNom_Offre()%>">
                            </div>
                               
                             <% DecimalFormat format = new DecimalFormat();
                                    String SM = String.valueOf(d.getMontant_Devis());
                                    int m = format.parse(SM).intValue();%>
                                    
                                    <% if (d.getStatut() == statut_Devis.en_negociation) {%> 
                            <div class='form-group'>
                                <label for="Montant"> Montant <span class="requis">*</span></label>
                                <input class='form-control' readonly type="text"  name="Montantfixe" value ="<%=m%>">
                            </div><%}%>
                            <% if (d.getStatut() == statut_Devis.incomplet || d.getStatut()== statut_Devis.a_traiter) {%>
                            <div class='form-group'>
                                <label for="Montant"> Montant <span class="requis">*</span></label>
                                <input class='form-control' type="text"  name="Montant" value ="<%=m%>">
                            </div><%}%>
                            <% if (d.getStatut() == statut_Devis.incomplet){%>
                            <div class='form-group'>
                                <label for="MRefus"> Motif Refus <span class="requis">*</span></label>
                                <input class='form-control' type="text" readonly name="Mrefus" value ="<%=d.getMotif_Refus() %>">
                            </div>
                            <%}%>
                           <input type="hidden" name="x" value="<%=d.getId()%>">
                            <% if (d.getStatut() == statut_Devis.en_negociation) {%>    
                            <input type="hidden" name="action" value="ValiderDevis">
                            <input class='btn btn-blue' type="submit"  value="Valider le devis"> <%}%>
                                <% if (d.getStatut() == statut_Devis.a_traiter) {
                                        x = 1;%>                       
                            <input  type="hidden" name="action" value="EnvoyerDevis">
                            <input class='btn btn-blue' type="submit" value="Envoyer le devis"> <%}%>               

                        </fieldset>
                    </form>
                            <hr class="my-6">
                            <a class="btn btn-outline-teal right" href="AcceuilGestionnaire?action=VisuClients" value="retour"> Retour </a>
                            
                </div>
            </div>
                            <%@include file="../jsp_reused/footer.jsp" %>
        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>
    </body>
</html>
