package web.tyss.com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import web.tyss.com.util.WebActionUtil;

public class PersonalFormFill_Page {
	public static WebDriver driver;
	public WebActionUtil WebActionUtil;
	public long ETO = 10;

	public PersonalFormFill_Page(WebDriver driver, long ETO, WebActionUtil WebActionUtil) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.WebActionUtil = WebActionUtil;
		this.ETO = ETO;
	}
	
	//div[text()='Personal']
	/*Name text box*/
	@FindBy(linkText = "Personal")
	private  WebElement lnkPersonalPage;
	
	/*Name text box*/
	@FindBy(id = "fname")
	private  WebElement tbName;
		
	/*Name text box*/
	@FindBy(id = "email")
	private  WebElement tbEmail;
	
	/*Password text box*/
	@FindBy(name = "password")
	private  WebElement tbPassword;
	
	/*Phone Number text box*/
	@FindBy(name = "number")
	private  WebElement tbPhoneNumber;
	
	/* Years drop down*/
	@FindBy(xpath ="//input[@placeholder='Select' and @name='expYear']")
	private WebElement ddYears;
		
	/*Select Years*/
	public static WebElement selectYearOpt(String years) 
	{
		String xpath = "//span[text()='Year(s)']/preceding-sibling::div[@class='experience ddwn']//div[@class='transcluded']/span[text()='"+years+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	/* Months dropdown*/
	@FindBy(xpath ="//input[@placeholder='Select' and @name='expMonth']")
	private WebElement ddMonths;
	
	
	/*Select Months*/
	public static WebElement selectMonthOpt(String months) 
	{
		String xpath = "//ul[@class='droopeCont listing']/li//div/span[text()='"+months+"']";
		return driver.findElement(By.xpath(xpath));
	}
	
	/*Upload Resume button*/
	@FindBy(xpath = "//span[@class='uploadCV']/button[text()='Upload']")
	private  WebElement btnUpload;
		
	/*Agree check box*/
	@FindBy(id = "term")
	private  WebElement chkbxAgree;
		
	/*Register Now button*/
	@FindBy(xpath = "//div[@class='submit-box']/button[text()='Register Now']")
	private  WebElement btnResgisterNow;
	
	
	/** 
	 * Description: Method to Validate the Personal page
	 * @author Manikandan A
	 */
	private synchronized void validateThePersonalPage() {
		try {
			WebActionUtil.waitForElement(lnkPersonalPage, "Personal Details", 5);
			WebActionUtil.verifytext("Personal", lnkPersonalPage, "Personal Fill form is validated");
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to close Window PopUps");
			Assert.fail("Unable to close Window PopUps");
		}
	}

	/** 
	 * Description: Method to Fill the Personal Form and validate
	 * @author Manikandan A
	 * @param name
	 * @param email
	 * @param password
	 * @param phoneNumber
	 * @param year
	 * @param month
	 */
	public synchronized void FillThePersonalForm(String name,String email,String password,String phoneNumber,String year,String month ) {
		try {
			validateThePersonalPage();
			setName(name);
			setEmail(email);
			setPassword(password);
			setPhoneNumber(phoneNumber);
			setYear(year);
			setMonth(month);
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to enter Name in text box");
			Assert.fail("Unable to enter Name in text box");
		}
	}
	
	/** 
	 * Description: Method to Fill the Name text box and validate
	 * @author Manikandan A
	 * @param name
	 */
	
	private synchronized void setName(String name) {
		try {
			WebActionUtil.waitForElement(tbName, "Name text box", 15);
			WebActionUtil.typeText(tbName, name, "Name is Entered in text box");
			String actualName=tbName.getAttribute("value");
			WebActionUtil.validateEnteredData(name, actualName, "Name Text box",name + " Name entered in text box", name+" Name not entered in text box");
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to enter Name in text box");
			Assert.fail("Unable to enter Name in text box");
		}
	}
	

	/** 
	 * Description: Method to Fill the Email text box and validate
	 * @author Manikandan A
	 * @param email
	 */
	private synchronized void setEmail(String email) {
		try {
			WebActionUtil.waitForElement(tbEmail, "Email text box", 15);
			WebActionUtil.typeText(tbEmail, email, "Email is Entered in text box");
			String actualEmail=tbEmail.getAttribute("value");
			WebActionUtil.validateEnteredData(email, actualEmail, "Email Text box",email + " Email entered in text box", email +" Email not entered in text box");
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to enter Email in text box");
			Assert.fail("Unable to enter Email in text box");
		}
	}
	

	/** 
	 * Description: Method to Fill the Phone Number text box and validate
	 * @author Manikandan A
	 * @param phoneNumber
	 */
	private synchronized void setPhoneNumber(String phoneNumber) {
		try {
			WebActionUtil.waitForElement(tbPhoneNumber, "Phone Number text box", 15);
			WebActionUtil.typeText(tbPhoneNumber, phoneNumber, "Phone Number is Entered in text box");
			String actualPhoneNumber=tbPhoneNumber.getAttribute("value");
			System.out.println(actualPhoneNumber);
			WebActionUtil.validateEnteredData(phoneNumber, actualPhoneNumber, "Phone Number Text box",phoneNumber + " Phone Number entered in text box", phoneNumber +" Phone Number not entered in text box");
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to enter Phone Number in text box");
			Assert.fail("Unable to enter Phone Number in text box");
		}
	}
	
	
	/** 
	 * Description: Method to Fill the Password text box and validate
	 * @author Manikandan A
	 * @param password
	 */
	private synchronized void setPassword(String password) {
		try {
			WebActionUtil.waitForElement(tbPassword, "Password text box", 15);
			WebActionUtil.typeText(tbPassword, password, "Password is Entered in text box");
			String actualPassword=tbPassword.getAttribute("value");
			WebActionUtil.validateEnteredData(password, actualPassword, "Password Text box",password + " Password entered in text box", password +" Password not entered in text box");
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to enter Password in text box");
			Assert.fail("Unable to enter Password in text box");
		}
	}
	
	
	/** 
	 * Description: Method to select year and validate
	 * @author Manikandan A
	 * @param years
	 */
	private synchronized void setYear(String years) {
		try {
			WebActionUtil.waitForElement(ddYears, "Years drop down", 15);
			WebActionUtil.clickOnWebElement(ddYears, "Year drop down", "Clicked on Years dropdown");
			WebActionUtil.waitForElement(selectYearOpt(years), "Year drop down", 15);
			WebActionUtil.clickOnWebElement(selectYearOpt(years), years, "Year is not selected from drop down");
			WebActionUtil.isElementDisplayed(selectYearOpt(years), "Year is Displayed");
			//WebActionUtil.validateEnteredData(years, actualYear, "Year drop down",years + " Year is selected from drop down", years +" Year is not selected from drop down");
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to select Year from drop down");
			Assert.fail("Unable to select Year from drop down");
		}
	}
	
	/** 
	 * Description: Method to select Month and validate
	 * @author Manikandan A
	 * @param month
	 */
	private synchronized void setMonth(String months) {
		try {
			WebActionUtil.waitForElement(ddMonths, "Months drop down", 15);
			WebActionUtil.clickOnWebElement(ddMonths, "Months drop down", "Clicked on Months dropdown");
			WebActionUtil.waitForElement(selectMonthOpt(months) , "Month drop down", 15);
			WebActionUtil.clickOnWebElement(selectMonthOpt(months), months, "Month is selected from drop down");
			WebActionUtil.isElementDisplayed(selectYearOpt(months), "Month is Displayed");
			//WebActionUtil.validateEnteredData(months, actualMonth, "Month drop down",months + " Month is selected from drop down", months +" Month is not selected from drop down");
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to select month from drop down");
			Assert.fail("Unable to select month from drop down");
		}
	}
	
	
	/** 
	 * Description: Method to Upload Resume
	 * @author Manikandan A
	 */
	public synchronized void setUploadResume() {
		try {
			WebActionUtil.waitForElement(btnUpload, "Upload Resume button", 5);
			WebActionUtil.clickOnWebElement(btnUpload, "Upload Resume button", "clicked on Upload Resume Button");
			Thread.sleep(5000);
			btnUpload.sendKeys("E:\\My College\\project\\6\\LITERATURE SURVEY.docx");
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to click on Upload Resume button");
			Assert.fail("Unable to click on Upload Resume button");
		}
	}
	
	/** 
	 * Description: Method to click on Register
	 * @author Manikandan A
	 */
	public synchronized void clkOnRegisterNowButton() {
		try {
			WebActionUtil.waitForElement(btnResgisterNow, "Register Now button", 10);
			WebActionUtil.clickOnWebElement(btnResgisterNow, "Register Now button", "clicked on Register Now Button");
			
			
			}
		catch (Exception e) 
		{
			 WebActionUtil.error(e.getMessage());
			WebActionUtil.error("Unable to enter Password in text box");
			Assert.fail("Unable to enter Password in text box");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
