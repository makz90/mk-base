package baseapi;

import com.getbase.models.Lead;
import com.getbase.services.LeadsService;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;

public class GetBaseTest extends FunctionalTest{

    private List<Lead> leadList;

    @Test
    public void createAndModifyLead(){

        // Create new lead
        Lead newLead = new Lead();
        newLead.setFirstName("Created at ");
        newLead.setLastName(Calendar.getInstance().getTime().toString());

        // Add newly created lead to dB
        baseClient.leads().create(newLead);

        // Wait for at most 5 seconds until dB gets updated
        leadList = baseClient.leads().list(new LeadsService.SearchCriteria());
        await().atMost(5, SECONDS).until(() -> leadList.size() == 1);

        assertEquals("Create a new Lead.",1, leadList.size());
        assertEquals("Check that the Lead status is set to \"New\".", "New", leadList.get(0).getStatus());

        // Change lead status from New to Working
        newLead.setStatus("Working");

        // Update changes to dB
        baseClient.leads().update(newLead);
        leadList = baseClient.leads().list(new LeadsService.SearchCriteria());
        await().atMost(5, SECONDS).until(() -> leadList.size() == 1);

        assertEquals("Check if the status name change is reflected.", "Working", leadList.get(0).getStatus());
    }

}

