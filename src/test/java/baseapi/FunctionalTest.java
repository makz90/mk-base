package baseapi;

import com.getbase.Client;
import com.getbase.Configuration;
import com.getbase.models.Lead;
import com.getbase.services.LeadsService;
import org.junit.Before;

import java.util.List;

public class FunctionalTest {

    protected Client baseClient;

    @Before
    public void setup() {
        String token = "32a3f51cc34cee6344f7625ddb66d27d8c7467ab609e47bac34e1b1fc2bd0d17";
        baseClient = new Client(new Configuration.Builder()
                .accessToken(token)
                .verbose()
                .build());

        System.out.println("Cleaning Up Lead Data:");
        List<Lead> leadList = baseClient.leads().list(new LeadsService.SearchCriteria());
        for (Lead lead : leadList) {
            System.out.println("deleting: " + lead.getLastName());
            baseClient.leads().delete(lead.getId());
        }
    }

}
