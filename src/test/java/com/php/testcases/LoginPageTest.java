package com.php.testcases;

import java.io.FileNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.php.base.BaseClass;
import com.php.pages.HomePage;
import com.php.pages.LoginPage;
import com.php.util.TestUtil;



public class LoginPageTest extends BaseClass {

	public static Logger log =LogManager.getLogger(BaseClass.class.getName());
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	String sheetName = "Login";
	
	public LoginPageTest(){
		
		super();

	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		testUtil = new TestUtil();
		homePage=new HomePage();
		
	}

	
	


	@DataProvider
	public Object[][] getTestData() throws FileNotFoundException{
		
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	
	@Test(priority=1, dataProvider="getTestData")
	public void loginTest(String usernameApplication, String passwordApplication) {
		
		log.info("Starting login test of Application");
		
	    homePage.validatingMyAccountLogin();
	    
	    log.info("validation of My Account Login is successful");
	    
	    log.info("Starting login page validation");
	    
		loginPage.validatingLogin(usernameApplication, passwordApplication);
		
		 log.info("validation of Login page is successful");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
