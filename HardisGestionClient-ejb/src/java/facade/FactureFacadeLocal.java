/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Facture;
import java.sql.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface FactureFacadeLocal {

    void create(Facture facture);

    void edit(Facture facture);

    void remove(Facture facture);

    Facture find(Object id);

    List<Facture> findAll();

    List<Facture> findRange(int[] range);

    int count();

    List<Facture> listeFacture();

    Facture rechercheFacture(long id);

    void creerFacture(Date dateFacture, double montant, int pourcentage);
    
}
