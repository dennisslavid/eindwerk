package internshipManagerBO.Services;

import internshipManagerDAL.Entities.Internship;
import internshipManagerDAL.Entities.Organisation;
import internshipManagerDAL.NewHibernateUtil;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    
    public void saveInternship(Internship newInternship) {
        Transaction trans = null;
        Session session = NewHibernateUtil.getSessionFactory().openSession();
        try {
            trans = session.beginTransaction();
            session.save(newInternship);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if(trans != null) {
                trans.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
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
    
    public boolean inputIsValid(String title, String startDate, String description, boolean noOrgSelected) {
        boolean result = false;
        if(!"".equals(title) && !"".equals(startDate) && !"".equals(description) 
                && noOrgSelected != true) {
            if(this.transformToDate(startDate) != null) {
                result = true;
            }
        }
        return result;
    }
    
    public Calendar transformToDate(String startDate) {
        Calendar formattedDate = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            formattedDate.setTime(formatter.parse(startDate));
        } catch (ParseException e) {
            formattedDate = null;
        }
        return formattedDate;
    }
}
