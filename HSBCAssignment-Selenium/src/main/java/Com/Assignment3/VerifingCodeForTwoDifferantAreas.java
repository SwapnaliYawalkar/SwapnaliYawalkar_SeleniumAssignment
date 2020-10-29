package Com.Assignment3;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifingCodeForTwoDifferantAreas {
	public static WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://chennaiiq.com/chennai/pincode-by-name.php");
	}
	
	@Test
	public void verifyPinForAreas() {
		
		List <WebElement> areasCodeList=driver.findElements(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table/tbody/tr/td[3]"));
		
		Iterator itr= areasCodeList.iterator();
		
		System.out.println("List of City Pincode: " +areasCodeList.size());
		
		while (itr.hasNext()) {
			WebElement element=(WebElement) itr.next();
			if(element.getText().equals(element)) {
				System.out.println("Picode of city is Same ");
			}else {
				System.out.println("Picode of city is differant ");
			}
			
		}
	
	}
	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
	
}
