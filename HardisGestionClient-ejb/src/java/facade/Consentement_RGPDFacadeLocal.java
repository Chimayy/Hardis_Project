/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entite.Consentement_RGPD;
import entite.Utilisateur;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author thoma
 */
@Local
public interface Consentement_RGPDFacadeLocal {

    void create(Consentement_RGPD consentement_RGPD);

    void edit(Consentement_RGPD consentement_RGPD);

    void remove(Consentement_RGPD consentement_RGPD);

    Consentement_RGPD find(Object id);

    List<Consentement_RGPD> findAll();

    List<Consentement_RGPD> findRange(int[] range);

    int count();

    void creerConsentement(boolean consentement, Date date, Utilisateur user);
    
}
