package RestTest.demotest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
	
	
	@BeforeTest
	public void BaseTest()
	{
		System.out.println("------------Start Test----------");
	}
	
	
	@AfterTest
	public void AfterTest()
	{
		System.out.println("------------End Test----------");
	}


}
