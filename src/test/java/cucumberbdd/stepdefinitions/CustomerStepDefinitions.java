package cucumberbdd.stepdefinitions;

import cucumberbdd.constants.EndPoint;
import cucumberbdd.context.TestContext;
import cucumberbdd.domainobjects.BillingDetails;
import cucumberbdd.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

public class CustomerStepDefinitions {
    private final WebDriver driver;
    private final TestContext context;

    public CustomerStepDefinitions(TestContext context){
        this .context = context;
        driver = context.driver; // Injecting the driver into the CustomerStepDefinitions class
    }

    @And("my billing details are")
    public void myBillingDetailsAre(BillingDetails billingDetails) {
        context.billingDetails = billingDetails; // Initialise billingDetails from Gherkin into TestContext class
    }

    @Given("I'm a guest customer")
    public void iMAGuestCustomer() {
        new StorePage(driver).load(EndPoint.STORE.url);
    }
}
