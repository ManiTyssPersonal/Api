package web.tyss.com.dataproviders;

import org.testng.annotations.DataProvider;

import web.tyss.com.baseutil.BaseTest;
import web.tyss.com.util.commonutils.ExcelUtil;



public class SampleDataProvider {
	
	@DataProvider(name = "TestUsersDataProvider")
	public static Object[][] getTestData() {
		int noofrows = ExcelUtil.getRowCount(BaseTest.EXCELPATH, "Ajio");
		int noofcols = ExcelUtil.getColoumCount(BaseTest.EXCELPATH, "Ajio");
		Object[][] workflowdata = new Object[noofrows][noofcols];
		
		for (int i = 1; i <= noofrows; i++) 
		{
			String data[] = ExcelUtil.getRowData(BaseTest.EXCELPATH, "Ajio", i);

			for (int j = 0; j < data.length; j++) {

				workflowdata[i - 1][j] = data[j];
			}

		}
		return workflowdata;
	}
}
