package tests.forgotpassword;

import moduleElement.CommonElements;
import moduleElement.forgotpasswordmodule.ForgotPasswordPageElemenst;
import moduleElement.formAuthenticationmodule.FormAuthenticationElements;
import moduleElement.homepage.HomePageElements;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.WebConfig;

public class ForgotPasswordTest extends WebConfig {

    SoftAssert softAssert;
    private HomePageElements homePage;
    private CommonElements elementsCommonForAllThePage;
    private ForgotPasswordPageElemenst forgotPasswordPageElement;

    @DataProvider(name = "Forgot_Password")
    public Object[][] getLoginData() {
        return getData("Forgot_Password_Data", "Automation_Verification_Data.xlsx");
    }

    @Test(priority = 1, description = "Verification of Forgot Password Page UI elements")
    public void verifyForgotPasswordPageUIElements() {
        softAssert = new SoftAssert();
        homePage = PageFactory.initElements(driver, HomePageElements.class);
        elementsCommonForAllThePage = PageFactory.initElements(driver, CommonElements.class);
        homePage.clickRelevantHomePageItemLink(20);
        softAssert.assertEquals(elementsCommonForAllThePage.getHeaderText("h2"), "Forgot Password");
        softAssert.assertEquals(elementsCommonForAllThePage.getFormLabelText(1), "E-mail");
        softAssert.assertEquals(elementsCommonForAllThePage.getLoginOrRetrieveBTNText(), "Retrieve password");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = {"verifyForgotPasswordPageUIElements"}, dataProvider = "Forgot_Password", priority = 2, description = "Verify Invalid Scenarios for Email")
    public void verifyForgotPasswordEmailValidationTest(String Scenario, String Email) {
        forgotPasswordPageElement = PageFactory.initElements(driver, ForgotPasswordPageElemenst.class);
        softAssert = new SoftAssert();
        switch (Scenario) {
            case "Empty Email":
                forgotPasswordPageElement.forgotPasswordSubmit(Email);
                softAssert.assertEquals(elementsCommonForAllThePage.getAlertMessageText(), "Please input your email!");
                driver.navigate().back();
                break;
            case "Invalid Email format":
                forgotPasswordPageElement.forgotPasswordSubmit(Email);
                softAssert.assertEquals(elementsCommonForAllThePage.getAlertMessageText(), "Email is invalid.");
                driver.navigate().back();
                break;
            case "Invalid Email":
                forgotPasswordPageElement.forgotPasswordSubmit(Email);
                softAssert.assertEquals(elementsCommonForAllThePage.getAlertMessageText(), "The user you were looking for was not found.");
                break;
            default:
                throw new SkipException("Skipping test. Test Scenario is :- " + Scenario);
        }
        softAssert.assertAll();
    }
}
