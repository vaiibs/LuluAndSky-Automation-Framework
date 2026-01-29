package BaseClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ExcelUtility;
import Utilities.PropertiesUtility;
import WaitUtilities.Wait;
import pom.HeaderAndFooterComponents;
import pom.LoginPage;
import pom.ProductDetailPage;
import pom.ProductListingPage;

public class BaseClass 
{
	public WebDriver d;
	public WebDriverWait wait;
	public ProductDetailPage p;
	
	@BeforeClass
	@Parameters("browser")@Optional("chrome")
	public void before(String browser)
	{
		System.setProperty("webdriver.chrome.silentOutput", "true"); 
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		switch (browser.toLowerCase()) 
		{
	        case "chrome":
	        	ChromeOptions o = new ChromeOptions();
	        	//o.addArguments("--headless=new");
	        	o.addArguments("--disable-gpu");
	        	o.addArguments("--no-sandbox");
	        	o.addArguments("--disable-dev-shm-usage");
	        	o.addArguments("--window-size=1920,1080");
	        	o.addArguments("--start-maximized");
	        	o.addArguments("--disable-notifications");
	        	o.addArguments("--remote-allow-origins=*");
	        	o.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
	        	d = new ChromeDriver(o);
	            d.manage().window().setSize(new Dimension(1920, 1080));
	            break;
	
	        case "firefox":
	            d = new FirefoxDriver();
	            break;
	
	        case "edge":
	            d = new EdgeDriver();
	            break;
	
	        default:
	            throw new RuntimeException("Browser not supported: " + browser);
		}
		d.manage().window().maximize();
		//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(PropertiesUtility.getDataFromProperties("wait"))));
		wait = new WebDriverWait(d,Duration.ofSeconds(15));
		//d.get(PropertiesUtility.getDataFromProperties("url"));
		//login();
	}

	@AfterClass
	public void after()
	{
		//d.quit();
	}
	
	public void addToWishlist()
	{
		p = new ProductDetailPage(d);
		NavigateToPDP();
		p.clickPlusIcon();
		p.clickL();
		wait.until(ExpectedConditions.elementToBeClickable(p.getAddToWishlistButton()));
		p.clickAddToWishlist();
	}
	
	public int addToBag()
	{
		p = new ProductDetailPage(d);
		NavigateToPDP();
		int price = p.getProductPrice();
		p.clickPlusIcon();
		p.clickFS();
		wait.until(ExpectedConditions.elementToBeClickable(p.getAddToBagButton()));
		p.clickAddToBag();
		return price;
	}
	
	public int addToBag2()
	{
		p = new ProductDetailPage(d);
		NavigateToPDP2();
		int price = p.getProductPrice();
		p.clickL();
		wait.until(ExpectedConditions.elementToBeClickable(p.getAddToBagButton()));
		p.clickAddToBag();
		return price;
	}
	
	public void openLuluAndSky()
	{
		d.get(PropertiesUtility.getDataFromProperties("url"));
	}
	
	public void login()
	{
		HeaderAndFooterComponents h = new HeaderAndFooterComponents(d);
		LoginPage l = new LoginPage(d);
		Wait w = new Wait(d);
		h.clickLogin();
		l.enterNumber("7058562889");
		l.continueButton();
		l.clickPasswordButton();
		l.enterPassword(ExcelUtility.getDataFromExcel(1, 0, PropertiesUtility.getDataFromProperties("excelPath"),"LoginData"));
		l.clickLogin();
	
		assertEquals(w.waitUntilPageTitle("Account Information"), "Account Information");
	}
	
	public void NavigateToPLP()
	{
		HeaderAndFooterComponents h = new HeaderAndFooterComponents(d);
		h.clickWomenButton();
	}
	
	public void NavigateToPDP()
	{
		HeaderAndFooterComponents h = new HeaderAndFooterComponents(d);
		h.clickWomenButton();
		ProductListingPage p = new ProductListingPage(d);
		p.clickProductImg2();
		
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
	}
	
	public void NavigateToPDP2()
	{
		HeaderAndFooterComponents h = new HeaderAndFooterComponents(d);
		h.clickWomenButton();
		ProductListingPage p = new ProductListingPage(d);
		p.HighToLowFilter();
		p.clickProductImg2();
		
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
	}
}
