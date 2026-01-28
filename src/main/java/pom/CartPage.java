package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage
{
	WebDriver d ;
	WebDriverWait wait;
	
	public CartPage(WebDriver d)
	{
		PageFactory.initElements(d,this);
		this.d = d;
		wait = new WebDriverWait(d, Duration.ofSeconds(15));
	}
	
	@FindBy(xpath="//span[text()='Proceed to Purchase']") private WebElement ProceedToPurchaseButton;
	@FindBy(xpath="//a[@title='Remove']") private WebElement RemoveButton;
	@FindBy(xpath="//a[@title='Remove']") private List<WebElement> RemoveAllList;
	@FindBy(xpath="//span[text()='Move to Wishlist']") private WebElement MoveToWishlistButton;
	@FindBy(xpath="//span[text()='Apply']") private WebElement ApplyCouponButton;
	@FindBy(id="coupon_code") private WebElement ApplyCodeTextBox;
	@FindBy(xpath="(//span[@class='dynamic-price'])[3]") private WebElement TotalAmount;
	@FindBy(xpath = "//span[text()='Coupon Discount:']/following-sibling::span") private WebElement DiscountPrice;
	
	
	
	public void applyCoupon(String code)
	{
		wait.until(ExpectedConditions.elementToBeClickable(ApplyCodeTextBox));
		ApplyCodeTextBox.sendKeys(code);
	}
	
	public void clickApplyCouponButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(ApplyCouponButton));
		ApplyCouponButton.click();
	}
	
	public int getDiscountAmount()
	{
		wait.until(ExpectedConditions.visibilityOf(DiscountPrice));		
		return -(Integer.parseInt(DiscountPrice.getText().replace(",", "").replace("₹", "")));
	} 
	
	public int getTotalAmount()
	{
		wait.until(ExpectedConditions.visibilityOf(TotalAmount));		
		return Integer.parseInt(TotalAmount.getText().replace(",", "").replace("₹", ""));
	} 
	
	public void clickRemoveButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(RemoveButton));
		RemoveButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		d.switchTo().alert().accept();
	}
	
	public void ClickRemoveAllButton()
	{
		 while (true) 
		 {
		    if (RemoveAllList.isEmpty()) 
		    {
		       break;
		    }
		    WebElement removeBtn = RemoveAllList.get(0);
		    
			wait.until(ExpectedConditions.elementToBeClickable(removeBtn));
			removeBtn.click();
			wait.until(ExpectedConditions.alertIsPresent());
			d.switchTo().alert().accept();
			wait.until(ExpectedConditions.stalenessOf(removeBtn));
		}
	}
	
	public void clickMoveToWishlistButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(MoveToWishlistButton));
		MoveToWishlistButton.click();
	}
	
	public void clickProceedToPurchaseButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(ProceedToPurchaseButton));
		ProceedToPurchaseButton.click();
	}	
	
	
}
