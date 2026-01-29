package pom;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage
{
	WebDriver d; 
	WebDriverWait wait;
	
	public ProductDetailPage(WebDriver d)
	{
		PageFactory.initElements(d,this);
		this.d=d;
		wait = new WebDriverWait(d, Duration.ofSeconds(15));
	}
	
	@FindBy(xpath="//span[text()='+']") private WebElement plusIcon;
	
	@FindBy(xpath="//a[text()='M']") private WebElement M;
	@FindBy(xpath="//a[text()='L']") private WebElement L;
	@FindBy(xpath="//a[text()='XL']") private WebElement XL;
	@FindBy(xpath="//a[text()='XXL']") private WebElement XXL;
	@FindBy(xpath="//a[text()='FS']") private WebElement FS;
	@FindBy(xpath="//span[normalize-space()='Add to Bag']") private WebElement AddToBag;
	@FindBy(xpath="//a[contains(@class,'hidden-xs action guest-towishlist towishlist')]") private WebElement AddToWishlist;
	@FindBy(xpath="//div[@class='price 1']") private WebElement ProductPrice;
	
	public int getProductPrice()
	{
		wait.until(ExpectedConditions.visibilityOf(ProductPrice));
		return Integer.parseInt(ProductPrice.getText().replace(",", "").replace("₹", ""));
	}
	
	public void clickFS()
	{
		wait.until(ExpectedConditions.visibilityOf(FS));
		FS.click();
	}
	
	public void clickPlusIcon()
	{
		wait.until(ExpectedConditions.visibilityOf(plusIcon));
		plusIcon.click();
	}
	
	public WebElement getAddToBagButton()
	{
		wait.until(ExpectedConditions.visibilityOf(AddToBag));
		return AddToBag;
	}
	public WebElement getAddToWishlistButton()
	{
		wait.until(ExpectedConditions.visibilityOf(AddToWishlist));
		return AddToWishlist;
	}
	
	public void clickM()
	{
		wait.until(ExpectedConditions.visibilityOf(M));
		M.click();
	}
	
	public void clickL()
	{
		wait.until(ExpectedConditions.visibilityOf(L));
		L.click();
	}
	
	public void clickXL()
	{
		wait.until(ExpectedConditions.visibilityOf(XL));
		XL.click();
	}
	
	public void clickXXL()
	{
		wait.until(ExpectedConditions.visibilityOf(XXL));
		XXL.click();
	}
	
	public void clickAddToBag()
	{
		wait.until(ExpectedConditions.visibilityOf(AddToBag));
		AddToBag.click();
	}
	
	public void clickAddToWishlist()
	{
		wait.until(ExpectedConditions.visibilityOf(AddToWishlist));
		AddToWishlist.click();
	}
	
}
