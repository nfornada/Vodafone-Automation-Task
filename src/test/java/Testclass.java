import Data.ReadFromData;
import Data.TestDataProvider;
import Pages.LandingPage;
import Pages.Page1;
import Pages.Pages2_3;
import Setup.Driversetup;
import io.qameta.allure.Attachment;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Map;


public class Testclass extends Driversetup {

    LandingPage home;
    Page1 page1;
    Pages2_3 page2;
    Pages2_3 page3;
    int numberOfLinksPage2,numberOfLinksPage3;

    @Test(priority = 1,description = "Open https://www.bing.com")
    @Attachment(value = "Screenshot", type = "image/png")
    public void Step1()
    {
        home= new LandingPage(driver);
        driver.get(testData.get("url"));
        Assert.assertTrue(driver.findElement(home.pageloaded()).isDisplayed());
    softassert.assertAll();
    }

    @Test(priority = 2,description = "Type and search for “Vodafone”")
    public void Step2() throws InterruptedException {
        home.typeinsearch(testData.get("searchKey"));
    }

    @Test(priority = 3,dataProvider = "csvData", dataProviderClass = TestDataProvider.class,description = "Validate that the first results page contains 2 \"Related searches for Vodafone\" sections")
    public void Step3(Map<String, String> data) throws InterruptedException {
        page1 =new Page1(driver);
        softassert.assertTrue(page1.numoftextsfound()>=2);
        softassert.assertTrue(page1.checkitemsunderneath(data.get("searchKey")));
        softassert.assertAll();
    }
    @Test(priority = 4,description = "Scroll down and go to the next page")
    public void Step4() throws InterruptedException {
        page1.scrollAndGoToNextPage(1);

    }

    @Test(priority = 5,description = "Count the number of results displayed on the second page")
    public void Step5() throws InterruptedException {
        page2=new Pages2_3(driver,2);
        numberOfLinksPage2=page2.findLinksCount();

    }

    @Test(priority = 6,description = "Scroll down and go to the next page")
    public void Step6() throws InterruptedException {
        page2.scrollAndGoToNextPage(2);
    }

    @Test(priority = 7,description = "Validate if the number of results on page 2 is equal to page 3 or not")
    public void Step7() throws InterruptedException {
        page3=new Pages2_3(driver,3);
        numberOfLinksPage3=page3.findLinksCount();
        Assert.assertEquals(numberOfLinksPage2, numberOfLinksPage3,"Number links in pages 2 and 3 don't match.");
        softassert.assertAll();
    }

}
