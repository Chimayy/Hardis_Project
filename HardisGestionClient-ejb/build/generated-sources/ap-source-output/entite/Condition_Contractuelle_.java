package entite;

import entite.Prestation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-15T09:42:50")
@StaticMetamodel(Condition_Contractuelle.class)
public class Condition_Contractuelle_ { 

    public static volatile ListAttribute<Condition_Contractuelle, Prestation> lesPrestations;
    public static volatile SingularAttribute<Condition_Contractuelle, String> contenu_Condition;
    public static volatile SingularAttribute<Condition_Contractuelle, Long> id;

}