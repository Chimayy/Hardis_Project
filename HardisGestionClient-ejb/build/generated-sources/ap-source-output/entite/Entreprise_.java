package entite;

import entite.Agence;
import entite.Client;
import entite.Interlocuteur;
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
@StaticMetamodel(Entreprise.class)
public class Entreprise_ { 

    public static volatile ListAttribute<Entreprise, Interlocuteur> interlocuteurs;
    public static volatile SingularAttribute<Entreprise, String> numero_SIRET;
    public static volatile ListAttribute<Entreprise, Client> clients;
    public static volatile SingularAttribute<Entreprise, String> nom_Entreprise;
    public static volatile SingularAttribute<Entreprise, String> ville_Entreprise;
    public static volatile SingularAttribute<Entreprise, String> CP_Entreprise;
    public static volatile SingularAttribute<Entreprise, Agence> lAgence;
    public static volatile SingularAttribute<Entreprise, Long> id;
    public static volatile SingularAttribute<Entreprise, String> rue_Entreprise;

}