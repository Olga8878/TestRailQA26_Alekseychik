package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

    public class DriverFactory {
        public static WebDriver getDriver(String browser) throws Exception {
            WebDriver driver;
            switch (browser) {
                case "chrome" -> driver = new ChromeDriver();
                case "microsoft edge" -> driver = new EdgeDriver();
                default -> throw new Exception("Unsupported browser....");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return driver;
        }
    }

