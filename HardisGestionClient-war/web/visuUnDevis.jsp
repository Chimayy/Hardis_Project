<%-- 
    Document   : visuUnDevis
    Created on : 18 mars 2019, 11:07:28
    Author     : thoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="entite.Devis"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:useBean id="devis" scope="request" class="entite.Devis"></jsp:useBean>
        <jsp:useBean id="message" scope="request" class="String"></jsp:useBean>
        <%@include file="jsp_reused/style.jsp" %>

        <title>JSP Page</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Devis client </h1>
                    </div>

                    <form method="get" action="ServletClient" >
                        <table class="table table-bordered">
                            <thead>
                                <tr>
                                    <th> numero du devis</th>
                                    <th> formulaire libre</th>
                                    <th> montant du devis</th>
                                </tr>
                            </thead>

                            <tr>
                                <td> 
                                    <%out.println("Devis n° :" + devis.getId());%>
                                <td> 
                                    <div class="form-group">
                                        <label for="zoneLibre"> Description du besoin</label>
                                        <input class="form-control"  type="text" value="<%=devis.getFormulaire_Client()%>" name="zoneLibre"/>
                                    </div>
                                </td>
                                <td>  
                                    <div class="form-group">
                                        <label for="montant"> montant</label>
                                        <input class="form-control" type="number" value="<%=devis.getMontant_Devis()%>" name="montant"/>
                                    </div>
                                </td>
                            </tr>
                        </table>
                        <div class="form-group">
                            <label for="refus"> Motif de refus</label>
                            <input class="form-control" type="text-area" name="refus">
                        </div>

                        <input type="hidden" name="devis" value="<%=devis.getId()%>">
                        <button class="btn btn-secondary" type="submit" name="action" value="Valider"> Valider</button>
                        <button class="btn btn-secondary" type="submit" name="action" value="Modifier"> Modifier</button>
                        <button class="btn btn-secondary" type="submit" name="action" value="Refuser"> Refuser le devis</button>
                    </form>
                    <a class="btn btn-outline-teal right" href="ServletClient"> Retour Menu </a>
                </div>
            </div>
            <%@include file="jsp_reused/footer.jsp" %>
        </div>
        <%@include file="jsp_reused/javascript.jsp" %>
    </body>
</html>
