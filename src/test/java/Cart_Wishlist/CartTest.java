package Cart_Wishlist;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.CartPage;
import pom.HeaderAndFooterComponents;
import pom.ProductDetailPage;

public class CartTest extends BaseClass
{
	public HeaderAndFooterComponents h;
	public CartPage c;
	public ProductDetailPage pdp;
	int price;

	@BeforeMethod
	public void setup()
	{
		h = new HeaderAndFooterComponents(d);
		openLuluAndSky();
		price = addToBag();
		h.openShoppingBag();
		c = new CartPage(d);
	}
	
	@Test
	public void TC011_MoveToWishlist()
	{
		c.clickMoveToWishlistButton();
	}
	
	@Test
	public void TC012_ProceedToPurchase()
	{
		c.clickProceedToPurchaseButton();
		wait.until(ExpectedConditions.urlContains("login"));
	}
	
	@Test
	public void TC013_RemoveFromBag()
	{
		c.clickRemoveButton();
	}
	
	@Test
	public void TC014_ConfirmPriceCalculation()
	{
		
		int total = c.getTotalAmount();		
		assertEquals(total,price*2);
	}
	
	@Test
	public void TC013_Login_ProceedToPurchase()
	{
		c.clickProceedToPurchaseButton();
		//wait.until(ExpectedConditions.urlContains("login"));
	}
}
