package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProjectTest extends BaseTest {
    @Test(description = "Positive test create project", groups = "Smoke")
    public void positiveProjectTest() {
        loginPage.open();
        loginPage.login("fiveta5169@carspure.com", "Qa26_onl");
        projectPage.clickButtonAddProject();
        projectPage.addProject("Test5", "Demo project");
        Assert.assertEquals(projectDetailsPage.getExpectedSuccessfulMessage(), "Successfully added the new project.");
    }
}
