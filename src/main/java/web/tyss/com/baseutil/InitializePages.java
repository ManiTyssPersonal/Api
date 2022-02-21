package web.tyss.com.baseutil;

import org.openqa.selenium.WebDriver;

import web.tyss.com.pages.PersonalFormFill_Page;
import web.tyss.com.util.WebActionUtil;

/**
 * Description Initialize all pages with driver,ETO, WebAactionUtil
 * 
 * @author Manikandan A
 * 
 */

public class InitializePages {

	public PersonalFormFill_Page personalFormFillPage;

	public InitializePages(WebDriver driver, long ETO, WebActionUtil WebActionUtil) {

		personalFormFillPage = new PersonalFormFill_Page(driver, ETO, WebActionUtil);

	}

}
