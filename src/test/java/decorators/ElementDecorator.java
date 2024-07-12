package decorators;

import org.openqa.selenium.*;
import utils.AllureUtils;

import java.util.ArrayList;
import java.util.List;

public class ElementDecorator implements WebElement {
    protected WebElement element;
    protected WebDriver driver;
    protected By locator;
    protected String dataTestId;

    public ElementDecorator(WebDriver driver, WebElement element) {
        this.driver = driver;
        this.element = element;
    }

    public ElementDecorator(WebDriver driver, By locator) {
        this.driver = driver;
        this.locator = locator;
        this.element = driver.findElement(locator);
    }

    public ElementDecorator(WebDriver driver, String dataTestId) {
        this.driver = driver;
        this.dataTestId = dataTestId;
        this.element = driver.findElement(By.cssSelector(String.format("[data-testid=%s]", this.dataTestId)));
    }

    public void click() {
        System.out.printf("Clicking on element: %s", this.dataTestId);
        AllureUtils.attachScreenshot(driver);
        try {
            element.click();
        } catch (ElementNotInteractableException exception) {
            scrollIntoView();
            element.click();
        }
    }

    public ElementDecorator findElementDecorator(By locator) {
        return new ElementDecorator(this.driver, locator);
    }

    public List<ElementDecorator> findElementsDecorator(By locator) {
        List<ElementDecorator> result = new ArrayList<>();
        for (WebElement elementElement : element.findElements(locator)) {
            result.add(new ElementDecorator(driver, elementElement));
        }
        return result;
    }

    public void scrollIntoView() {
        ((JavascriptExecutor) this.driver)
                .executeScript("arguments[0].scrollIntoView(true);", this.element);

    }

    @Override
    public void submit() {
        element.submit();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        element.sendKeys(keysToSend);

    }

    public void clear() {
        element.clear();
    }

    @Override
    public String getTagName() {
        return element.getTagName();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    public boolean isDisplayed() {
        return element.isDisplayed();

    }

    @Override
    public Point getLocation() {
        return element.getLocation();
    }

    @Override
    public Dimension getSize() {
        return element.getSize();
    }

    @Override
    public Rectangle getRect() {
        return element.getRect();
    }

    @Override
    public String getCssValue(String propertyName) {
        return element.getCssValue(propertyName);
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();

    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }
}
