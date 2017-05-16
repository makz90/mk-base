package baseapi;

import com.getbase.Client;
import com.getbase.Configuration;
import org.junit.BeforeClass;

public class FunctionalTest {

    static Client baseClient;

    @BeforeClass
    public static void Setup() {
        String token = "619df849bd0bdac5520c5aa526707564316b051d67c7f77886a30a6f743d32e5";
        baseClient = new Client(new Configuration.Builder()
                .accessToken(System.getenv(token))
                .verbose()
                .build());

    }

}
