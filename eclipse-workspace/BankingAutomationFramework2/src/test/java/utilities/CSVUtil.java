package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CSVUtil {

    public static Map<String, String> getData(String filePath) {

        Map<String, String> data = new HashMap<>();

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader(filePath));

            String header = br.readLine();
            String values = br.readLine();

            String[] headers = header.split(",");
            String[] row = values.split(",");

            for (int i = 0; i < headers.length; i++) {
                data.put(headers[i], row[i]);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}