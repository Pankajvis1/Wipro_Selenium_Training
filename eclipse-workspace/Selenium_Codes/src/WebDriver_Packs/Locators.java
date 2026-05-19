package WebDriver_Packs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
//		
//		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//
//		// Open Zero Bank Website
//		driver.get("http://zero.webappsecurity.com/login.html");
//
//		// Click using Link Text
//		driver.findElement(By.linkText("Forgot your password ?")).click();
//
//		// Click using Partial Link Text
//		driver.findElement(By.partialLinkText("Forgot your")).click();
//
//		// css selector
		// 1.id
		// 2.class
		// 3.attribute
		// 4.multiple attribute
		// 5.parent child

		// Open DemoQA Practice Form
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");

		Thread.sleep(2000);

		// css by id
		// syntax ==> (node[id="id value"])

		// Click First Name Field
		driver.findElement(By.cssSelector("input[id=\"firstName\"]")).click();

		// Enter First Name
		driver.findElement(By.cssSelector("input[id=\"firstName\"]")).sendKeys("Neeva");

		// css by class
		// syntax ==> (node[class="class value"])

		// Click Last Name Field
		driver.findElement(By.cssSelector("input[class=\" mr-sm-2 form-control\"]")).click();

		// Enter Last Name
		driver.findElement(By.cssSelector("input[class=\" mr-sm-2 form-control\"]")).sendKeys("Sharma");

		// css by attribute
		// syntax ==> (node[any unique attribute="attribute value"])

		// Click Email Field
		driver.findElement(By.cssSelector("input[placeholder=\"name@example.com\"]")).click();

		// Enter Email
		driver.findElement(By.cssSelector("input[placeholder=\"name@example.com\"]")).sendKeys("abc@gmail.com");

		// css by multiple attribute
		// syntax ==> (node#other attribute value[attribute="attribute value"])

		// Select Gender Radio Button
		driver.findElement(By.cssSelector("input#gender-radio-2[name=\"gender\"]")).click();


		// css by parent-child
		// syntax ==> (parentnode>childnode[childnode attribute="value"])

		// Open Date Picker
		driver.findElement(By.cssSelector("input[id=\"dateOfBirthInput\"]")).click();

		// Select Year
		driver.findElement(By.cssSelector("select>option[value=\"2017\"]")).click();

		// Select Month
		driver.findElement(By.cssSelector("select>option[value=\"1\"]")).click();

		// Select Date
		driver.findElement(By.cssSelector("div[class=\"react-datepicker__day react-datepicker__day--020\"]")).click();
		
		//Tag name
		List<WebElement> el=driver.findElements(By.tagName ("input" ));
				for (WebElement element : el) {
				System.out.println(element.getAttribute("type"));
				 }
		
		driver.quit();
	}

}
