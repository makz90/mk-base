package baseapi;

import com.getbase.Client;
import com.getbase.Configuration;
import org.junit.BeforeClass;

public class FunctionalTest {

    static Client baseClient;

    @BeforeClass
    public static void setup() {
        String token = "32a3f51cc34cee6344f7625ddb66d27d8c7467ab609e47bac34e1b1fc2bd0d17";
        baseClient = new Client(new Configuration.Builder()
                .accessToken(token)
                .verbose()
                .build());
    }

}
