
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationDemoToNopCom {

    private WebDriver driver;
    // Utils.Utils Object Created
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
    public void userShouldNavigateRegisterPageSuccessfully() {
        utils.clickOnElement(By.xpath("//a[@class='ico-register']"));
        //Actual text from webElements
        WebElement text = driver.findElement(By.xpath("//h1[contains(text(),'Register')]"));
        // Expected text
        Assert.assertTrue("Register", text.isDisplayed());
    }

    @Test
    public void userShouldRegisterSuccessfully() {
        // registration for new user
        //driver.findElement(By.xpath("\"//a[@class='ico-register']"));
        utils.clickOnElement(By.xpath("//a[@class='ico-register']"));

        // Driver Selecting to Gender
        //driver.findElement(By.id("gender-male")).click();
        utils.clickOnElement(By.id("gender-male"));

        // Enter First Name
        //driver.findElement(By.id("FirstName")).sendKeys("Jay");
        utils.enterText(By.id("FirstName"), "Jay");

        // Enter Last Name
        //driver.findElement(By.id("LastName")).sendKeys("Patel");
        utils.enterText(By.id("LastName"), "Patel");

        // Select Date / Day of Birth
        //driver.findElement(By.name("DateOfBirthDay")).sendKeys("20");
        utils.enterText(By.name("DateOfBirthDay"), "20");

        //Select Birth Month
        //driver.findElement(By.name("DateOfBirthMonth")).sendKeys("June");
        utils.enterText(By.name("DateOfBirthMonth"), "June");

        //Select Birth year
        //driver.findElement(By.name("DateOfBirthYear")).sendKeys("2001");
        utils.enterText(By.name("DateOfBirthYear"), "2001");

        //Enter email ID + RandomNumber after Email ID
        //driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("jaypatel@gmail.com");
        String email = "jaypatel" + utils.getRandomNumber() + "@gmail.com";
        utils.sendTextToElement(By.xpath("//input[@id='Email']"), email);
        System.out.println(email);

        //Enter Company name
        //driver.findElement(By.id("Company")).sendKeys("JayAmbe");
        utils.enterText(By.id("Company"), "JayAmbe");

        // Select newsletter
        //driver.findElement(By.name("Newsletter")).click();
        utils.clickOnElement(By.name("Newsletter"));

        // Enter Password
        //driver.findElement(By.id("Password")).sendKeys("jay123");
        utils.enterText(By.id("Password"), "jay123");

        //Confirm Password
        //driver.findElement(By.id("ConfirmPassword")).sendKeys("jay123");
        utils.enterText(By.id("ConfirmPassword"), "jay123");

        //Click on register button
        //driver.findElement(By.name("register-button")).click();
        utils.clickOnElement(By.name("register-button"));

        //Verify actual result vs expected result
        //String actualResult = driver.findElement(By.className("result")).getText();
        String expectedMessage = "Your registration completed";

        //String expectedMessage = "Your registration completed";
        String actualMessage = Utils.getText(By.className("result"));


        //Assert.assertEquals(expectedMessage,"Your registration completed");
        Assert.assertEquals(expectedMessage, actualMessage);

    }

/*
* Login page
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
*/
    @After

    public void closeBrowser(){
        driver.quit();
    }
}
