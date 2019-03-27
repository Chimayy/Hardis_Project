package entite;

import entite.Agence;
import entite.Historique_Consultant;
import entite.Historique_QuestionPublique;
import entite.Periode_Disponible;
import entite.Profil_Metier;
import entite.profil_Technique;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-27T00:18:18")
@StaticMetamodel(Utilisateur_Hardis.class)
public class Utilisateur_Hardis_ extends Utilisateur_ {

    public static volatile ListAttribute<Utilisateur_Hardis, Periode_Disponible> periode_Disponibles;
    public static volatile ListAttribute<Utilisateur_Hardis, Profil_Metier> profil_Metiers;
    public static volatile SingularAttribute<Utilisateur_Hardis, profil_Technique> profil_Technique;
    public static volatile SingularAttribute<Utilisateur_Hardis, Agence> lAgence;
    public static volatile ListAttribute<Utilisateur_Hardis, Historique_Consultant> historique_Consultants;
    public static volatile ListAttribute<Utilisateur_Hardis, Historique_QuestionPublique> historique_QuestionPubliques;
    public static volatile SingularAttribute<Utilisateur_Hardis, Boolean> statut_Actif;
    public static volatile SingularAttribute<Utilisateur_Hardis, Double> plafond_Delegation;

}