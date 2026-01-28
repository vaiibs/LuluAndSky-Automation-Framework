package WaitUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait
{
	 WebDriver d;
	 WebDriverWait wait ;
	 
	 public Wait(WebDriver d)
	 {
		 this.d=d;
	 }
	 


	 public String waitUntilPageTitle(String expectedTitle)
	 {
		 wait = new WebDriverWait(d, Duration.ofSeconds(15));
		 wait.until(ExpectedConditions.titleIs(expectedTitle));
		 return d.getTitle();	
	 }

}
