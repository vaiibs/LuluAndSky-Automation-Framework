package pom;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriverWait wait;
	WebDriver d;
	
	public LoginPage(WebDriver d)
	{
		PageFactory.initElements(d, this);
		wait = new WebDriverWait(d, Duration.ofSeconds(10));
		this.d = d;
	}
	
	@FindBy(id = "mobile_number") private WebElement mobileNumberField;
	@FindBy(id = "signupcontinue") private WebElement signupcontinueButton;
	@FindBy(className = "loginusing") private WebElement passwordButton;
	@FindBy(id = "password") private WebElement passwordTextField;
	@FindBy(id = "loginwithpassword") private WebElement loginButton;
	

	public void enterNumber(String num)
	{
		wait.until(ExpectedConditions.visibilityOf(mobileNumberField));
		mobileNumberField.sendKeys(num);
	}
	
	public void continueButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(signupcontinueButton));
		signupcontinueButton.click();
	}
	
	public void clickPasswordButton()
	{
		wait.until(ExpectedConditions.elementToBeClickable(passwordButton));		
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].click();",passwordButton);
		
	}
	
	public void enterPassword(String pass)
	{
		wait.until(ExpectedConditions.elementToBeClickable(passwordTextField));
		passwordTextField.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].click();",loginButton);
	}
	
}
