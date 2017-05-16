package baseapi;

import com.getbase.models.Lead;
import com.getbase.services.LeadsService;
import org.junit.After;
import org.junit.Test;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;

public class GetBaseTest extends FunctionalTest{

    private List<Lead> leadList = baseClient.leads().list(new LeadsService.SearchCriteria());

    @After
    public void cleanUpLeads(){
        System.out.println("Leads cleanup (delete all)");
        for (Lead lead : leadList) {
            baseClient.leads().delete(lead.getId());
        }
    }

    @Test
    public void createLeadTest(){
        Lead newLead = new Lead();
        newLead.setFirstName("TestFirstName");
        newLead.setLastName("TestLastName");

        baseClient.leads().create(newLead);

        await().atMost(60, SECONDS).until(leadList::size, equalTo(1));

        assertEquals("Create a new Lead.",1, leadList.size());
        assertEquals("Check that the Lead status is set to \"New\".", "New", leadList.get(0).getStatus());

        leadList.get(0).setStatus("Working");
        assertEquals("Check if the status name change is reflected.", "Working", leadList.get(0).getStatus());
    }

}

