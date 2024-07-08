package pages;

import decorators.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {

    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isOpen() {
    }

    private final static By NAME_PROJECT_INPUT = By.cssSelector("[data-testid='addProjectNameInput']");
    private final static By CHECKBOX_SHOW_THE_ANNOUNCEMENT = By.cssSelector("[data-testid='addEditProjectShowAnnouncement']");
    private final static By CHECKBOX_ENABLE_TEST_CASE_APPROVALS = By.cssSelector("[data-testid='addEditProjectCaseStatusesEnabled']");
    private final static By TEXT_IN_ANNOUNCEMENT_AREA = By.cssSelector("[data-testid='addEditProjectAnnouncement']");
    private final static By PROJECT_ADD_BUTTON = By.cssSelector("[data-testid='sidebarProjectsAddButton']");
    private final static By PROJECT_CANCEL_BUTTON = By.cssSelector("[data-testid='addEditProjectAddButton']");

    @Step("Check Checkbox 'Show The Announcement'")
    public void checkCheckboxShowTheAnnouncement() {
        new Checkbox(driver, CHECKBOX_SHOW_THE_ANNOUNCEMENT).check();
    }

    @Step("Uncheck Checkbox 'Show The Announcement'")
    public void unCheckCheckboxShowTheAnnouncement() {
        new Checkbox(driver, CHECKBOX_SHOW_THE_ANNOUNCEMENT).uncheck();
    }

    public boolean isCheckboxShowTheAnnouncementChecked() {
        return new Checkbox(driver, CHECKBOX_SHOW_THE_ANNOUNCEMENT).isChecked();
    }

    @Step("Check Checkbox 'Enable TestCase Approvals'")
    public void checkCheckboxEnableTestCaseApprovals() {
        new Checkbox(driver, CHECKBOX_ENABLE_TEST_CASE_APPROVALS).check();
    }

    @Step("Click the button 'Add Project'")
    public void clickButtonAddProject() {
        new Button(driver, PROJECT_ADD_BUTTON).click();
    }

    @Step("Creating project '{projectName}' with announcement: '{project.announcement}'")

    public void addProject(String projectName, String projectAnnouncement) {
        new Input(driver, NAME_PROJECT_INPUT).sendKeys(projectName);
        new TextArea(driver, TEXT_IN_ANNOUNCEMENT_AREA).sendKeys(projectAnnouncement);
        new Checkbox(driver, CHECKBOX_SHOW_THE_ANNOUNCEMENT).check();
        new Button(driver, PROJECT_CANCEL_BUTTON).click();

    }
}
