package moduleElement.homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonOperations;


public class HomePageElements {
    WebDriver driver;
    public CommonOperations commonOperations;


    public HomePageElements(WebDriver driver) {
        commonOperations = new CommonOperations(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void clickRelevantHomePageItemLink(int i) {
        commonOperations.scrollDown();
        WebElement homePageItemLink = driver.findElement(By.xpath("//ul/li[" + i + "]/a"));
        commonOperations.waitUntilElementStanelessOfClickable(driver, homePageItemLink,30);
        homePageItemLink.click();

    }
}
