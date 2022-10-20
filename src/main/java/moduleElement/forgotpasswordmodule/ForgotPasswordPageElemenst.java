package moduleElement.forgotpasswordmodule;

import moduleElement.CommonElementXpath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonOperations;

public class ForgotPasswordPageElemenst {

    WebDriver driver;
    public CommonOperations commonOperations;

    @FindBy(xpath = CommonElementXpath.LOGIN_OR_RETRIEVE_BTN)
    private WebElement loginOrRetrieveBTN;

    @FindBy(xpath = ForgotPasswordPageElementXpath.EMAIL)
    private WebElement emailField;

    public ForgotPasswordPageElemenst(WebDriver driver) {
        commonOperations = new CommonOperations(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void forgotPasswordSubmit(String email) {
        commonOperations.waitUntilElementStanelessOf(driver, emailField, 30);
        emailField.sendKeys(email);
        loginOrRetrieveBTN.click();
    }
}
