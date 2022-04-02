package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
	
	@Test(dataProvider="dp-name")
	public void PrintData(String data) {
		
		System.out.println("This data is:"+ data);
	}
	
	@DataProvider(name="dp-name")
	public Object[][] dpMethod(){
		
		return new Object[][] {
			{"First-data"},
			{"Second-data"}
		};
	}

}
