package FinalAssesment;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Finall.BaseClass;
import Finall.BuzzPage;
import Finall.HomePage;
import genericUtilities.ExcelUtility;

public class OrangeHRMBuzzTest extends BaseClass {

    @Test
    public void createBuzzPost() throws IOException, InterruptedException {

        HomePage homePage = new HomePage(driver);
        homePage.clickBuzz();
        Thread.sleep(2000);
        BuzzPage buzzPage = new BuzzPage(driver);
        String post = ExcelUtility.getData("Sheet1", 0, 0);
        buzzPage.enterPost(post);
        buzzPage.clickPost();
        Thread.sleep(2000);
        boolean result = buzzPage.verifyPost(post);
        Assert.assertTrue(result, "Post is not displayed after posting");
        System.out.println("Post is displayed successfully after posting");

    }

}