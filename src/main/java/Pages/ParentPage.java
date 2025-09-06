package Pages;

import Data.ReadFromData;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import Setup.Driversetup;


import java.util.Map;

public  class ParentPage extends Driversetup {

    protected WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver=driver;
    }

    Map<String, String> DataInFile = ReadFromData.readCSV("C:\\Users\\nadaf\\IdeaProjects\\vodafone_task\\src\\main\\resources\\data.csv");;
    By nextpage = By.xpath("//a[@title=\"Next page\"]");



    public void scrollAndGoToNextPage(int pageNum) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(3000);
        checkPage(pageNum);
        driver.findElement(nextpage).click();
    }

    public void checkPage(int pageNum) throws InterruptedException {
        Thread.sleep(5000);

        try{
            driver.findElement(nextpage).isDisplayed();

        } catch (Exception e) {
            if (pageNum==3) {
                pageNum=13;
            }
            browserSetup(browser);
            driver=super.driver;
            driver.get(DataInFile.get("url2")+pageNum);
        }

    }

}


