package web.tyss.com.baseutil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDriver {
	
	private static CreateDriver instance = null;
	
	private ThreadLocal <WebDriver> webDriver =new ThreadLocal<WebDriver>();
	

	/*constructor*/
	 private CreateDriver() {
	 }
	 
	 /**
	  * getInstance method to retrieve active driver instance
	  *
	  * @return CreateDriver
	  */
	  public static CreateDriver getInstance() {
	  if ( instance == null ) {
	  instance = new CreateDriver();
	  }
	  return instance;
	  }
	  
	  @SuppressWarnings("deprecation")
	public  WebDriver setdriver(String browser)
	  {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
	
//			WebDriverManager.chromedriver().forceDownload().cachePath("./drivers").avoidOutputTree().setup();
			return  new ChromeDriver();
		}
		else if(browser=="Firefox")
		{
//			WebDriverManager.firefoxdriver().setup();
			WebDriverManager.firefoxdriver().forceDownload().cachePath("./drivers").avoidOutputTree().setup();
			return  new FirefoxDriver();
		}
		else
		{
		
		}
		return null;
     }
	  
	  
	  public DesiredCapabilities setWebDriverCapabilities(String browser, DesiredCapabilities capabilities) throws IOException {

		    switch (browser) {
		        case "ie":
		            capabilities = new DesiredCapabilities().internetExplorer();
		            break;
		        case "firefox":
		            capabilities = new DesiredCapabilities().firefox();
		            break;
		        case "chrome":
		        	
		            capabilities = new DesiredCapabilities().chrome();
		            
		            break;
		        case "edge":
		            capabilities = new DesiredCapabilities().edge();
		            break;
		        case "safari":
		            capabilities = new DesiredCapabilities().safari();
		            break;
		        default:
		            capabilities = null;
		    }
		    
		    return capabilities;
	  }
		
	  /**
		 * Description :Sets the driver instance
		 *
		 * @author Manikandan A
		 * @param browser
		 *
		 */
		public WebDriver launchBrowser(String browser) {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				return new ChromeDriver();
			} else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				return new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("Edge")) {
				System.setProperty("webdriver.edge.driver", "./drivers/EdgeDriver.exe");
				return new EdgeDriver();
			} else {
				return null;
			}

		}

}