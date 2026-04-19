package listeners;

import org.testng.*;
import utils.JiraUtil;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        String testName = result.getName();

        JiraUtil.createBug(
                "Test Failed: " + testName
        );
    }
}
