package Com.Assignment2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.Reader;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DataProvider {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}

	@Test(dataProvider = "SignInData")
	public void signIn(String username, String password) throws InterruptedException {
		System.out.println("Username: " + username + "\t" + "Password: " + password);
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/div/span")).click();
		driver.findElement(By.cssSelector("#ap_email")).sendKeys(username);
		driver.findElement(By.cssSelector("#continue")).click();
		driver.findElement(By.cssSelector("#ap_password")).sendKeys(password);
		driver.findElement(By.cssSelector("#signInSubmit")).click();
		Thread.sleep(2000);
		System.out.println("You are sucessfully login");

	}

	@org.testng.annotations.DataProvider(name = "SignInData")
	public Object[][] readCSV() throws FileNotFoundException {
		Object[][] obj = new Object[1][2];

		Reader fis = new java.io.FileReader(
				"D:\\Swapnali\\Eclips_Program_RestAPI\\HSBCAssignment-Selenium\\src\\main\\resources\\Inpute.csv");
		BufferedReader reader = new BufferedReader(fis);

		Scanner sc = new Scanner(reader);

		int index = 0;
		while (sc.hasNext()) {
			String[] unamepasspair = sc.next().split(",");
			if (!unamepasspair[0].equals("uname")) {
				obj[index][0] = unamepasspair[0];
				obj[index][1] = unamepasspair[1];
				index++;
			}
		}
		return obj;
	}

	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
