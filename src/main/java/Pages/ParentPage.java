package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import Setup.Driversetup;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class ParentPage extends Driversetup {

    protected WebDriver driver;

    public ParentPage(WebDriver driver) {
        this.driver=driver;
    }

    By nextpage = By.xpath("//a[@title=\"Next page\"]");



    public void scrollAndGoToNextPage(int pageNum) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(3000);
        checkPage(pageNum);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(nextpage));
        driver.findElement(nextpage).click();
    }

    public void checkPage(int pageNum) throws InterruptedException {
        Thread.sleep(5000);
        try {
            driver.findElement(nextpage).isDisplayed();
        }
        catch (Exception e) {
            if (pageNum==3) {
                pageNum=13;
            }
            browserSetup(browser);
            driver=super.driver;
            driver.get(testData.get("url2")+pageNum);
        }
    }

}


