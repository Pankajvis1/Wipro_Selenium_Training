package FileHandling;

import java.io.*;

public class FilePrograms {
    public static void main(String[] args) throws IOException {

        File file = new File("Text.txt");
        file.createNewFile();

        // Writing sample text
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("Hello welcome to Java learning\n");
        bw.write("Java is easy to learn\n");
        bw.write("Python and Java are programming languages");
        bw.close();

        // 1. Count number of lines
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        int lineCount = 0;

        while ((line = br.readLine()) != null) {
            lineCount++;
        }
        br.close();
        System.out.println("Number of lines: " + lineCount);

        // 2. Replace word (Python -> Java)
        br = new BufferedReader(new FileReader(file));
        String data = "";

        while ((line = br.readLine()) != null) {
            data = data + line + "\n";
        }
        br.close();

        data = data.replace("Python", "Java");

        BufferedWriter bw2 = new BufferedWriter(new FileWriter(file));
        bw2.write(data);
        bw2.close();

        System.out.println("Word replaced successfully.");

        // 3. Count number of words
        String[] words = data.split("\\s+");
        System.out.println("Number of words: " + words.length);

        // 4. Count number of characters
        int charCount = data.length();
        System.out.println("Number of characters: " + charCount);
    }
}