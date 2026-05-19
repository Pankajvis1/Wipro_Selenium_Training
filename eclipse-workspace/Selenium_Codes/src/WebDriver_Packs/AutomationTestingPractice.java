package WebDriver_Packs;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutomationTestingPractice {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");

		driver.manage().window().maximize();
		
		Thread.sleep(2000);

		driver.findElement(By.id("name")).sendKeys("Pankaj Vishwakarma");

		Thread.sleep(2000);

		driver.findElement(By.id("phone")).sendKeys("7275656529");

		Thread.sleep(2000);

		driver.findElement(By.id("email")).sendKeys("Pankaj@gmail.com");

		Thread.sleep(2000);

		driver.findElement(By.id("textarea")).sendKeys("SuperTech Capetown");

		Thread.sleep(2000);

		driver.findElement(By.id("male")).click();

		Thread.sleep(2000);

		driver.findElement(By.id("sunday")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("monday")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("tuesday")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("wednesday")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("friday")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("country")).sendKeys("India");

		Thread.sleep(2000);

		driver.findElement(By.id("colors")).sendKeys("Blue");

		Thread.sleep(1000);

		driver.findElement(By.id("animals")).sendKeys("Lion");

		Thread.sleep(1000);

		WebElement datePicker1 = driver.findElement(By.id("datepicker"));
		datePicker1.sendKeys("05/15/2021");

		Thread.sleep(1000);

		driver.findElement(By.id("txtDate")).click();

		Thread.sleep(1000);

		WebElement month = driver.findElement(By.className("ui-datepicker-month"));
		Select selectMonth = new Select(month);
		selectMonth.selectByValue("3");

		Thread.sleep(1000);

		WebElement year = driver.findElement(By.className("ui-datepicker-year"));
		Select selectYear = new Select(year);
		selectYear.selectByVisibleText("2017");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//a[text()='15']")).click();

		Thread.sleep(1000);

		driver.findElement(By.id("start-date")).sendKeys("04/05/2023");

		driver.findElement(By.id("end-date")).sendKeys("08/06/2023");

		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		Thread.sleep(1000);

		WebElement upload = driver.findElement(By.id("singleFileInput"));

		upload.sendKeys("/Users/pankajvishwakarma/Desktop/Wipro Day-8 Assignment.pdf");

		driver.findElement(By.xpath("//*[@id='singleFileForm']/button")).click();

		Thread.sleep(1000);

		WebElement upload2 = driver.findElement(By.id("multipleFilesInput"));

		upload2.sendKeys(
		        "/Users/pankajvishwakarma/Desktop/Wipro Day-12 Assignment.pdf"
		        + "\n" +
		        "/Users/pankajvishwakarma/Desktop/Wipro Day-5 Assignment.pdf");

		driver.findElement(By.xpath("//*[@id='multipleFilesForm']/button")).click();

		Thread.sleep(1000);

		TakesScreenshot tc = (TakesScreenshot) driver;

		File sc = tc.getScreenshotAs(OutputType.FILE);

		File dest = new File("AutomationPractice.png");

		FileHandler.copy(sc, dest);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,-1000)");

		Thread.sleep(2000);

		js.executeScript("window.scrollBy(0,1300)");

		Thread.sleep(2000);		
		WebElement  wiki = driver.findElement(By.id("Wikipedia1_wikipedia-search-input"));
		
		wiki.click();
		wiki.sendKeys("Selenium");
		Thread.sleep(1500);
		
		driver.findElement(By.xpath("//*[@id=\"Wikipedia1_wikipedia-search-form\"]/div/span[2]/span[2]/input")).click();
		Thread.sleep(2000);

		
		driver.findElement(By.xpath("//*[@id=\"HTML5\"]/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"HTML5\"]/div[1]/button")).click();
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
        driver.findElement(By.id("alertBtn")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000); 
        driver.switchTo().alert().accept();
             

        driver.findElement(By.id("confirmBtn")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000); 
        driver.switchTo().alert().dismiss();
       

        driver.findElement(By.id("promptBtn")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Pankaj");
        Thread.sleep(2000); 
        alert.accept();
       
        
        WebElement tab = driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/button"));
        tab.click();
        Thread.sleep(1000);

        // switch to new tab
        String mainTab = driver.getWindowHandle();

        for(String win : driver.getWindowHandles())
        {
            if(!win.equals(mainTab))
            {
                driver.switchTo().window(win);
            }
        }

        Thread.sleep(2000);

        // close new tab
        driver.close();

        // switch back to main tab
        driver.switchTo().window(mainTab);

        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"PopUp\"]")).click();
        Thread.sleep(2000);
		
		WebElement ts = driver.findElement(By.xpath("//*[@id=\"HTML3\"]/div[1]/div/button"));
		
		Actions ac = new Actions(driver);
		
		ac.moveToElement(ts).perform();
		
		Thread.sleep(2000);
		
		WebElement dc = driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));

		ac.doubleClick(dc).perform();
		
		Thread.sleep(2000);
		
		WebElement sr = driver.findElement(By.id("draggable"));

	    WebElement tg = driver.findElement(By.id("droppable"));

	    Thread.sleep(2000);

	    ac.dragAndDrop(sr, tg).perform();
	    
	    Thread.sleep(2000);
		 
	    WebElement sr1 = driver.findElement( By.id("slider-range"));

        ac.dragAndDropBy(sr1, 70, 0).perform();
        Thread.sleep(2000);

        ac.dragAndDropBy(sr1, -20, 0).perform();
        Thread.sleep(2000);
        
        WebElement items = driver.findElement(By.id("comboBox"));
        items.click();
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"dropdown\"]/div[3]")).click();
        Thread.sleep(2000);
        
		Thread.sleep(5000);
		
		driver.quit();
	}
}