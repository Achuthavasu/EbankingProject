package com.inetbanking.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeTest;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Reporting {
    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);
        ExtentTest test1 = extentReports.createTest("Test 1");
        test1.pass("this is passed");
        ExtentTest test2 = extentReports.createTest("Test 2");
        test2.log(Status.FAIL, "this is failed");

        extentReports.createTest("Test 3").skip("This is skipped");
        extentReports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());

    }

}


