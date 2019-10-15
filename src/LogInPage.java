
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LogInPage {

    private WebDriver driver;

    Utils utils;

    @Before
    public void setUpBrowser() {
        //First set up base URL and Driver setUp
        System.setProperty("webdriver.chrome.driver", "drivres\\chromedriver.exe");
        // ChromeDriver  given to Driver
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        utils = new Utils(driver);
    }

    @Test
    public void userShouldNavigateToLoginPage() {
        //find element for login link
        //driver.findElement(By.linkText("Log in")).click();
        utils.clickOnElement(By.linkText("Log in"));

        //Actual Text from webElement via Locator
        //WebElement welComeText = driver.findElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        String expectedText = "Welcome, Please Sign In!";

        String actualText = Utils.getText(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        //String actualText = welComeText.getText(); // Use directly with assert

        //Assert from JUnit Library
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void userShouldLoginSuccessfully() {
        //driver.findElement(By.linkText("Log in")).click();
        utils.clickOnElement(By.linkText("Log in"));

        // find elements for emailField and type email
        //WebElement emilField = driver.findElement(By.id("Email"));
        //driver.findElement(By.id("Email")).sendKeys("abc@gmail.com");
        utils.enterText(By.id("Email"), "abc@gmail.com");

        //find elements for password field and type password
        //WebElement passwordField = driver.findElement(By.id("Password"));
        //driver.findElement(By.id("Password")).sendKeys("abc123");
        utils.enterText(By.xpath("//input[@id='Password']"), "abc123");

        //find elements for loginBtn and click
        // WebElement loginBtn = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        // driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        utils.clickOnElement(By.xpath("//input[@class='button-1 login-button']"));

        String expectedMessage = "Welcome to our store";
        String actualMessage = driver.findElement(By.xpath("//h2[contains(text(),'Welcome to our store')]")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}
