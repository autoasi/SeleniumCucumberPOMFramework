package cucumberbdd.hooks;

import cucumberbdd.context.TestContext;
import cucumberbdd.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private WebDriver driver;
    private final TestContext context;

    // DI - Constructor to retrieve the TestContext class by Pico container
    public MyHooks(TestContext context){
        this.context = context;
    }

    @Before
    public void before(Scenario scenario){
        context.scenarioName = scenario.getName();
        System.out.println("DI: Scenario name: " + context.scenarioName);

        System.out.println("BEFORE: Tread ID - " + Thread.currentThread().getId() +
                " , Scenario Name - " + scenario.getName() );
        // Browser type is taken from the Maven command line (default is chrome)
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        context.driver = driver;
    }

    @After
    public void after(Scenario scenario){
        System.out.println("BEFORE: Tread ID - " + Thread.currentThread().getId() +
                " , Scenario Name - " + scenario.getName() );
        driver.quit();
    }
}
