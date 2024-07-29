package Managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private WebDriver driver;

    public void createWebDriver() {
        // Code to create WebDriver
        driver = WebDriverManager.firefoxdriver().create();
        driver.manage().window().maximize();
    }

    public WebDriver getWebDriver() {
        if (driver == null) {
            createWebDriver();
        }
        return driver;
    }

    public void closeWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
