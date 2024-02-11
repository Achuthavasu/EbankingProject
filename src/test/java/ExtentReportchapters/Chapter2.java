package ExtentReportchapters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.internal.runners.statements.Fail;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Chapter2 {

    public static void main(String[] args) throws IOException {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        extentReports
                .createTest("Test 1")
                .log(Status.INFO, "info1")
                .log(Status.PASS, "pass")
                .log(Status.INFO, "info2")
//                .log(Status.WARNING, "warning")
                .log(Status.INFO, "info3")
//                .log(Status.SKIP, "skip")
                .log(Status.INFO, "info4")
                .log(Status.INFO, "info5");
//                .log(Status.FAIL, "failed");
        //Fail, skip, warning, pass, info//



        extentReports.flush();
        Desktop.getDesktop().browse(new File("report.html").toURI());

    }
}
