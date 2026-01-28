package Search_Filter;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import pom.HeaderAndFooterComponents;
import pom.SearchPage;

public class SearchFeildTesting extends BaseClass
{
	SearchPage s;
	HeaderAndFooterComponents h;
	
	@BeforeMethod
	public void setup()
	{
		s = new SearchPage(d);
		h = new HeaderAndFooterComponents(d);
		openLuluAndSky();
		h.clickSearchFeild();
	}
	
	@Test
	public void TC015_SearchBox()
	{
		s.enterIntoSearchBoxAndSearch("dress");
		wait.until(ExpectedConditions.urlContains("dress"));
	}
	
	@Test
	public void TC016_SeachBoxInvalid()
	{
		s.enterIntoSearchBoxAndSearch("xyz123");
		assertTrue(s.NotFoundIsVisbible());
	}
	
	@Test
	public void TC017_SearchSuggestions()
	{
		s.enterIntoSearchBox("Top");
		assertTrue(s.isSuggestionsDisplayed());
	}
	
}
