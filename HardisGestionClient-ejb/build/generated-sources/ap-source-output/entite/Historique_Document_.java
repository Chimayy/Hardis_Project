package entite;

import entite.Devis;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-24T18:03:36")
@StaticMetamodel(Historique_Document.class)
public class Historique_Document_ { 

    public static volatile SingularAttribute<Historique_Document, String> path_Document;
    public static volatile SingularAttribute<Historique_Document, Long> id;
    public static volatile SingularAttribute<Historique_Document, Devis> leDevis;

}