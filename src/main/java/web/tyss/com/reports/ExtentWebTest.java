package web.tyss.com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import web.tyss.com.baseutil.BaseTest;
/**
 * Description : Creates the HTML report based on the name specified.
 * @author Manikandan A
 * 
 */
public class ExtentWebTest {
	private static ExtentTest extentTtest;
	private static ExtentReports extentReports;

	/**
	 * Description : Creates the HTML report based on the name specified
	 * @author Manikandan A
	 * 
	 */
	public static ExtentTest createTest(String name) {

		extentTtest = extentReports.createTest(name);
		return extentTtest;
	}

	public static ExtentReports getExtent() {
		return extentReports;
	}
	/**
	 * Description : Initializes report specified in the file path
	 * @author Manikandan A
	 * 
	 */
	public void initReport(String filepath) {
		extentReports = new Extent().getExtent(filepath);
		BaseTest.logger.info("Report Initiated");
	}

}
