package listeners;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseClass.BaseClass;

public class MyListener implements ITestListener
{	
	public ExtentTest test;
	public ExtentReports report;
	public ExtentSparkReporter spark; 
	
	@Override
	public void onTestStart(ITestResult result)
	  {
		test = report.createTest(result.getMethod().getMethodName());
	    System.out.println("Test : "+result.getMethod().getMethodName()+" Started Execution");
	  }
	@Override
	  public void onTestSuccess(ITestResult result)
	  {
		  test.log(Status.PASS,result.getMethod().getMethodName()+" is Pass");
		  System.out.println("Test : "+result.getMethod().getMethodName()+" Passed");
		  System.out.println("");
	  }
	@Override
	  public void onTestFailure(ITestResult result) 
	  {
		  WebDriver d = null;
	      
		  try 
	      {
	          d = (WebDriver) result.getTestClass().getRealClass().getSuperclass().getDeclaredField("d").get(result.getInstance());
	      } 
	      catch (Exception e) 
	      {
	          System.out.println("Could not get driver for screenshot: " + e.getMessage());
	      }
	    
		  System.out.println("Test : "+result.getMethod().getMethodName()+" Failed");
		  Throwable error = result.getThrowable();
		  System.out.println("Failure Reason: " + error.getMessage());
		  
		  String className = result.getTestClass().getRealClass().getSimpleName();
		  String methodName = result.getMethod().getMethodName();
		  String date = LocalDateTime.now().toString().replace(':', '-');
		  
		  String fileName = className+"_"+methodName+"_"+date;
		  
		  Reporter.log("Test Failed ! Screenshot Captured for "+methodName,true);
		 
		  TakesScreenshot ts = (TakesScreenshot) d;
		  
		  String from = ts.getScreenshotAs(OutputType.BASE64);
		  test.addScreenCaptureFromBase64String(from);
		  test.log(Status.FAIL,methodName+"is Fail");

		  File ss = ts.getScreenshotAs(OutputType.FILE);
		  File save = new File(System.getProperty("user.dir")+"\\Screenshots\\"+fileName+".png");
		  
		  try 
		  {
			FileHandler.copy(ss, save);
		  } 
		  catch (IOException e) 
		  {
			e.printStackTrace();
		  }
		  System.out.println("");
	  }
	@Override
	  public void onTestSkipped(ITestResult result) 
	  {
		  System.out.println("Test : "+result.getMethod().getMethodName()+" Skipped");
		  Throwable error = result.getThrowable();
		  System.out.println("Failure Reason: " + error.getMessage());
		  test.log(Status.SKIP,result.getMethod().getMethodName()+" is Pass");
		  System.out.println("");
	  }
	@Override
	  public void onStart(ITestContext context) 
	  {
		 	System.out.println();
		    spark = new ExtentSparkReporter(".\\src\\test\\resources\\Report\\"+context.getClass().getSimpleName()+".html");
			spark.config().setDocumentTitle("Lulu&Sky Test Report");
			spark.config().setReportName("Vaibhav");
			spark.config().setTheme(Theme.DARK);
			report = new ExtentReports();
			report.setSystemInfo("System Brand", "MSI");
			report.setSystemInfo("OS", "Windows - 11");
			report.setSystemInfo("Browser", "Chrome - 1313");
			report.attachReporter(spark);		
		    System.out.println("Class : "+context.getAllTestMethods()[0].getTestClass().getRealClass().getSimpleName()+" Started Execution");
		    System.out.println("-------------------------------------------------------");
	  }
	@Override
	  public void onFinish(ITestContext context)
	  {
		 report.flush();
		 System.out.println("Class : "+context.getAllTestMethods()[0].getTestClass().getRealClass().getSimpleName()+" Completed");
		 System.out.println("-------------------------------------------------------");
	  }
		  
}
