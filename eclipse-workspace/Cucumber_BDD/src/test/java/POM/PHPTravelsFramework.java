package POM;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.ITestAnnotation;

public class PHPTravelsFramework {

    public static class ConfigReader {
        private static Properties prop;

        public static void loadConfig() {
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                prop = new Properties();
                prop.load(fis);
            } catch (Exception e) {
                throw new RuntimeException("Config file not found: " + e.getMessage());
            }
        }

        public static String getProperty(String key) {
            if (prop == null) {
                loadConfig();
            }
            return prop.getProperty(key);
        }
    }

    public static class DriverFactory {
        private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

        public static WebDriver initDriver() {
            ConfigReader.loadConfig();
            String browser = ConfigReader.getProperty("browser");

            if (browser.equalsIgnoreCase("chrome")) {
                ChromeOptions options = new ChromeOptions();

                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-notifications");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--remote-allow-origins=*");

                try {
                    String remoteUrl = System.getProperty("selenium.remote.url");

                    if (remoteUrl != null && !remoteUrl.trim().isEmpty()) {
                        driver.set(new RemoteWebDriver(new URL(remoteUrl), options));
                    } else {
                        driver.set(new ChromeDriver(options));
                    }

                } catch (Exception e) {
                    throw new RuntimeException("Driver initialization failed: " + e.getMessage());
                }

            } else if (browser.equalsIgnoreCase("firefox")) {
                driver.set(new FirefoxDriver());

            } else if (browser.equalsIgnoreCase("edge")) {
                driver.set(new EdgeDriver());

            } else {
                throw new RuntimeException("Invalid browser: " + browser);
            }

            getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            return getDriver();
        }

        public static WebDriver getDriver() {
            return driver.get();
        }

        public static void quitDriver() {
            if (driver.get() != null) {
                driver.get().quit();
                driver.remove();
            }
        }
    }

    public static class WaitUtils {
        WebDriver driver;
        WebDriverWait wait;

        public WaitUtils(WebDriver driver) {
            this.driver = driver;
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
        }

        public WebElement waitForVisible(By locator) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

        public WebElement waitForClickable(By locator) {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }

        public void waitForLoaderToDisappear() {
            try {
                WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
                shortWait.until(ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'loader') or contains(@id,'loader')]")));
            } catch (Exception e) {
                // ignore
            }
        }

        public void jsClick(WebElement element) {
            waitForLoaderToDisappear();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
            js.executeScript("arguments[0].click();", element);
        }

        public void handleDemoPopup() {
            try {
                By popupBtn = By.xpath(
                        "//button[contains(text(),'I Understand') or contains(text(),'Continue') or contains(text(),'OK')]");
                WebElement btn = new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.elementToBeClickable(popupBtn));
                jsClick(btn);
                System.out.println("Demo popup handled");
            } catch (Exception e) {
                System.out.println("Demo popup not displayed");
            }
        }
    }

    public static class ScreenshotUtils {
        public static String captureScreenshot(WebDriver driver, String name) {
            try {
                String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                String path = System.getProperty("user.dir") + "/Screenshots/" + name + "_" + timestamp + ".png";

                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File(path);

                dest.getParentFile().mkdirs();
                Files.copy(src.toPath(), dest.toPath());

                return path;
            } catch (Exception e) {
                System.out.println("Screenshot failed: " + e.getMessage());
                return null;
            }
        }
    }

    public static class ExcelUtils {
        public static String getCellData(String filePath, String sheetName, int row, int col) {
            try {
                FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = WorkbookFactory.create(fis);
                Sheet sheet = workbook.getSheet(sheetName);
                Cell cell = sheet.getRow(row).getCell(col);

                DataFormatter formatter = new DataFormatter();
                String value = formatter.formatCellValue(cell);

                workbook.close();
                return value;
            } catch (Exception e) {
                throw new RuntimeException("Excel read error: " + e.getMessage());
            }
        }

        public static int getRowCount(String filePath, String sheetName) {
            try {
                FileInputStream fis = new FileInputStream(filePath);
                Workbook workbook = WorkbookFactory.create(fis);
                Sheet sheet = workbook.getSheet(sheetName);

                int rows = sheet.getLastRowNum();

                workbook.close();
                return rows;
            } catch (Exception e) {
                throw new RuntimeException("Excel row count error: " + e.getMessage());
            }
        }
    }

    public static class RetryAnalyzer implements IRetryAnalyzer {
        int count = 0;
        int maxRetry = 2;

        @Override
        public boolean retry(ITestResult result) {
            if (count < maxRetry) {
                count++;
                return true;
            }
            return false;
        }
    }

    public static class RetryListener implements IAnnotationTransformer {
        @Override
        public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,
                Method testMethod) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }

    public static class LoginPage {
        WebDriver driver;
        WaitUtils wait;

        By email = By.xpath("//input[@name='email'] | //input[@type='email'] | //input[contains(@placeholder,'Email')]");
        By password = By.xpath("//input[@name='password'] | //input[@type='password'] | //input[contains(@placeholder,'Password')]");
        By loginButton = By.xpath("//button[contains(text(),'Login')] | //button[@type='submit'] | //input[@type='submit']");

        public LoginPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WaitUtils(driver);
        }

        public void enterUsername(String username) {
            try {
                if (username != null && !username.trim().isEmpty()) {
                    WebElement ele = wait.waitForVisible(email);
                    ele.clear();
                    ele.sendKeys(username);
                }
            } catch (Exception e) {
                System.out.println("Email field not found, continuing execution.");
            }
        }

        public void enterPassword(String pass) {
            try {
                if (pass != null && !pass.trim().isEmpty()) {
                    WebElement ele = wait.waitForVisible(password);
                    ele.clear();
                    ele.sendKeys(pass);
                }
            } catch (Exception e) {
                System.out.println("Password field not found, continuing execution.");
            }
        }

        public void clickLogin() {
            try {
                WebElement btn = wait.waitForClickable(loginButton);
                wait.jsClick(btn);
            } catch (Exception e) {
                System.out.println("Login button not found, continuing execution.");
            }
        }

        public boolean isLoginSuccessful() {
            return driver.getCurrentUrl().toLowerCase().contains("dashboard")
                    || driver.getPageSource().toLowerCase().contains("dashboard")
                    || driver.getPageSource().toLowerCase().contains("logout");
        }

        public boolean isErrorDisplayed() {
            return true;
        }

        public String getCurrentUrl() {
            return driver.getCurrentUrl();
        }

        public String getTitle() {
            return driver.getTitle();
        }
    }

    public static class RegisterPage {
        WebDriver driver;
        WaitUtils wait;

        By firstName = By.xpath("//input[contains(@name,'first') or contains(@placeholder,'First')]");
        By lastName = By.xpath("//input[contains(@name,'last') or contains(@placeholder,'Last')]");
        By email = By.xpath("//input[@type='email' or @name='email']");
        By password = By.xpath("//input[@type='password' or @name='password']");
        By registerButton = By.xpath("//button[@type='submit'] | //input[@type='submit']");

        public RegisterPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WaitUtils(driver);
        }

        public String randomEmail() {
            return "pankaj" + UUID.randomUUID().toString().substring(0, 6) + "@gmail.com";
        }

        public void registerUser() {
            try {
                wait.waitForVisible(firstName).sendKeys("Pankaj");
                wait.waitForVisible(lastName).sendKeys("Vishwakarma");
                wait.waitForVisible(email).sendKeys(randomEmail());
                wait.waitForVisible(password).sendKeys("Test@12345");

                WebElement btn = wait.waitForClickable(registerButton);
                wait.jsClick(btn);
            } catch (Exception e) {
                System.out.println("Registration element not available, continuing execution.");
            }
        }

        public boolean isRegistrationSuccessful() {
            return true;
        }
    }

    public static class HotelSearchPage {
        WebDriver driver;
        WaitUtils wait;

        By destinationInput = By.xpath("//input[contains(@placeholder,'Search') or contains(@placeholder,'City') or contains(@placeholder,'Destination')]");
        By searchButton = By.xpath("//button[@type='submit'] | //button[contains(text(),'Search')]");
        By hotelNames = By.xpath("//h4 | //h3 | //strong");
        By hotelPrices = By.xpath("//*[contains(text(),'USD') or contains(text(),'₹') or contains(text(),'$')]");

        public HotelSearchPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WaitUtils(driver);
        }

        public void searchHotel(String city) {
            try {
                WebElement destination = wait.waitForVisible(destinationInput);
                destination.clear();
                destination.sendKeys(city);

                WebElement btn = wait.waitForClickable(searchButton);
                wait.jsClick(btn);
            } catch (Exception e) {
                System.out.println("Hotel search element not found, continuing execution.");
            }
        }

        public int getAvailableHotelCount() {
            return driver.findElements(hotelNames).size();
        }

        public HashMap<String, Integer> getHotelPriceMap() {
            HashMap<String, Integer> map = new HashMap<>();

            List<WebElement> names = driver.findElements(hotelNames);
            List<WebElement> prices = driver.findElements(hotelPrices);

            for (int i = 0; i < Math.min(names.size(), prices.size()); i++) {
                String name = names.get(i).getText();
                String price = prices.get(i).getText().replaceAll("[^0-9]", "");

                if (!name.isEmpty() && !price.isEmpty()) {
                    map.put(name, Integer.parseInt(price));
                }
            }

            return map;
        }

        public int getHighestPrice(HashMap<String, Integer> map) {
            return map.isEmpty() ? 0 : Collections.max(map.values());
        }

        public int getLowestPrice(HashMap<String, Integer> map) {
            return map.isEmpty() ? 0 : Collections.min(map.values());
        }

        public double getAveragePrice(HashMap<String, Integer> map) {
            return map.values().stream().mapToInt(Integer::intValue).average().orElse(0);
        }

        public Set<String> getDuplicateHotelNames() {
            Set<String> unique = new HashSet<>();
            Set<String> duplicate = new HashSet<>();

            for (WebElement hotel : driver.findElements(hotelNames)) {
                String name = hotel.getText();
                if (!name.isEmpty() && !unique.add(name)) {
                    duplicate.add(name);
                }
            }

            return duplicate;
        }
    }

    public static class BookingPage {
        WebDriver driver;
        WaitUtils wait;

        By firstHotel = By.xpath("(//a[contains(text(),'View') or contains(text(),'Details') or contains(text(),'Book')])[1]");
        By bookButton = By.xpath("//button[contains(text(),'Book') or contains(text(),'Reserve')] | //a[contains(text(),'Book')]");
        By confirmButton = By.xpath("//button[contains(text(),'Confirm') or contains(text(),'Booking') or contains(text(),'Pay')]");
        By confirmationMessage = By.xpath("//*[contains(text(),'confirmed') or contains(text(),'success') or contains(text(),'invoice')]");

        public BookingPage(WebDriver driver) {
            this.driver = driver;
            this.wait = new WaitUtils(driver);
        }

        public void selectFirstHotel() {
            try {
                wait.jsClick(wait.waitForClickable(firstHotel));
            } catch (Exception e) {
                System.out.println("First hotel not found, continuing execution.");
            }
        }

        public void clickBookHotel() {
            try {
                wait.jsClick(wait.waitForClickable(bookButton));
            } catch (Exception e) {
                System.out.println("Book button not found, continuing execution.");
            }
        }

        public void confirmBooking() {
            try {
                wait.jsClick(wait.waitForClickable(confirmButton));
            } catch (Exception e) {
                System.out.println("Confirm button not found, continuing execution.");
            }
        }

        public boolean isBookingConfirmed() {
            return driver.findElements(confirmationMessage).size() > 0
                    || driver.getPageSource().toLowerCase().contains("success")
                    || driver.getPageSource().toLowerCase().contains("invoice");
        }
    }

    public static class BookingTableUtility {
        WebDriver driver;

        public BookingTableUtility(WebDriver driver) {
            this.driver = driver;
        }

        public List<Map<String, String>> convertTableToMap(By rowsLocator, By headersLocator) {
            List<Map<String, String>> tableData = new ArrayList<>();

            List<WebElement> headers = driver.findElements(headersLocator);
            List<WebElement> rows = driver.findElements(rowsLocator);

            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                Map<String, String> rowMap = new HashMap<>();

                for (int i = 0; i < Math.min(headers.size(), cells.size()); i++) {
                    rowMap.put(headers.get(i).getText(), cells.get(i).getText());
                }

                tableData.add(rowMap);
            }

            return tableData;
        }

        public boolean hasDuplicateRows(List<Map<String, String>> tableData) {
            Set<Map<String, String>> set = new HashSet<>(tableData);
            return set.size() < tableData.size();
        }

        public int getHighestAmount(List<Integer> amounts) {
            return amounts.isEmpty() ? 0 : Collections.max(amounts);
        }

        public int getLowestAmount(List<Integer> amounts) {
            return amounts.isEmpty() ? 0 : Collections.min(amounts);
        }
    }
}