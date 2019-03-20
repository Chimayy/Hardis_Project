package entite;

import entite.Agence;
import entite.Historique_Consultant;
import entite.Periode_Disponible;
import entite.Profil_Metier;
import entite.profil_Technique;
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
@StaticMetamodel(Utilisateur_Hardis.class)
public class Utilisateur_Hardis_ extends Utilisateur_ {

    public static volatile ListAttribute<Utilisateur_Hardis, Periode_Disponible> periode_Disponibles;
    public static volatile ListAttribute<Utilisateur_Hardis, Profil_Metier> profil_Metiers;
    public static volatile SingularAttribute<Utilisateur_Hardis, profil_Technique> profil_Technique;
    public static volatile SingularAttribute<Utilisateur_Hardis, Agence> lAgence;
    public static volatile ListAttribute<Utilisateur_Hardis, Historique_Consultant> historique_Consultants;
    public static volatile SingularAttribute<Utilisateur_Hardis, Boolean> statut_Actif;
    public static volatile SingularAttribute<Utilisateur_Hardis, Double> plafond_Delegation;

}