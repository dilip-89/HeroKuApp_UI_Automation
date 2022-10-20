package tests.checkbox;

import moduleElement.CommonElements;
import moduleElement.checkboxmodule.CheckBoxPageElements;
import moduleElement.dropdownmodule.DropDownPageElements;
import moduleElement.homepage.HomePageElements;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.WebConfig;

public class CheckBoxPageTest extends WebConfig {

    SoftAssert softAssert;
    private HomePageElements homePage;
    private CommonElements elementsCommonForAllThePage;
    private CheckBoxPageElements checkBoxPageElements;

    @Test(priority = 1, description = "Verification of Check Box Page UI Elements")
    public void verifyCheckBoxPageUIElements() {
        homePage = PageFactory.initElements(driver, HomePageElements.class);
        elementsCommonForAllThePage = PageFactory.initElements(driver, CommonElements.class);
        checkBoxPageElements = PageFactory.initElements(driver, CheckBoxPageElements.class);
        homePage.clickRelevantHomePageItemLink(6);
        Assert.assertEquals(elementsCommonForAllThePage.getHeaderText("h3"), "Checkboxes");
        checkBoxPageElements.selectCheckBox(2);
    }

    @Test(dependsOnMethods = {"verifyCheckBoxPageUIElements"}, priority = 2, description = "Verification Whether the first checkBox is checked")
    public void verifyCheckBox1() {
        checkBoxPageElements.selectCheckBox(1);
        Assert.assertTrue(checkBoxPageElements.checkBoxSelected(1), "CheckBox one is not selected");
        checkBoxPageElements.selectCheckBox(1);
    }
    @Test(dependsOnMethods = {"verifyCheckBox1"}, priority = 3, description = "Verification Whether the Second checkBox is checked")
    public void verifyCheckBox2() {
        checkBoxPageElements.selectCheckBox(2);
        Assert.assertTrue(checkBoxPageElements.checkBoxSelected(2), "CheckBox Two is not selected");
        checkBoxPageElements.selectCheckBox(2);
    }
    @Test(dependsOnMethods = {"verifyCheckBox2"}, priority = 4, description = "Verification Whether Both the checkBox is checked")
    public void verifyBothCheckBox() {
        checkBoxPageElements.selectCheckBox(1);
        checkBoxPageElements.selectCheckBox(2);
        Assert.assertTrue(checkBoxPageElements.checkBoxSelected(1), "CheckBox one is not selected");
        Assert.assertTrue(checkBoxPageElements.checkBoxSelected(2), "CheckBox Two is not selected");
    }
}
