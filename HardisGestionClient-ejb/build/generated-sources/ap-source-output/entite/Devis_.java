package entite;

import entite.Client;
import entite.Historique_Consultant;
import entite.Historique_Document;
import entite.Historique_Echange;
import entite.Historique_Question;
import entite.Offre;
import entite.Prestation;
import entite.statut_Devis;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-14T17:11:06")
@StaticMetamodel(Devis.class)
public class Devis_ { 

    public static volatile SingularAttribute<Devis, Boolean> facturation_Auto;
    public static volatile SingularAttribute<Devis, String> motif_Refus;
    public static volatile SingularAttribute<Devis, Offre> lOffre;
    public static volatile ListAttribute<Devis, Historique_Echange> historique_Echanges;
    public static volatile SingularAttribute<Devis, Date> date_Fin;
    public static volatile SingularAttribute<Devis, Date> date_Devis;
    public static volatile SingularAttribute<Devis, Client> leClient;
    public static volatile ListAttribute<Devis, Historique_Document> historique_Documents;
    public static volatile SingularAttribute<Devis, Date> date_Debut;
    public static volatile ListAttribute<Devis, Historique_Consultant> historique_Consultants;
    public static volatile SingularAttribute<Devis, Date> date_Intervention;
    public static volatile ListAttribute<Devis, Historique_Question> historique_Questions;
    public static volatile SingularAttribute<Devis, Prestation> laPrestation;
    public static volatile SingularAttribute<Devis, String> formulaire_Client;
    public static volatile SingularAttribute<Devis, Double> montant_Devis;
    public static volatile SingularAttribute<Devis, Long> id;
    public static volatile SingularAttribute<Devis, statut_Devis> statut;

}