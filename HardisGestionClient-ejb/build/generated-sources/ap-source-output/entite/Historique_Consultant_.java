package entite;

import entite.Devis;
import entite.Utilisateur_Hardis;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
<<<<<<< HEAD

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T16:47:31")

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:03")

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:03")

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-18T11:01:56")

=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T17:10:48")
>>>>>>> schellen
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-18T09:42:31")
>>>>>>> schellen
@StaticMetamodel(Historique_Consultant.class)
public class Historique_Consultant_ { 

    public static volatile SingularAttribute<Historique_Consultant, String> fonctionConsultant;
    public static volatile SingularAttribute<Historique_Consultant, Date> dateDebut;
    public static volatile SingularAttribute<Historique_Consultant, Utilisateur_Hardis> leConsultant;
    public static volatile SingularAttribute<Historique_Consultant, Date> dateFin;
    public static volatile SingularAttribute<Historique_Consultant, Long> id;
    public static volatile SingularAttribute<Historique_Consultant, Devis> leDevis;

}