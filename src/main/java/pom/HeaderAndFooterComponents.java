package pom;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderAndFooterComponents
{
	WebDriver d;
	WebDriverWait wait;
	
	public HeaderAndFooterComponents(WebDriver d)
	{
		PageFactory.initElements(d, this);
		this.d = d;
		wait = new WebDriverWait(d,Duration.ofSeconds(15));
	}
	
	// Header
	
	@FindBy(xpath = "//span[text()='New']") private WebElement newButton;
	@FindBy(xpath = "//span[text()='Women']") private WebElement WomenButton;
	@FindBy(xpath = "//span[text()='Bags']") private WebElement BagsButton;
	@FindBy(xpath = "//span[text()='Shoes']") private WebElement ShoesButton;
	@FindBy(xpath = "//span[text()='Accessories']") private WebElement AccessoriesButton;
	@FindBy(xpath = "//span[text()='Trends']") private WebElement TrendsButton;
	@FindBy(xpath = "//span[text()='Kids']") private WebElement KidsButton;
	@FindBy(xpath = "//img[@alt='Lulu & Sky']") private WebElement LuluAndSkyButton;
	@FindBy(className = "search-icon") private WebElement SearchIcon;
	@FindBy(className = "whislist-cover") private WebElement WishListButton;
	@FindBy(xpath = "//span[@class='total']") private WebElement wishlistCount;
	@FindBy(xpath = "//a[contains(@class,'action showcart')]") private WebElement ShoppingBagIcon;
	@FindBy(xpath = "//span[text()='View Bag']") private WebElement viewBagButton;
	@FindBy(xpath = "//span[@class='counter-number']") private WebElement BagCount;
	
	@FindBy(xpath = "//span[text()='Get App']") private WebElement GetAppButton;
	@FindBy(className = "re_gis") private WebElement SignupButton;
	@FindBy(xpath = "//a[text()='Login']") private WebElement LoginButton;
	
	public void clickSearchFeild()
	{
		wait.until(ExpectedConditions.elementToBeClickable(SearchIcon));
		SearchIcon.click();
	}
	
	public void openShoppingBag()
	{
		Actions a = new Actions(d);
		wait.until(ExpectedConditions.elementToBeClickable(ShoppingBagIcon));
		a.moveToElement(ShoppingBagIcon).perform();
		wait.until(ExpectedConditions.elementToBeClickable(viewBagButton));
		viewBagButton.click();
		wait.until(ExpectedConditions.urlContains("cart"));
	}
	
	public boolean isShoppingNotEmpty()
	{
		Actions a = new Actions(d);
		wait.until(ExpectedConditions.elementToBeClickable(ShoppingBagIcon));
		a.moveToElement(ShoppingBagIcon).perform();
		
		try
		{
			wait.until(ExpectedConditions.elementToBeClickable(viewBagButton));
		}
		catch(Exception e)
		{
			return false;
		}
		
		return true;
	}
	
	public void clickWishListButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(WishListButton));
		WishListButton.click();
	}
	
	public WebElement getWishlistElement()
	{
		wait.until(ExpectedConditions.visibilityOf(wishlistCount));
	    return wishlistCount;
	}
	
	public WebElement getBagElement()
	{
		wait.until(ExpectedConditions.visibilityOf(BagCount));
		return BagCount;
	}
	
	public String getWishlistCount()
	{
		wait.until(ExpectedConditions.visibilityOf(wishlistCount));
		return wishlistCount.getText();
	}
	
	public String getBagCount()
	{
		wait.until(ExpectedConditions.visibilityOf(BagCount));
		return BagCount.getText();
	}
	
	public void clickLogin()
	{
		//wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		JavascriptExecutor js = (JavascriptExecutor)d;
		js.executeScript("arguments[0].click()", LoginButton);
	}
	
	public void clickWomenButton()
	{
		JavascriptExecutor js = (JavascriptExecutor)d;
		wait.until(ExpectedConditions.elementToBeClickable(WomenButton));
		js.executeScript("arguments[0].click();", WomenButton);
	}
	
	
	// Footer
	
	@FindBy(linkText = "Terms & Conditions") private WebElement TermsAndConditionsLink;
	@FindBy(linkText = "Contact us") private WebElement ContactUsLink;
	@FindBy(linkText = "Returns policy") private WebElement ReturnsPolicyLink;
	@FindBy(linkText = "FAQs") private WebElement FAQsLink;
	@FindBy(linkText = "Track Order") private WebElement TrackOrderLink;
	@FindBy(xpath = "(//img[@class='img-responsive'])[2]") private WebElement AppStoreLink;
	@FindBy(xpath = "(//img[@class='img-responsive'])[3]") private WebElement GooglePlayLink;
	@FindBy(xpath = "(//i[@class='fa fa-facebook'])[1]") private WebElement FaceBookLink;
	@FindBy(xpath = "(//i[@class='fa fa-twitter'])[1]") private WebElement TwitterLink;
	@FindBy(xpath = "(//i[@class='fa fa-instagram'])[1]") private WebElement InstagramLink;
	@FindBy(linkText = "Help Center") private WebElement HelpCenterLink;
	@FindBy(xpath = "//input[contains(@placeholder,'Enter your email address')]") private WebElement EmailTextField;
	@FindBy(id = "btn-subscribe") private WebElement SubscribeButton;
	
	@FindBy(tagName = "footer") private WebElement footerContainer;

	public List<String> getFooterLinks()
	{
		 List<String> links = new ArrayList<>();
		 
		 List<WebElement> allLinks = footerContainer.findElements(By.tagName("a"));
		 
		 for (WebElement link : allLinks) 
		 {
			String href = link.getAttribute("href");
			
			if (href != null && href.startsWith("http")) 
			{
				links.add(href);
			}
		 }
		 return links;
	}
	
	public void scrollToFooter()
	{
		JavascriptExecutor js = (JavascriptExecutor) d;
		wait.until(ExpectedConditions.visibilityOf(footerContainer));
		js.executeScript("arguments[0].scrollIntoView(true);", footerContainer);
	}
	
}
