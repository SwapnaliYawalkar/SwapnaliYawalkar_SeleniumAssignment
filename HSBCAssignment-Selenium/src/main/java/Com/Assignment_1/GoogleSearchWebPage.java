package Com.Assignment_1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchWebPage {
	public static WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","D:\\Swapnali\\JAVA\\SP\\JARFiles\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
}
	@Test
	public void GoogleSearch() throws InterruptedException {
    	
		driver.findElement(By.xpath("//*[@class='gLFyf gsfi']")).sendKeys("iPhone");
    	
		Thread.sleep(2000);
    	//Collect numbers of elements 
    	List<WebElement> suggestedList= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
    	System.out.println("List of Suggestion : " + suggestedList.size());
    	
    	for(int i =0; i<suggestedList.size(); i++) {
    		System.out.println(suggestedList.get(i).getText());
    		if (suggestedList.get(i).getText().contains("iphone xr")) {
    			suggestedList.get(i).click();
				//When requested element find then break the loop
				break;
			   	
    			} 
    	}
	}
	
	@AfterClass
	public void WebDriverClosure() {
		driver.quit();
	}
}
