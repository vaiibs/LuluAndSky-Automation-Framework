package ProductListingPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Set;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BaseClass.BaseClass;
import pom.HeaderAndFooterComponents;
import pom.ProductListingPage;

public class ProductListingPageTesting extends BaseClass
{
	public ProductListingPage p;
	public HeaderAndFooterComponents h;
	 
	@BeforeMethod
	public void setup()
	{
		openLuluAndSky();
		NavigateToPLP();
		p = new ProductListingPage(d);
		h = new HeaderAndFooterComponents(d);
	}
	
	@Test
	public void TC001_ColorFilter()
	{
		p.clickBlackColor();
		wait.until(ExpectedConditions.urlContains("black"));
		assertEquals(p.getActiveFilter(),"Black","Black Color filter not applied");
	}
	
	@Test
	public void TC002_StylesFilter()
	{
		p.clickAsymmetricalStyle();
		wait.until(ExpectedConditions.urlContains("asymmetrical_dresses"));
		assertEquals(p.getActiveFilter(),"Asymmetrical Dresses","Aymmetric Style filter not applied");
	}
	
	@Test
	public void TC003_AddToWishlist()
	{
		int beforeCount = 0;
		String str = h.getWishlistCount();
		
		if (str!=null && !str.trim().isEmpty()) 
		{
			beforeCount = Integer.parseInt(str.trim());
		}
		String afterCount = String.valueOf(beforeCount+1);
		
		p.hoverProduct();
		p.clickAddToWishlistButton();
		//assertTrue(p.isRemoveFromWishlistDisplayed(),"'Remove From Wishlist' button is not displayed");
		//wait.until(ExpectedConditions.textToBePresentInElement(h.getWishlistElement(), afterCount ));
		//assertEquals(h.getWishlistCount(), afterCount);
	}
	
	@Test
	public void TC004_RemoveFromWishlist()
	{
		int beforeCount = 0;
		String str = h.getWishlistCount();
		
		if (str!=null && !str.trim().isEmpty()) 
		{
			beforeCount = Integer.parseInt(str.trim());
		}
		String afterCount = String.valueOf(beforeCount+1);
		
		p.hoverProduct();
		p.clickAddToWishlistButton();
		//assertTrue(p.isRemoveFromWishlistDisplayed(),"'Remove From Wishlist' button is not displayed");
		//wait.until(ExpectedConditions.textToBePresentInElement(h.getWishlistElement(), afterCount ));
		//assertEquals(h.getWishlistCount(), afterCount);
		
		p.clickRemoveFromWishlist();
		//assertTrue(p.isAddToWishlistDisplayed(),"'Add to Wishlist' button is not displayed");
		//wait.until(ExpectedConditions.textToBePresentInElement(h.getWishlistElement(), String.valueOf(beforeCount) ));
		//assertEquals(h.getWishlistCount(), beforeCount);
	}
	
	@Test
	public void TC005_AddToBag()
	{
		p.hoverProduct();
		String productName = p.getProductName();
		p.clickAddToBagButton();
		
		String parent = d.getWindowHandle();
		Set<String> handles = d.getWindowHandles();
		String title ="";
		
		for (String window : handles) 
		{
			d.switchTo().window(window);
			if (d.getWindowHandle()!=parent) 
			{
				title = d.getTitle();
			}
		}
		assertTrue(title.contains(productName),"Incorrect Product detail page opened");
	}
}
