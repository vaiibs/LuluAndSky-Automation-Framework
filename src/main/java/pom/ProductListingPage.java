package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductListingPage 
{
	WebDriver d;
	WebDriverWait wait;
	
	public ProductListingPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
		wait = new WebDriverWait(d, Duration.ofSeconds(10));
		this.d = d; 
	}
	
	@FindBy(xpath = "//li[@data-label='Dresses']") private WebElement dressFilter;
	@FindBy(xpath = "//li[@data-label='Lingerie' and @class='item']") private WebElement lingerieFilter;
	@FindBy(xpath = "//li[@data-label='Asymmetrical Dresses' and @class='item']") private WebElement AsymmetricalStyle;
	@FindBy(xpath = "//li[@data-label='Black' and @class='item']") private WebElement blackColor;
	@FindBy(xpath = "//li[@data-label='1XL' and @class='item']") private WebElement xlSize;
	@FindBy(xpath = "//li[@data-label='Rs. 1000 - 1200' and @class='item']") private WebElement price;
	@FindBy(xpath = "//span[@class='filter-value am-filter-value']") private WebElement activeFilter;
	
	@FindBy(xpath = "//img[@class='product-image-photo']") private WebElement productImg;
	@FindBy(xpath = "(//img[@class='product-image-photo'])[2]") private WebElement productImg2;
	@FindBy(xpath = "//span[text()='Add to Bag']") private WebElement addToBagButton;
	@FindBy(xpath = "//span[text()='Add to Wishlist']") private WebElement addToWishlistButton;
	@FindBy(xpath = "//span[text()='Remove From Wishlist']") private WebElement removeFromWishlistButton;
	@FindBy(xpath = "//div[@class='price-box']") private WebElement priceBox;
	@FindBy(xpath = "//strong[@class='product name product-item-name']") private WebElement productName;
	@FindBy(xpath = "//strong[@class='product name product-item-name']") private List<WebElement> productsName;
	
	@FindBy(xpath = "//div[text()='Popular']") private WebElement filterButton;
	@FindBy(xpath = "//a[text()='Price High to Low']") private WebElement HighToLowButton;
	
	public void HighToLowFilter()
	{
		wait.until(ExpectedConditions.elementToBeClickable(filterButton));
		filterButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(HighToLowButton));
		HighToLowButton.click();
	}
	
	public void hoverProduct()
	{
		Actions a = new Actions(d) ;
		wait.until(ExpectedConditions.elementToBeClickable(productImg));
		a.moveToElement(productImg).perform();
	}
	
	public String getActiveFilter()
	{
		return activeFilter.getText();
	}
	
	public void clickDressFilter()
	{
		wait.until(ExpectedConditions.elementToBeClickable(dressFilter));
		dressFilter.click();
	}
	
	public void clickAsymmetricalStyle()
	{
		wait.until(ExpectedConditions.elementToBeClickable(AsymmetricalStyle));
		AsymmetricalStyle.click();
	}
	
	public void clickBlackColor()
	{
		wait.until(ExpectedConditions.elementToBeClickable(blackColor));
		blackColor.click();
	}
	 
	public void clickProductImg()
	{
		wait.until(ExpectedConditions.elementToBeClickable(productImg));
		productImg.click();
	}
	
	public void clickProductImg2()
	{
		wait.until(ExpectedConditions.elementToBeClickable(productImg2));
		productImg2.click();
	}
	
	public void clickAddToBagButton()
	{
		wait.until(ExpectedConditions.visibilityOf(addToBagButton));
		addToBagButton.click();
	}
	
	public void clickAddToWishlistButton()
	{
		wait.until(ExpectedConditions.visibilityOf(addToWishlistButton));
		addToWishlistButton.click();
		
	}
	
	public boolean isRemoveFromWishlistDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(removeFromWishlistButton));
		return removeFromWishlistButton.isDisplayed();
	}
	
	public boolean isAddToWishlistDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(addToWishlistButton));
		return addToWishlistButton.isDisplayed();
	}
	
	public void clickRemoveFromWishlist()
	{
		removeFromWishlistButton.click();
	}
	
	public String getPriceBox()
	{
		return priceBox.getText();
	}
	
	public String getProductName()
	{
		return productName.getText();
	}
	
	public List<WebElement> getProductsName()
	{
		return productsName;
	}
	  
}


