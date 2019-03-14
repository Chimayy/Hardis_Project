package entite;

import entite.Bon_De_Commande;
import entite.Condition_Contractuelle;
import entite.Devis;
import entite.Livrable;
import entite.Service;
import entite.lieu_Intervention;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T16:47:31")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:14:04")
>>>>>>> origin/schellen
@StaticMetamodel(Prestation.class)
public class Prestation_ { 

    public static volatile SingularAttribute<Prestation, Boolean> facturation_Frais_Inclus;
    public static volatile SingularAttribute<Prestation, String> description_Prestation;
    public static volatile SingularAttribute<Prestation, String> nom_Responsable;
    public static volatile SingularAttribute<Prestation, String> mail_Responsable;
    public static volatile ListAttribute<Prestation, Livrable> livrables;
    public static volatile SingularAttribute<Prestation, String> nom_Prestation;
    public static volatile SingularAttribute<Prestation, lieu_Intervention> lieu_Intervention;
    public static volatile SingularAttribute<Prestation, Service> leService;
    public static volatile SingularAttribute<Prestation, Integer> delai_Relance;
    public static volatile ListAttribute<Prestation, Condition_Contractuelle> condition_Contractuelles;
    public static volatile SingularAttribute<Prestation, Double> cout_Prestation;
    public static volatile ListAttribute<Prestation, Bon_De_Commande> bon_De_Commandes;
    public static volatile ListAttribute<Prestation, Devis> lesDevis;
    public static volatile SingularAttribute<Prestation, Long> id;
    public static volatile SingularAttribute<Prestation, String> tel_Responsable;

}