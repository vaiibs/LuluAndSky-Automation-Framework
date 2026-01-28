package LoginRegister;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import Utilities.ExcelUtility;
import Utilities.PropertiesUtility;
import WaitUtilities.Wait;
import pom.HeaderAndFooterComponents;
import pom.LoginPage;

public class LoginTest extends BaseClass
{
	HeaderAndFooterComponents h;
	LoginPage l;
	Wait w;
	
	@BeforeMethod
	public void setup()
	{
		openLuluAndSky();
		h = new HeaderAndFooterComponents(d);
		l = new LoginPage(d);
		w = new Wait(d);
	}

	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void TC006_Login()
	{		
		h.clickLogin();
		l.enterNumber("7058562889");
		l.continueButton();
		l.clickPasswordButton();
		l.enterPassword(ExcelUtility.getDataFromExcel(1, 0, PropertiesUtility.getDataFromProperties("excelPath"),"LoginData"));
		l.clickLogin();
	
		assertEquals(w.waitUntilPageTitle("Account Information"), "Account Information");
	}
	
}
