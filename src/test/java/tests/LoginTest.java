package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(description = "Positive login test", groups = "Smoke")
    public void positiveLoginTest() {
        loginPage.open();
        loginPage.login("fiveta5169@carspure.com", "Qa26_onl");
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

    }
}
