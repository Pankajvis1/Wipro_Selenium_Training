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

        try {
            WaitUtils wait = new WaitUtils(DriverFactory.getDriver());
            wait.handleDemoPopup();
        } catch (Exception e) {
            System.out.println("Popup handling skipped: " + e.getMessage());
        }

        System.out.println("Browser Started: " + scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (DriverFactory.getDriver() != null) {
                String screenshotPath = ScreenshotUtils.captureScreenshot(
                        DriverFactory.getDriver(),
                        scenario.getName().replaceAll("[^a-zA-Z0-9]", "_")
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