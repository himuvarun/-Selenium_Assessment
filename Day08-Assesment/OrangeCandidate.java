package PomUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrangeCandidate {
	WebDriver driver;

	public OrangeCandidate(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//declare
	
	@FindBy(name = "firstName")
	private WebElement firstname;
	
	@FindBy(name = "middleName")
	private WebElement middleName;
	
	@FindBy(name = "lastName")
	private WebElement lastName;
	
	@FindBy(css = "[class='oxd-select-text-input']")
	private WebElement vacanyselect;
	
	@FindBy(xpath = "//div[@class='oxd-select-dropdown --positon-bottom']/descendant::span[text()='Payroll Administrator']")
	private WebElement vacanyclick;
	
	@FindBy(xpath =  "(//input[@class='oxd-input oxd-input--active'])[2]")
	private WebElement email;
	
	@FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
	private WebElement phoneno;
	
	@FindBy(css = "[type='file']")
	private WebElement resume;
	
	@FindBy(xpath = "//a[text()='Candidates']")
	private WebElement candidatesclick;
	
	//getters
	
	public void setCandidatesclick(WebElement candidatesclick) {
		this.candidatesclick = candidatesclick;
	}

	public void setResume(WebElement resume) {
		this.resume = resume;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getMiddleName() {
		return middleName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPhoneno() {
		return phoneno;
	}

	@FindBy(css = "[type='submit']")
	private WebElement savebut;
	
	//getters 

	
	public void getFirstname(String value) {
		firstname.sendKeys(value);;
	}

	public void getMiddleName(String value) {
		middleName.sendKeys(value);;
	}

	public void getLastName(String value) {
		lastName.sendKeys(value);
	}

	public void getVacanyselect() {
		vacanyselect.click();
	}

	public void getVacanyclick() {
		vacanyclick.click();
	}

	public void getEmail(String value) {
		email.sendKeys(value);
	}

	public void getPhoneno(String value) {
		phoneno.sendKeys(value);
	}
	
	public void getResume(String value) {
		resume.sendKeys(value);
	}

	public void getSavebut() {
		savebut.click();
	}
	
	public void getCandidatesclick() {
		candidatesclick.click();
	}

	

}