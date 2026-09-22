package Finall;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import genericUtilities.PropertyUtility;

public class BaseClass {

    public WebDriver driver;
    public LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws IOException, InterruptedException {

        String browser = PropertyUtility.getData("browser");
        String url = PropertyUtility.getData("url");
        String username = PropertyUtility.getData("username");
        String password = PropertyUtility.getData("password");

        System.out.println("Browser : " + browser);
        System.out.println("URL : " + url);

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        // Login
        loginPage = new LoginPage(driver);
        loginPage.getUserName(username);
        loginPage.getPassword(password);
        loginPage.getLogin();
        System.out.println("Login Successful");
        Thread.sleep(2000);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        loginPage.getLogOut();
        Thread.sleep(1000);
        driver.quit();
        System.out.println("Logout Successfully");
    }
}