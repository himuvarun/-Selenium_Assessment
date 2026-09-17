package PomUtilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class OrangeHrmPage {
	WebDriver driver;
	public OrangeHrmPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//declare
	
	@FindBy(css = "[class='oxd-button oxd-button--medium oxd-button--secondary']")
	private WebElement addbut;
	
	@FindBy(css ="[class='oxd-select-text oxd-select-text--active']")
	private WebElement jobtitle;
	
	@FindBy(xpath = "//div[@class='oxd-select-option']/descendant::span[text()='Payroll Administrator']")
	private WebElement jobtitleclick;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text oxd-select-text--active'])[2]")
	private WebElement vacancy;
	
	@FindBy(xpath = "//div[@class='oxd-select-option']/descendant::span[text()='Payroll Administrator']")
	private WebElement vacancyclick;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[3]")
	private WebElement hiringmanager;

	@FindBy(xpath = "//div[@class='oxd-select-option']/descendant::span[text()='Rahul Patil']")
	private WebElement hiringmanagerclick;
	
	@FindBy(xpath = "(//div[@class='oxd-select-text-input'])[4]")
	private WebElement status;
	
	@FindBy(xpath = "//div[@class='oxd-select-option']/descendant::span[text()='Application Initiated']")
	private WebElement statusclick;
	
	@FindBy(css = "[placeholder='Type for hints...']")
	private WebElement candidatename;
	
	@FindBy(css = "[type='submit']")
	private WebElement search;
	
	@FindBy(xpath ="//div[@role='rowgroup']/descendant::div[text()='varun kumar K']")
	private WebElement RecordFound;
	
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	private WebElement profileclick;
	
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;
	
	//getters

	public void getAddbut() {
		addbut.click();
	}
	
	public void getJobtitle() {
		jobtitle.click();
	}

	public void getJobtitleclick() {
		jobtitleclick.click();
	}

	public void getVacancy() {
		vacancy.click();
	}

	public void getVacancyclick() {
		vacancyclick.click();
	}

	public void getHiringmanager() {
		hiringmanager.click();
	}

	public void getHiringmanagerclick() {
		hiringmanagerclick.click();
	}

	public void getStatus() {
		status.click();
	}

	public void getStatusclick() {
		statusclick.click();
	}

	public void getCandidatename(String value) throws InterruptedException {
		candidatename.sendKeys(value);
		Thread.sleep(4000);
		candidatename.sendKeys(Keys.DOWN,Keys.ENTER);
	}

	public void getSearch() {
		search.click();
	}
	
	public void getRecordFound() {
		if(RecordFound.isDisplayed())
		{
			System.out.println("1 candidate record is found");
		}
		else
		{
			System.out.println("candidate record is not found");
		}
	}

	
	public void getProfileclick() {
		profileclick.click();
	}

	public void getLogout() {
		logout.click();
	}
	

}