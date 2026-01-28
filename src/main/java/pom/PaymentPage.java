
package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage 
{
	WebDriver d;
	WebDriverWait wait;
	
	public PaymentPage(WebDriver d)
	{
		PageFactory.initElements(d,this);
		this.d = d;
		wait = new WebDriverWait(d,Duration.ofSeconds(15));
	}
	
	@FindBy(xpath = "(//li[contains(@class,'tablinks')])[1]") private WebElement CreditCard;
	@FindBy(xpath = "(//li[contains(@class,'tablinks')])[2]") private WebElement DebitCard;
	@FindBy(xpath = "(//li[contains(@class,'tablinks')])[3]") private WebElement NetBanking;
	@FindBy(xpath = "(//li[contains(@class,'tablinks')])[4]") private WebElement UPI;
	@FindBy(xpath = "(//li[contains(@class,'tablinks')])[5]") private WebElement EMI;
	@FindBy(xpath = "(//li[contains(@class,'tablinks')])[6]") private WebElement CashOnDelivery;
	
	@FindBy(xpath = "//span[text()='Total Amount:']/following-sibling::span") private WebElement TotalAmount;

	@FindBy(xpath = "//span[text()='Buy It']") private WebElement BuyItButton;
	
	public void clickBuyItButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(BuyItButton));
		BuyItButton.click();
	}
	
	public void checkCashOnDelivery()
	{
		wait.until(ExpectedConditions.elementToBeClickable(CashOnDelivery));
		CashOnDelivery.click();
	}
	
	public WebElement getCashOnDeliveryButton()
	{
		wait.until(ExpectedConditions.visibilityOf(CashOnDelivery));
		return CashOnDelivery;
	}
	
	public void clickCashOnDelivery()
	{
		wait.until(ExpectedConditions.elementToBeClickable(CashOnDelivery));
		CashOnDelivery.click();
	}
	
}
