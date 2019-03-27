
<nav class="navbar ">
    <div class="container-fluid">
        <div class="navbar-header"> 
            <div class="navbar-brand" > <a href="Menu_principal.jsp"><h1> HARDIS</h1> </a> </div>                     
        </div>
        <div>
                    <div class="dropdown">
                        <div class="btn-group">
                            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                connexion
                            </button>                               
                            <div class="dropdown-menu dropdown-menu-right ">
                                <form method="get" action="Accueil" class="container">

                                    <fieldset >
                                        <h1>Connexion</h1>
                                        <div class="form-group">
                                            <label for="login"> Login <span class="requis">*</span></label>

                                            <input type="text" class="form-control" name="mail" value="" size="20" maxlength="200"/>

                                        </div>
                                        <div class="form-group">
                                            <label for="pass"> Pass <span class="requis">*</span></label>
                                            <input type="password" class="form-control" name="mdp" value="" size="20" maxlength="20"/>
                                            <input type ="hidden" name="action" value="authentif">
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


