package cucumberbdd.domainobjects;

import cucumberbdd.utils.CookieUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class Cookies {
    private io.restassured.http.Cookies cookies; // REST Assured Cookies instance variable

    // Getter
    public io.restassured.http.Cookies getCookies() {
        return cookies;
    }

    // Setter
    public void setCookies(io.restassured.http.Cookies cookies) {
        this.cookies = cookies;
    }

    // Injects Selenium Cookies to the browser
    public void injectCookiesToBrowser(WebDriver driver){
        // Converts Rest Assured Cookies into Selenium Cookies
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        int i = 0;
        for(Cookie cookie: seleniumCookies){
            System.out.println("COUNTER " + i + ": " + cookie.toString());
            driver.manage().addCookie(cookie);
            i++;
        }
        driver.navigate().refresh();
    }
}
