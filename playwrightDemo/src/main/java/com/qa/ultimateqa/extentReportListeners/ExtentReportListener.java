package com.qa.ultimateqa.extentReportListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static com.qa.ultimateqa.PlaywrightFactory.takeScreenshot;

public class ExtentReportListener implements ITestListener {
    private static final String OUTPUT_FOLDER = "./build/";
    private static final String FILE_NAME = "TestExecutionReport.html";

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    private static ExtentReports init() {
        Path path = Paths.get(OUTPUT_FOLDER);
        //if directory does not exist, create it
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter reporter = new ExtentSparkReporter(OUTPUT_FOLDER + FILE_NAME);
        reporter.config().setReportName("Automation Test Results");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("System", "Windows");
        extentReports.setSystemInfo("Author", "sasavic2003@yahoo.com");
        return extentReports;
    }

    @Override
    public void onStart(ITestContext context) {
        extent = init();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = takeScreenshot();
        test.get().fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        test.get().log(Status.FAIL, "Test Failed");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped");
        test.get().getModel().setEndTime(getTime(result.getEndMillis()));
    }

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
    }

    // The following methods are not used but must be present to complete the interface
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {}

    private Date getTime(long millis) {
        return new Date(millis);
    }
}
