package web.tyss.com.listeners;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.Field;
import net.rcarz.jiraclient.Issue;
import net.rcarz.jiraclient.JiraClient;
import net.rcarz.jiraclient.JiraException;
import web.tyss.com.baseutil.BaseTest;
import web.tyss.com.reports.ExtentManager;
import web.tyss.com.reports.ExtentWebTest;
import web.tyss.com.util.WebActionUtil;
/**
 * Description: This class implements ITestListener
 * 
 * @author Manikandan A
 * 
 */
public class TestListener implements ITestListener {

	String className;
	public static int iPassCount = 0;
	public static int iFailCount = 0;
	public static int iSkippedCount = 0;
	public static String profile = null;
	public static long totPassedTime = 0;
	public static long totFailedTime = 0;
	public static long totSkippedTime = 0;
	public static long totalTimeTaken = 0;
	public static String pass_Time = "0";
	public static String fail_Time = "0";
	public static String skip_Time = "0";
	public static String tot_Time = "0";
	public static Properties prop;
	public static String sDirPath = System.getProperty("user.dir");
	public static final String PDFREPORTPATH=sDirPath +"./docs"+".pdf";
	public static final String CONFIGPATH = sDirPath + "./conf/config.properties";
	static {
		BaseTest.logger.info("");
		profile = System.getProperty("profile");
		profile = "JavaMail";
		System.setProperty("profile", profile);
		BaseTest.logger.info("Running locally " + profile);
	}
	
	static Map<String, String> reportMailBody = new HashMap<String, String>();
	File pdfReports = new File(PDFREPORTPATH);
	
	/**
	 * Description :Flushes the Extent report and sends an email of the report.
	 * 
	 * @author Manikandan A
	 * @paran context
	 * 
	 */
	
	public void onFinish(ITestContext context) {
		
		iPassCount = context.getPassedTests().size();
		iFailCount = context.getFailedTests().size();
		iSkippedCount = context.getSkippedTests().size();
		totalTimeTaken = totPassedTime + totFailedTime + totSkippedTime;
		tot_Time = WebActionUtil.formatDuration(totalTimeTaken);
		ExtentWebTest.getExtent().flush();

	}

	public void onStart(ITestContext context) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	/**
	 * Description :Increases the fail count and add fail result in Extent
	 * report,adds screenshots to the  Extent report on Test case failure.
	 * 
	 * @author Manikandan A
	 * @param result
	 * 
	 */
public void onTestFailure(ITestResult result) {
		
		iFailCount =iFailCount+1;
		ExtentManager.getTestReport().log(Status.FAIL, result.getMethod().getMethodName() + "-Test case failed");
		
		BasicCredentials creds=new BasicCredentials("manikandantyss", "Mani@9120");
		JiraClient client = new JiraClient("http://localhost:8081/", creds);
		try {
			
			if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println("Hello");
				
				
				Issue issue;
				try {
					issue = client.createIssue("TREL", "Bug").field(Field.SUMMARY, result.getMethod().getMethodName() + "is failed due to : " + result.getThrowable().toString()).field(Field.DESCRIPTION, "get the description").execute();
					System.out.println("Issue is created with key:" +issue.getKey());
				} catch (JiraException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Hello");
			}
			ExtentManager.getTestReport().addScreenCaptureFromPath(
					WebActionUtil.getScreenShot(System.getProperty("user.dir") + "/reports" + "/ScreenShots-"
							+ WebActionUtil.getCurrentDateTime() + "/screenshots/"));
		} catch (IOException e) {
			BaseTest.logger.error("Unable to attach the screenshot");
		}

	}
	/**
	 * Description :Increases the skip count and adds the skip result in Extent report.
	 * 
	 * @author Manikandan A
	 * @param result
	 * 
	 */
	public void onTestSkipped(ITestResult result) {
		iSkippedCount = iSkippedCount + 1;
		ExtentManager.getTestReport().log(Status.SKIP, result.getMethod().getMethodName() + "-Test case Skipped");

	}

	public void onTestStart(ITestResult result) {

	}
	/**
	 * Description:Increases the pass count and adds the pass result in Extent report
	 * 
	 * @author Manikandan A
	 * @param result
	 * 
	 */
	public void onTestSuccess(ITestResult result) {
		iPassCount = iPassCount + 1;
		ExtentManager.getTestReport().log(Status.PASS, result.getMethod().getMethodName() + "-Test case passed");
	}

}
