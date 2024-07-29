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

    @FindBy(xpath = "//form[@method='POST' and @action='../v2/challengeinfo']//input[@id='acssubmit' and @type='submit' and @value='Submit']")
    private WebElement submitButton;

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
        waiting.waitForElementVisibility(cardDetailsContainer);
        driver.switchTo().frame(cardDetailsContainer);
    }

    public void enterCardDetails(String cardNumber, String expiryDate, String cvv) {
        waiting.waitForElementVisibility(cardNumberFieldClicker);
        cardNumberFieldClicker.click();
        waiting.sendText(cardNumberField, cardNumber);
        waiting.waitForElementVisibility(expiryDateField).click();
        waiting.sendText(expiryDateField, expiryDate);
        waiting.waitForElementVisibility(cvvField).click();
        waiting.sendText(cvvField, cvv);
        driver.switchTo().defaultContent();
    }

    public void clickGenerateTokenButton() {
        waiting.waitForElementVisibility(generateTokenButton).click();
    }

    public void waitFor3dsPage() {
        // wait for challenge cardDetailsContainer to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(cardDetailsContainer));

        driver.switchTo().frame(cardDetailsContainer);
    }

    public void clickSubmitButton() {
        // wait for challenge authenticationIFrame to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(authenticationIFrame));
        driver.switchTo().frame(authenticationIFrame);

        // wait for challenge frame to be visible
        wait.until(ExpectedConditions.visibilityOf(challengeFrame));
        driver.switchTo().frame(challengeFrame);
        waiting.waitForElementVisibility(submitButton).click();
    }

    public void waitForResponseData() {
        driver.switchTo().defaultContent();

        // wait for response tab to be visible
        waiting.waitForElementPresence(By.cssSelector("#Response\\ ✅"));
        responseTab.click();
    }

    public void printTransactionDetails() {
        System.out.println("The Transaction Details are: " + waiting.getText(responseTabData));
    }
}