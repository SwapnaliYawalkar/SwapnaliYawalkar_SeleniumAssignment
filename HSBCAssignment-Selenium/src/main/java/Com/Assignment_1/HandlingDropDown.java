package Com.Assignment_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HandlingDropDown {
	
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
	}
	
	@Test
	public void DropDown() {
		
		//Scrolling Page down
		JavascriptExecutor js = (JavascriptExecutor) driver;
 		js.executeScript("window.scrollBy(0,200)");
 		
 		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
 		
 		//Element which needs to drag.    		
        WebElement From=driver.findElement(By.xpath("//*[@id='draggable']"));		      	
         
        //Element on which need to drop.		
        WebElement toElement=driver.findElement(By.xpath("//*[@id='droppable']"));					
         		
        //Using Action class for drag and drop.		
        Actions act=new Actions(driver);

        //Dragged and dropped.		
        act.dragAndDrop(From, toElement).build().perform();	
        
        System.out.println("Performed Drag and drop successfully"); 
    
        	}
	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}

}
