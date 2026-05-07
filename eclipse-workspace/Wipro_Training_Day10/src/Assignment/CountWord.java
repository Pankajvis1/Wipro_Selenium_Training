package Assignment;

import java.io.*;
import java.util.Scanner;

public class CountWord {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("Text.txt"));

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter word to search: ");
        String target = sc.nextLine().toLowerCase().trim();

        String line;
        int count = 0;

        while ((line = br.readLine()) != null) {

            String[] words = line.toLowerCase().split("\\W+");

            for (String word : words) {
                if (!word.isEmpty() && word.equals(target)) {
                    count++;
                }
            }
        }

        br.close();
        sc.close();

        System.out.println("Occurrences of '" + target + "': " + count);
    }
}