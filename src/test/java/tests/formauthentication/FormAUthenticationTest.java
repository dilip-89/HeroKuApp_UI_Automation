package tests.formauthentication;

import moduleElement.CommonElements;
import moduleElement.formAuthenticationmodule.FormAuthenticationElements;
import moduleElement.homepage.HomePageElements;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.WebConfig;

public class FormAUthenticationTest extends WebConfig {

    SoftAssert softAssert;
    private HomePageElements homePage;
    private String Username;
    private String Password;
    private FormAuthenticationElements formAuthenticationPage;
    private CommonElements elementsCommonForAllThePage;

    @DataProvider(name = "Login")
    public Object[][] getLoginData() {
        return getData("Login_Validation_Data", "Automation_Verification_Data.xlsx");
    }

    @Test(priority = 1, description = "Verification of Form Authentication Module UI elements")
    public void verifyLoginPageUIElements() {
        softAssert = new SoftAssert();
        homePage = PageFactory.initElements(driver, HomePageElements.class);
        elementsCommonForAllThePage = PageFactory.initElements(driver, CommonElements.class);
        homePage.clickRelevantHomePageItemLink(21);
        softAssert.assertEquals(elementsCommonForAllThePage.getHeaderText("h2"), "Login Page");
        softAssert.assertEquals(elementsCommonForAllThePage.getHeaderText("h4"), "This is where you can log into the secure area. Enter " +
                "tomsmith for the username and SuperSecretPassword! for the password. If the information is wrong you should see error messages.");
        softAssert.assertEquals(elementsCommonForAllThePage.getFormLabelText(1), "Username");
        softAssert.assertEquals(elementsCommonForAllThePage.getFormLabelText(2), "Password");
        softAssert.assertEquals(elementsCommonForAllThePage.getLoginOrRetrieveBTNText(), "Login");
        softAssert.assertAll();
    }

    @Test(dataProvider = "Login", priority = 2, description = "Invalid Login scenario Verification")
    public void verifyInvalidLoginScenarios(String Scenario, String UserName, String Password) {
        formAuthenticationPage = PageFactory.initElements(driver, FormAuthenticationElements.class);
        softAssert = new SoftAssert();
        switch (Scenario) {
            case "Empty Username & valid password":
                formAuthenticationPage.loginFunction(UserName, Password);
                softAssert.assertEquals(elementsCommonForAllThePage.getAlertMessageText(), "Your username is invalid!");
                break;
            case "Valid Username & empty password":
                formAuthenticationPage.loginFunction(UserName, Password);
                softAssert.assertEquals(elementsCommonForAllThePage.getAlertMessageText(), "Your password is invalid!");
                break;
            case "Invalid Username  & valid password":
                formAuthenticationPage.loginFunction(UserName, Password);
                softAssert.assertEquals(elementsCommonForAllThePage.getAlertMessageText(), "Your username is invalid!");
                break;
            case "Valid Username & invalid password":
                formAuthenticationPage.loginFunction(UserName, Password);
                softAssert.assertEquals(elementsCommonForAllThePage.getAlertMessageText(), "Your password is invalid!");
                break;
            default:
                throw new SkipException("Skipping test. Test Scenario is :- " + Scenario);
        }
        softAssert.assertAll();
    }

    @Test(priority = 3, description = "Success Login Page Verification")
    public void verifySuccessLoginValidation() {
        softAssert = new SoftAssert();
        this.Username = excel.getCellData("Login_Validation_Data", "UserName", 6);
        this.Password = excel.getCellData("Login_Validation_Data", "Password", 6);
        formAuthenticationPage.loginFunction(Username, Password);
        softAssert.assertEquals(elementsCommonForAllThePage.getAlertMessageText(), "You logged into a secure area!");
        softAssert.assertAll();
    }

    @Test(priority = 4, description = "Success Login out Verification")
    public void verifySuccessLogoutValidation() {
        softAssert = new SoftAssert();
        softAssert.assertEquals(elementsCommonForAllThePage.getHeaderText("h2"),"Secure Area");
        softAssert.assertEquals(elementsCommonForAllThePage.getHeaderText("h4"),"Welcome to the Secure Area. When you are done click logout below.");
        formAuthenticationPage.logoutFunction();
        softAssert.assertEquals(elementsCommonForAllThePage.getAlertMessageText(), "You logged out of the secure area!");
        softAssert.assertAll();
    }

}
