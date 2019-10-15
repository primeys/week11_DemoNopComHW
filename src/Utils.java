import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
    static WebDriver driver;

    public Utils(WebDriver driver)
    {
        this.driver = driver;
    }

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void clickOnElement(WebElement element) {
        element.click();
    }

    public void enterText(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void clearField(By by) {
        driver.findElement(by).clear();

    }
    public static String getText(By by)
    {
        return driver.findElement(by).getText();
    }

    public void sendTextToElement(By by, String str){driver.findElement(by).sendKeys(str);}

    public void select_By_Index(By by, int i) {
        Select dob = new Select(driver.findElement(by));
        dob.deselectByIndex(5);
    }

    public void select_By_Value(By by, String str) {
        Select dom = new Select(driver.findElement(by));
        dom.selectByValue(str);
    }

    public void select_By_Visible_Text(By by, String txt) {
        Select doy = new Select(driver.findElement(by));
        doy.deselectByVisibleText(txt);
    }

    public void mouseOver(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void scrollUpDown(int i) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + i + ")");
    }

    public void scrollLeftRight(int i) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + i + ",0)");
    }

    public static int getRandomNumber(){ return (int) (Math.random() * 5000 + 1); }

    public void mouseOverElement(WebElement element)
    { Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
    }

    public void clickOnHold(WebElement element) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).build().perform();
    }

    public void clickOnHold(By by) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(by)).build().perform();
    }

    public void dragAndDropElement(WebElement element) {
        Actions actions = new Actions(driver);
        driver.switchTo().frame(1);
        actions.dragAndDropBy(element, 135, 40).build().perform();
    }

    public boolean verifyThatElementIsDisplay(By by) {
        WebElement element = driver.findElement(by);
        if (element.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean verifyThatTextIsDisplayed(By by, String text) {
        WebElement element = driver.findElement(by);
        if (text.equals(element.getText())) {
            return true;
        } else {
            return false;
        }
    }

    public void waitUntilPresenceOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitUntilPresenceOfElementClickable(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void waitUntilVisibilityOfElementLocated(By by, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public Boolean isElementDisplayed(By by) {
        if (driver.findElement(by).isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}




