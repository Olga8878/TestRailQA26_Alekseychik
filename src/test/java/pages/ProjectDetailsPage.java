package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectDetailsPage extends BasePage {
    public ProjectDetailsPage(WebDriver driver) {
        super(driver);
    }

    private final static By DASHBOARD_TAB = By.id("navigation-dashboard");
    private final static String PROJECT_ADDED_NAME = "//table[@class='grid']/descendant::a[text()='%s']";
    private final static By SIDEBAR_OVERVIEW = By.cssSelector("[data-testid='administrationSidebarOverview']");
    private final static By MESSAGE_TEXT = By.cssSelector("[data-testid='messageSuccessDivBox']");


    @Override
    public void isOpen() {
        wait.until(ExpectedConditions.elementToBeClickable(SIDEBAR_OVERVIEW));
    }

    public boolean isProjectAdded(String projectName) {
        return driver.findElement(By.xpath(String.format(PROJECT_ADDED_NAME, projectName))).isDisplayed();
    }

    @Step("Click the tab 'Dashboard'")
    public void clickDashboardTab() {
        driver.findElement(DASHBOARD_TAB).click();
    }

    @Step("Get Expected Successful Message")
    public String getExpectedSuccessfulMessage() {
        return driver.findElement(MESSAGE_TEXT).getText();

    }

}

