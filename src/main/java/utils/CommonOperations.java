package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.InputStream;
import java.util.Properties;

public class CommonOperations {

    private WebDriver driver;
    int sleepTime;
    Properties properties = null;
    private Actions actions;

    public CommonOperations(WebDriver driver) {
        this.driver = driver;
    }

    public CommonOperations() {
        this.sleepTime = 1000;
    }

    public CommonOperations(int sleep, int tries) {
        this.sleepTime = sleep;
    }

    public Properties getProperties (String propertiesPath) {
        InputStream input = CommonOperations.class.getClassLoader().getResourceAsStream(propertiesPath + ".properties");
        properties = new Properties();
        try {
            if (input.available() > 0) {
                properties.load(input);
            }
        } catch (Exception e) {
        }
        return this.properties;
    }

    public boolean isPageLoading(WebDriver d) {
        JavascriptExecutor js = (JavascriptExecutor)d;
        String strExec = "return document.readyState!=\'complete\';";
        return ((Boolean)js.executeScript(strExec, new Object[0])).booleanValue();
    }

    public void waitUntilPageLoaded(WebDriver driver) {
        while(this.isPageLoading(driver)) {
            try {
                Thread.sleep((long)this.sleepTime);
            } catch (InterruptedException var3) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void waitForSpecificTime(int sleepTime){
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitUntilElementStanelessOf(WebDriver driver, WebElement element, int delay) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, delay);
            return wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
        }catch (NoSuchElementException e){
            throw new RuntimeException("Web element not visible within given time" + element +" Time "+ delay);
        }
    }

    public WebElement waitUntilElementStanelessOfClickable(WebDriver driver, WebElement element, int delay) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, delay);
            return wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element)));
        }catch (NoSuchElementException e){
            throw new RuntimeException("Web element not visible within given time" + element +" Time "+ delay);
        }
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)", "");
    }

    public static void dropDownSelectByText(WebElement webElement, String VisibleText){
        Select selObj=new Select(webElement);
        selObj.selectByVisibleText(VisibleText);
    }

    public void mouseHoverToElement(WebElement element){
        actions = new Actions(driver);
        actions.moveToElement(element).perform();

    }
}
