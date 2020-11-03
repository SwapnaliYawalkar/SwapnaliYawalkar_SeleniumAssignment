package Com.Assignment_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadPropertyFile {
	
		public static WebDriver driver;
		String username="swapnayawalkar@gmail.com";
		String password="Smile@123"; 

		@BeforeClass
		public void setUp() {
			System.setProperty("webdriver.chrome.driver","D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		
		@Test
		public void signIn() throws IOException {
			
			Properties property=new Properties();
			
			FileInputStream fis=new FileInputStream("D:\\Swapnali\\Eclips_Program_RestAPI\\HSBCAssignment-Selenium\\src\\main\\resources\\Properties");
			
			property.load(fis);
			
			driver.get(property.getProperty("baseURL"));
			driver.findElement(By.xpath(property.getProperty("signIn"))).click();
			driver.findElement(By.cssSelector(property.getProperty("userName"))).sendKeys(username);
			driver.findElement(By.cssSelector(property.getProperty("next"))).click();
			driver.findElement(By.cssSelector(property.getProperty("password"))).sendKeys(password);
			driver.findElement(By.cssSelector(property.getProperty("signInSubmit"))).click();
		}
	}

