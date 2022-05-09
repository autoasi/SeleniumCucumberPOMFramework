package cucumberbdd.stepdefinitions;

import cucumberbdd.apis.CartApi;
import cucumberbdd.context.TestContext;
import cucumberbdd.domainobjects.Product;
import cucumberbdd.pages.CartPage;
import cucumberbdd.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStepDefinitions {
    // private final WebDriver driver; // can be removed as we are using PageFactoryManager
    private final CartPage cartPage;
    private final TestContext context;

    public CartStepDefinitions(TestContext context){
       // driver = context.driver; // Injecting the driver into the CartStepDefinitions class
        cartPage = PageFactoryManager.getCartPage(context.driver); // Uses PageFactoryManager
        this.context = context;
    }

    @Then("I should see {int} {product} in the cart")
    public void i_should_see_in_the_cart(int quantity, Product product) {
        //CartPage cartPage = new CartPage(driver); // can be removed as we are using PageFactoryManager
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

    @And("I have {int} {product} in the cart")
    public void iHaveInTheCart(int quantity, Product product) throws Exception {
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        product = context.productList.getProductByName(product.getName());
        cartApi.addToCart(product.getId(), quantity);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);
        context.product = product;
    }
}
