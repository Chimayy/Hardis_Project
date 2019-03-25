/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Client;
import entite.Consentement_RGPD;
import entite.Entreprise;
import entite.Utilisateur_Hardis;
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
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {

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
        String txt = "SELECT c FROM Client AS c";
        Query req = getEntityManager().createQuery(txt);
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
    public void creerClient(String nom_Client, String mdp, String mail, Entreprise etp, Consentement_RGPD consentement) {
        Client clientACreer = new Client();
        clientACreer.setMail_Connexion(mail);
        clientACreer.setMot_De_Passe(mdp);
        clientACreer.setNom_Utilisateur(nom_Client);
        clientACreer.setPrenom_Utilisateur(nom_Client);
        clientACreer.setLeConsentement(consentement);        
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
    public void clientPersist(Object o) {
        em.persist(o);
    }

    @Override
    public List ListeClientGest(Utilisateur_Hardis user) {
       String txt = "SELECT c FROM Client AS c JOIN Devis.c AS d JOIN Historique_Consultant.d AS hc WHERE hc.leConsultant";
        Query req = getEntityManager().createQuery(txt);
        req=req.setParameter("user", user);
        List <Client> result=req.getResultList();
        return result;
    }
       
    
    
}
