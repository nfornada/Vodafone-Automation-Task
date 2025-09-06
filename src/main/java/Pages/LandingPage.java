package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;

    By searchbar = By.xpath("//textarea[@id=\"sb_form_q\"]");
    By logo = By.xpath("//h1[@class=\"logo_cont\"]");

    public LandingPage(WebDriver driver){this.driver=driver;}

    public By pageloaded()
    {
        return logo;
    }

    public void typeinsearch(String search) throws InterruptedException {

        for (char c : search.toCharArray()) {
            driver.findElement(searchbar).sendKeys(Character.toString(c));
            Thread.sleep(1000);
        }
        driver.findElement(searchbar).submit();
    }


}