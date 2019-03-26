<%-- 
    Document   : creerPeriode
    Created on : 25 mars 2019, 09:15:18
    Author     : thoma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../jsp_reused/style.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                    <%@include file="../jsp_reused/header.jsp" %>
                </header>

                <div class="container">
                    <div class="mx-auto" style="width: 400px ; text-align: center; margin-top:5%;margin-bottom: 5%">
                        <h1>Creer date de disponibilité</h1>
                    </div>

                    <hr class="my-6">

                    <form method="get" action="AcceuilGestionnaire">
                        <div class="form-group">
                            <label for="debut">Date de début</label>
                            <input type="date" name="dateDebut" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <label for="fin">Date de fin</label>
                            <input type="date" name="dateFin" class="form-control" />
                        </div>
                        <input class="btn btn-blue" type="submit" name="Valider"/>
                        <input type="hidden" name="action" value="creationDispo">
                    </form>
                    <hr class="my-6">
                       
                            <a class="btn btn-outline-teal right" href ="MenuAdmin.jsp"> Retour Menu </a>
                </div>
            </div>
            <%@include file="../jsp_reused/footer.jsp" %>
        </div>
        <%@include file="../jsp_reused/javascript.jsp" %>
    </body>
</html>
