package Day_12;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

    WebDriver driver;

    public RecruitmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Recruitment']")
    public WebElement recruitment;

    @FindBy(xpath = "//a[text()='Vacancies']")
    public WebElement vacancy;

    @FindBy(xpath = "//button[contains(.,' Add ')]")
    public WebElement add;

    public void getRecruitment() {
        recruitment.click();
    }

    public void getVacancy() {
        vacancy.click();
    }

    public void getAdd() {
        add.click();
    }
}