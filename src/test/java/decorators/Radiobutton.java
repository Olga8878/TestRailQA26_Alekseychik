package decorators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Radiobutton extends ElementDecorator {
    public Radiobutton(WebDriver driver, WebElement element) {
        super(driver, element);
    }

    public Radiobutton(WebDriver driver, By locator) {
        super(driver, locator);
    }

    public Radiobutton(WebDriver driver, String dataTestId) {
        super(driver, dataTestId);
    }

    public void check() {
        if (!isChecked()) {
            element.click();
        }
    }

    private boolean isChecked() {
        return element.isSelected();
    }
}
