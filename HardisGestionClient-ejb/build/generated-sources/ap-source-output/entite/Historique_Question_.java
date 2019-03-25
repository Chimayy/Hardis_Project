package entite;

import entite.Devis;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-25T09:28:46")
@StaticMetamodel(Historique_Question.class)
public class Historique_Question_ { 

    public static volatile SingularAttribute<Historique_Question, String> Contenu_Question;
    public static volatile SingularAttribute<Historique_Question, String> Reponse;
    public static volatile SingularAttribute<Historique_Question, Long> id;
    public static volatile SingularAttribute<Historique_Question, Date> Date_Question;
    public static volatile SingularAttribute<Historique_Question, Devis> leDevis;
    public static volatile SingularAttribute<Historique_Question, String> mot_Cle;

}