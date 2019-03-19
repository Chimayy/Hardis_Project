package entite;

import entite.Utilisateur_Hardis;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-19T12:01:47")
@StaticMetamodel(Periode_Disponible.class)
public class Periode_Disponible_ { 

    public static volatile SingularAttribute<Periode_Disponible, Date> date_Fin;
    public static volatile SingularAttribute<Periode_Disponible, Date> date_Debut;
    public static volatile SingularAttribute<Periode_Disponible, Long> id;
    public static volatile SingularAttribute<Periode_Disponible, Utilisateur_Hardis> user;

}