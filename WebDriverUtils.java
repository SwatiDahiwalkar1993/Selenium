package CommonUtils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtils {

	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
public void implicitwait(WebDriver driver) {
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}
public void handleDropdown(WebElement element,String targatedelement) {
	Select s = new Select(element);
	s.selectByVisibleText(targatedelement);
}
public void mouseHover(WebDriver driver,WebElement element) {
	Actions a = new Actions(driver);
	a.moveToElement(element);
	a.perform();
	
}
public void switchwindow(WebDriver driver,String Expectedurl) {
	Set<String> ids = driver.getWindowHandles();
	for(String e: ids){
	String actualurl = driver.switchTo().window(e).getCurrentUrl();
		//String Chlildurl = "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
	if (actualurl. contains(Expectedurl)) {
		break;
	
	}
	}
}
  public File ScreenShot (WebDriver driver,String ScreenshotName) throws IOException {
	TakesScreenshot ts =(TakesScreenshot) driver;
 File tempfile = ts.getScreenshotAs(OutputType.FILE);
 File destinationFile = new File("./Screenshot/"+ScreenshotName+".png");
 FileUtils.copyFile(tempfile, destinationFile);
// return destinationfile;
 return destinationFile;
	
	
}









}