package pages;

import decorators.Button;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {
    private final String PROJECT_CONTAINER = "//div[@class = 'table']//a[text() = '%s']";
    private static final By navigationUserName = By.cssSelector(".navigation-username");
    private final String ADD_PROJECT_LINK = "sidebarProjectsAddButton";
    private final By DASHBOARD_LINK = By.id("navigation-dashboard");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void isOpen() {
    }

    @Step("Click '{add project}' link")
    public void clickAddProjectLink() {
        new Button(driver, this.ADD_PROJECT_LINK).click();
    }

    @Step("Click '{dashboard}' link")
    public void clickDashboardLink() {
        new Button(driver, this.DASHBOARD_LINK).click();
    }

    @Step("Open '{projectName}' project")
    public void openProject(String projectName) {
        driver.findElement(By.xpath(String.format(PROJECT_CONTAINER, projectName))).click();
    }
}
