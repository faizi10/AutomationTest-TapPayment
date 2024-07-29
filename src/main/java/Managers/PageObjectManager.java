package Managers;

import PageObjects.CardTransactionPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private CardTransactionPage cardTransactionPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public CardTransactionPage getCardTransactionPage() {
        return (cardTransactionPage == null) ? cardTransactionPage = new CardTransactionPage(driver) : cardTransactionPage;
    }
}
