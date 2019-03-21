package entite;

import entite.Offre;
import entite.Utilisateur_Hardis;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-21T12:36:37")
@StaticMetamodel(Profil_Metier.class)
public class Profil_Metier_ { 

    public static volatile SingularAttribute<Profil_Metier, Integer> niveau_Habilitation;
    public static volatile SingularAttribute<Profil_Metier, Offre> lOffre;
    public static volatile SingularAttribute<Profil_Metier, Utilisateur_Hardis> lUtilisateur;
    public static volatile SingularAttribute<Profil_Metier, Long> id;

}