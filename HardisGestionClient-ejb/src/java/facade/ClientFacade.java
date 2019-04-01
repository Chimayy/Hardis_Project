/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Client;
import entite.Entreprise;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author thoma
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

    @EJB
    private EntrepriseFacadeLocal entrepriseFacade;

    @PersistenceContext(unitName = "HardisGestionClient-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

    @Override
    public List<Client> listeClient() {
        String a = "Client";
        String txt = "SELECT c FROM Utilisateur AS c WHERE c.DType =:par";   
        
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("par", a);
        List<Client> liste = req.getResultList();
       
        return liste;
    }

    @Override
    public Client rechercheClient(long id) {
        Client result;
        String txt = "SELECT c FROM Client AS c WHERE c.id=:id";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("id", id);
        result=(Client)req.getSingleResult();
        return result;
    }
    
      @Override
    public Client rechercheClientNom(String nom) {
        Client result;
        String txt = "SELECT c FROM Client AS c WHERE c.nom_Client=:nom";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("nom", nom);
        result=(Client)req.getSingleResult();
        return result;
    }


    @Override
    public void creerClient(String nom_Client, String prenom_Client, String mdp, String mail, Entreprise etp) {
        Client clientACreer = new Client();
        clientACreer.setMail_Connexion(mail);
        clientACreer.setMot_De_Passe(mdp);
        clientACreer.setNom_Utilisateur(nom_Client);
        clientACreer.setPrenom_Utilisateur(nom_Client);
        clientACreer.setlEntreprise(etp);
        em.persist(clientACreer);
    }

    @Override
    public Client authentif(String mail, String mdp) {
       Client user;
        String txt = "SELECT a FROM Utilisateur AS a WHERE a.mail_Connexion=:lo AND a.mot_De_Passe=:motp";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("lo", mail);
        req=req.setParameter("motp", mdp);
        user=(Client)req.getSingleResult();
        return user;
    }

    @Override
    public List<Entreprise> listeEntreprise() {
        return entrepriseFacade.listeEntreprise();
    }

    @Override
    public Client rechercheClientMail(String mail) {
         Client user;
        String txt = "SELECT a FROM Utilisateur AS a WHERE a.mail_Connexion=:lo";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("lo", mail);
         List<Client> liste = req.getResultList();
        if(!liste.isEmpty()){
            return liste.get(0);
        }
        else {return null;}
    }

       
    
    
}
