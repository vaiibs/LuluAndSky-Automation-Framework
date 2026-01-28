package ProductDetailPage;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.HeaderAndFooterComponents;
import pom.ProductDetailPage;

public class ProductDetailPageTesting extends BaseClass
{
	public ProductDetailPage p;
	public HeaderAndFooterComponents h;
	
	@BeforeMethod()
	public void setup()
	{
		p = new ProductDetailPage(d);
		h = new HeaderAndFooterComponents(d);
		openLuluAndSky();
		NavigateToPDP();
		wait.until(ExpectedConditions.visibilityOf(p.getAddToBagButton()));
	}
	
	@Test
	public void TC007_AddingToBag()
	{
		int beforeCount = 0;
		String str = h.getBagCount();
		if (str!=null && !str.trim().isEmpty()) 
		{
			beforeCount = Integer.parseInt(str.trim());
		}
		String afterCount = String.valueOf(beforeCount+2);
		
		p.clickPlusIcon();
		p.clickL();
		p.clickAddToBag();
		
		//wait.until(ExpectedConditions.textToBePresentInElement(h.getBagElement(), afterCount ));
		//assertEquals(h.getBagCount(), afterCount);
	}
	
	@Test
	public void TC008_AddingToWishlist()
	{
		int beforeCount = 0;
		String str = h.getWishlistCount();
		
		if (str!=null && !str.trim().isEmpty()) 
		{
			beforeCount = Integer.parseInt(str.trim());
		}
		String afterCount = String.valueOf(beforeCount+1);
		
		p.clickPlusIcon();
		p.clickL();
		//wait.until(ExpectedConditions.elementToBeClickable(p.getAddToWishlistButton()));
		p.clickAddToWishlist();
		
		//wait.until(ExpectedConditions.textToBePresentInElement(h.getWishlistElement(), afterCount ));
		//assertEquals(h.getWishlistCount(), afterCount);
	}
}
