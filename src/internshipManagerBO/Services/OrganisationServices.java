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
}
