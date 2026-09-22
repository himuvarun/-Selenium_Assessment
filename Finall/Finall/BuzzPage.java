package Finall;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BuzzPage {
    WebDriver driver;
    public BuzzPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@placeholder=\"What's on your mind?\"]")
    private WebElement whatsOnYourMind;
    @FindBy(xpath = "//button[contains(.,'Post')]")
    private WebElement postButton;
    public void enterPost(String text) {
        whatsOnYourMind.sendKeys(text);
    }
    public void clickPost() {
        postButton.click();
    }
    public boolean verifyPost(String text) {
        String pageText = driver.findElement(By.tagName("body")).getText();
        return pageText.contains(text);
    }
}