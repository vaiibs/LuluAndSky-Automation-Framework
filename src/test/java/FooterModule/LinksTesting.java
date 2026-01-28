package FooterModule;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.BaseClass;
import pom.HeaderAndFooterComponents;

public class LinksTesting extends BaseClass
{
	public HeaderAndFooterComponents f;
	public List<String> links;
	public SoftAssert s;
	int num ;
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void clickFooterLinks()
	{
		openLuluAndSky();
		if (num==0) 
		{
			num++;
			login();
		}
		
		f = new HeaderAndFooterComponents(d);
		f.scrollToFooter();
		links = f.getFooterLinks();
		s = new SoftAssert();
		
		System.out.println("Checking "+links.size()+" footer links !");
		
		for (String link : links) 
		{
			try
			{
				URL url = new URL(link);
				
				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				
				con.setRequestMethod("GET");
				con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Safari/537.36");
				
				con.setConnectTimeout(30000);
				con.connect();
				
				int statusCode = con.getResponseCode();
				
				if (link.contains("facebook.com") && statusCode == 400)
				{
	                System.out.println("Status 400 (Bot Block) ignored for Facebook: " + link);
	                continue;
	            }
				
				System.out.println("Status "+statusCode+" for: "+link);
				
				
				s.assertTrue( statusCode < 400 ,"Link Broken: " + link + " returned " + statusCode);
				
				con.disconnect();
				
			}
			catch(Exception e)
			{
				s.fail("Link threw exception: " + link + " -> " + e.getMessage());
			}
		}
		
		s.assertAll();
	}	
}
