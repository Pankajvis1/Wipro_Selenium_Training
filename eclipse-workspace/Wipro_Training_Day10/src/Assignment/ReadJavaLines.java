package Assignment;
import java.io.*;

public class ReadJavaLines {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));

        String line;

        while ((line = br.readLine()) != null) {
            if (line.toLowerCase().contains("java")) {
                System.out.println(line);
            }
        }

        br.close();
    }
}