package entite;

import entite.Entreprise;
import entite.Utilisateur_Hardis;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-20T17:24:39")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-20T11:31:40")
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