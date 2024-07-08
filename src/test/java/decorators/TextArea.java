package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TextArea extends ElementDecorator {

    public TextArea(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public TextArea(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public TextArea(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void clearValueTextarea() {
        Actions actions = new Actions(driver);
        actions.sendKeys(this.element, Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
    }

    public String getValueTextarea() {
        return this.element.getAttribute("value");
    }
}

