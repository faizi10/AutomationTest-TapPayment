/*
package PageObjects;

import Fundamentals.Waiting;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.logging.Logger;

public class CardTransactionPage extends BasePage {

    private final Waiting waiting;
    private final JavascriptExecutor jsExecutor;

    public CardTransactionPage(WebDriver driver) {
        super(driver);
        waiting = new Waiting(driver);
        jsExecutor = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//p[normalize-space(text())='Configurations' and small='5123450000000008']")
    private WebElement getCardTransactionPageTitle;

    @FindBy(xpath = "//div[@style='display: flex; gap: 5px; align-items: center;']/select[@name='currency' and @id='currency']")
    private WebElement currencyDropdown;

    @FindBy(xpath = "//div[@style='display: flex; gap: 5px; align-items: center;']//select[@name='currency']/option[@value='BHD']")
    private WebElement currencyOption;

    @FindBy(xpath = "//div[@style='display: flex; gap: 5px; align-items: center;']/select[@name='scope']")
    private WebElement scopeDropdown;

    @FindBy(xpath = "//div[@style='display: flex; gap: 5px; align-items: center;']//select[@name='scope']/option[@value='AuthenticatedToken']")
    private WebElement scopeOption;

    @FindBy(css = "#tap-card-iframe")
    private WebElement cardDetailsContainer;

    @FindBy(css = "#card-inputs-container")
    private WebElement cardNumberFieldClicker;

    @FindBy(xpath = "//input[@placeholder='Card number']")
    private WebElement cardNumberField;

    @FindBy(xpath = "//section[@style='max-height: 48px; display: flex; flex-direction: row; width: 100%;']//input[@id='date_input']")
    private WebElement expiryDateField;

    @FindBy(xpath = "//input[@placeholder='CVV']")
    private WebElement cvvField;

    @FindBy(xpath = "//button[@type='button' and contains(@class, 'button token_button') and @style='background-color: green; flex: 1 1 100%;']")
    private WebElement generateTokenButton;

    @FindBy (css = "#tap-card-iframe-authentication")
    private WebElement authenticationIFrame;

    @FindBy (css = "#challengeFrame")
    private WebElement challengeFrame;

    @FindBy(xpath = "//form[@method='POST' and @action='../v2/challengeinfo']//input[@id='acssubmit' and @type='submit' and @value='Submit']\n")
    private WebElement submitButton;

    @FindBy(css = "#Response\\ ✅")
    private WebElement responseTab;


    public void visitCardTransactionPage() {
        driver.get("https://demo.dev.tap.company/v2/sdk/card");
    }

    public String getCardTransactionPageTitle() {
        return waiting.getText(getCardTransactionPageTitle);
    }

    public void selectCurrency(String currency) {
        waiting.waitForElementVisibility(currencyDropdown);
        currencyDropdown.click();
        waiting.waitForElementVisibility(currencyOption);
        currencyOption.click();
    }

    public void selectScope(String scope) {
        waiting.waitForElementVisibility(scopeDropdown);
        scopeDropdown.click();
        waiting.waitForElementVisibility(scopeOption);
        scopeOption.click();
    }

    public void switchToCardDetailsIFrame() {
        System.out.println("Switching to Card Details IFrame");
        waiting.waitForElementVisibility(cardDetailsContainer);
        driver.switchTo().frame(cardDetailsContainer);
        System.out.println("Switched to Card Details IFrame");
    }

    public void enterCardDetails(String cardNumber, String expiryDate, String cvv) {
        waiting.waitForElementVisibility(cardNumberFieldClicker);
        cardNumberFieldClicker.click();
        System.out.println("Card Number Field clicker is visible");

        waiting.sendText(cardNumberField, cardNumber);
        System.out.println("Card Number Field is entered");

        waiting.waitForElementVisibility(expiryDateField).click();
        System.out.println("Expiry Date Field is clicked");
        waiting.sendText(expiryDateField, expiryDate);
        System.out.println("Expiry Date is entered");

        waiting.waitForElementVisibility(cvvField).click();
        System.out.println("CVV Field is clicked");
        waiting.sendText(cvvField, cvv);
        System.out.println("CVV is entered");

        // driver.switchTo().defaultContent();
        System.out.println("Switched to default content");
    }

    public void clickGenerateTokenButton() {
        System.out.println("Waiting for Generate Token Button");
        waiting.waitForElementVisibility(generateTokenButton).click();
        System.out.println("Generate Token Button is clicked");
    }

    public void waitFor3dsPage() {
        System.out.println("Switching to Card Details IFrame");
        driver.switchTo().frame(cardDetailsContainer);
        System.out.println("Switched to Card Details IFrame");
    }

    public void clickSubmitButton() {
        System.out.println("Switching to Authentication IFrame");
        driver.switchTo().frame(authenticationIFrame);
        System.out.println("Switched to Authentication IFrame");

        // wait for challenge frame to be visible
        waiting.waitForElementVisibility(challengeFrame);
        System.out.println("Switching to Challenge Frame");
        driver.switchTo().frame(challengeFrame);
        System.out.println("Switched to Challenge Frame");

        waiting.waitForElementVisibility(submitButton).click();
    }

    public void waitForResponseData() {
        waiting.waitForElementVisibility(responseTab);
        System.out.println("Response Tab is visible");
        responseTab.click();
        System.out.println("Response Tab is clicked");
    }

    public void printTransactionDetails() {
        System.out.println("Transaction Details: " + waiting.getText(responseTab));
        Logger.getLogger(waiting.getText(responseTab));
    }
}
*/

