/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Bon_De_Commande;
import entite.Facture;
import entite.Prestation;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Bon_De_CommandeFacadeLocal {

    void create(Bon_De_Commande bon_De_Commande);

    void edit(Bon_De_Commande bon_De_Commande);

    void remove(Bon_De_Commande bon_De_Commande);

    Bon_De_Commande find(Object id);

    List<Bon_De_Commande> findAll();

    List<Bon_De_Commande> findRange(int[] range);

    int count();

    List<Bon_De_Commande> listeBonDeCommande();

    Bon_De_Commande rechercheBDC(long id);

    void creerBonDeCommande(double montantBonDeCommande, String descriptifBonDeCommande, Facture facture, Prestation prestation);
    
}
