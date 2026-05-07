package Assignment;
import java.io.*;
import java.util.Scanner;

public class AppendToFile {
    public static void main(String[] args) throws IOException {

        File file = new File("Text.txt");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text to append:");
        String input = sc.nextLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
        bw.newLine(); 
        bw.write(input);
        bw.close();

        System.out.println("Data appended successfully.");

        sc.close();
    }
}