package entite;

import entite.Consentement_RGPD;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-13T09:41:07")
@StaticMetamodel(Utilisateur.class)
public class Utilisateur_ { 

    public static volatile SingularAttribute<Utilisateur, String> prenom_Utilisateur;
    public static volatile SingularAttribute<Utilisateur, String> mot_De_Passe;
    public static volatile SingularAttribute<Utilisateur, String> mail_Connexion;
    public static volatile SingularAttribute<Utilisateur, String> nom_Utilisateur;
    public static volatile SingularAttribute<Utilisateur, Long> id;
    public static volatile SingularAttribute<Utilisateur, Consentement_RGPD> leConsentement;

}