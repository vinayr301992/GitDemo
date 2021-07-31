package com.php.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.php.util.TestUtil;



public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log =LogManager.getLogger(BaseClass.class.getName());
	
	public BaseClass() {
		
		log.info("Trying to read config and test is about to start");
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/config/config.properties");
				
			prop.load(fis);
		} catch (Exception e) {
			
		}
		log.info("config readed successfully");
	}

	public static void initialization() {
		
		log.info("Trying to start initialization of Browser");
		
		String browserName = prop.getProperty("Browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
			driver = new ChromeDriver();
		} 
		
		else if (browserName.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", ".//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}  
		
		
		else if (browserName.equals("MicrosoftEdge")) {
			System.setProperty("webdriver.edge.driver", ".//Drivers//msedgedriver.exe");
			driver = new EdgeDriver();
			
			log.info("initilization is completed and browser is up and running");
		}

		

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		log.info("entered url successfully");
	}
}
