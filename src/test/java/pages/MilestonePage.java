package pages;

import decorators.Button;
import decorators.Checkbox;
import decorators.Input;
import decorators.TextArea;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MilestonePage extends BasePage {
    private final static By CANCEL_MILESTONE_BUTTON = By.cssSelector("[data-testid='milestoneButtonCancel']");
    private final String MILESTONE_NAME_INPUT = "addEditMilestoneName";
    private final String MILESTONE_REFERENCE_INPUT = "addEditMilestoneReference";
    private final String SECTION_DESCRIPTION_TEXTAREA = "editSectionDescription";
    private final String START_DATE_INPUT = "addEditMilestoneStartOn";
    private final String END_DATE_INPUT = "addEditMilestoneDueOn";
    private final String thisMilestoneIsCompletedCheckbox = "addEditMilestoneIsCompleted";
    private final String ADD_CANCEL_BUTTON = "milestoneButtonOk";
    private final By ADD_MILESTONE_BUTTON = By.id("sidebar-milestones-add");
    private final By MESSAGE_TEXT = By.cssSelector("[data-testid='messageSuccessDivBox']");

    public MilestonePage(WebDriver driver) {
        super(driver);
    }


    @Override
    public void isOpen() {
        wait.until(ExpectedConditions.elementToBeClickable(CANCEL_MILESTONE_BUTTON));
    }

    @Step("Click add milestone")
    public void clickButton() {
        new Button(driver, this.ADD_MILESTONE_BUTTON).click();
    }


    @Step("Check Checkbox This Milestone Is Completed")
    public void checkCheckboxThisMilestoneIsCompleted() {
        new Checkbox(driver, this.thisMilestoneIsCompletedCheckbox).check();
    }

    @Step("Click the button 'Add Milestone'")
    public void clickAddMilestoneButton() {
        new Button(driver, this.ADD_CANCEL_BUTTON).click();
    }

    @Step("Get Expected Successful Message")
    public String getExpectedSuccessfulMessageMilestone() {
        return driver.findElement(MESSAGE_TEXT).getText();
    }

    @Step("Creating milestone '{Name}' with reference: '{reference}', with description '{description}' ")
    public void addMilestone(String milestoneName, String milestoneReference, String description, String startDate, String endDate) {
        new Input(driver, this.MILESTONE_NAME_INPUT).sendKeys(milestoneName);
        new Input(driver, this.MILESTONE_REFERENCE_INPUT).sendKeys(milestoneReference);
        new TextArea(driver, this.SECTION_DESCRIPTION_TEXTAREA).sendKeys(description);
        new Input(driver, this.START_DATE_INPUT).sendKeys(startDate);
        new Input(driver, this.END_DATE_INPUT).sendKeys(endDate);

        clickAddMilestoneButton();
    }
}

