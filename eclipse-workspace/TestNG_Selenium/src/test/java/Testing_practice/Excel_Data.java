package Testing_practice;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel_Data {

    WebDriver driver;

    @DataProvider(name = "loginData")
    public Object[][] getData() throws Exception {

        FileInputStream file = new FileInputStream(
                "/Users/pankajvishwakarma/eclipse-workspace/TestNG_Selenium/TestData/Excel_Data.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] =
                        sheet.getRow(i).getCell(j).toString();
            }
        }

        workbook.close();
        file.close();

        return data;
    }

    @Test(dataProvider = "loginData", alwaysRun = true)
    public void loginTest(String username, String password)
            throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(5));

        driver.get("http://zero.webappsecurity.com/login.html");

        WebElement user =
                driver.findElement(By.id("user_login"));

        user.sendKeys(username);

        WebElement pass =
                driver.findElement(By.id("user_password"));

        pass.sendKeys(password);

        driver.findElement(By.name("submit"))
                .click();

        Thread.sleep(3000);

        System.out.println(
                "Username: " + username +
                " Password: " + password);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {

            driver.quit();
        }
    }
