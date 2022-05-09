/*
package cucumberbdd.stepdefinitions;

import cucumberbdd.constants.EndPoint;
import cucumberbdd.context.TestContext;
import cucumberbdd.domainobjects.BillingDetails;
import cucumberbdd.domainobjects.Product;
import cucumberbdd.factory.DriverFactory;
import cucumberbdd.pages.CartPage;
import cucumberbdd.pages.CheckoutPage;
import cucumberbdd.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class MyStepDefinitionsAll {

    private final WebDriver driver;
    private BillingDetails billingDetails;

    // When MyStepDefinition class will be created Pico Container will injection the already ready TestContext class
    public MyStepDefinitionsAll(TestContext context){
        System.out.println("StepDefinitions DI: Scenario name: " + context.scenarioName);
        driver = context.driver;
    }

    @Given("I'm on the Store Page")
    public void i_m_on_the_store_page() {
       // driver = DriverFactory.getDriver(); // not required anymore as using Pico container to inject driver
        new StorePage(driver).load(EndPoint.STORE.url);
    }

    @When("I add a {product} to the cart")
    public void i_add_a_to_the_cart(Product product) {
        new StorePage(driver).addToCart(product.getName());
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int quantity, Product product) {
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        //driver = DriverFactory.getDriver(); // not required anymore as using Pico container to inject driver
        new StorePage(driver).load(EndPoint.STORE.url);
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
       this.billingDetails = billingDetails;
    }

    @And("I have a product in the cart")
    public void iHaveAProductInTheCart() {
        new StorePage(driver).addToCart("Blue Shoes");
    }

    @And("I'm on the Checkout page")
    public void iMOnTheCheckoutPage() {
        new CartPage(driver).checkout();
    }

    @When("I provide billing details")
    public void iProvideBillingDetails() {
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.setBillingDetails(billingDetails);
    }

    @And("i place an order")
    public void iPlaceAnOrder() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("The order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals("Thank you. Your order has been received.", new CheckoutPage(driver).getNotice());
    }
}
*/
