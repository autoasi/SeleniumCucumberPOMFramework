package cucumberbdd.context;

import cucumberbdd.domainobjects.BillingDetails;
import cucumberbdd.domainobjects.Cookies;
import cucumberbdd.domainobjects.Product;
import cucumberbdd.domainobjects.ProductList;
import cucumberbdd.utils.JacksonUtils;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestContext {
    public String scenarioName;
    public WebDriver driver; // driver to be injected by Pico container
    public BillingDetails billingDetails; // object to be injected by Pico container
    public Cookies cookies; // Cookies object to be injected by Pico container
    public ProductList productList = new ProductList();
    public Product product;

    public TestContext() throws IOException {
        cookies = new Cookies();
        cookies.setCookies(new io.restassured.http.Cookies());
        productList.addAllProducts(JacksonUtils.deserializeJson("products.json", Product[].class));
    }
}
