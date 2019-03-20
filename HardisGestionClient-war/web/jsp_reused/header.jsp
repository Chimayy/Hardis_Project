<%-- 
    Document   : header
    Created on : 19 mars 2019, 15:51:27
    Author     : 3133973
--%>


    
        <nav class="navbar ">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <!--                   <img src="Images/Logo_Hardis_Group.png" class="rounded mx-auto d-block" alt="" max-height="10%" width="10%">  -->
                        <div class="navbar-brand"> <h1> HARDIS </h1> </div>
                    </div>
                    <div>
                        <!--                    <div class="col right"><a  href="Connexion.jsp" > <img src="Images/person-3x.png" alt=""></a></div> -->
                        <div class="dropdown">
                            <div class="btn-group">
                                <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    connexion
                                </button>                               
                                <div class="dropdown-menu dropdown-menu-right ">
                                    <form method="get" action="authentification" class="container">
                                        <fieldset >
                                            <h1>Connexion</h1>
                                            <div class="form-group">
                                                <label for="login"> Login <span class="requis">*</span></label>
                                                <input type="text" class="form-control" name="login" value="" size="20" maxlength="20"/>
                                            </div>
                                            <div class="form-group">
                                                <label for="pass"> Pass <span class="requis">*</span></label>
                                                <input type="text" class="form-control" name="pass" value="" size="20" maxlength="20"/>
                                            </div>
                                            <br/>           
                                        </fieldset>
                                          <input class="btn btn-secondary" type="submit" value="Valider"/>
                                        <input class="btn btn-secondary" type="reset" value="Remettre à zéro"/><br/>
                                    </form>
                                </div>                               
                            </div>
                        </div>  
                    </div>
                </div>
            </nav>
    

