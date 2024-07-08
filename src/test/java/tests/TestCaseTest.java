package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCaseTest extends BaseTest {
    @Test(description = "Create test case", groups = "Regression")
    public void positiveCreateTestCase() {
        loginPage.open();
        loginPage.login("fiveta5169@carspure.com", "Qa26_onl");
        dashboardPage.openProject("Test1");
        testCasePage.clickAddTestCaseButton();
        testCasePage.addTestCase("Title", "Test Cases", "Test Case (Text)", "Regression", "Critical", "Steps", "Result");
        Assert.assertEquals(testCasePage.getExpectedSuccessfulMessage(), "Successfully added the new test case. Add another");

    }
}