package PageObjects;

import Fundamentals.Waiting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CardTransactionPage extends BasePage {

    private final Waiting waiting;

    public CardTransactionPage(WebDriver driver) {
        super(driver);
        waiting = new Waiting(driver);
    }

    @FindBy(xpath = "//p[normalize-space(text())='Configurations' and small='5123450000000008']")
    private WebElement getCardTransactionPageTitle;

    @FindBy(xpath = "//div[@style='display: flex; gap: 5px; align-items: center;']/select[@name='currency' and @id='currency']")
    private WebElement currencyDropdown;

    @FindBy(xpath = "//div[@style='display: flex; gap: 5px; align-items: center;']//select[@name='currency']/option[@value='BHD']")
    private WebElement currencyOption;

    @FindBy(xpath = "//div[@style='display: flex; gap: 5px; align-items: center;']/select[@name='scope']")
    private WebElement scopeDropdown;

    @FindBy(xpath = "//div[@style='display: flex; gap: 5px; align-items: center;']//select[@name='scope']/option[@value='AuthenticatedToken']")
    private WebElement scopeOption;

    @FindBy(css = "#tap-card-iframe")
    private WebElement cardDetailsContainer;

    @FindBy(css = "#card-inputs-container")
    private WebElement cardNumberFieldClicker;

    @FindBy(xpath = "//input[@placeholder='Card number']")
    private WebElement cardNumberField;

    @FindBy(xpath = "//section[@style='max-height: 48px; display: flex; flex-direction: row; width: 100%;']//input[@id='date_input']")
    private WebElement expiryDateField;

    @FindBy(xpath = "//input[@placeholder='CVV']")
    private WebElement cvvField;

    @FindBy(xpath = "//button[@type='button' and contains(@class, 'button token_button') and @style='background-color: green; flex: 1 1 100%;']")
    private WebElement generateTokenButton;

    @FindBy (css = "#tap-card-iframe-authentication")
    private WebElement authenticationIFrame;

    @FindBy (css = "#challengeFrame")
    private WebElement challengeFrame;

    @FindBy(xpath = "//form[@method='POST' and @action='../v2/challengeinfo']//input[@id='acssubmit' and @type='submit' and @value='Submit']\n")
    private WebElement submitButton;

    @FindBy(css = ".preview")
    private WebElement preview;

    @FindBy (css = "#root > section > aside > article._controls-container_nogne_5")
    private WebElement previewContainer;

    @FindBy (css = "input[type='radio'][id='Response'][name='preview'][value='response']")
    private WebElement responseRadio;

    @FindBy (css = "#Response")
    private WebElement responseContainer;

    @FindBy(css = "#Response\\ ✅")
    private WebElement responseTab;

    @FindBy (css = "#root > section > aside > article:nth-child(2) > pre")
    private WebElement responseTabData;


    public void visitCardTransactionPage() {
        driver.get("https://demo.dev.tap.company/v2/sdk/card");
    }

    public String getCardTransactionPageTitle() {
        return waiting.getText(getCardTransactionPageTitle);
    }

    public void selectCurrency(String currency) {
        waiting.waitForElementVisibility(currencyDropdown);
        currencyDropdown.click();
        waiting.waitForElementVisibility(currencyOption);
        currencyOption.click();
    }

    public void selectScope(String scope) {
        waiting.waitForElementVisibility(scopeDropdown);
        scopeDropdown.click();
        waiting.waitForElementVisibility(scopeOption);
        scopeOption.click();
    }

    public void switchToCardDetailsIFrame() {
        System.out.println("Switching to Card Details IFrame");
        waiting.waitForElementVisibility(cardDetailsContainer);
        driver.switchTo().frame(cardDetailsContainer);
        System.out.println("Switched to Card Details IFrame");
    }

    public void enterCardDetails(String cardNumber, String expiryDate, String cvv) {
        waiting.waitForElementVisibility(cardNumberFieldClicker);
        cardNumberFieldClicker.click();
        System.out.println("Card Number Field clicker is visible");

        waiting.sendText(cardNumberField, cardNumber);
        System.out.println("Card Number is entered");

        waiting.waitForElementVisibility(expiryDateField).click();
        System.out.println("Expiry Date Field is clicked");
        waiting.sendText(expiryDateField, expiryDate);
        System.out.println("Expiry Date is entered");

        waiting.waitForElementVisibility(cvvField).click();
        System.out.println("CVV Field is clicked");
        waiting.sendText(cvvField, cvv);
        System.out.println("CVV is entered");

        driver.switchTo().defaultContent();
        System.out.println("Switched to default content");
    }

    public void clickGenerateTokenButton() {
        System.out.println("Waiting for Generate Token Button");
        waiting.waitForElementVisibility(generateTokenButton).click();
        System.out.println("Generate Token Button is clicked");
    }

    public void waitFor3dsPage() {
        // wait for challenge cardDetailsContainer to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(cardDetailsContainer));

        System.out.println("Switching to Card Details IFrame");
        driver.switchTo().frame(cardDetailsContainer);
        System.out.println("Switched to Card Details IFrame");
    }

    public void clickSubmitButton() {
        // wait for challenge authenticationIFrame to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(authenticationIFrame));

        System.out.println("Switching to Authentication IFrame");
        driver.switchTo().frame(authenticationIFrame);
        System.out.println("Switched to Authentication IFrame");

        // wait for challenge frame to be visible
        wait.until(ExpectedConditions.visibilityOf(challengeFrame));

        System.out.println("Switching to Challenge Frame");
        driver.switchTo().frame(challengeFrame);
        System.out.println("Switched to Challenge Frame");

        waiting.waitForElementVisibility(submitButton).click();
    }

    public void waitForResponseData() {
        driver.switchTo().defaultContent();
        System.out.println("Switched to default content");

        waiting.waitForElementPresence(By.cssSelector("#Response\\ ✅"));
        System.out.println("Response Tab is present");

        responseTab.click();
        System.out.println("Response Tab is clicked");
    }

    public void printTransactionDetails() {
        System.out.println("Transaction Details: " + waiting.getText(responseTabData));
    }
}