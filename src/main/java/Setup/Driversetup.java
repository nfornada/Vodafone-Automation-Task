package Setup;
import Data.ReadFromData;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.Map;
public class Driversetup
{


    protected   WebDriver driver;
    public static String browser;
    public SoftAssert softassert;
    protected Map<String, String> testData = ReadFromData.readCSV("C:\\Users\\nadaf\\IdeaProjects\\vodafone_task\\src\\main\\resources\\data.csv");;


    @BeforeClass(alwaysRun = true)
    @Parameters("browser")
    public void start(String browser)
    {
        browserSetup(browser);
        this.browser=browser;
        System.out.println("Browser = "+browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        softassert=new SoftAssert();
    }

    @AfterClass(alwaysRun = true)
    public void quit() {
            driver.quit();
    }

    public void browserSetup(String browser){
        if(browser.equalsIgnoreCase("Chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("FireFox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("Edge"))
        {
            System.setProperty("webdriver.edge.driver", "C:\\Users\\nadaf\\Downloads\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
    }

}


