package internshipManagerBO.Services;

import internshipManagerDAL.Entities.Internship;
import internshipManagerDAL.Entities.Organisation;
import internshipManagerDAL.NewHibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author denni
 */
public class InternshipServices {
    
    public List<Internship> getAllInternships() {
        List<Internship> allInternships = new ArrayList<>();
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            allInternships = session.createQuery("from Internship").list();
            
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return allInternships;
    }
    
    public String getInternshipOrganisationName(int internshipId) {
        Organisation o = null;
        Internship i = null;
        Transaction trans = null;
        String organisationName = "Not Found";
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            String queryString = "from Internship where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", internshipId);
            i = (Internship) query.uniqueResult();
            o = i.getOrganisation();
            organisationName = o.getName();
        } catch (RuntimeException e){
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return organisationName;
    }
}
