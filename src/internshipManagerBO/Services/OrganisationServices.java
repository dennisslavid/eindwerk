package internshipManagerBO.Services;

import internshipManagerDAL.Entities.Organisation;
import internshipManagerDAL.OrganisationDA;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denni
 */
public class OrganisationServices {
    
    OrganisationDA organisationDA = new OrganisationDA();
    
    public List<Organisation> getAllOrganisations() {
        List<Organisation> allOrganisations = new ArrayList<>();
        allOrganisations = organisationDA.getAllOrganisations();
        return allOrganisations;
    }
    
    public void saveOrganisation(Organisation newOrganisation) {
        organisationDA.saveOrganisation(newOrganisation);
    }
    
    public boolean inputIsValid(String name, String street, String zip, 
                                String city, String contact, String email) {
        boolean result = false;
        if(!"".equals(name) && !"".equals(street) && !"".equals(zip) 
                            && !"".equals(city) && !"".equals(contact) 
                            && !"".equals(email)) {
            result = true;
        }
        return result;
    }
}
