package moduleElement.checkboxmodule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.CommonOperations;

public class CheckBoxPageElements {

    WebDriver driver;
    public CommonOperations commonOperations;

    public CheckBoxPageElements(WebDriver driver) {
        commonOperations = new CommonOperations(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCheckBox(int i) {
        WebElement Checkbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[" + i + "]"));
        Checkbox.click();
    }

    public boolean checkBoxSelected(int i) {
        WebElement selectedCheckbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[" + i + "]"));
        return selectedCheckbox.isSelected();
    }

}
