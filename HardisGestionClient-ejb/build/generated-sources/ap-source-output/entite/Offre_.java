package entite;

import entite.Devis;
import entite.Historique_QuestionPublique;
import entite.Profil_Metier;
import entite.Service;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-26T09:26:21")
@StaticMetamodel(Offre.class)
public class Offre_ { 

    public static volatile SingularAttribute<Offre, String> description_Offre;
    public static volatile ListAttribute<Offre, Profil_Metier> profil_Metiers;
    public static volatile SingularAttribute<Offre, String> nom_Offre;
    public static volatile ListAttribute<Offre, Devis> lesDevis;
    public static volatile ListAttribute<Offre, Service> services;
    public static volatile SingularAttribute<Offre, Long> id;
    public static volatile ListAttribute<Offre, Historique_QuestionPublique> historique_QuestionPubliques;

}