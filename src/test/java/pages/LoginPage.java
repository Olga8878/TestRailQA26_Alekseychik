package pages;

import decorators.Button;
import decorators.Input;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final static By LOG_IN_BUTTON = By.cssSelector("[data-testid='loginButtonPrimary']");

    @Override
    public void isOpen() {
        wait.until(ExpectedConditions.elementToBeClickable(LOG_IN_BUTTON));
    }

    @Step("Login with email '{email}' and password '{password}'")
    public void login(String email, String password) {
        new Input(driver, "loginIdName").sendKeys(email);
        new Input(driver, "loginPasswordFormDialog").sendKeys(password);
        new Button(driver, "loginButtonPrimary").click();
    }

    public void open() {
        driver.get("https://tms26qaonl.testrail.io/");

    }
}

