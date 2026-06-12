package utilities;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVDataProvider {

    @DataProvider(name = "parabankData")
    public Object[][] getCSVData() {

        List<Object[]> list = new ArrayList<>();

        try {

            String path = System.getProperty("user.dir")
                    + "/src/test/resources/user_data.csv";

            System.out.println("CSV Path : " + path);

            BufferedReader br = new BufferedReader(
                    new FileReader(path));

            br.readLine();
            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                list.add(new Object[]{
                        data[0],
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6],
                        data[7],
                        data[8],
                        data[9]
                });
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list.toArray(new Object[0][]);
    }
}