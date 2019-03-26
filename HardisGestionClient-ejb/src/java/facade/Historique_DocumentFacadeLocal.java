/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Devis;
import entite.Historique_Document;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Historique_DocumentFacadeLocal {

    void create(Historique_Document historique_Document);

    void edit(Historique_Document historique_Document);

    void remove(Historique_Document historique_Document);

    Historique_Document find(Object id);

    List<Historique_Document> findAll();

    List<Historique_Document> findRange(int[] range);

    int count();

    void creerDocument(String path, Devis leDevis);
    
    Historique_Document rechercheDocument(long id);
    
}
