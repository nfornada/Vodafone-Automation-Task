package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Pages2_3 extends ParentPage
{
    int pageNum;
    public Pages2_3(WebDriver driver,int pageNum) {
        super(driver);
        this.pageNum=pageNum;
    }


    public int findLinksCount() throws InterruptedException {
        List<WebElement> links = driver.findElements(By.xpath("//li[@class=\"b_algo\"]//h2"));

        return links.size();
    }

}