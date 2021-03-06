package internshipManagerBO.Services;

import internshipManagerDAL.Entities.Internship;
import internshipManagerDAL.InternshipDA;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    
    public void deleteInternship(Internship current) {
        internshipDA.deleteInternship(current);
    }
    
    public String getInternshipOrganisationName(int internshipId) {
        String organisationName = "Organisation not Found";
        organisationName = internshipDA.getInternshipOrganisationName(internshipId);
        return organisationName;
    }
    
    public String getInternshipOrganisationSearchified(int internshipId) {
        String searchifiedOrganisation = "";
        searchifiedOrganisation = internshipDA.getInternshipOrganisationSearchified(internshipId);
        return searchifiedOrganisation;
    }
    
    public List<Internship> searchInternships(String searchQuery) {
        List<Internship> allInternships = new ArrayList<>();
        List<Internship> searchResults = new ArrayList<>();
        allInternships = internshipDA.getAllInternships();
        for(Internship item : allInternships) {
            if(item.toSearchableString().contains(searchQuery.toLowerCase())) {
                searchResults.add(item);
            }
        }
        return searchResults;
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
    
    public String transformDateToString(Date startDate) {
        String stringifiedDate;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        stringifiedDate = formatter.format(startDate);
        return stringifiedDate;
    }
}
