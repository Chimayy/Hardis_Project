/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Agence;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface AgenceFacadeLocal {

    void create(Agence agence);

    void edit(Agence agence);

    void remove(Agence agence);

    Agence find(Object id);

    List<Agence> findAll();

    List<Agence> findRange(int[] range);

    int count();

    List<Agence> listeAgence();

    List<Agence> rechercherAgenceParId(long id);

    void creerAgence(String rue_Agence, String ville_Agence, String CP_Agence, String pays_Agence);

    public Agence rechercherAgenceParVille(String ville);

    public void supprimerAgence(Agence agence);

    public void modifierAgence(Agence agence, String cp, String pays, String adresse, String ville);
    
}
