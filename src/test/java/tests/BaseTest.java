package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;

@Listeners({InvokedListener.class})
public abstract class BaseTest {
    protected LoginPage loginPage;
    protected MilestonePage milestonePage;
    protected ProjectPage projectPage;
    protected TestCasePage testCasePage;
    protected DashboardPage dashboardPage;
    protected ProjectDetailsPage projectDetailsPage;

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName"})
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception {
        driver = DriverFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
        this.loginPage = new LoginPage(driver);
        this.milestonePage = new MilestonePage(driver);
        this.projectPage = new ProjectPage(driver);
        this.dashboardPage = new DashboardPage(driver);
        this.testCasePage = new TestCasePage(driver);
        this.projectDetailsPage = new ProjectDetailsPage(driver);
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}

