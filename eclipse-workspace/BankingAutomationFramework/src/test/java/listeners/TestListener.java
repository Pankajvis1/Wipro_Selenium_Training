package listeners;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static final ThreadLocal<ExtentTest> test =
            new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {

        System.out.println("Test Suite Started : " + context.getName());


    }

    @Override
    public void onFinish(ITestContext context) {

        ExtentManager.getExtent().flush();

   
        System.out.println("Test Suite Finished : " + context.getName());
  

    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest =
                ExtentManager.getExtent()
                        .createTest(result.getMethod().getMethodName());

        test.set(extentTest);

        test.get().info("Test Started");

      
        System.out.println("STARTED : " + result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed Successfully");

        System.out.println("PASSED : " +
                result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        String screenshotPath =
                ScreenshotUtil.takeScreenshot(
                        result.getMethod().getMethodName());

        test.get().fail("Test Failed");

        test.get().fail(result.getThrowable());

        try {
            test.get().addScreenCaptureFromPath(screenshotPath);
        } catch (Exception e) {
            test.get().info("Unable to attach screenshot");
        }

        System.out.println("FAILED : " +
                result.getMethod().getMethodName());

        System.out.println("REASON : " +
                result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        test.get().skip("Test Skipped");

        if (result.getThrowable() != null) {
            test.get().skip(result.getThrowable());
        }

        System.out.println("SKIPPED : " +
                result.getMethod().getMethodName());
    }
}