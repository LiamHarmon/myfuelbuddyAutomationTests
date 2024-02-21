package TestUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
    	System.out.println("Starting test method: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	System.out.println("Test method succeeded: " + result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	System.out.println("Test method failed: " + result.getMethod().getMethodName());
        Throwable throwable = result.getThrowable();
        if (throwable != null) {
            System.out.println("Error message: " + throwable.getMessage());
            throwable.printStackTrace();
        }
    }
}