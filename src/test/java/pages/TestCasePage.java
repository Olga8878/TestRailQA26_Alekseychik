package pages;

import decorators.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasePage extends BasePage {
    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isOpen() {
    }

    private final String CASE_TITLI_INPUT = "addEditCaseTitle";
    private final By testCaseButton = By.cssSelector("[data-testid='sidebarCasesAdd']");

    private final By CANCEL_TESTCASE_BUTTON = By.cssSelector("[data-testid='addEditCaseCancelButton']");
    private final By TEMPLATE = By.id("template_id_chzn");
    private final By TYPE = By.id("type_id_chzn");

    private final By PRIORITY = By.id("priority_id_chzn");

    private final static By ACTUAL_STEPS = By.xpath("//*[@id=\"custom_steps_display\"]");

    private final static By EXPECTED_RESULTS = By.xpath("//*[@id=\"custom_expected_display\"]");

    private final static By EDIT_BUTTON = By.cssSelector("[data-testid='addTestCaseButton']");

    private final static By ACTUAL_STATUS = By.xpath("//*[@id=\"section_id_chzn\"]");

    private final static By MESSAGE_TEXT = By.cssSelector("[data-testid='messageSuccessDivBox']");


    @Step("Click the button 'Add Test Case'")
    public void clickAddTestCaseButton() {
        new Button(driver, this.testCaseButton).click();
    }

    @Step("Get Expected Successful Message")
    public String getExpectedSuccessfulMessage() {
        return driver.findElement(MESSAGE_TEXT).getText();
    }

    @Step("Creating testCase")

    public void addTestCase(String title, String status, String template, String type, String priority, String steps, String result) {
        new Input(driver, CASE_TITLI_INPUT).sendKeys(title);
        new Dropdown(driver, ACTUAL_STATUS).selectByVisibleText(status);
        new Dropdown(driver, TEMPLATE).selectByVisibleText(template);
        new Dropdown(driver, TYPE).selectByVisibleText(type);
        new Dropdown(driver, PRIORITY).selectByVisibleText(priority);
        new TextArea(driver, ACTUAL_STEPS).sendKeys(steps);
        new TextArea(driver, EXPECTED_RESULTS).sendKeys(result);
        new Button(driver, EDIT_BUTTON).click();

    }

}
