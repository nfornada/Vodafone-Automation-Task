package Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadFromData {

public static Map<String, String> readCSV(String filePath) {
    Map<String, String> data = new HashMap<>();

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",", 2); // only split into 2
            if (parts.length == 2) {
                data.put(parts[0].trim(), parts[1].trim());
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return data;
}
}
