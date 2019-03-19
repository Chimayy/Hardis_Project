package entite;

import entite.Offre;
import entite.Prestation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-19T12:01:47")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Offre> lOffre;
    public static volatile ListAttribute<Service, Prestation> prestations;
    public static volatile SingularAttribute<Service, String> description_Service;
    public static volatile SingularAttribute<Service, Double> cout_Service;
    public static volatile SingularAttribute<Service, Long> id;

}