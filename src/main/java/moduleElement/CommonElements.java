package moduleElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonOperations;

public class CommonElements {

    WebDriver driver;
    public CommonOperations commonOperations;

    @FindBy(xpath = CommonElementXpath.LOGIN_OR_RETRIEVE_BTN)
    private WebElement loginOrRetrieveBTN;

    @FindBy(xpath = CommonElementXpath.ALERT_MESSAGE)
    private WebElement alertMessage;

    public CommonElements(WebDriver driver) {
        commonOperations = new CommonOperations(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLoginOrRetrieveBTNText() {
        commonOperations.waitUntilElementStanelessOf(driver, loginOrRetrieveBTN, 30);
        return loginOrRetrieveBTN.getText();
    }

    public String getHeaderText(String tagname) {
        WebElement header = driver.findElement(By.xpath("//div[@class='example']/" + tagname));
        commonOperations.waitUntilElementStanelessOf(driver, header, 30);
        return header.getText();
    }
    public String getFormLabelText(int i) {
        WebElement formLabel = driver.findElement(By.xpath("(//label)[" + i + "]"));
        commonOperations.waitUntilElementStanelessOf(driver, formLabel, 30);
        return formLabel.getText();
    }
    public String getAlertMessageText() {
        commonOperations.waitUntilElementStanelessOf(driver, alertMessage, 5);
        return alertMessage.getText();
    }
}
