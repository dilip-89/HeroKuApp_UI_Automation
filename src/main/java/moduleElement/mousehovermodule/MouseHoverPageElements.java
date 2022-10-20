package moduleElement.mousehovermodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonOperations;

public class MouseHoverPageElements {

    WebDriver driver;
    public CommonOperations commonOperations;

    public MouseHoverPageElements(WebDriver driver) {
        commonOperations = new CommonOperations(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void mouseHover(int i) {
        WebElement userFigure = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[" + i + "]"));
        commonOperations.waitUntilElementStanelessOf(driver, userFigure, 30);
        commonOperations.mouseHoverToElement(userFigure);
    }
    public String getUserFigurerText(String tagname, int i) {
        WebElement userFigureText = driver.findElement(By.xpath("(//div[@class='figcaption']/" + tagname + ")[" + i + "]"));
        commonOperations.waitUntilElementStanelessOf(driver, userFigureText, 30);
        return userFigureText.getText();
    }
}
