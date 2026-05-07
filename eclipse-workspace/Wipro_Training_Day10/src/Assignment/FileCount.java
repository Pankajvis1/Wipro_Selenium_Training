package Assignment;

import java.io.*;

public class FileCount {
	public static void main(String[] args) throws IOException {

		File file = new File("Text.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String line;
		int lineCount = 0;
		int wordCount = 0;
		int charCount = 0;

		while ((line = br.readLine()) != null) {
			lineCount++;
			
			charCount += line.length();

			String[] words = line.trim().split("\\s+");
			if (!line.trim().isEmpty()) {
				wordCount += words.length;
			}
		}

		br.close();

		System.out.println("Number of lines: " + lineCount);
		System.out.println("Number of words: " + wordCount);
		System.out.println("Number of characters: " + charCount);
	}
}