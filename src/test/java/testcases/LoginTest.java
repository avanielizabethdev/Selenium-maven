package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends BaseClass {
	
	@Test
	public void LoginFailiureTest() {
		
		//test = report.startTest("LoginFailureTest"); // start generate report
		
		LoginPage login = new LoginPage();
		login.LoginFunction("xyz@abc.com","Abc@12345");
		
		WebElement ErrorMsg = driver.findElement(By.id("msg_box")); 
		
		String ActualMsg = ErrorMsg.getText();
		String ExpMsg = "The email or password you have entered is invalid.";
		
		//insted of this below condition we are going to use assert method
		/*if(ActualMsg.equals(ExpMsg)) {
			System.out.println("TC Passed");
		}else {
			System.out.println("TC Failed");
		}*/
		
		Assert.assertEquals(ActualMsg, ExpMsg);//as soon as testcase failed it will stop there and it will not go further.
		
		//report.endTest(test);
	}
	
//values from test cases
	
@Test	
public void LoginSuccessTest() {
	
		
	LoginPage login = new LoginPage();
	login.LoginFunction("xyz@abc.com","Abc@12345");
		
	}

//Remove this function from here and paste it in new package(page) class(LoginPage)
/*public void LoginFunction(String UserNameVal, String PasswordVal) {
	
	WebElement LoginLink = driver.findElement(By.linkText("Log in"));
	LoginLink.click();
	
	WebElement UserName = driver.findElement(By.name("user_login"));
	WebElement Password = driver.findElement(By.id("password"));
	WebElement LoginBtn = driver.findElement(By.name("btn_login"));
	WebElement RememberMe= driver.findElement(By.className("rememberMe"));
	
	UserName.sendKeys(UserNameVal);
	Password.sendKeys(PasswordVal);
	RememberMe.click();
	LoginBtn.click();
	
}*/

//values from xml file:provide the data from external file(please add parameter in testing.xml file)
@Test
@Parameters({"Param1","Param2"})
public void ParamererizedTest(String UserNameVal, String PasswordVal) {
	
	LoginPage login = new LoginPage();
	login.LoginFunction(UserNameVal, PasswordVal);
}

@Test
public void ExternalDataTest() {
	
	String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
	String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
	
	LoginPage login = new LoginPage();
	login.LoginFunction(UserNameVal, PasswordVal);
}


}
