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
import com.php.pages.ProfileCreation;
import com.php.util.TestUtil;



public class ProfileCreationTest extends BaseClass {

	public static Logger log =LogManager.getLogger(BaseClass.class.getName());
	
	LoginPage loginPage;
	HomePage homePage;
	ProfileCreation profileCreation;
	TestUtil testUtil;
	String sheetName = "Profile";
	
	
	public ProfileCreationTest(){
		super();

	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
		testUtil = new TestUtil();
		homePage=new HomePage();
		profileCreation=new ProfileCreation();
		
	}

	
	


	@DataProvider
	public Object[][] getTestData() throws FileNotFoundException{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	

	
	
	@Test(priority=2, dataProvider="getTestData")
	public void profileCreationTest(String uname,String pass,String pa,String cpa,String at,String ct,String st,String pc,String cout,String ph) throws InterruptedException {
		log.info("Starting profile creation test of Application");
		homePage.validatingMyAccountLogin();
		log.info("validation of My Account Login is successful");
		log.info("Starting login into Application");
		loginPage.validatingLogin(uname, pass);
		log.info("login successful");
		Thread.sleep(5000);
		log.info("Starting validation of profile creation page");
		profileCreation.validatingProfileCreation(pa, cpa, at, ct, st, pc, cout, ph);
		log.info("profile creation successful");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
	
}
