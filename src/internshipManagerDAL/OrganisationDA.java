/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internshipManagerDAL;

import internshipManagerDAL.Entities.Organisation;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author denni
 */
public class OrganisationDA {
    public List<Organisation> getAllOrganisations() {
        List<Organisation> allOrganisations = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            allOrganisations = session.createQuery("from Organisation").list();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return allOrganisations;
    }
}
