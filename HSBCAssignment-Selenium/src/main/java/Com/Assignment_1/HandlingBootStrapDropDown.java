package Com.Assignment_1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HandlingBootStrapDropDown {
	
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
	}

	@Test
	private void bootStrapDropDown() {
		driver.findElement(By.xpath("//span[contains(text(),'HTML, CSS')]")).click();

		List<WebElement> listdrop = driver.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']//li//a//label"));
		
		System.out.println("Size of bootStrap Drop down is : " + listdrop.size());

		for (int i = 0; i < listdrop.size(); i++) {
			if (listdrop.get(i).getText().contains("Java")) {
				listdrop.get(i).click();
				//when element is find then break the loop
				break;
			} 
		}
		
			}
	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
