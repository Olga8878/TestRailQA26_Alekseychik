package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Input extends ElementDecorator {

    public Input(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Input(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public Input(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void clearValue() {
        Actions actions = new Actions(driver);
        actions.sendKeys(this.element, Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    public void getValue() {
        this.element.getAttribute("value");
    }

    public void setValue(String value) {
        this.element.sendKeys(value);
    }
}


