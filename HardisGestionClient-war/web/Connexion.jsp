<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         
        <%
               String attribut = (String) request.getAttribute("message");
               if(!attribut.isEmpty())
               {
                    out.println(attribut);
               }

           %>
        
        <form method ="get" action="Accueil">
            </br>
                <input type ="text" placeholder='Mail' name="mail" class='input'/>
                <input type ="text" placeholder='mdp'name="mdp" class='input'/>             
                <input type ="hidden" name="action" value="authentif">
            <div class='bouton1'>
            </br>
            <input  class='bouton' type="submit" value="Valider"/>
            <input  class='bouton'type="reset" value="Remise à 0"/>       
            </div>
            </br>         
        </form>
    </body>
</html>
