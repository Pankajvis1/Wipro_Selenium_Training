package Hooks;

import java.io.File;
import java.nio.file.Files;

import POM.PHPTravelsFramework.DriverFactory;
import POM.PHPTravelsFramework.ScreenshotUtils;
import POM.PHPTravelsFramework.WaitUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setup(Scenario scenario) {
        DriverFactory.initDriver();

        DriverFactory.getDriver().get("https://phptravels.net/");

        WaitUtils wait = new WaitUtils(DriverFactory.getDriver());
        wait.handleDemoPopup();

        System.out.println("Browser Started: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (DriverFactory.getDriver() != null) {
                String screenshotPath = ScreenshotUtils.captureScreenshot(
                        DriverFactory.getDriver(),
                        scenario.getName().replaceAll(" ", "_")
                );

                if (screenshotPath != null) {
                    byte[] screenshot = Files.readAllBytes(new File(screenshotPath).toPath());

                    scenario.attach(
                            screenshot,
                            "image/png",
                            scenario.isFailed() ? "Failed Screenshot" : "Passed Screenshot"
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Screenshot Error: " + e.getMessage());
        } finally {
            DriverFactory.quitDriver();
            System.out.println("Browser Closed");
        }
    }
}