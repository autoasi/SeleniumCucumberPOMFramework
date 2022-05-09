package cucumberbdd.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.nio.charset.StandardCharsets;

public class StorePage extends BasePage{
    @FindBy(css = "a[title='View cart']") private WebElement viewCartLink;
    @FindBy(xpath = "//h1[normalize-space()='Store']") private WebElement titleText;

    public StorePage(WebDriver driver) {
        super(driver); // passing the driver to the constructor of the BasePage
    }

    public void addToCart(String productName){
        // Convert string into UTF-8 to handle "" in element name
        String raw = "a[aria-label='Add “" + productName + "” to your cart']";
        byte[] bytes = raw.getBytes(StandardCharsets.UTF_8);
        String utf8Encoded = new String(bytes, StandardCharsets.UTF_8);
        By addToCartBtn = By.cssSelector(utf8Encoded);
        wait.until(ExpectedConditions.visibilityOf(titleText)); // sync - wait for title to be visible
        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
    }
}
