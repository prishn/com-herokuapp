package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Heroku_App_MultiBrowser {
    //Multi browser
    static String browser = "Chrome";
    //static String browser = "Firefox";
    //static String browser = "Edge";

    static String baseUrl = "http://the-internet.herokuapp.com/login";

    //launch the browser
    static WebDriver driver;

    public void multiBrowserTest() {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
    }

    public static void main(String[] args) {
        //object creation for multiBrowserTest
        Heroku_App_MultiBrowser obj = new Heroku_App_MultiBrowser();
        obj.multiBrowserTest();

        //open the URL into the browser
        driver.get(baseUrl);

        //maximise the browser
        driver.manage().window().maximize();

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //print the title of the page
        System.out.println("Print the title of the page: " + driver.getTitle());

        //Print the current URL
        System.out.println("Print the current URL: " + driver.getCurrentUrl());

        //print the page source
        System.out.println("Print the page source: " + driver.getPageSource());

        //Enter the email to email field.
        WebElement emailField = driver.findElement(By.id("username"));
        emailField.sendKeys("tomsmith ");

        //Enter the password to password field.
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("SuperSecretPassword!");

        //Click on Login Button.
        WebElement login = driver.findElement(By.className("radius"));
        login.click();

        //Print the current URL
        System.out.println(driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();
        System.out.println("Refresh the page: " + driver.getCurrentUrl());

        //closing the browser automatically
        driver.quit();
    }
}
