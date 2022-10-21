package tests.mousehover;

import moduleElement.CommonElements;
import moduleElement.homepage.HomePageElements;
import moduleElement.mousehovermodule.MouseHoverPageElements;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.WebConfig;

public class MouseHoverTest extends WebConfig {

    SoftAssert softAssert;
    private HomePageElements homePage;
    private CommonElements elementsCommonForAllThePage;
    private MouseHoverPageElements mouseHoverPageElements;

    @Test(priority = 1, description = "Verification of Mouse Hover Page UI elements")
    public void verifyMouseHoverPageUIElements() {
        softAssert = new SoftAssert();
        homePage = PageFactory.initElements(driver, HomePageElements.class);
        elementsCommonForAllThePage = PageFactory.initElements(driver, CommonElements.class);
        homePage.clickRelevantHomePageItemLink(25);
        softAssert.assertEquals(elementsCommonForAllThePage.getHeaderText("h3"), "Hovers");
        softAssert.assertEquals(elementsCommonForAllThePage.getHeaderText("p"), "Hover over the image for additional information");
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = {"verifyMouseHoverPageUIElements"}, priority = 2, description = "Verification of User Figure 1 Mouse Hover")
    public void verifyUserFigure1MouseHover() {
        mouseHoverPageElements = PageFactory.initElements(driver, MouseHoverPageElements.class);
        mouseHoverPageElements.mouseHover(1);
        Assert.assertEquals(mouseHoverPageElements.getUserFigurerText("h5",1), "name: user1");
        Assert.assertEquals(mouseHoverPageElements.getUserFigurerText("a",1), "View profile");
    }

    @Test(dependsOnMethods = {"verifyUserFigure1MouseHover"}, priority = 3, description = "Verification of User Figure 2 Mouse Hover")
    public void verifyUserFigure2MouseHover() {
        mouseHoverPageElements.mouseHover(2);
        Assert.assertEquals(mouseHoverPageElements.getUserFigurerText("h5",2), "name: user2");
        Assert.assertEquals(mouseHoverPageElements.getUserFigurerText("a",2), "View profile");
    }
    @Test(dependsOnMethods = {"verifyUserFigure2MouseHover"}, priority = 4, description = "Verification of User Figure 3 Mouse Hover")
    public void verifyUserFigure3MouseHover() {
        mouseHoverPageElements.mouseHover(3);
        Assert.assertEquals(mouseHoverPageElements.getUserFigurerText("h5",3), "name: user3");
        Assert.assertEquals(mouseHoverPageElements.getUserFigurerText("a",3), "View profile");
    }
}
