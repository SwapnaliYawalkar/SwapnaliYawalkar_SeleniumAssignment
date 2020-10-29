package Com.Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TabHandling {
	
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	}

	@Test
	public void tabHandling() {

		driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[2]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"content\"]/h2[1]/a")).click();

		Select select = new Select(driver.findElement(By.xpath("//*[@id=\"search_type\"]")));
		select.selectByValue("3");

		driver.findElement(By.xpath("//*[@id=\"search_patient\"]")).click();

		System.out.println("Selected First Name from drop down and clicked on search button ");
	}

	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
