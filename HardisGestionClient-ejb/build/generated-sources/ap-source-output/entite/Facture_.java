package entite;

import entite.Bon_De_Commande;
import entite.etat_Facture;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-22T09:56:17")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-22T09:14:17")
>>>>>>> Exilessv2
@StaticMetamodel(Facture.class)
public class Facture_ { 

    public static volatile SingularAttribute<Facture, Double> montant_Facture;
    public static volatile ListAttribute<Facture, Bon_De_Commande> bon_De_Commandes;
    public static volatile SingularAttribute<Facture, Integer> pourcentage_paiement_Facture;
    public static volatile SingularAttribute<Facture, Long> id;
    public static volatile SingularAttribute<Facture, Date> date_Facture;
    public static volatile SingularAttribute<Facture, etat_Facture> etat_Facture;

}