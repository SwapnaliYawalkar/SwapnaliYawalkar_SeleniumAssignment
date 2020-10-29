package Com.Assignment_1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SetBrowserWindowSize {
public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
}
	
	 @Test
	    public void SetSizeWindow() {
	    
	    	Dimension dimen = new Dimension(500,500);
	     	//Resize current window to the set dimension
	     	driver.manage().window().setSize(dimen);
	    }
	 
	@AfterClass
		public void WebDriverClosure() {
			driver.quit();
		}
}
