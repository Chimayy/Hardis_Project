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
        <% DateFormat f = new SimpleDateFormat("dd/MM/yyyy");%>

        <title>Edition du devis</title>
    </head>
    <body>
        <form method="get" action="AcceuilGestionnaire">
            <%Devis d = Devis;
                int x = 0;%>
            <h1>Edition du devis  <%=d.getStatut()%></h1
            <table border width=50%>


                <p>id devis :<td width=15%><input type="text" readonly name="ID" value ="<%=d.getId()%>" required minlength="0" maxlength="100" size="10"></td></p>
                <p>Client <td width=15%><input type="text" readonly name="NomCli" value ="<%=d.getLeClient().getNom_Utilisateur()%>" required minlength="0" maxlength="100" size="10"></td></p>              
                <p>Date intervention :<td width=15%><input type="text" readonly  name="DateInter" value ="<%=f.format(d.getDate_Intervention())%>" required minlength="0" maxlength="100" size="10">
                    <% if (d.getStatut() == statut_Devis.en_negociation) {%>
                </td><td>Modifier la date d'intervention :</td><td width=15%><input type="date"  name="DateModif"     required minlength="0" maxlength="100" size="10"></td>
                <%}%></p>
                <p>Formulaire client :<td width=15%><input type="text" readonly name="FClient" value ="<%=d.getFormulaire_Client()%>" required minlength="0" maxlength="100" size="10"></td></p>
                <p>Type de prestation :<td width=15%><input type="text" readonly name="Prestation" value ="<%=d.getlOffre().getNom_Offre()%>" required minlength="0" maxlength="100" size="10"></td></p>
                    <% DecimalFormat format = new DecimalFormat();
                        String SM = String.valueOf(d.getMontant_Devis());
                        int m = format.parse(SM).intValue();%>
                <p>Montant : <td width=15%><input type="text"  name="Montant" value ="<%=m%>" required minlength="0" maxlength="100" size="10"></td></p>
                <input type="hidden" name="x" value="<%=d.getId()%>">
                <% if (d.getStatut() == statut_Devis.en_negociation) {%>    
                <input type="hidden" name="action" value="ValiderDevis">
                <td width=15%><input type="submit"  value="Valider le devis"></td> <%}%>
                    <% if (d.getStatut() == statut_Devis.a_traiter) {
                            x = 1;%>                       
                <input type="hidden" name="action" value="EnvoyerDevis">
                <td width=15%><input type="submit" value="Envoyer le devis"></td> <%}%>               

            </table>
        </form>
    </body>
</html>
