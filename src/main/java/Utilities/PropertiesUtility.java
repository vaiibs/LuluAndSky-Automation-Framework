package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesUtility 
{
	public static String getDataFromProperties(String key)
	{
		Properties p;
		String data = "";
		try
		{
			FileInputStream f = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
			p = new Properties();
			p.load(f);
			data = p.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
}
