package baseselenium;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

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
    public void createAndModifyLeadTest(){
        driver.findElement(By.id("user_mail")).sendKeys("maksym.krawczyk@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("base123");
        driver.findElement(By.id("user_new")).findElement(By.tagName("button")).click();
        driver.findElement(By.id("nav-leads")).click();
        driver.findElement(By.id("leads-new")).click();
        driver.findElement(By.id("leads-new")).click();

        WebElement editBox = driver.findElement(By.id("lead-last-name"));
        editBox.sendKeys("testLead");
        editBox.submit();

        WebElement leadStatus = driver.findElement(By.id("object-details")).findElement(By.className("lead-status"));
        assertEquals("New", leadStatus.getText());

        leadStatus.click();
        WebElement statusMenu = driver.findElement(By.id("object-details")).findElement(By.className("dropdown open"));
        statusMenu.findElement(By.linkText("Working")).click();

        leadStatus = driver.findElement(By.id("object-details")).findElement(By.className("lead-status"));
        assertEquals("Working", leadStatus.getText());


    }
}
