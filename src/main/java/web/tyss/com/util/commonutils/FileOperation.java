package web.tyss.com.util.commonutils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import web.tyss.com.baseutil.BaseTest;
import web.tyss.com.reports.ExtentWebTest;
import web.tyss.com.util.WebActionUtil;


/**
 * Description : Implements creation of the folder structure for Extent reports,screenshots,deletion of the previously created folder.
 * @author: Manikandan A
 */
public class FileOperation {
	FileVariables fileVariables = new FileVariables();
	   
		/**
		 * Description:Implements setting of the path,creation of the folder structure for Extent reports,screenshot,deletion of the folder.
		 * @author: Manikandan A
		 */
	public void CreateFiles() {

		fileVariables.setDate(new Date());
		fileVariables.setSdf(new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss"));
		fileVariables.setsDate(fileVariables.getSdf().format(fileVariables.getDate()));
		fileVariables.setsStartTime(fileVariables.getsDate());
		fileVariables.setExtentReportFolderPath(System.getProperty("user.dir") + "/reports");

		fileVariables.setExtentDir(System.getProperty("user.dir") + "/reports" + "/Automation Report- "

				+ WebActionUtil.getCurrentDateTime() + "/Report/" + WebActionUtil.getCurrentDateTime());
		fileVariables.setScreenShotPath(System.getProperty("user.dir") + "/reports" + "/ScreenShots-"
				+ WebActionUtil.getCurrentDateTime() + "/screenshots/");


		BaseTest.logger.info("ExtentDir:-" + fileVariables.getExtentDir());

		/* delete extent folder if it exists before running suite */
		WebActionUtil.deleteDir(fileVariables.getExtentReportFolderPath());

		try {
			File file = new File(fileVariables.getExtentDir());
			if (!(file.exists())) {
				boolean extentFolderStatus = file.mkdirs();
				if (extentFolderStatus == true) {
					new ExtentWebTest().initReport(fileVariables.getExtentDir());

				}

				else
					BaseTest.logger.info("--> Extent Folder not Created");
			}

		} catch (Exception e) {
			BaseTest.logger.info("Inside on start catch block" + e.getMessage());
			e.printStackTrace();
		}

		// Setting ScreenShot Report Location
		try {
			File screenShot = new File(FileVariables.getScreenShotPath());
			if (!(screenShot.exists())) {
				boolean screenshotFolderStatus = screenShot.mkdirs();
				if (screenshotFolderStatus == true)
					BaseTest.logger.info("Screenshot Folder Created");

				else
					BaseTest.logger.info("Screenshot Folder Not Created");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
