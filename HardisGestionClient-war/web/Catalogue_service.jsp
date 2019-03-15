<%-- 
    Document   : Catalogue_service
    Created on : 15 mars 2019, 09:28:56
    Author     : 3133973
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
          <% 
                String attribut = (String) request.getAttribute("message");
                out.println(attribut);
            %>
    </body>
</html>
