/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Periode_Disponible;
import entite.Utilisateur_Hardis;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thoma
 */
@Stateless
public class Periode_DisponibleFacade extends AbstractFacade<Periode_Disponible> implements Periode_DisponibleFacadeLocal {

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Periode_DisponibleFacade() {
        super(Periode_Disponible.class);
    }

    @Override
    public List<Periode_Disponible> listePeriodeUser(String idHardis) {
        String txt = "SELECT  pd FROM Periode_Disponible pd JOIN Periode_Disponible.Utilisateur_Hardis user WHERE user.id = :idHardis";
        Query req = getEntityManager().createQuery(txt);
        List<Periode_Disponible> liste = req.getResultList();
        return liste;
    }

    @Override
    public void creerPeriode(Date dateDebut, Date dateFin, Utilisateur_Hardis user) {
        Periode_Disponible periodeACreer = new Periode_Disponible();
        periodeACreer.setDate_Debut(dateDebut);
        periodeACreer.setDate_Fin(dateFin);
        periodeACreer.setUser(user);
        em.persist(periodeACreer);
        
    }   
    
}
