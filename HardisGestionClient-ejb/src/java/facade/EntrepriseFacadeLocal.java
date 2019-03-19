/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Agence;
import entite.Entreprise;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface EntrepriseFacadeLocal {

    void create(Entreprise entreprise);

    void edit(Entreprise entreprise);

    void remove(Entreprise entreprise);

    Entreprise find(Object id);

    List<Entreprise> findAll();

    List<Entreprise> findRange(int[] range);

    int count();

    List<Entreprise> listeEntreprise();

    List<Entreprise> rechercherEntrepriseParId(long id);

    void creerEntreprise(String cp, String nom, String siret, String rue, String ville, Agence agence);

    public Entreprise rechercherEntrepriseParSiret(String siret);

    public List<Entreprise> rechercherEntrepriseParNom(String nom);

    public void supprimerEntreprise(Entreprise ent);

    public void modifierEntreprise(Entreprise ent, String nom, String siret, String cp, String adresse, String ville, Agence agence);

    public List<Entreprise> rechercherEntrepriseParAgence(Agence agence);
    
}
