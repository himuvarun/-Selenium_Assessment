package Day10;
import Day10.CartPage;
import Day10.CheckoutPage;
import Day10.LoginPage;
import Day10.ProductsPage;
import Day10.ExcelUtility;
import Day10.PropertyUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class SauceDemoTest {
    WebDriver driver;
    LoginPage login;
    ProductsPage products;
    CartPage cart;
    CheckoutPage checkout;

    @BeforeClass
    public void setup() throws IOException {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(PropertyUtility.getData("url"));
        // Create POM objects
        login = new LoginPage(driver);
        products = new ProductsPage(driver);
        cart = new CartPage(driver);
        checkout = new CheckoutPage(driver);
        System.out.println("Browser launched");
    }


    @Test
    public void loginTest() throws IOException, InterruptedException {
        login.getUser(PropertyUtility.getData("username"));
        login.getPass(PropertyUtility.getData("password"));
        login.getLoginBtn();
        Thread.sleep(2000);

        if (products.isProdDisplayed()) {
            System.out.println("Login successful");
            System.out.println("Products page is displayed");
        } else {
            System.out.println("Products page is NOT displayed");
        }
        
    }

   
    @Test(dependsOnMethods = "loginTest")
    public void oderPalcementTest() throws IOException, InterruptedException {
        products.addBackPack();
        System.out.println("Sauce Labs Backpack added to cart");

        if (products.getCartCount().equals("1")) {
            System.out.println("Cart contains 1 item");
        } else {
            System.out.println("Cart does not contain 1 item");
        }

        // Open cart
        products.getCartBtn();
        Thread.sleep(2000);

        if (cart.isBackpackDisplayed()) {
            System.out.println("Sauce Labs Backpack is displayed in cart");
        } else {
            System.out.println("Sauce Labs Backpack is NOT displayed in cart");
        }

        cart.getCheckOut();
        Thread.sleep(2000);

        String firstName = ExcelUtility.getData(1, 0);
        String lastName = ExcelUtility.getData(1, 1);
        String postalCode = ExcelUtility.getData(1, 2);

        checkout.getFirstName(firstName);
        checkout.getlastName(lastName);

        checkout.getZip(postalCode);

        checkout.getContinue();
        Thread.sleep(2000);

        if (checkout.isCheckoutOverviewDisplayed()) {
            System.out.println("Checkout: Overview page is displayed");
        } else {
            System.out.println("Checkout: Overview page is NOT displayed");
        }

        checkout.getFinish();

        if (checkout.getSuccessMessage().equals("Thank you for your order!")) {
            System.out.println("Thank you for your order!");
        } else {
            System.out.println("Order confirmation message is NOT displayed");
        }
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
        System.out.println("Browser closed");
    }
}