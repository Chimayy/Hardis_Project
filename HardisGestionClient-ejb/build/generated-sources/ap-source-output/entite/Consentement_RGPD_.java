package entite;

import entite.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-13T09:41:07")
@StaticMetamodel(Consentement_RGPD.class)
public class Consentement_RGPD_ { 

    public static volatile SingularAttribute<Consentement_RGPD, Boolean> boolConsentement;
    public static volatile SingularAttribute<Consentement_RGPD, Long> id;
    public static volatile SingularAttribute<Consentement_RGPD, Date> dateConsentement;
    public static volatile SingularAttribute<Consentement_RGPD, Utilisateur> user;

}