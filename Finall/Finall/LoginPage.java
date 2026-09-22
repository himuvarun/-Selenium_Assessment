package Finall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement login;

    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    private WebElement profile;

    @FindBy(xpath = "//a[text()='Logout']")
    private WebElement logout;
    public void getUserName(String user) {
        username.sendKeys(user);
    }
    public void getPassword(String pass) {
        password.sendKeys(pass);
    }
    public void getLogin() {
        login.click();
    }
    public void getLogOut() {
        profile.click();
        logout.click();
    }
}