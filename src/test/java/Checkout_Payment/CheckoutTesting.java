package Checkout_Payment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.AddressPage;
import pom.CartPage;
import pom.HeaderAndFooterComponents;
import pom.PaymentPage;
import pom.WishlistPage;

public class CheckoutTesting extends BaseClass
{
	public HeaderAndFooterComponents h;
	public WishlistPage w;	
	public CartPage c;
	public AddressPage a;
	public PaymentPage p;
	
	@BeforeMethod
	public void setup()
	{
		c = new CartPage(d);
		a = new AddressPage(d);
		p = new PaymentPage(d);
		h = new HeaderAndFooterComponents(d);
		
		openLuluAndSky();
		login();
		if(h.isShoppingNotEmpty())
		{
			h.openShoppingBag();
			c.ClickRemoveAllButton();
		}
		addToBag2();
		h.openShoppingBag();
	}
	
	@Test
	public void TC0018_checkout()
	{
		int before = c.getTotalAmount();
		
		c.applyCoupon("SEPT15");
		c.clickApplyCouponButton();

		int after = c.getTotalAmount();
		int discount = c.getDiscountAmount();
		int expectedDiscount = before*15/100;
		
		assertEquals(discount, expectedDiscount,"Coupon discount calculation is wrong");
		
		assertEquals(after, before-discount ,"Final payable amount is incorrect");
		
		c.clickProceedToPurchaseButton();
		wait.until(ExpectedConditions.urlToBe("https://www.luluandsky.com/checkout/#shipping"));
		assertEquals("https://www.luluandsky.com/checkout/#shipping", d.getCurrentUrl());
		
		//a.clickProceedToPurchase();
		//a.clickProceedToPurchase();
		//wait.until(ExpectedConditions.urlToBe("https://www.luluandsky.com/checkout/#payment"));
		//assertEquals("https://www.luluandsky.com/checkout/#payment", d.getCurrentUrl());
		
		//p.checkCashOnDelivery();
		//wait.until(ExpectedConditions.attributeContains(p.getCashOnDeliveryButton(), "class", "active"));
		//assertTrue(p.getCashOnDeliveryButton().getAttribute("class").contains("active"),"Cash On Delivery option was not activated");;	
	}
	
}