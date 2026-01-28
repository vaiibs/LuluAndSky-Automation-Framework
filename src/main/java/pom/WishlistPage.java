package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishlistPage
{
	WebDriver d ;
	WebDriverWait wait ;
	
	public WishlistPage(WebDriver d)
	{
		this.d = d;
		PageFactory.initElements(d, this);
		wait = new WebDriverWait(d,Duration.ofSeconds(15));
	}
	
	@FindBy(xpath = "//a[contains(@class,'remove')]") private WebElement removeButton;
	@FindBy(xpath = "//button[contains(@class,'button-moveto button-movetocart')]") private WebElement moveToBagButton;
	@FindBy(xpath = "//a[text()='Continue Shopping']") private WebElement continueShoppingButton;
	@FindBy(xpath = "//span[@class='total']") private WebElement totalInWishlist;
	
	public void clickMoveToBagButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(moveToBagButton));
		moveToBagButton.click();
	}
	
	public void removeFromWishlist()
	{
		wait.until(ExpectedConditions.elementToBeClickable(removeButton));
		removeButton.click();
	}
	
	public void addToBag()
	{
		wait.until(ExpectedConditions.elementToBeClickable(moveToBagButton));
		moveToBagButton.click();
	}
	
	public void continueShopping()
	{
		wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
		continueShoppingButton.click();
	}
	
	public String getAlertText()
	{
		return d.switchTo().alert().getText();
	}
	
	public void clickOk()
	{
		d.switchTo().alert().accept();
	}
	
	public void clickCancel()
	{
		d.switchTo().alert().dismiss();
	}
	
	public String getWishlistCount()
	{
		return totalInWishlist.getText();
	}
	
}
