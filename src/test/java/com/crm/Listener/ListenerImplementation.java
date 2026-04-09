package com.crm.Listener;

import GenericUtilities.FileUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.crm.basetest.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import java.io.File;
import java.io.IOException;


public class ListenerImplementation implements ITestListener, ISuiteListener {

    public static ExtentReports report;
    ExtentTest test;


    @Override
    public void onStart(ISuite suite) {
        //Report configuration....

        ExtentSparkReporter spark= new ExtentSparkReporter("./AdvancedReport/reort.html");
        spark.config().setDocumentTitle("Test report");
        spark.config().setReportName("Crm report");
        spark.config().setTheme(Theme.DARK);

        //Environment setup
        report= new ExtentReports();
        report.attachReporter(spark);
        report.setSystemInfo("os","windows10");
        report.setSystemInfo("browser","chrome12");


    }
    @Override
    public void onFinish(ISuite suite) {
        report.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("===="+result.getMethod().getMethodName()+"====");
        test= report.createTest("Test created");
        test.log(Status.INFO, "test created");

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        try{
        String tsName= result.getMethod().getMethodName();
        TakesScreenshot ts= (TakesScreenshot) BaseClass.sdriver;
        String src= ts.getScreenshotAs(OutputType.BASE64);
        test.addScreenCaptureFromBase64String(src,tsName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Report configuraton");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Report backup..");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName());
    }
}
