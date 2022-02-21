package web.tyss.com.scripts;

import org.testng.annotations.Test;

import web.tyss.com.baseutil.BaseTest;
import web.tyss.com.baseutil.InitializePages;
import web.tyss.com.dataproviders.SampleDataProvider;

public class SampleTest extends BaseTest {
//	
	
//	String productName, String mainMenu, String quantity, String priceRange, String items
	@Test(description = "Create Users", dataProvider = "TestUsersDataProvider", dataProviderClass = SampleDataProvider.class)
	public void sampleTest(String productName, String mainMenu, String quantity, String priceRange, String items)
			throws Exception {

		InitializePages pages = new InitializePages(driver, ETO, WebActionUtil);

		System.out.println("Hi");
		pages.personalFormFillPage.FillThePersonalForm("", "", "", "", "", "");

	}
}
