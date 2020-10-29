package Com.Assignment_1;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class HandlingWindow {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://popuptest.com/goodpopups.html");

	}

	@Test
	public void WindowHandle() throws InterruptedException {

		driver.findElement(By.xpath("//a[@href='http://www.popuptest.com/popup3.html']")).click();

		Thread.sleep(2000);

		// for two window handling main window n popup window

		String parent_window = driver.getWindowHandle();
		System.out.println("Before Swiching Title is =" + driver.getTitle());
		Set<String> childWindow = driver.getWindowHandles();
		Iterator<String> itr = childWindow.iterator();
		for (String handle : childWindow) {
			if (!parent_window.equalsIgnoreCase(handle)) {
				driver.switchTo().window(handle);
				System.out.println("Child Window Title: " + driver.getTitle());
				driver.close();
				driver.switchTo().window(parent_window);
				System.out.println("Parent Window Title: " + driver.getTitle());

			}
			
		}

	}
}
