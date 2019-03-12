package entite;

import entite.Facture;
import entite.Prestation;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-12T12:06:51")
@StaticMetamodel(Bon_De_Commande.class)
public class Bon_De_Commande_ { 

    public static volatile SingularAttribute<Bon_De_Commande, Facture> laFacture;
    public static volatile SingularAttribute<Bon_De_Commande, Double> montant_BonDeCommande;
    public static volatile SingularAttribute<Bon_De_Commande, Long> id;
    public static volatile SingularAttribute<Bon_De_Commande, Prestation> laPrestation;
    public static volatile SingularAttribute<Bon_De_Commande, String> descriptif_BonDeCommande;

}