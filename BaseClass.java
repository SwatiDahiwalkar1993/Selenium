package CommonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	
	//Driver Global driver
	public WebDriver driver;
	
	//WebDriver driver = new ChromeDriver();
	
	WebDriverUtils wutil = new WebDriverUtils();
	PropertyfileUtil putil = new PropertyfileUtil();
	@BeforeSuite 
	public void BS() throws IOException
	{
	System.out.println("Connect to the data Base");
	}
	@BeforeClass
	public void BC() throws IOException {
		 String BROWSER = putil.getDataFromPropertyFile("Browser");
		String URL = putil.getDataFromPropertyFile("URL");
		if(BROWSER.equals("Chrome")) {
			 driver = new ChromeDriver();
			
		}else if(BROWSER.equals("Edge")){
  driver = new EdgeDriver();
    }else if (BROWSER.equals("FireFox")) {
    	 driver = new FirefoxDriver();
    }
		
		
		
		
		
		
		//To Maximize the window
		wutil.maximize(driver);
		
		//To apply wait to findlElement()
		wutil.implicitwait(driver);
		System.out.println("Connect to Data base");
		//To launch the application
		driver.get(URL);
	}
	@BeforeMethod
	public void BM() throws IOException {
		//@Before method is used to login to the application
		String USERNAME = putil.getDataFromPropertyFile("USERNAME");
		String  PASSWORD= putil.getDataFromPropertyFile("PASSWORD");
		
		// To read data from property file
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);	
	    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	    driver.findElement(By.id("submitButton")).click();
	    
		
		
		
		
		
	}
	@AfterMethod
	public void AM() throws InterruptedException {
		
		 //Mouse hover on administration
		 WebElement img = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		  wutil.mouseHover(driver, img);
		  
		  Thread.sleep(3000);
		  //Click on sign out
		  driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	@AfterClass
	public void AC() {
		
		//@After class is used to close the browser
		driver.quit();
	}
    @AfterSuite
    public void AS() {
    	System.out.println("Disconnect from Data base");
    }
}

