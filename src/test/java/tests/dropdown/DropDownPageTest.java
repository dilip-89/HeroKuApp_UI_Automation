package tests.dropdown;

import moduleElement.CommonElements;
import moduleElement.dropdownmodule.DropDownPageElements;
import moduleElement.homepage.HomePageElements;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.WebConfig;

public class DropDownPageTest extends WebConfig {

    SoftAssert softAssert;
    private HomePageElements homePage;
    private CommonElements elementsCommonForAllThePage;
    private DropDownPageElements dropDownPageElements;

    @Test(priority = 1, description = "Verification of Drop Down Page UI Elements")
    public void verifyDropDownPageUIElements() {
        softAssert = new SoftAssert();
        homePage = PageFactory.initElements(driver, HomePageElements.class);
        elementsCommonForAllThePage = PageFactory.initElements(driver, CommonElements.class);
        dropDownPageElements = PageFactory.initElements(driver, DropDownPageElements.class);
        homePage.clickRelevantHomePageItemLink(11);
        softAssert.assertEquals(elementsCommonForAllThePage.getHeaderText("h3"), "Dropdown List");
        softAssert.assertEquals(dropDownPageElements.getDropDownOptionText(1), "Please select an option");
        softAssert.assertEquals(dropDownPageElements.getDropDownOptionText(2), "Option 1");
        softAssert.assertEquals(dropDownPageElements.getDropDownOptionText(3), "Option 2");
        softAssert.assertAll();
    }

    @Test(priority = 2, dependsOnMethods = {"verifyDropDownPageUIElements"}, description = "Selecting the Option 1 and Verifying whether its selected")
    public void verifySelectingOption1() {
        dropDownPageElements.selectDropDownOption("Option 1");
        Assert.assertTrue(dropDownPageElements.checkOptionSelected("Option 1"),"Option One is not Selected");
    }

    @Test(priority = 3, dependsOnMethods = {"verifySelectingOption1"}, description = "Selecting the Option 2 and Verifying whether its selected")
    public void verifySelectingOption2() {
        dropDownPageElements.selectDropDownOption("Option 2");
        Assert.assertTrue(dropDownPageElements.checkOptionSelected("Option 2"),"Option Two is not Selected");
    }
}
