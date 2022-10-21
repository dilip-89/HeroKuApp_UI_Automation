package moduleElement.dropdownmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonOperations;

public class DropDownPageElements {

    WebDriver driver;
    public CommonOperations commonOperations;

    @FindBy(xpath = DropDownPageElementXpath.DROP_DOWN)
    private WebElement dropDown;

    public DropDownPageElements(WebDriver driver) {
        commonOperations = new CommonOperations(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getDropDownOptionText(int i) {
        WebElement dropDownOptions = driver.findElement(By.xpath("//select[@id='dropdown']/option["+ i + "]"));
        commonOperations.waitUntilElementStanelessOf(driver, dropDownOptions, 30);
        return dropDownOptions.getText();
    }

    public void selectDropDownOption(String optionText) {
        commonOperations.waitUntilElementStanelessOf(driver, dropDown, 30);
        commonOperations.dropDownSelectByText(dropDown,optionText);
    }

    public boolean checkOptionSelected(String optionText) {
        WebElement selectedOption = driver.findElement(By.xpath("//option[contains(text(),'" + optionText + "')]"));
        return selectedOption.isSelected();
    }
}
