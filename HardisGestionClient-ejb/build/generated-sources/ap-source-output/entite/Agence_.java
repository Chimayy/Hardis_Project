package entite;

import entite.Entreprise;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T16:47:31")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:04")
>>>>>>> origin/schellen
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:04")
>>>>>>> schellen
@StaticMetamodel(Agence.class)
public class Agence_ { 

    public static volatile SingularAttribute<Agence, String> pays_Agence;
    public static volatile ListAttribute<Agence, Entreprise> entreprises;
    public static volatile SingularAttribute<Agence, String> ville_Agence;
    public static volatile SingularAttribute<Agence, String> rue_Agence;
    public static volatile SingularAttribute<Agence, Long> id;
    public static volatile SingularAttribute<Agence, String> CP_Agence;

}