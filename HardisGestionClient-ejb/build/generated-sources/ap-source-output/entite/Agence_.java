package entite;

import entite.Entreprise;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-20T11:31:40")
@StaticMetamodel(Agence.class)
public class Agence_ { 

    public static volatile SingularAttribute<Agence, String> pays_Agence;
    public static volatile ListAttribute<Agence, Entreprise> entreprises;
    public static volatile SingularAttribute<Agence, String> ville_Agence;
    public static volatile SingularAttribute<Agence, String> rue_Agence;
    public static volatile SingularAttribute<Agence, Long> id;
    public static volatile SingularAttribute<Agence, String> CP_Agence;

}