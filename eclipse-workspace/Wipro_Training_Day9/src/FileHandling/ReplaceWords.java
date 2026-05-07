package FileHandling;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class ReplaceWords {
	public static void main(String[] args) throws IOException {

		File file = new File("/Users/pankajvishwakarma/Desktop/Text.txt");
		file.createNewFile();

		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write("Hello welcome to Java learning");
		bw.close();

		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		String data = "";

		while ((line = br.readLine()) != null) {
			data = data + line;
		}
		br.close();

		data = data.replace("Java", "Python");

		BufferedWriter bw2 = new BufferedWriter(new FileWriter(file));
		bw2.write(data);
		bw2.close();

		
		BufferedReader br2 = new BufferedReader(new FileReader(file));
		while ((line = br2.readLine()) != null) {
			System.out.println(line);
		}
		br2.close();
	}
}