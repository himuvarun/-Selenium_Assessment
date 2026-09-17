package PomUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeLogin {
	WebDriver driver;
	public OrangeLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//declare 
	@FindBy(name ="username")
	private WebElement user;
	
	@FindBy(name ="password")
	private WebElement pass;
	
	@FindBy(css = "[type='submit']")
	private WebElement loginbut;
	
	//getters
	public void getUser(String value) {
		user.sendKeys(value);;
	}

	public void getPass(String value) {
		pass.sendKeys(value);;
	}

	public void getLoginbut() {
		loginbut.click();
	}

}