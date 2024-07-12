package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkbox extends ElementDecorator {

    public Checkbox(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Checkbox(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public Checkbox(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void check() {
        if (!element.isSelected()) {
            element.click();
        }
    }

    public void uncheck() {
        if (element.isSelected()) ;
        element.click();
    }

    public boolean isChecked() {
        return element.isSelected();
    }

}

