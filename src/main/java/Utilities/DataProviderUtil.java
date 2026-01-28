package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtil 
{
	@DataProvider(name = "LoginData")
	public static Object[][] loginData()
	{
		Object[][] data = null;
		
		try 
		{
			String path = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
			data = ExcelUtility.getDataFromExcel(path, "LoginData");
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		return data;
	}
}
