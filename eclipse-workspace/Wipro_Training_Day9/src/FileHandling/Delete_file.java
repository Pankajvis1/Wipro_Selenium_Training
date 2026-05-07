package FileHandling;
 
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
 
public class Delete_file {
 
	public static void main(String[] args) throws IOException {
		File file=new File("Test.txt");
		if(file.createNewFile())
		{
			System.out.println("File created successfully");
		}
		else
		{
			System.out.println("Unable to create file");
		}
		 FileWriter wr=new FileWriter("Test.txt");
	        wr.write("Let's learn Java Prgraming\n, Selenium Automation\n");// override  line
	       // wr.write("");
	        wr.close();
		FileReader reader = new FileReader("Test.txt");
        int data;
        while ((data = reader.read()) != -1) {
            System.out.print((char) data);
        }
        reader.close();
		
		if(file.delete())
		{
			System.out.println("File deleted");
		}
		else
		{
			System.out.println("Failed to delete");
		}
		if(file.getName()!=null)
		{
			System.out.println("File not found");
		}
		else
			System.out.println(file);
 
	}
 
}
