package cucumberbdd.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    // should be static so methods will also be static
    //private static WebDriver driver;
    //private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>(); // Use Thread Local for JUnit runner

    public static WebDriver initializeDriver(String browser){
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                //System.setProperty("webdriver.chrome.driver", "E:\\Testing\\Selenium\\Drivers\\chrome\\99.0.4844.51\\chromedriver.exe");
                WebDriverManager.chromedriver().setup(); // Driver manager to handle browser versions
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                //System.setProperty("webdriver.gecko.driver", "E:\\Testing\\Selenium\\Drivers\\firefox\\0.31.0\\geckodriver.exe");
                WebDriverManager.firefoxdriver().setup(); // Driver manager to handle browser versions
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("Invalid browser type: " + browser);
        }
        driver.manage().window().maximize();
        //DriverFactory.driver.set(driver);
        return driver;
    }

    /*public static WebDriver getDriver(){
        //return driver;
        return driver.get();
    }*/
}
