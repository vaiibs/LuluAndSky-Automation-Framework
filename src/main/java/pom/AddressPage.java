package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage 
{
	WebDriver d;
	WebDriverWait wait;
	
	public AddressPage(WebDriver d)
	{
		PageFactory.initElements(d,this);
		this.d = d;
		wait = new WebDriverWait(d,Duration.ofSeconds(15));
	}
	
	@FindBy(xpath = "//span[text()='Add new address']") private List<WebElement> addNewAddressButton;
	@FindBy(xpath = "//button[@data-role='opc-continue' and text()='Proceed to Purchase']") private WebElement proceedToPurchase;
	@FindBy(xpath = "//span[text()='Remove']") private WebElement RemoveButton;
	@FindBy(xpath = "//span[text()='Edit']") private WebElement EditButton;
	
	public void clickAddNewAddress()
	{
		wait.until(ExpectedConditions.elementToBeClickable(addNewAddressButton.get(0)));
		addNewAddressButton.get(0).click();
	}
	
	public void clickProceedToPurchase()
	{
		wait.until(ExpectedConditions.elementToBeClickable(proceedToPurchase));
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].click();",proceedToPurchase);
	}
	
	public void clickRemove()
	{
		wait.until(ExpectedConditions.elementToBeClickable(RemoveButton));
		RemoveButton.click();
	}
	
	public void clickEdit()
	{
		wait.until(ExpectedConditions.elementToBeClickable(EditButton));
		EditButton.click();
	}
	
}
