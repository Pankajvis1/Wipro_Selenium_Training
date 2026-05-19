package WebDriver_Packs;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckSearchButtonTiraBeauty {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.tirabeauty.com/");
		Thread.sleep(2000);

		driver.findElement(By.id("search")).click();

		driver.findElement(By.id("search")).sendKeys("shampoo");
		
		Thread.sleep(1000);

		driver.findElement(By.id("search")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		
	}
}


 