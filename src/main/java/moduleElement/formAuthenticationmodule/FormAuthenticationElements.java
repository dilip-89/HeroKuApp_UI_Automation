package moduleElement.formAuthenticationmodule;

import moduleElement.CommonElementXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonOperations;

public class FormAuthenticationElements {
    WebDriver driver;
    public CommonOperations commonOperations;

    public FormAuthenticationElements(WebDriver driver) {
        commonOperations = new CommonOperations(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = CommonElementXpath.LOGIN_OR_RETRIEVE_BTN)
    private WebElement loginBTN;

    @FindBy(xpath = FormAuthenticationElementsXpath.USER_NAME)
    private WebElement userName;

    @FindBy(xpath = FormAuthenticationElementsXpath.PASSWORD)
    private WebElement password;

    @FindBy(xpath = FormAuthenticationElementsXpath.LOG_OUT_BTN)
    private WebElement logoutBTN;

    public void loginFunction(String UserName, String passWord) {
        commonOperations.waitUntilElementStanelessOf(driver, userName, 30);
        userName.sendKeys(UserName);
        commonOperations.waitUntilElementStanelessOf(driver, password, 30);
        password.sendKeys(passWord);
        loginBTN.click();
    }
    public void logoutFunction() {
        commonOperations.waitUntilElementStanelessOfClickable(driver, logoutBTN, 30);
        logoutBTN.click();
    }

}
