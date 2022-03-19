package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import testcases.BaseClass;

public class LoginPage {
	
	WebDriver driver = BaseClass.driver; //point driver to the base class driver. make sure driver class in base class is public static
	
	ExtentTest test = BaseClass.test; //generate report
	
	//=================================Web Elements===============================
	
	@FindBy(className="login")
	WebElement LoginLink;
	
	@FindBy(name="user_login")
	WebElement UserName;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(name="btn_login")
	WebElement LoginBtn;
	
	@FindBy(className="rememberMe")
	WebElement RememberMe;
	
	
	//assign all the values to the driver
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//===================================Functions===============================
	
	public void LoginFunction(String UserNameVal, String PasswordVal) {
		
				
		//WebElement LoginLink = driver.findElement(By.linkText("Log in"));
		
		LoginLink.click();
		test.log(LogStatus.PASS, "Click on Login link","Login link clicked successfully");
		
		/*
		WebElement UserName = driver.findElement(By.name("user_login"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement LoginBtn = driver.findElement(By.name("btn_login"));
		WebElement RememberMe= driver.findElement(By.className("rememberMe"));
		*/
				
		UserName.sendKeys(UserNameVal);
		test.log(LogStatus.PASS, "Enter user name","name entered successfully");
		
		Password.sendKeys(PasswordVal);
		test.log(LogStatus.PASS, "Enter password","password entered successfully");
		
		RememberMe.click();
		test.log(LogStatus.PASS, "Click on Remember me","Clicked successfully");
		
		LoginBtn.click();
		test.log(LogStatus.PASS, "Click on Login Button","Login button clicked successfully");
		
	}
	
	//to verify multiple declaration
	public void UICheck() {
		
		//WebElement UserName = driver.findElement(By.name("user_login"));
		Assert.assertTrue(UserName.isDisplayed());
	}

}
