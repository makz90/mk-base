package baseselenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserTests {

    private WebDriver driver = (WebDriver) new ChromeDriver();

    @Before
    public void beforeTest(){
        driver.get("https://app.futuresimple.com");
    }

    @After
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void createAndModifyLead(){

    }
}
