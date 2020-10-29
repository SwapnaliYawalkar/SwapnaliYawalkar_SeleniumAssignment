package Com.Assignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleAccountUsingGetAttribute {
	public static WebDriver driver;
	private By acountFirstName = By.id("firstName");
	private By acountLastName = By.name("lastName");
	private By userName = By.id("username");
	private By password = By.name("Passwd");
	private By confirmPassword = By.name("ConfirmPasswd");
	

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signup");
	}
	
		@Test
		public void getAttribute_FirstName() {
			
		
			WebElement firstName = driver.findElement(acountFirstName);
			System.out.println("Id of the button is:- " +firstName.getAttribute("id"));
			
		}

		@Test
		public void getAttribute_LastName() {
			WebElement lastName = driver.findElement(acountLastName);
			System.out.println("Id of the button is:- "+ lastName.getAttribute("name"));
		}

		@Test
		public void getAttribute_UserName() {

				WebElement email = driver.findElement(userName);
			System.out.println("Class of the button is:- "+ email.getAttribute("id"));

		}
		@Test
		public void getAttribute_Password() {

			WebElement emailPassword = driver.findElement(password);
			System.out.println("Class of the button is:- "+ emailPassword.getAttribute("class"));

		}
		@Test
		public void getAttribute_ConfirmPassword() {

			WebElement emailConfirmPassword = driver.findElement(confirmPassword);
			System.out.println("Class of the button is:- "+ emailConfirmPassword.getAttribute("name"));

		}

	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
