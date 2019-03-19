package entite;

import entite.Offre;
import entite.Prestation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

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
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Offre> lOffre;
    public static volatile ListAttribute<Service, Prestation> prestations;
    public static volatile SingularAttribute<Service, String> description_Service;
    public static volatile SingularAttribute<Service, Double> cout_Service;
    public static volatile SingularAttribute<Service, Long> id;
    public static volatile SingularAttribute<Service, String> nom_Service;

}