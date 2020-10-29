package Com.Assignment_1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EnterTextWithoutSendKey {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}
	
	@Test
    public void textWithoutSenkeys() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement search = driver.findElement(By.xpath("//*[@class='gLFyf gsfi']"));
    	
		js.executeScript("arguments[0].value = 'Book'" , search);
    }
	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
