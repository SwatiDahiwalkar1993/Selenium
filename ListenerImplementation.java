package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Test Script Execuition is Start");
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"Test Script Execuition is Started",true);
		test= report.createTest(MethodName);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String MethodName = result.getMethod().getMethodName();
		//Reporter.log(MethodName+"Test Script Execuition is Passed",true);
		test.log(Status.PASS,"Test Script Execuition is Passed" );
		test.log(Status.PASS, "null");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("Test Script Execuition is Failed");
	String message = result.getThrowable().toString();
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"Test Script Execuition is Faild",true);		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	String Message = result.getThrowable().toString();
		String MethodName = result.getMethod().getMethodName();
		Reporter.log(MethodName+"Test Script Execuition is Skipped",true);
		test.log(Status.SKIP,"Test Script Execuition is Skipped" );
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	//	Reporter.log("To Start the TestScript",true);
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	//	Reporter.log("To Fail the TestScript",true);
		test.log(Status.FAIL,"Test Script Execuition is Failed" );
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		//Reporter.log("To Start the TestScript ",true);
		//Use ExtentSparkReporter class just to configure extent report
		javaUtils jUtil = new javaUtils();
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extentreport/report"+jUtil.getRandumNumber()+".html");
	reporter.config().setDocumentTitle("vtigercrm");
	reporter.config().setTheme(Theme.DARK);
	reporter.config().setReportName("Pune");
	
	//Use ExtendsReports to genrate extentreport
	report  = new ExtentReports();
	report.attachReporter(reporter);
	report.setSystemInfo("OS","Window");
	report.setSystemInfo("Browser", "Chrome");
	report.setSystemInfo("Chromeversion","121");
	report.setSystemInfo("Author", "pune");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Reporter.log("To Fail the TestScript",true);
		report.flush();
	}

}
