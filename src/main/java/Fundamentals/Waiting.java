package Fundamentals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiting {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final int timeout;


    public Waiting(WebDriver driver) {
        this.driver = driver;
        this.timeout = 20;
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    public WebElement waitForElementVisibility(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("TimeoutException: Element not visible: " + e.getMessage());
            try {
                throw new Exception(e.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public WebElement waitForElementPresence(By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println("TimeoutException: Element not present: " + e.getMessage());
            try {
                throw new Exception(e.getMessage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public WebElement clear(WebElement element) {
        waitForElementVisibility(element);
        element.clear();
        return element;
    }

    public WebElement click(WebElement element) {
        waitForElementVisibility(element);
        element.click();
        return element;
    }

    public WebElement sendText(WebElement element, String text) {
        waitForElementVisibility(element);
        element.sendKeys(text);
        return element;
    }

    public String getText(WebElement element) {
        waitForElementVisibility(element);
        return element.getText();
    }
}
