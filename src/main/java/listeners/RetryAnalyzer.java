package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer
{

	int retry;
	
	@Override
	public boolean retry(ITestResult result) 
	{
		if(retry < 2)
		{
			retry++;
			return true;
		}
		
		return false;
	}

}
