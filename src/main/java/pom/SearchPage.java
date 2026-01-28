package pom;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage 
{
	WebDriver d ;
	WebDriverWait wait;
	
	
	public SearchPage(WebDriver d)
	{
		PageFactory.initElements(d,this);
		this.d = d;
		wait = new WebDriverWait(d,Duration.ofSeconds(15));
	}
	
	@FindBy(xpath = "//input[@id='search']") private WebElement searchBox;
	@FindBy(xpath = "//div[normalize-space()='Your search returned no results.']") private WebElement notFoundText;
	@FindBy(xpath = "//span[contains(@class,'qs-option-name') and normalize-space()='Tops']") private WebElement suggetions;
	
	public boolean isSuggestionsDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(suggetions));
		return suggetions.isDisplayed();
	}
	
	public boolean NotFoundIsVisbible()
	{
		wait.until(ExpectedConditions.visibilityOf(notFoundText));
		return notFoundText.isDisplayed();
	}
	
	public void enterIntoSearchBoxAndSearch(String s)
	{
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		//searchBox.sendKeys(s+Keys.ENTER);
		searchBox.sendKeys(s);
		searchBox.submit();
	}
	public void enterIntoSearchBox(String s)
	{
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(s);
	}
}
