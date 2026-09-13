//Test case 
Login to orangeHrm application -> Click on PIM link -> click on +Add button ->enter firstname , middlename, lastname , employeeId -> 
click on Create Login Details toggle button -> enter username , password and confirm password -> click on save button-> 
click on Admin link -> enter username , select role ,enter employee name and select status -> click on search button
->verify whether the emplyoee is added from the records found section and logout.
Note: store the common data in property file and testscript data in excel file


package Assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class day6testcase01 {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// property file
		FileInputStream file=new FileInputStream("./src/test/resources/DDT/orangehrm1.properties");
		Properties p=new Properties();
		p.load(file);
		//excel file
		FileInputStream file1=new FileInputStream("./src/test/resources/DDT/orangehrm1.xlsx");
		Workbook wb = WorkbookFactory.create(file1);
		DataFormatter df=new DataFormatter();
		String BROWSER=p.getProperty("browser");
		String URL=p.getProperty("url");
		String username = p.getProperty("Username");
		String pass=p.getProperty("Password");
		WebDriver driver=null;
		if(BROWSER.contains("chrome"))
		{
			driver= new ChromeDriver();
		}
		if(BROWSER.contains("edge"))
		{
			driver= new EdgeDriver();
		}
		if(BROWSER.contains("firefox"))
		{
			driver= new FirefoxDriver();
		}
		//minimize
		driver.manage().window().maximize();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("[type='password']")).sendKeys(pass);
		driver.findElement(By.cssSelector("[type='submit']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='PIM']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class='oxd-icon bi-plus oxd-button-icon']")).click();
		String firstname =df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(0));
		String middlename =df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(1));
		String lastname =df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(2));
		String empId=df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(3));
		String user=df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(4));
		String password=df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(5));
		String confirmpass=df.formatCellValue(wb.getSheet("Sheet1").getRow(1).getCell(6));
		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).sendKeys(firstname);
		driver.findElement(By.name("middleName")).sendKeys(middlename);
		driver.findElement(By.name("lastName")).sendKeys(lastname);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(empId);
		driver.findElement(By.cssSelector("[class='oxd-switch-input oxd-switch-input--active --label-right']")).click();
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]")).sendKeys(user);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys(password);
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys(confirmpass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(user);
		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).click();
		driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/descendant::span[text()='ESS']")).click();
		WebElement EmpFullName = driver.findElement(By.cssSelector("[placeholder='Type for hints...']"));
		EmpFullName.sendKeys(firstname," ",lastname);
		Thread.sleep(2000);
		EmpFullName.sendKeys(Keys.DOWN,Keys.ENTER);
		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[2]")).click();
		driver.findElement(By.xpath("//div[@class='oxd-select-dropdown --positon-bottom']/descendant::span[text()='Enabled']")).click();
		driver.findElement(By.xpath("//button[text()=' Search ']")).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//span[text()='(1) Record Found']")).getText();
	    if (text.contains("(1) Record Found")) {
	           System.out.println("Employee is successfully added and displayed in Records Found");
	    } else {
	           System.out.println("Employee is NOT displayed in Records Found");
	    }  
	    Thread.sleep(2000);
	    //logout
	    driver.findElement(By.className("oxd-userdropdown-name")).click();
	
	    driver.findElement(By.xpath("//a[text()='Logout']")).click();
	
	    driver.quit();
        
	}

}
