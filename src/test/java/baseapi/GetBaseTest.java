package baseapi;

import com.getbase.models.Lead;
import com.getbase.services.LeadsService;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GetBaseTest extends FunctionalTest{

    @Test
    public void createLeadTest(){

        Lead newLead = new Lead();

        newLead.setFirstName("TestFirstName");
        newLead.setLastName("TestLastName");

        baseClient.leads().create(newLead);

        List<Lead> leadList = baseClient.leads().list(new LeadsService.SearchCriteria());

        assertEquals(1, leadList.size());
    }

}