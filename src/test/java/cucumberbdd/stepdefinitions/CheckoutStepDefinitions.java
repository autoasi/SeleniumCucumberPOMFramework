package cucumberbdd.stepdefinitions;

import cucumberbdd.constants.EndPoint;
import cucumberbdd.context.TestContext;
import cucumberbdd.domainobjects.BillingDetails;
import cucumberbdd.pages.CartPage;
import cucumberbdd.pages.CheckoutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutStepDefinitions {
    private final WebDriver driver;
    private  final TestContext context;

    public CheckoutStepDefinitions(TestContext context){
        this.context = context;
        driver = context.driver; // Injecting the driver into the CheckoutStepDefinitions class
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(context.billingDetails);
    }

    @And("i place an order")
    public void iPlaceAnOrder() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", new CheckoutPage(driver).getNotice());
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        //new CartPage(driver).checkout(); // can be removed as we are using PageFactoryManager
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.load(EndPoint.CHECKOUT.url);
    }
}
