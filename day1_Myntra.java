package mouseAction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class day1_Myntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		
		WebElement ref = driver.findElement(By.className("desktop-searchBar"));
		Thread.sleep(2000);
		ref.sendKeys("shoes",Keys.ENTER);
		WebElement ref1 = driver.findElement(By.xpath("(//span[@class='product-wishlistFlex product-actionsButton product-wishlist ']) [1]"));
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",ref1);
		Thread.sleep(4000);
		
		String link=driver.getCurrentUrl();
		System.out.println(link);
		if(link.equals("https://www.myntra.com/login?referer=https://www.myntra.com/shoes?rawQuery=shoes")) {
			System.out.println("product added wishlist");
		}else {
			System.out.println("product isnot added");
		}
		driver.close();
	}

}
