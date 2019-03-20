package entite;

import entite.Entreprise;
import entite.Utilisateur_Hardis;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T16:47:31")

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:04")

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:04")

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-18T11:01:56")

=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T17:10:48")
>>>>>>> schellen
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-18T09:42:31")
>>>>>>> schellen
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-19T18:20:53")
>>>>>>> schellen
@StaticMetamodel(Agence.class)
public class Agence_ { 

    public static volatile SingularAttribute<Agence, String> pays_Agence;
    public static volatile ListAttribute<Agence, Entreprise> entreprises;
    public static volatile ListAttribute<Agence, Utilisateur_Hardis> lesUtilisateur_Hardis;
    public static volatile SingularAttribute<Agence, String> ville_Agence;
    public static volatile SingularAttribute<Agence, String> rue_Agence;
    public static volatile SingularAttribute<Agence, Long> id;
    public static volatile SingularAttribute<Agence, String> CP_Agence;

}