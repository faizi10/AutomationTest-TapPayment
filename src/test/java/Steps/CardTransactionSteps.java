package Steps;

import Cucumber.TestContext;
import Managers.SoftAssertManager;
import PageObjects.CardTransactionPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class CardTransactionSteps {
    TestContext context;
    CardTransactionPage cardTransactionPage;

    public CardTransactionSteps(TestContext context) {
        this.context = context;
        cardTransactionPage = context.getPageObjectManager().getCardTransactionPage();
    }

    @Given("I am in card transaction page")
    public void iAmInCardTransactionPage() {
        cardTransactionPage.visitCardTransactionPage();
        SoftAssertManager.getSoftAssert().assertEquals(cardTransactionPage.getCardTransactionPageTitle(), "Configurations 5123450000000008");
    }

    @When("I change the currency to {string}")
    public void iChangeTheCurrencyToCurrency(String currency) {
        cardTransactionPage.selectCurrency(currency);

    }

    @And("I change the scope to {string}")
    public void iChangeTheScopeToScope(String scope) {
        cardTransactionPage.selectScope(scope);
    }

    @And("I switch to IFrame of Card details")
    public void iSwitchToIFrameOfCardDetails() {
        cardTransactionPage.switchToCardDetailsIFrame();
    }

    @And("I fill in the card details {string} {string} {string}")
    public void iFillInTheCardDetails(String cardNumber, String expiryDate, String cvv) {
        cardTransactionPage.enterCardDetails(cardNumber, expiryDate, cvv);
    }

    @And("I generate the token")
    public void iGenerateTheToken() {
        cardTransactionPage.clickGenerateTokenButton();
    }

    @And("I wait until the '3ds' page is opened")
    public void iWaitUntilTheDsPageIsOpened() {
        cardTransactionPage.waitFor3dsPage();
    }

    @And("I click on submit button")
    public void iClickOnSubmitButton() {
        cardTransactionPage.clickSubmitButton();
    }

    @And("I wait until data exists in the response tab")
    public void iWaitUntilDataExistsInTheResponseTab() {
        cardTransactionPage.waitForResponseData();
    }

    @Then("I print the transaction details")
    public void iPrintTheTransactionDetails() {
        cardTransactionPage.printTransactionDetails();
    }


}
