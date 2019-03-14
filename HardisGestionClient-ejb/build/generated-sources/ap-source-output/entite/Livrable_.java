package entite;

import entite.Prestation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:04")
@StaticMetamodel(Livrable.class)
public class Livrable_ { 

    public static volatile SingularAttribute<Livrable, String> type_Livrable;
    public static volatile SingularAttribute<Livrable, String> path_Livrable;
    public static volatile SingularAttribute<Livrable, Long> id;
    public static volatile SingularAttribute<Livrable, Prestation> laPrestation;

}