package testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListenerClass implements ITestListener{

	public void onTestStart(ITestResult result) {
		
		System.out.println("=====================Test Start===================");
		
	  }
	public void onTestFailure(ITestResult result) {
	    
TakesScreenshot obj = (TakesScreenshot) BaseClass.driver;
		
		File file = obj.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(file, new File("image.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
