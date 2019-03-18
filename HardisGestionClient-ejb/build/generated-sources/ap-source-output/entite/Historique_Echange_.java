package entite;

import entite.Devis;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-18T09:42:31")
@StaticMetamodel(Historique_Echange.class)
public class Historique_Echange_ { 

    public static volatile SingularAttribute<Historique_Echange, String> path_Compte_Rendu;
    public static volatile SingularAttribute<Historique_Echange, String> contenu_Echange;
    public static volatile SingularAttribute<Historique_Echange, Long> id;
    public static volatile SingularAttribute<Historique_Echange, Date> date_Echange;
    public static volatile SingularAttribute<Historique_Echange, Devis> leDevis;

}