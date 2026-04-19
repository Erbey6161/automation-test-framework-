package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReportObject() {

        if (extent == null) {

            String path = System.getProperty("user.dir") + "/test-output/report.html";

            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Automation Results");
            reporter.config().setDocumentTitle("Test Report");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }

        return extent;
    }
}