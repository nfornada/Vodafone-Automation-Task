package Data;
import org.testng.annotations.DataProvider;
import java.util.Map;

public class TestDataProvider {

    @DataProvider(name = "csvData")
    public static Object[][] csvData() {
        Map<String, String> data = ReadFromData.readCSV("C:\\Users\\nadaf\\IdeaProjects\\vodafone_task\\src\\main\\resources\\data.csv");
        return new Object[][] {
                { data }
        };
    }
}




