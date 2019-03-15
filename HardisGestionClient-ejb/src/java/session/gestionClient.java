/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import entite.Client;
import facade.ClientFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author thoma
 */
@Stateless
public class gestionClient implements gestionClientLocal {
    
    @EJB
    private ClientFacadeLocal ClientFacade;
    
    
    
        

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public List<Client> ListeClient() {
        return ClientFacade.listeClient();
    }
}
