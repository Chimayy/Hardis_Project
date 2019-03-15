<%-- 
    Document   : Catalogue_service
    Created on : 15 mars 2019, 09:28:56
    Author     : 3133973
--%>

<%@page import="entite.Service"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <jsp:useBean id="listeService" scope="request" class="java.util.List"></jsp:useBean>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
          
             <% List<Service> lesServices=listeService;
                for(Service sv : lesServices){%>
    <tr> 
        <td><%=sv.getId()%></td>
        <td><%=sv.getDescription_Service()%></td>
        <td><%=sv.getCout_Service()%></td>
    </tr>
           <%}%> 
    </body>
</html>
