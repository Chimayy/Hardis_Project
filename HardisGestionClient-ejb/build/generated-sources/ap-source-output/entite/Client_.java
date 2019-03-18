package entite;

import entite.Devis;
import entite.Entreprise;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-03-18T10:46:04")
@StaticMetamodel(Client.class)
public class Client_ extends Utilisateur_ {

    public static volatile SingularAttribute<Client, Entreprise> lEntreprise;
    public static volatile ListAttribute<Client, Devis> lesDevis;

}