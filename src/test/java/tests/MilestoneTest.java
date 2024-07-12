package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MilestoneTest extends BaseTest {

    @Test(description = "Positive test milestone create", groups = "Smoke")
    public void positiveMilestoneTest() {
        loginPage.open();
        loginPage.login("fiveta5169@carspure.com", "Qa26_onl");
        dashboardPage.openProject("Test1");
        milestonePage.clickButton();
        milestonePage.addMilestone("Name", "Reference", "Description", "7/7/2024", "7/7/2024");
        Assert.assertEquals(milestonePage.getExpectedSuccessfulMessageMilestone(), "Successfully added the new milestone.");
    }

}



