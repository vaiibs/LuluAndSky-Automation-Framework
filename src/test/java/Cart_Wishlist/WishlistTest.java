package Cart_Wishlist;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.HeaderAndFooterComponents;
import pom.WishlistPage;

public class WishlistTest extends BaseClass
{
	public HeaderAndFooterComponents h;
	public WishlistPage w;
	
	@BeforeMethod
	public void setup()
	{
		h = new HeaderAndFooterComponents(d);
		w = new WishlistPage(d);
		
		openLuluAndSky();
	}
	
	@Test
	public void TC0010_Wishlist_MoveToBag()
	{
		addToWishlist();
		h.clickWishListButton();
		wait.until(ExpectedConditions.urlContains("wishlist"));

		w.clickMoveToBagButton();
		//assertTrue(d.getCurrentUrl().contains("login"));
	}
	
	@Test
	public void TC009_Wishlist_RemoveFromWishlist()
	{
		h.clickWishListButton();
		w.removeFromWishlist();
		wait.until(ExpectedConditions.alertIsPresent());
		w.clickOk();
	}
	
}
