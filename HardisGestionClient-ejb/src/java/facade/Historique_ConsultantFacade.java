/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;


import entite.Devis;
import entite.Historique_Consultant;
import entite.Utilisateur_Hardis;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author thoma
 */
@Stateless
public class Historique_ConsultantFacade extends AbstractFacade<Historique_Consultant> implements Historique_ConsultantFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Historique_ConsultantFacade() {
        super(Historique_Consultant.class);
    }
    
    @Override
    public void proposerConsultants(Devis devis, List<Utilisateur_Hardis> ListeConsultants) {
        for(int i=0; i<ListeConsultants.size(); i++ )
        {
            Utilisateur_Hardis userEnCours = ListeConsultants.get(i);
            Historique_Consultant HistoEnCours = new Historique_Consultant();
            HistoEnCours.setLeConsultant(userEnCours);
            HistoEnCours.setLeDevis(devis);
            em.persist(HistoEnCours);
        }
    }

    
}
