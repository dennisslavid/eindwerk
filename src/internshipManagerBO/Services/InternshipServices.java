package internshipManagerBO.Services;

import internshipManagerDAL.Entities.Internship;
import internshipManagerDAL.InternshipDA;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author denni
 */
public class InternshipServices {
    
    InternshipDA internshipDA = new InternshipDA();
    
    public List<Internship> getAllInternships() {
        List<Internship> allInternships = new ArrayList<>();
        allInternships = internshipDA.getAllInternships();
        return allInternships;
    }
    
    public void saveInternship(Internship newInternship) {
        internshipDA.saveInternship(newInternship);
    }
    
    public void updateInternship(Internship internship) {
        internshipDA.updateInternship(internship);
    }
    
    public String getInternshipOrganisationName(int internshipId) {
        String organisationName = "Organisation not Found";
        organisationName = internshipDA.getInternshipOrganisationName(internshipId);
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
