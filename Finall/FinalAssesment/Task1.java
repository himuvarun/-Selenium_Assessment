package FinalAssesment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://demoapps.qspiders.com/ui/toggle/disabled?sublist=1");
		List<WebElement> togs =driver.findElements(By.xpath("//input[@type='checkbox']"));
		JavascriptExecutor ex = (JavascriptExecutor) driver;
		for (WebElement tog : togs) {
          ex.executeScript("arguments[0].removeAttribute('disabled');",tog);
          ex.executeScript("arguments[0].click();",tog);
      }
		driver.findElement(By.id("togglers")).click();
        WebElement msg = driver.findElement(By.xpath("//*[contains(text(),'successfully placed')]"));
        if (msg.isDisplayed() && msg.getText().contains("successfully placed")) {
            System.out.println("Order is placed successfully");
        } 
        else{
            System.out.println("Order placement failed");
        }	
		}
  }

