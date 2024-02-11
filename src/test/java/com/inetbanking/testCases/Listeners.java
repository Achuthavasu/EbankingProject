package com.inetbanking.testCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("**** test started: " +result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("**** test is successes: " +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("**** test failed: " +result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("**** test is skipped: " +result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("**** test Failed But Within Success Percentage: " +result.getName());
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("**** Test Failed With Timeout: " +result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("**** On Start " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
