
<%@page import="java.util.List"%>
<%@page import="entite.Service"%>
<%-- 
    Document   : DemandeDevis
    Created on : 15 mars 2019, 14:47:08
    Author     : thoma
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <%@include file="jsp_reused/style.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
         <div class="flex-wrapper">
            <div class="container-fluid nopad">
                <header>
                     <%@include file="jsp_reused/header.jsp" %>
                     <jsp:useBean id="listService" scope="request" class="java.util.List"></jsp:useBean>
                </header>
        
            <div class="container">
                <form method="get" action="ServletClient">
                     <fieldset>
                         <div  style=" margin-top:1%;margin-bottom: 1%">
                                <h1>Formulaire de demande de devis</h1>
                                <hr class="my-6">
                            </div>
                         <div class="form-group">                          
                            <label for="zoneLibre"> zone libre</label>
                            <input type="text"class="form-control" name="zoneLibre" value="" rows ="5"/>
                         </div>
                         <div class="form-group">
                            
                           <label for="idService"> Service voulu :</label>
                            <select name="idService">
                                <% List<Service> lesServices = listService;
                                    for (Service s : lesServices){%>
                                <option value="<%=s.getId()%>"><%=s.getNom_Service()%></option>
                                <%}%>
                            </select>
                         </div>
                         <input type="hidden" name="action" value="demandeDevis">
                     </fieldset>
                     <input type="submit" class="btn btn-secondary" value="Valider"/>
                     <input type="reset"class="btn btn-secondary" value="Remettre à zéro"/><br/>
                 </form>
                <hr class="my-6">
                <a class="btn btn-outline-teal right" href="MenuClient.jsp" value="retour"> Retour </a> 
            </div>
            </div>
                <%@include file="jsp_reused/footer.jsp"%>
         </div>
         <%@include file="jsp_reused/javascript.jsp"%>